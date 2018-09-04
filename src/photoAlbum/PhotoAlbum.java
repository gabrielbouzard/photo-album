package photoAlbum;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.gson.Gson;

public class PhotoAlbum extends GenericJson {
	
	@Key("albumId")
    private int albumId;
//    @Key("id")
//    private int id;
    @Key("title")
    private String title;
//    @Key("url")
//    private PhotoAlbumURL url;
//    @Key("thumbnailUrl")
//    private PhotoAlbumURL thumbnailUrl;
    
    public PhotoAlbum() {
        super();
    }
    
    PhotoAlbum(int albumId, String title) {
    	this.albumId = albumId;
//    	this.id = 0;
    	this.title = title;
//    	this.url = new GenericUrl();
//    	this.thumbnailUrl = new GenericUrl();
    }
    
    public String getAlbumId() {
    	return String.valueOf(this.albumId);
    }
    
//    public String getId() {
//    	return String.valueOf(this.id);
//    }
//    
    public String getTitle() {
    	return String.valueOf(this.title);
    }
    
//    public PhotoAlbumURL getURL() {
//    	return this.url;
//    }
//    
//    public PhotoAlbumURL getThumbnailUrl() {
//    	return this.thumbnailUrl;
//    }
    
    public String get() {
    	return this.toString();
    }
    
    public String toString() {
    	return new Gson().toJson(this);
    }
		
}