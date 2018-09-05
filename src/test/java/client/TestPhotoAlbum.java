package client;

import org.junit.Test;
import client.PhotoAlbum;

import static org.junit.Assert.*;

public class TestPhotoAlbum {
	
	protected String albumId = "4";
	protected String title = "loris ipsum";
	protected PhotoAlbum photoAlbum = new PhotoAlbum(4, "loris ipsum");
	
	@Test
	public void testGetId() {
		assertEquals(albumId, photoAlbum.getAlbumId());
		assertFalse(String.valueOf(5) == photoAlbum.getAlbumId());
		assertNotNull(albumId, photoAlbum.getAlbumId());
	}
	
	@Test
	public void testGetTitle() {
		assertEquals(title, photoAlbum.getTitle());
		assertFalse("Loris ipsum" == photoAlbum.getTitle());
		assertNotNull(title, photoAlbum.getTitle());
	}

}
