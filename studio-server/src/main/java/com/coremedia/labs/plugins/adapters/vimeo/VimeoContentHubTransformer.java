package com.coremedia.labs.plugins.adapters.vimeo;

import com.coremedia.contenthub.api.ContentHubAdapter;
import com.coremedia.contenthub.api.ContentHubContentCreationException;
import com.coremedia.contenthub.api.ContentHubContext;
import com.coremedia.contenthub.api.ContentHubObject;
import com.coremedia.contenthub.api.ContentHubTransformer;
import com.coremedia.contenthub.api.ContentModel;
import com.coremedia.contenthub.api.ContentModelReference;
import com.coremedia.contenthub.api.Item;
import com.coremedia.contenthub.api.UrlBlobBuilder;
import com.coremedia.labs.plugins.adapters.vimeo.model.VimeoItem;
import com.coremedia.labs.plugins.adapters.vimeo.model.VimeoVideoItem;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.VideoRepresentation;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class VimeoContentHubTransformer implements ContentHubTransformer {

  private static final Logger LOG = LoggerFactory.getLogger(VimeoContentHubTransformer.class);

  @Nullable
  @Override
  public ContentModel transform(Item source, ContentHubAdapter contentHubAdapter, ContentHubContext contentHubContext) throws ContentHubContentCreationException {
    if (!(source instanceof VimeoItem)) {
      throw new IllegalArgumentException("Cannot transform source " + source);
    }

    VimeoItem item = (VimeoItem) source;
    LOG.info("Creating content model for item {}.", item);

    String contentName = FilenameUtils.removeExtension(item.getName());
    ContentModel contentModel = ContentModel.createContentModel(contentName, item.getId(), item.getCoreMediaContentType());
    contentModel.put("title", contentName);

    if (item instanceof VimeoVideoItem) {
      VimeoVideoItem videoItem = (VimeoVideoItem) item;
      VideoRepresentation video = videoItem.getVideo();
      contentModel.put("dataUrl", video.getLink());

      // Store image reference
      String thumbnailUrl = videoItem.getThumbnailUrl();
      if (thumbnailUrl != null) {
        ContentModelReference ref = ContentModelReference.create(contentModel, "CMPicture", thumbnailUrl);
        contentModel.put("pictures", Collections.singletonList(ref));
      }
    }

    return contentModel;
  }

  @Nullable
  @Override
  public ContentModel resolveReference(ContentHubObject owner, ContentModelReference reference, ContentHubAdapter contentHubAdapter, ContentHubContext contentHubContext) {
    Object data = reference.getData();
    if (!(data instanceof String)) {
      throw new IllegalArgumentException("Not my reference: " + reference);
    }

    String imageUrl = (String) data;
    String imageName = reference.getOwner().getContentName() + " (Thumbnail)";

    ContentModel referenceModel = ContentModel.createReferenceModel(imageName, reference.getCoreMediaContentType());
    referenceModel.put("data", new UrlBlobBuilder(owner, "thumbnail").withUrl(imageUrl).build());
    referenceModel.put("title", "Video Thumbnail " + imageName);

    return referenceModel;
  }
}
