package com.coremedia.labs.contenthub.adapters.vimeo.model;

import com.coremedia.contenthub.api.ContentHubObjectId;
import com.coremedia.contenthub.api.ContentHubType;
import com.coremedia.contenthub.api.Folder;
import edu.umd.cs.findbugs.annotations.NonNull;

public class VimeoFolder extends VimeoContentHubObject implements Folder {

  private final ContentHubType type;
  private final String name;

  public VimeoFolder(@NonNull ContentHubObjectId objectId, String name) {
    this(objectId, name, VimeoContentHubType.FOLDER);
  }
  public VimeoFolder(@NonNull ContentHubObjectId objectId, String name, VimeoContentHubType type) {
    super(objectId);
    this.name = name;
    this.type = type.getType();
  }

  @Override
  public String getName() {
    return name;
  }

  @NonNull
  @Override
  public ContentHubType getContentHubType() {
    return type;
  }

}
