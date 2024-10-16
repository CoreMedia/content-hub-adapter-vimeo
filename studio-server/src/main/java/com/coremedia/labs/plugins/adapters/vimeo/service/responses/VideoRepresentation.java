package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static com.coremedia.labs.plugins.adapters.vimeo.service.VimeoConstants.DATE_TIME_PATTERN;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoRepresentation {

    /**
     * The categories to which the video belongs.
     */
    @JsonProperty("categories")
    private List<CategoryRepresentation> categories;

    /**
     * The video's content rating.
     */
    @JsonProperty("content_rating")
    private List<String> contentRating;

    /**
     * The context of the video's subscription, if the video is part of a subscription.
     */
    @JsonProperty("context")
    private Object context;

    /**
     * The time in ISO 8601 format when the video was created.
     */
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime createdTime;

    /**
     * A brief explanation of the video's content.
     */
    @JsonProperty("description")
    private String description;

    /**
     * The video's duration in seconds.
     */
    @JsonProperty("duration")
    private int duration;

    /**
     * Information about the Vimeo Create session of a video.
     * This data requires a bearer token with the private scope.
     */
    @JsonProperty("edit_session")
    private Object /*EditingSession*/ editSession;

    /**
     * Information about embedding the video.
     */
    @JsonProperty("embed")
    private Object /*EmbedSettings*/ embed;

    /**
     * The video's height in pixels.
     */
    @JsonProperty("height")
    private int height;

    /**
     * Whether the clip is playable.
     */
    @JsonProperty("is_playable")
    private boolean isPlayable;

    /**
     * The video's primary language.
     */
    @JsonProperty("language")
    private String language;

    /**
     * The time in ISO 8601 format when the user last modified the video.
     */
    @JsonProperty("last_user_action_event_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime lastUserActionEventDate;

    /**
     * The Creative Commons license used for the video:
     * by - The Attribution license.
     * by-nc - The Attribution Non-Commercial license.
     * by-nc-nd - The Attribution Non-Commercial No Derivatives license.
     * by-nc-sa - The Attribution Non-Commercial Share Alike license.
     * by-nd - The Attribution No Derivatives license.
     * by-sa - The Attribution Share Alike license.
     * cc0 - The Public Domain Dedication license.
     */
    @JsonProperty("license")
    private String license;

    /**
     * The link to the video.
     */
    @JsonProperty("link")
    private String link;

    /**
     * The link to the video management page.
     * This data requires a bearer token with the private scope.
     */
    @JsonProperty("manage_link")
    private String manageLink;

    /**
     * The video's metadata.
     */
    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    /**
     * The time in ISO 8601 format when the video metadata was last modified.
     */
    @JsonProperty("modified_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime modifiedTime;

    /**
     * The video's title.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Information about the folder that contains the video.
     */
    @JsonProperty("parent_folder")
    private FolderRepresentation parentFolder;

    /**
     * The privacy-enabled password to watch the video.
     * Only the video's owner and those team members with permission can access the video's password.
     * This data requires a bearer token with the private scope.
     */
    @JsonProperty("password")
    private String password;

    /**
     * The video's active picture.
     */
    @JsonProperty("pictures")
    private PictureRepresentation pictures;

    /**
     * The video's privacy setting.
     */
    @JsonProperty("privacy")
    private Map<String, Object> privacy;

    /**
     * The time in ISO 8601 format when the video was released.
     */
    @JsonProperty("release_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime releaseTime;

    /**
     * The resource key string of the video.
     */
    @JsonProperty("resource_key")
    private String resourceKey;

    /**
     * The video's 360 spatial data.
     */
    @JsonProperty("spatial")
    private Map<String, Object> spatial;

    /**
     * A collection of analytics associated with the video.
     */
    @JsonProperty("stats")
    private Map<String, Object> stats;

    /**
     * The status code for the availability of the video. This field is deprecated in favor of upload and transcode.
     * available - The video is available.
     * quota_exceeded - The user's quota is exceeded with this video.
     * total_cap_exceeded - The user has exceeded their total cap with this video.
     * transcode_starting - Transcoding is starting for the video.
     * transcoding - Transcoding has started and is currently underway for the video.
     * transcoding_error - There was an error in transcoding the video.
     * unavailable - The video is unavailable.
     * uploading - The video is being uploaded.
     * uploading_error - There was an error in uploading the video.
     */
    @JsonProperty("status")
    private String status;

    /**
     * An array of all tags assigned to the video.
     */
    @JsonProperty("tags")
    private List<TagResponse> tags;

    /**
     * The transcode information of the video upload.
     */
    @JsonProperty("transcode")
    private Map<String, Object> transcode;

    /**
     * The type of the video.
     * live - The video is or was a live event.
     * stock - The video is a Vimeo Stock video.
     * video - The video is a standard Vimeo video.
     */
    @JsonProperty("type")
    private String type;

    /**
     * The video's upload information.
     */
    @JsonProperty("upload")
    private Map<String, Object> upload;

    /**
     * The video's uploader.
     */
    @JsonProperty("uploader")
    private Map<String, Object> uploader;

    /**
     * The video's canonical relative URI.
     */
    @JsonProperty("uri")
    private String uri;

    /**
     * The video's owner.
     */
    @JsonProperty("user")
    private UserRepresentation user;

    /**
     * The Vimeo On Demand information for the video, if applicable.
     */
    @JsonProperty("vod")
    private Map<String, Object> vod;

    /**
     * The video's width in pixels.
     */
    @JsonProperty("width")
    private int width;

    public List<CategoryRepresentation> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRepresentation> categories) {
        this.categories = categories;
    }

    public List<String> getContentRating() {
        return contentRating;
    }

    public void setContentRating(List<String> contentRating) {
        this.contentRating = contentRating;
    }

    public Object getContext() {
        return context;
    }

    public void setContext(Object context) {
        this.context = context;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Object getEditSession() {
        return editSession;
    }

    public void setEditSession(Object editSession) {
        this.editSession = editSession;
    }

    public Object getEmbed() {
        return embed;
    }

    public void setEmbed(Object embed) {
        this.embed = embed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isPlayable() {
        return isPlayable;
    }

    public void setPlayable(boolean playable) {
        isPlayable = playable;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ZonedDateTime getLastUserActionEventDate() {
        return lastUserActionEventDate;
    }

    public void setLastUserActionEventDate(ZonedDateTime lastUserActionEventDate) {
        this.lastUserActionEventDate = lastUserActionEventDate;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getManageLink() {
        return manageLink;
    }

    public void setManageLink(String manageLink) {
        this.manageLink = manageLink;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public ZonedDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(ZonedDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FolderRepresentation getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(FolderRepresentation parentFolder) {
        this.parentFolder = parentFolder;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PictureRepresentation getPictures() {
        return pictures;
    }

    public void setPictures(PictureRepresentation pictures) {
        this.pictures = pictures;
    }

    public Map<String, Object> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Map<String, Object> privacy) {
        this.privacy = privacy;
    }

    public ZonedDateTime getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(ZonedDateTime releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public Map<String, Object> getSpatial() {
        return spatial;
    }

    public void setSpatial(Map<String, Object> spatial) {
        this.spatial = spatial;
    }

    public Map<String, Object> getStats() {
        return stats;
    }

    public void setStats(Map<String, Object> stats) {
        this.stats = stats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  public List<TagResponse> getTags() {
    return tags;
  }

  public void setTags(List<TagResponse> tags) {
    this.tags = tags;
  }

  public Map<String, Object> getTranscode() {
        return transcode;
    }

    public void setTranscode(Map<String, Object> transcode) {
        this.transcode = transcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getUpload() {
        return upload;
    }

    public void setUpload(Map<String, Object> upload) {
        this.upload = upload;
    }

    public Map<String, Object> getUploader() {
        return uploader;
    }

    public void setUploader(Map<String, Object> uploader) {
        this.uploader = uploader;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public UserRepresentation getUser() {
        return user;
    }

    public void setUser(UserRepresentation user) {
        this.user = user;
    }

    public Map<String, Object> getVod() {
        return vod;
    }

    public void setVod(Map<String, Object> vod) {
        this.vod = vod;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
