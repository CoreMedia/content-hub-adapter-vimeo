/** @type { import('@jangaroo/core').IJangarooConfig } */
module.exports = {
  type: "code",
  extName: "com.coremedia.labs.plugins__studio-client.content-hub-adapter-vimeo",
  extNamespace: "com.coremedia.labs.plugins.adapters.vimeo",
  sencha: {
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
