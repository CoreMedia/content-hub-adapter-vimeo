package com.coremedia.labs.plugins.adapters.vimeo.service;

import com.coremedia.labs.plugins.adapters.vimeo.service.responses.FolderRepresentation;
import com.coremedia.labs.plugins.adapters.vimeo.service.responses.VideoRepresentation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class VimeoServiceIT {

  private VimeoService testling;

  private static final String USER_ID = "<YOUR USER ID>";
  private static final String ACCESS_TOKEN = "<YOUR ACCESS TOKEN>";
  private static final int FOLDER_ID = 123456;
  private static final int VIDEO_ID = 123456;

  @BeforeEach
  public void setUp() {
    testling = new VimeoService(USER_ID, ACCESS_TOKEN);
  }

  // --- FOLDERS ---

  @Test
  public void testListFolders() {
    List<FolderRepresentation> folders = testling.listFolders();
    assertEquals(2, folders.size());
  }

  @Test
  public void testGetFolderById() {
    FolderRepresentation folder = testling.getFolderById(FOLDER_ID);
    assertNotNull(folder);
    assertEquals("Looks", folder.getName());
  }

  @Test
  public void testGetVideosInFolder() {
    List<VideoRepresentation> videosInFolder = testling.getVideosInFolder(FOLDER_ID);
    assertNotNull(videosInFolder);
    assertEquals(2, videosInFolder.size());
  }

  // --- VIDEOS ---

  @Test
  public void testGetVideoById() {
    VideoRepresentation video = testling.getVideoById(VIDEO_ID);
    assertNotNull(video);
    assertEquals("The Colorful Collection", video.getName());
  }

  @Test
  public void testSearchVideos() {
    List<VideoRepresentation> hits = testling.searchVideos("color", 100);
    assertEquals(1, hits.size());
  }

  @Test
  public void testSearchVideosInFolder() {
    List<VideoRepresentation> hits = testling.searchVideosInFolder("summer", FOLDER_ID, 100);
    assertEquals(2, hits.size());
  }

}
