package com.coremedia.blueprint.contenthub.adapters.vimeo.service;

import com.coremedia.labs.contenthub.adapters.vimeo.service.responses.FolderRepresentation;
import com.coremedia.labs.contenthub.adapters.vimeo.service.VimeoService;
import com.coremedia.labs.contenthub.adapters.vimeo.service.responses.VideoRepresentation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class VimeoServiceIT {

    private VimeoService testling;

    private static final String USER_ID = "<YOUR USER ID>";
    private static final String ACCESS_TOKEN = "<YOUR ACCESS TOKEN>";
    private static final int FOLDER_ID = 123456;
    private static final int VIDEO_ID = 123456;

    @Before
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
        List<VideoRepresentation> hits = testling.searchVideos("lilly", FOLDER_ID, 100);
        assertEquals(1, hits.size());
    }

}
