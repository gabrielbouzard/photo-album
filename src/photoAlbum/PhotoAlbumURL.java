package photoAlbum;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class PhotoAlbumURL extends GenericUrl {
	
	public PhotoAlbumURL(String encodedURL) {
		super(encodedURL);
	}
	
    @Key("albumId")
    public int albumId;
    
}
