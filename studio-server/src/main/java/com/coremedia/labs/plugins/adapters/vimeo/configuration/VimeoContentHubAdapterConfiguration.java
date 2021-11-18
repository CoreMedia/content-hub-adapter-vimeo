package com.coremedia.labs.plugins.adapters.vimeo.configuration;

import com.coremedia.labs.plugins.adapters.vimeo.VimeoContentHubAdapterFactory;
import com.coremedia.labs.plugins.adapters.vimeo.VimeoContentHubSettings;
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
