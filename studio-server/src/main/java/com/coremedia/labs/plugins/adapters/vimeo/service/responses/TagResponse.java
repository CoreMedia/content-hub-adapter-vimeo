package com.coremedia.labs.plugins.adapters.vimeo.service.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TagResponse {

  /**
   * The normalized canonical tag name.
   */
  @JsonProperty("canonical")
  private String canonical;

  /**
   * Metadata about the tag.
   * - metadata.connections	Object
   * A collection of information that is connected to this resource.
   * - metadata.connections.videos	Object
   * Information about the videos related to this tag.
   * - metadata.connections.videos.options	Array
   * An array of HTTP methods permitted on this URI.
   * - metadata.connections.videos.total	Number
   * The total number of videos on this connection.
   * - metadata.connections.videos.uri	String
   * The API URI that resolves to the connection data.
   */
  @JsonProperty("metadata")
  private Object metadata;

  /**
   * The tag value.
   */
  @JsonProperty("name")
  private String name;

  /**
   * The tag's resource key string.
   */
  @JsonProperty("resource_key")
  private String resourceKey;

  /**
   * The canonical relative URI of the tag.
   */
  @JsonProperty("uri")
  private String uri;

  public String getCanonical() {
    return canonical;
  }

  public void setCanonical(String canonical) {
    this.canonical = canonical;
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

  public String getResourceKey() {
    return resourceKey;
  }

  public void setResourceKey(String resourceKey) {
    this.resourceKey = resourceKey;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }
}
