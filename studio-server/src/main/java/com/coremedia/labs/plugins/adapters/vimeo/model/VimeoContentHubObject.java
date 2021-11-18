package com.coremedia.labs.plugins.adapters.vimeo.model;

import com.coremedia.contenthub.api.ContentHubObject;
import com.coremedia.contenthub.api.ContentHubObjectId;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;

public abstract class VimeoContentHubObject implements ContentHubObject {

  private final ContentHubObjectId objectId;

  public VimeoContentHubObject(@NonNull ContentHubObjectId objectId) {
    this.objectId = objectId;
  }

  @Override
  public ContentHubObjectId getId() {
    return objectId;
  }

  @Nullable
  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public String getDisplayName() {
    return getName();
  }

}
