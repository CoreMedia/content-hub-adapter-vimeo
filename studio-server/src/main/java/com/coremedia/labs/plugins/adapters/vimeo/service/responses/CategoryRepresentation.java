package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static com.coremedia.labs.plugins.adapters.vimeo.service.VimeoConstants.DATE_TIME_PATTERN;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryRepresentation {

    /**
     * The active icon for the category.
     */
    @JsonProperty("icon")
    private PictureRepresentation icon;

    /**
     * Whether the category is deprecated and should not be used for new categorization.
     */
    @JsonProperty("is_deprecated")
    private boolean isDeprecated;

    /**
     * The most recent time in ISO 8601 format when the video was featured.
     */
    @JsonProperty("last_video_featured_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime lastVideoFeaturedTime;

    /**
     * The URL to access the category in a browser.
     */
    @JsonProperty("link")
    private String link;

    /**
     * Metadata about the category.
     */
    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    /**
     * The display name that identifies the category.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The container of the category's parent category, if the current category is a subcategory.
     */
    @JsonProperty("parent")
    private Map<String, Object> parent;

    /**
     * The active picture for this category. The default shows vertical color bars.
     */
    @JsonProperty("pictures")
    private PictureRepresentation pictures;

    /**
     * The resource key of the category.
     */
    @JsonProperty("resource_key")
    private String resourceKey;

    /**
     * All the subcategories that belong to the category, if the current category is a top-level parent.
     */
    @JsonProperty("subcategories")
    private List<Object> subcategories;


    /**
     * Whether the category isn't a subcategory of another category.
     */
    @JsonProperty("top_level")
    private boolean topLevel;

    /**
     * The unique identifier to access the category resource.
     */
    @JsonProperty("uri")
    private String uri;

    public PictureRepresentation getIcon() {
        return icon;
    }

    public void setIcon(PictureRepresentation icon) {
        this.icon = icon;
    }

    public boolean isDeprecated() {
        return isDeprecated;
    }

    public void setDeprecated(boolean deprecated) {
        isDeprecated = deprecated;
    }

    public ZonedDateTime getLastVideoFeaturedTime() {
        return lastVideoFeaturedTime;
    }

    public void setLastVideoFeaturedTime(ZonedDateTime lastVideoFeaturedTime) {
        this.lastVideoFeaturedTime = lastVideoFeaturedTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getParent() {
        return parent;
    }

    public void setParent(Map<String, Object> parent) {
        this.parent = parent;
    }

    public PictureRepresentation getPictures() {
        return pictures;
    }

    public void setPictures(PictureRepresentation pictures) {
        this.pictures = pictures;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

  public List<Object> getSubcategories() {
    return subcategories;
  }

  public void setSubcategories(List<Object> subcategories) {
    this.subcategories = subcategories;
  }

  public boolean isTopLevel() {
        return topLevel;
    }

    public void setTopLevel(boolean topLevel) {
        this.topLevel = topLevel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
