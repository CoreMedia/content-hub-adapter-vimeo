package com.coremedia.labs.plugins.adapters.vimeo.model;

import com.coremedia.contenthub.api.ContentHubObjectId;
import com.coremedia.contenthub.api.ContentHubType;
import com.coremedia.contenthub.api.Item;
import edu.umd.cs.findbugs.annotations.NonNull;

public abstract class VimeoItem extends VimeoContentHubObject implements Item {

  private VimeoContentHubType type;

  public VimeoItem(@NonNull ContentHubObjectId objectId, VimeoContentHubType type) {
    super(objectId);
    this.type = type;
  }

  @Override
  public ContentHubType getContentHubType() {
    return type.getType();
  }

  public String getThumbnailUrl() {
    return null;
  }

}
