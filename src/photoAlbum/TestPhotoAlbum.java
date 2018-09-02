package photoAlbum;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPhotoAlbum {
	
	protected String id = "4";
	protected String title = "loris ipsum";
	protected PhotoAlbum photoAlbum = new PhotoAlbum(4, "loris ipsum");
	
	@Test
	public void testGetId() {
		assertEquals(id, photoAlbum.getId());
		assertFalse(String.valueOf(5) == photoAlbum.getId());
		assertNotNull(id, photoAlbum.getId());
	}
	
	@Test
	public void testGetTitle() {
		assertEquals(title, photoAlbum.getTitle());
		assertFalse("Loris ipsum" == photoAlbum.getTitle());
		assertNotNull(title, photoAlbum.getTitle());
	}

}
