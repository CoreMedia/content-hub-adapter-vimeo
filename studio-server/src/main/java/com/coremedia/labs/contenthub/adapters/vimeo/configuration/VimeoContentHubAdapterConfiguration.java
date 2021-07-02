package com.coremedia.labs.contenthub.adapters.vimeo.configuration;

import com.coremedia.labs.contenthub.adapters.vimeo.VimeoContentHubAdapterFactory;
import com.coremedia.labs.contenthub.adapters.vimeo.VimeoContentHubSettings;
import com.coremedia.contenthub.api.ContentHubAdapterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VimeoContentHubAdapterConfiguration {

  @Bean
  public ContentHubAdapterFactory<VimeoContentHubSettings> vimeoContentHubAdapterFactory() {
    return new VimeoContentHubAdapterFactory();
  }

}
