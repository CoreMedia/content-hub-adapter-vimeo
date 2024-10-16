package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;

import static com.coremedia.labs.plugins.adapters.vimeo.service.VimeoConstants.DATE_TIME_PATTERN;

/**
 * Folder (aka Project) representation.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FolderRepresentation {

    /**
     * The access grant response that applies to the team member who owns the folder.
     * The possible values of this field are
     * \Vimeo\Api\Response\TeamGroupFolderAccessGrantResponse,
     * \Vimeo\Api\Response\UserFolderAccessGrantResponse,
     * \Vimeo\Api\Response\RoleFolderAccessGrantResponse,
     * or null.
     */
    @JsonProperty("access_grant")
    private Map<String, Object> accessGrant;

    /**
     * The time in ISO 8601 format when the folder was created.
     */
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime createdTime;

    /**
     * Whether the folder is pinned.
     */
    @JsonProperty("is_pinned")
    private boolean isPinned;

    /**
     * The time in ISO 8601 format when a user last performed an action on the folder.
     */
    @JsonProperty("last_user_action_event_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime lastUserActionEventDate;

    /**
     * The link to the video on Vimeo.
     */
    @JsonProperty("link")
    private String link;

    /**
     * Information about the folders's metadata.
     */
    @JsonProperty("metadata")
    private Map<String, Object> metadata;

    /**
     * The time in ISO 8601 format when the folder was last modified.
     */
    @JsonProperty("modified_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime modifiedTime;

    /**
     * The name of the folder.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The time in ISO 8601 format when the folder was pinned.
     */
    @JsonProperty("pinned_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime pinnedOn;

    /**
     * The privacy settings of the folder.
     */
    @JsonProperty("privacy")
    private Map<String, Object> privacy;

    /**
     * The URI of the folder.
     */
    @JsonProperty("uri")
    private String uri;

    /**
     * The owner of the folder.
     */
    @JsonProperty("user")
    private UserRepresentation user;

    public Map<String, Object> getAccessGrant() {
        return accessGrant;
    }

    public void setAccessGrant(Map<String, Object> accessGrant) {
        this.accessGrant = accessGrant;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public ZonedDateTime getLastUserActionEventDate() {
        return lastUserActionEventDate;
    }

    public void setLastUserActionEventDate(ZonedDateTime lastUserActionEventDate) {
        this.lastUserActionEventDate = lastUserActionEventDate;
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

    public ZonedDateTime getPinnedOn() {
        return pinnedOn;
    }

    public void setPinnedOn(ZonedDateTime pinnedOn) {
        this.pinnedOn = pinnedOn;
    }

    public Map<String, Object> getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Map<String, Object> privacy) {
        this.privacy = privacy;
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
}
