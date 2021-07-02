package com.coremedia.labs.contenthub.adapters.vimeo;

import com.coremedia.contenthub.api.ContentHubAdapter;
import com.coremedia.contenthub.api.ContentHubAdapterFactory;
import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;

@DefaultAnnotation(NonNull.class)
public class VimeoContentHubAdapterFactory implements ContentHubAdapterFactory<VimeoContentHubSettings> {

  private static final String ADAPTER_ID = "vimeo";

  @Override
  public String getId() {
    return ADAPTER_ID;
  }

  @Override
  public ContentHubAdapter createAdapter(@NonNull VimeoContentHubSettings settings,
                                         @NonNull String connectionId) {
    return new VimeoContentHubAdapter(settings, connectionId);
  }
}
