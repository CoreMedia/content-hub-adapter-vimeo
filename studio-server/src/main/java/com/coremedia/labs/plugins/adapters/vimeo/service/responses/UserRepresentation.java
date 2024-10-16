package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Map;

import static com.coremedia.labs.plugins.adapters.vimeo.service.VimeoConstants.DATE_TIME_PATTERN;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRepresentation {

    /**
     * The authenticated user's account type:
     * basic - The user has a Vimeo Basic subscription.
     * business - The user has a Vimeo Business subscription.
     * live_business - The user has a Vimeo Business Live subscription.
     * live_premium - The user has a Vimeo Premium subscription.
     * live_pro - The user has a Vimeo PRO Live subscription.
     * plus - The user has a Vimeo Plus subscription.
     * pro - The user has a Vimeo Pro subscription.
     * pro_unlimited - The user has a Vimeo PRO Unlimited subscription.
     * producer - The user has a Vimeo Producer subscription.
     * available_for_hire
     */
    @JsonProperty("account")
    private String account;

    /**
     * Whether the authenticated user is available for hire.
     */
    @JsonProperty("available_for_hire")
    private boolean availableForHire;

    /**
     * The authenticated user's long bio text.
     */
    @JsonProperty("bio")
    private String bio;

    /**
     * Whether the authenticated user can work remotely.
     */
    @JsonProperty("can_work_remotely")
    private boolean canWorkRemotely;

    /**
     * The users's capabilities list.
     */
    @JsonProperty("capabilities")
    private Map<String, Object> capabilities;

    /**
     * The comma-separated list of clients.
     */
    @JsonProperty("clients")
    private String clients;

    /**
     * The authenticated user's content filters:
     * drugs - Drugs or alcohol use.
     * language - Profanity or sexually suggestive content.
     * nudity - Nudity.
     * safe - Suitable for all audiences.
     * unrated - No rating.
     * violence - Violent or graphic content.
     */
    @JsonProperty("content_filter")
    private Object contentFilter;

    /**
     * The time in ISO 8601 format when the user account was created.
     */
    @JsonProperty("created_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime createdTime;

    /**
     * The authenticated user's gender.
     */
    @JsonProperty("gender")
    private String gender;

    /**
     * The absolute URL of the authenticated users's profile page.
     */
    @JsonProperty("link")
    private String link;

    /**
     * The authenticated user's location.
     */
    @JsonProperty("location")
    private String location;

    /**
     * The authenticated user's location details.
     */
    @JsonProperty("location_details")
    private Object /*Location*/ locationDetails;

    /**
     * The authenticated user's metadata.
     */
    @JsonProperty("metadata")
    private Object metadata;

    /**
     * The authenticated user's display name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The active portrait of the authenticated user.
     */
    @JsonProperty("pictures")
    private PictureRepresentation pictures;

    /**
     * The authenticated user's resource key string.
     */
    @JsonProperty("resource_key")
    private String resourceKey;

    /**
     * The authenticated user's short bio text.
     */
    @JsonProperty("short_bio")
    private String shortBio;

    /**
     * A list of the authenticated user's skills.
     */
    @JsonProperty("skills")
    private Object/*List<Skill>*/ skills;

    /**
     * This information appears only when the authenticated user has upload access and is looking at their own user record.
     */
    @JsonProperty("upload_quota")
    private Object uploadQuota;

    /**
     * The authenticated user's canonical relative URI.
     */
    @JsonProperty("uri")
    private String uri;

    /**
     * The authenticated user's websites.
     */
    @JsonProperty("websites")
    private Object websites;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public boolean isAvailableForHire() {
        return availableForHire;
    }

    public void setAvailableForHire(boolean availableForHire) {
        this.availableForHire = availableForHire;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isCanWorkRemotely() {
        return canWorkRemotely;
    }

    public void setCanWorkRemotely(boolean canWorkRemotely) {
        this.canWorkRemotely = canWorkRemotely;
    }

    public Map<String, Object> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Map<String, Object> capabilities) {
        this.capabilities = capabilities;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public Object getContentFilter() {
        return contentFilter;
    }

    public void setContentFilter(Object contentFilter) {
        this.contentFilter = contentFilter;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(Object locationDetails) {
        this.locationDetails = locationDetails;
    }

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public Object getSkills() {
        return skills;
    }

    public void setSkills(Object skills) {
        this.skills = skills;
    }

    public Object getUploadQuota() {
        return uploadQuota;
    }

    public void setUploadQuota(Object uploadQuota) {
        this.uploadQuota = uploadQuota;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Object getWebsites() {
        return websites;
    }

    public void setWebsites(Object websites) {
        this.websites = websites;
    }
}
