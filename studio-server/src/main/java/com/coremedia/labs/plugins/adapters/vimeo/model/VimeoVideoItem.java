package com.coremedia.labs.plugins.adapters.vimeo.model;

import com.coremedia.contenthub.api.ContentHubBlob;
import com.coremedia.contenthub.api.ContentHubObjectId;
import com.coremedia.contenthub.api.UrlBlobBuilder;
import com.coremedia.contenthub.api.preview.DetailsElement;
import com.coremedia.contenthub.api.preview.DetailsSection;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.PictureRepresentation;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.VideoRepresentation;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.coremedia.contenthub.api.ContentHubBlob.THUMBNAIL_BLOB_CLASSIFIER;

public class VimeoVideoItem extends VimeoItem {

  private final VideoRepresentation video;

  public VimeoVideoItem(@NonNull ContentHubObjectId objectId, @NonNull VideoRepresentation video) {
    super(objectId, VimeoContentHubType.VIDEO);
    this.video = video;
  }

  @Override
  public String getCoreMediaContentType() {
    return "CMVideo";
  }

  @Override
  public String getName() {
    return getVideo().getName();
  }

  @Nullable
  @Override
  public String getDescription() {
    return getVideo().getDescription();
  }

  @Nullable
  @Override
  public ContentHubBlob getThumbnailBlob() {
    return getBlob(THUMBNAIL_BLOB_CLASSIFIER);
  }

  @Override
  public String getThumbnailUrl() {
    return Optional.ofNullable(getVideo().getPictures())
            .map(PictureRepresentation::getSizes)
            .map(sizes -> sizes.get(sizes.size() - 1)) // Last element holds the largest image url
            .map(PictureRepresentation.Size::getLink)
            .orElse(null);
  }

  @NonNull
  @Override
  public List<DetailsSection> getDetails() {
    ContentHubBlob blob = null;
    String thumbnailUrl = getDefaultThumbnailUrl();
    if (StringUtils.isNotBlank(thumbnailUrl)) {
      blob = new UrlBlobBuilder(this, "preview").withUrl(thumbnailUrl).build();
    }

    return List.of(
            // Name & thumbnail
            new DetailsSection("main", List.of(
                    new DetailsElement<>(getName(), false, Objects.requireNonNullElse(blob, SHOW_TYPE_ICON))
            ), false, false, false),

            // Metadata
            new DetailsSection("metadata", Stream.of(
                    new DetailsElement<>("description", getVideo().getDescription()),
                    new DetailsElement<>("duration", formatDuration(getVideo().getDuration())),
                    new DetailsElement<>("dimensions", formatDimensions(getVideo().getWidth(), getVideo().getHeight())),
                    new DetailsElement<>("contentRating", formatContentRating(getVideo())),
                    new DetailsElement<>("createdAt", formatPreviewDate(getVideo().getCreatedTime())),
                    new DetailsElement<>("updatedAt", formatPreviewDate(getVideo().getModifiedTime())),
                    new DetailsElement<>("status", getVideo().getStatus())

            ).filter(p -> Objects.nonNull(p.getValue())).collect(Collectors.toUnmodifiableList())));
  }

  private String getDefaultThumbnailUrl() {
    return Optional.ofNullable(getVideo().getPictures())
            .map(PictureRepresentation::getSizes)
            .map(sizes ->
                    // Size at index 2 = 295x166px
                    sizes.size() >= 2 ? sizes.get(2) : sizes.get(0)
            )
            .map(PictureRepresentation.Size::getLink)
            .orElse(null);
  }

  @Nullable
  private Calendar formatPreviewDate(@Nullable ZonedDateTime zdt) {
    if (zdt == null) {
      return null;
    }

    return GregorianCalendar.from(zdt);
  }

  private String formatDuration(int duration) {
    return DurationFormatUtils.formatDuration(duration * 1000L, "HH:mm:ss");
  }

  private String formatDimensions(int width, int height) {
    return String.format("%dx%dpx", width, height);
  }

  private String formatContentRating(VideoRepresentation video) {
    List<String> contentRating = video.getContentRating();
    String result = "";
    if (contentRating != null) {
      result = String.join(",", contentRating);
    }
    return result;
  }

  @Nullable
  @Override
  public ContentHubBlob getBlob(String classifier) {
    ContentHubBlob blob;
    try {
      blob = new UrlBlobBuilder(this, classifier).withUrl(getDefaultThumbnailUrl()).build();
    } catch (Exception e) {
      throw new IllegalArgumentException("Cannot create blob for " + this, e);
    }
    return blob;
  }

  public VideoRepresentation getVideo() {
    return video;
  }

}
