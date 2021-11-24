import ContentHub_properties from "@coremedia/studio-client.main.content-hub-editor-components/ContentHub_properties";
import CopyResourceBundleProperties from "@coremedia/studio-client.main.editor-components/configuration/CopyResourceBundleProperties";
import StudioPlugin from "@coremedia/studio-client.main.editor-components/configuration/StudioPlugin";
import Config from "@jangaroo/runtime/Config";
import ConfigUtils from "@jangaroo/runtime/ConfigUtils";
import resourceManager from "@jangaroo/runtime/l10n/resourceManager";
import ContentHubVimeo_properties from "./ContentHubVimeo_properties";

interface ContentHubVimeoStudioPluginConfig extends Config<StudioPlugin> {
}

class ContentHubVimeoStudioPlugin extends StudioPlugin {
  declare Config: ContentHubVimeoStudioPluginConfig;

  static readonly xtype: string = "com.coremedia.blueprint.studio.contenthub.vimeo.ContentHubVimeoStudioPlugin";

  constructor(config: Config<ContentHubVimeoStudioPlugin> = null) {
    super(ConfigUtils.apply(Config(ContentHubVimeoStudioPlugin, {
      configuration: [
        new CopyResourceBundleProperties({
          destination: resourceManager.getResourceBundle(null, ContentHub_properties),
          source: resourceManager.getResourceBundle(null, ContentHubVimeo_properties),
        }),
      ],
    }), config));
  }
}

export default ContentHubVimeoStudioPlugin;
