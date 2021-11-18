package com.coremedia.labs.plugins.adapters.vimeo.model;

import com.coremedia.contenthub.api.ContentHubType;

public enum VimeoContentHubType {

  ROOT(new ContentHubType("vimeoRoot")),
  FOLDER(new ContentHubType("vimeoFolder")),
  VIDEO(new ContentHubType("vimeoVideo"));

  private ContentHubType type;

  VimeoContentHubType(ContentHubType type) {
    this.type = type;
  }

  public ContentHubType getType() {
    return type;
  }

}
