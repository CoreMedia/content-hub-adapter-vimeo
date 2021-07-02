package com.coremedia.labs.contenthub.adapters.vimeo;

import com.coremedia.labs.contenthub.adapters.vimeo.model.VimeoContentHubType;
import com.coremedia.labs.contenthub.adapters.vimeo.model.VimeoFolder;
import com.coremedia.labs.contenthub.adapters.vimeo.model.VimeoVideoItem;
import com.coremedia.labs.contenthub.adapters.vimeo.service.VimeoService;
import com.coremedia.contenthub.api.ContentHubAdapter;
import com.coremedia.contenthub.api.ContentHubContext;
import com.coremedia.contenthub.api.ContentHubObject;
import com.coremedia.contenthub.api.ContentHubObjectId;
import com.coremedia.contenthub.api.ContentHubTransformer;
import com.coremedia.contenthub.api.ContentHubType;
import com.coremedia.contenthub.api.Folder;
import com.coremedia.contenthub.api.GetChildrenResult;
import com.coremedia.contenthub.api.Item;
import com.coremedia.contenthub.api.exception.ContentHubException;
import com.coremedia.contenthub.api.pagination.PaginationRequest;
import com.coremedia.contenthub.api.search.ContentHubSearchResult;
import com.coremedia.contenthub.api.search.ContentHubSearchService;
import com.coremedia.contenthub.api.search.Sort;
import com.coremedia.labs.contenthub.adapters.vimeo.service.responses.FolderRepresentation;
import com.coremedia.labs.contenthub.adapters.vimeo.service.responses.VideoRepresentation;
import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;


public class VimeoContentHubAdapter implements ContentHubAdapter, ContentHubSearchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VimeoContentHubAdapter.class);

    private final String connectionId;
    private final VimeoContentHubSettings settings;

    private VimeoService vimeoService;

    private VimeoFolder rootFolder;

    public VimeoContentHubAdapter(VimeoContentHubSettings settings, String connectionId) {
        this.settings = settings;
        this.connectionId = connectionId;

        rootFolder = new VimeoFolder(new ContentHubObjectId(connectionId, "root"), settings.getDisplayName(), VimeoContentHubType.ROOT);

        vimeoService = new VimeoService(settings.getUserId(), settings.getAccessToken(), settings.getApiEndpoint());
    }

    // --- ContentHubAdapter ---------------------------------------------------------------------------------------------

    @Override
    public Folder getRootFolder(ContentHubContext context) throws ContentHubException {
        return rootFolder;
    }

    @Nullable
    @Override
    public Folder getFolder(ContentHubContext context, ContentHubObjectId id) throws ContentHubException {
        if (rootFolder.getId().equals(id)) {
            return rootFolder;
        }

        VimeoFolder folder = Optional.of(extractIdFromUri(id.getExternalId()))
                .map(folderId -> vimeoService.getFolderById(folderId))
                .map(this::createVimeoFolder)
                .orElse(null);

        return folder;
    }

    public List<Folder> getSubFolders(ContentHubContext context, Folder folder) throws ContentHubException {
        List<Folder> folders = Collections.emptyList();
        if (rootFolder == folder) {
             folders = vimeoService.listFolders()
                    .stream()
                    .map(this::createVimeoFolder)
                    .collect(Collectors.toUnmodifiableList());
            return folders;
        }
        return folders;
    }

    @Nullable
    @Override
    public Folder getParent(ContentHubContext context, ContentHubObject contentHubObject) throws ContentHubException {
        Folder parent = (rootFolder == contentHubObject) ? null : getRootFolder(context);
        return parent;
    }

    public List<Item> getItems(ContentHubContext context, Folder folder) throws ContentHubException {
        List<Item> items = Collections.emptyList();

        int folderId = extractIdFromUri(folder.getId().getExternalId());
        if (folderId > 0) {
            items = vimeoService.getVideosInFolder(folderId).stream()
                    .map(this::createVideoItem)
                    .collect(Collectors.toUnmodifiableList());
        }

        return items;
    }

    @Nullable
    @Override
    public Item getItem(ContentHubContext context, ContentHubObjectId id) throws ContentHubException {
        int videoId = extractIdFromUri(id.getExternalId());
        return Optional.ofNullable(vimeoService.getVideoById(videoId))
                .map(this::createVideoItem)
                .orElse(null);
    }

    @Override
    public GetChildrenResult getChildren(ContentHubContext context, Folder folder, @Nullable PaginationRequest paginationRequest) {
        List<ContentHubObject> children = new ArrayList<>();
        children.addAll(getSubFolders(context, folder));
        children.addAll(getItems(context, folder));
        return new GetChildrenResult(children);
    }

    @Override
    public ContentHubTransformer transformer() {
        return new VimeoContentHubTransformer();
    }


    // --- ContentHubSearchService ---------------------------------------------------------------------------------------

    private static final List<ContentHubType> SEARCH_TYPES = List.of(
            VimeoContentHubType.VIDEO.getType()
    );

    @NonNull
    @Override
    public Optional<ContentHubSearchService> searchService() {
        return Optional.of(this);
    }

    @Override
    public ContentHubSearchResult search(@NonNull String query,
                                         @Nullable Folder belowFolder,
                                         @Nullable ContentHubType type,
                                         Collection<String> filterQueries,
                                         List<Sort> sortCriteria,
                                         int limit) {
        ContentHubSearchResult result = new ContentHubSearchResult(Collections.emptyList());

        // Search is just supported in sub-folders and must contain a query string
        if (rootFolder.equals(belowFolder) || StringUtils.isBlank(query)) {
            return result;
        }

        int folderId = extractIdFromUri(belowFolder.getId().getExternalId());
        if (StringUtils.isNotBlank(query) && folderId > 0) {
            List<VideoRepresentation> searchResults = vimeoService.searchVideos(query, folderId, limit);
            List<VimeoVideoItem> hits = searchResults.stream().map(this::createVideoItem).collect(Collectors.toUnmodifiableList());
            result = new ContentHubSearchResult(hits, hits.size());
        }


        return result;
    }

    @Override
    public boolean supportsSearchBelowFolder() {
        return true;
    }

    @Override
    public Collection<ContentHubType> supportedTypes() {
        return SEARCH_TYPES;
    }

    // --- INTERNAL ------------------------------------------------------------------------------------------------------

    private VimeoFolder createVimeoFolder(@NonNull FolderRepresentation folder) {
        ContentHubObjectId hubId = new ContentHubObjectId(connectionId, folder.getUri());
        return new VimeoFolder(hubId, folder.getName());
    }

    private VimeoVideoItem createVideoItem(@NonNull VideoRepresentation video) {
        ContentHubObjectId hubId = new ContentHubObjectId(connectionId, video.getUri());
        return new VimeoVideoItem(hubId, video);
    }

    /**
     * Extract the numeric entity id from the given entity uri.
     * @param uri
     * @return
     */
    private int extractIdFromUri(String uri) {
        return Arrays.stream(uri.split("/"))
                .reduce((first, second) -> second)
                .filter(StringUtils::isNumeric)
                .map(Integer::parseInt)
                .orElse(-1);
    }

}
