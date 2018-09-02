package photoAlbum;

import com.google.api.client.util.Key;

public class PhotoAlbum {
	
    @Key("id")
    private long id;
    @Key("title")
    private String title;
    
    public String getId() {
    	return String.valueOf(this.id);
    }
    
    public String getTitle() {
    	return String.valueOf(this.title);
    }
		
}