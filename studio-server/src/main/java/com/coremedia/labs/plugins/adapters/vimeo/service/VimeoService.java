package com.coremedia.labs.plugins.adapters.vimeo.service;

import com.coremedia.labs.plugins.adapters.vimeo.service.responses.PagedResponse;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.FolderRepresentation;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.VideoRepresentation;
import edu.umd.cs.findbugs.annotations.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Service class wrapping all API calls to Vimeo API.
 * See <a href="https://developer.vimeo.com/api">Vimeo API Documentation</a> for details.
 */
@Service
public class VimeoService {

  private static final Logger LOG = LoggerFactory.getLogger(VimeoService.class);

  private static final String DEFAULT_API_ENDPOINT = "https://api.vimeo.com/";

  private RestTemplate restTemplate;
  private String apiEndpoint = DEFAULT_API_ENDPOINT;
  private final String userId;
  private final String accessToken;

  public VimeoService(@NonNull String userId, @NonNull String accessToken) {
    this(userId, accessToken, DEFAULT_API_ENDPOINT);
  }

  public VimeoService(@NonNull String userId, @NonNull String accessToken, String apiEndpoint) {
    this.userId = userId;
    this.accessToken = accessToken;
    if (StringUtils.isNotBlank(apiEndpoint)) {
      this.apiEndpoint = apiEndpoint;
    }

    this.restTemplate = new RestTemplate();
  }


  // --- FOLDERS (PROJECTS) ------------------------------------------------------------------------------------------

  private static final int DEFAULT_FOLDERS_PAGE = 1;
  private static final int DEFAULT_FOLDERS_PER_PAGE = 100;

  public List<FolderRepresentation> listFolders() {
    return listFolders(DEFAULT_FOLDERS_PAGE, DEFAULT_FOLDERS_PER_PAGE);
  }

  public List<FolderRepresentation> listFolders(int page, int perPage) {
    ResponseEntity<PagedResponse<FolderRepresentation>> response = performApiCall("/users/{userId}/projects",
            Map.of("userId", userId),
            Map.of(
                    "page", page,
                    "per_page", perPage

            ),
            new ParameterizedTypeReference<PagedResponse<FolderRepresentation>>() {
            }
    );

    return Optional.ofNullable(response.getBody())
            .map(PagedResponse::getData)
            .orElse(Collections.emptyList());
  }

  public FolderRepresentation getFolderById(int folderId) {
    ResponseEntity<FolderRepresentation> response = performApiCall("/users/{userId}/projects/{projectId}",
            Map.of(
                    "userId", userId,
                    "projectId", folderId
            ),
            null,
            FolderRepresentation.class);
    return response.getBody();
  }

  public List<VideoRepresentation> getVideosInFolder(int folderId) {
    ResponseEntity<PagedResponse<VideoRepresentation>> response = performApiCall("/users/{userId}/projects/{projectId}/videos?direction=asc&per_page=100&sort=default",
            Map.of(
                    "userId", userId,
                    "projectId", folderId
            ),
            Map.of(
                    "direction", "asc",
                    "per_page", 100,
                    "sort", "alphabetical"
            ),
            new ParameterizedTypeReference<PagedResponse<VideoRepresentation>>() {
            }
    );

    return Optional.ofNullable(response.getBody())
            .map(PagedResponse::getData)
            .orElse(Collections.emptyList());
  }


  // --- VIDEOS ------------------------------------------------------------------------------------------------------

  public VideoRepresentation getVideoById(int videoId) {
    ResponseEntity<VideoRepresentation> response = performApiCall("/videos/{videoId}",
            Map.of(
                    "videoId", videoId
            ),
            null,
            VideoRepresentation.class);
    return response.getBody();
  }

  /**
   * Search for videos.
   *
   * @param query search term
   * @param limit limit
   * @return
   */
  public List<VideoRepresentation> searchVideos(String query, int limit) {
    int perPage = limit > 0 && limit <= 100 ? limit : 100;
    ResponseEntity<PagedResponse<VideoRepresentation>> response = performApiCall("/users/{userId}/videos?direction=asc&per_page=100&sort=default",
            Map.of(
                    "userId", userId
            ),
            Map.of(
                    "query", query,
                    "direction", "asc",
                    "per_page", perPage,
                    "sort", "alphabetical"
            ),
            new ParameterizedTypeReference<PagedResponse<VideoRepresentation>>() {
            }
    );

    return Optional.ofNullable(response.getBody())
            .map(PagedResponse::getData)
            .orElse(Collections.emptyList());
  }

  /**
   * Search for videos in the given folder.
   *
   * @param query    search query
   * @param folderId folder id
   * @param limit    limit
   * @return
   */
  public List<VideoRepresentation> searchVideosInFolder(@NonNull String query, int folderId, int limit) {
    if (StringUtils.isBlank(query)) {
      return Collections.emptyList();
    }

    int perPage = limit > 0 && limit <= 100 ? limit : 100;
    ResponseEntity<PagedResponse<VideoRepresentation>> response = performApiCall("/users/{userId}/projects/{projectId}/videos?direction=asc&per_page=100&sort=default",
            Map.of(
                    "userId", userId,
                    "projectId", folderId
            ),
            Map.of(
                    "query", query,
                    "direction", "asc",
                    "per_page", perPage,
                    "sort", "alphabetical"
            ),
            new ParameterizedTypeReference<PagedResponse<VideoRepresentation>>() {
            }
    );

    return Optional.ofNullable(response.getBody())
            .map(PagedResponse::getData)
            .orElse(Collections.emptyList());
  }


  // --- INTERNAL ----------------------------------------------------------------------------------------------------

  private <T> ResponseEntity<T> performApiCall(String path, Class<T> responseType) {
    return performApiCall(path, Map.of(), Map.of(), responseType);
  }

  private <T> ResponseEntity<T> performApiCall(String path, Map<String, Object> pathVariables, Map<String, Object> queryParams, Class<T> responseType) {
    return performApiCall(path, pathVariables, queryParams, ParameterizedTypeReference.forType(responseType));
  }

  private <T> ResponseEntity<T> performApiCall(String path, Map<String, Object> pathVariables, Map<String, Object> queryParams, ParameterizedTypeReference<T> responseType) {
    if (pathVariables == null) {
      pathVariables = Map.of();
    }

    if (queryParams == null) {
      queryParams = Map.of();
    }

    // Build headers
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

    // Build request entity
    HttpEntity<String> entity = new HttpEntity<>(null, headers);

    // Build request URI
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(buildUrl(path));

    // Add query params
    for (Map.Entry<String, Object> queryParam : queryParams.entrySet()) {
      uriBuilder.queryParam(queryParam.getKey(), queryParam.getValue());
    }

    // perform request
    String url = uriBuilder.buildAndExpand(pathVariables).toUriString();
    LOG.debug("GET - {}", url);
    return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
  }

  private String buildUrl(String path) {
    return apiEndpoint + path;
  }

}
