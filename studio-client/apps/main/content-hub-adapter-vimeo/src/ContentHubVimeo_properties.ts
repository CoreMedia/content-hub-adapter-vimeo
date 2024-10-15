import SvgIconUtil from "@coremedia/studio-client.base-models/util/SvgIconUtil";
import CoreIcons_properties from "@coremedia/studio-client.core-icons/CoreIcons_properties";
import icon from "./icons/vimeo.svg";

/**
 * Interface values for ResourceBundle "ContentHubVimeo".
 * @see ContentHubVimeo_properties#INSTANCE
 */
interface ContentHubVimeo_properties {

/**
 * Adapter
 */
  adapter_type_vimeo_name: string;
  adapter_type_vimeo_icon: string;
/**
 * Folders
 */
  folder_type_vimeoRoot_name: string;
  folder_type_vimeoRoot_icon: string;
  folder_type_vimeoFolder_name: string;
  folder_type_vimeoFolder_icon: string;
/**
 * Items
 */
  item_type_vimeoVideo_name: string;
  item_type_vimeoVideo_icon: string;
/**
 * Details panel
 */
  description_sectionItemKey: string;
  dimensions_sectionItemKey: string;
  color_sectionItemKey: string;
  createdAt_sectionItemKey: string;
  updatedAt_sectionItemKey: string;
  duration_sectionItemKey: string;
  tags_sectionItemKey: string;
  contentRating_sectionItemKey: string;
  status_sectionItemKey: string;
}

/**
 * Singleton for the current user Locale's instance of ResourceBundle "ContentHubVimeo".
 * @see ContentHubVimeo_properties
 */
const ContentHubVimeo_properties: ContentHubVimeo_properties = {
  adapter_type_vimeo_name: "Vimeo",
  adapter_type_vimeo_icon: SvgIconUtil.getIconStyleClassForSvgIcon(icon),
  folder_type_vimeoRoot_name: "Account",
  folder_type_vimeoRoot_icon: SvgIconUtil.getIconStyleClassForSvgIcon(icon),
  folder_type_vimeoFolder_name: "Folder",
  folder_type_vimeoFolder_icon: CoreIcons_properties.folder,
  item_type_vimeoVideo_name: "Video",
  item_type_vimeoVideo_icon: CoreIcons_properties.loaded_video_placeholder,
  description_sectionItemKey: "Description",
  dimensions_sectionItemKey: "Dimensions",
  color_sectionItemKey: "Color",
  createdAt_sectionItemKey: "Created at",
  updatedAt_sectionItemKey: "Updated at",
  duration_sectionItemKey: "Duration",
  tags_sectionItemKey: "Tags",
  contentRating_sectionItemKey: "Content Rating",
  status_sectionItemKey: "Status",
};

export default ContentHubVimeo_properties;
