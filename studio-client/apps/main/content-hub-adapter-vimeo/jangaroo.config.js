/** @type { import('@jangaroo/core').IJangarooConfig } */
module.exports = {
  type: "code",
  sencha: {
    name: "com.coremedia.labs.plugins__studio-client.content-hub-adapter-vimeo",
    namespace: "com.coremedia.labs.plugins.adapters.vimeo",
    studioPlugins: [
      {
        mainClass: "com.coremedia.labs.plugins.adapters.vimeo.ContentHubVimeoStudioPlugin",
        name: "Content Hub - Vimeo",
      },
    ],
  },
  command: {
    build: {
      ignoreTypeErrors: true
    },
  },
};
