package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PictureRepresentation {

    /**
     * Whether the picture is currently active.
     */
    @JsonProperty("active")
    private boolean active;

    /**
     * Whether the picture is Vimeo's default
     */
    @JsonProperty("default_picture")
    private boolean defaultPicture;

    /**
     * The upload URL of the picture.
     * This field appears upon the initial creation of a picture resource.
     */
    @JsonProperty("link")
    private String link;

    /**
     * The resource key string of the picture.
     */
    @JsonProperty("resource_key")
    private String resourceKey;

    /**
     * An array containing reference information about all available image files.
     */
    @JsonProperty("sizes")
    private List<Size> sizes;

    /**
     * The type of the picture:
     *  caution - The picture isn't appropriate for all ages.
     *  custom - The picture is a custom video image.
     *  default - The picture is the default video image.
     */
    @JsonProperty("type")
    private String type;

    /**
     * The URI of the picture.
     */
    @JsonProperty("uri")
    private String uri;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDefaultPicture() {
        return defaultPicture;
    }

    public void setDefaultPicture(boolean defaultPicture) {
        this.defaultPicture = defaultPicture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    public static class Size {

        /**
         * The height of the picture.
         */
        @JsonProperty("height")
        private int height;

        /**
         * The direct link to the image file.
         * For information about the format of the image file, see our Working with Thumbnail Uploads guide.
         */
        @JsonProperty("link")
        private String link;

        /**
         * The direct link to the image file with a play button overlay.
         * For information about the format of the image file, see our Working with Thumbnail Uploads guide.
         */
        @JsonProperty("link_with_play_button")
        private String linkWithPlayButton;

        /**
         * The width of the picture.
         */
        @JsonProperty("width")
        private int width;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLinkWithPlayButton() {
            return linkWithPlayButton;
        }

        public void setLinkWithPlayButton(String linkWithPlayButton) {
            this.linkWithPlayButton = linkWithPlayButton;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }
}
