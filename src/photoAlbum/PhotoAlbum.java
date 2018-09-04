package photoAlbum;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.gson.Gson;

public class PhotoAlbum extends GenericJson {
	
	@Key("albumId")
    private Integer albumId;
    @Key("id")
    private Integer id;
    @Key("title")
    private String title;
    @Key("url")
    private String url;
    @Key("thumbnailUrl")
    private String thumbnailUrl;

    public PhotoAlbum() {
        super();
    }
    
    PhotoAlbum(int albumId, String title) {
    	this.albumId = albumId;
    	this.id = 0;
    	this.title = title;
    	this.url = "";
    	this.thumbnailUrl = "";
    }
    
    PhotoAlbum(int albumId, int id, String title, String url, String thumbnailUrl) {
    	this.albumId = albumId;
    	this.id = id;
    	this.title = title;
    	this.url = url;
    	this.thumbnailUrl = thumbnailUrl;
    }

	public String getAlbumId() {
    	return String.valueOf(this.albumId);
    }
    
    public String getId() {
    	return String.valueOf(this.id);
    }
    
    public String getTitle() {
    	return String.valueOf(this.title);
    }
    
    public PhotoAlbumURL getURL() {
    	return new PhotoAlbumURL(this.url);
    }
    
    public PhotoAlbumURL getThumbnailUrl() {
    	return new PhotoAlbumURL(this.thumbnailUrl);
    }
    
    public String get() {
    	return this.toString();
    }
    
    public String toString() {
    	return new Gson().toJson(this);
    }
		
}