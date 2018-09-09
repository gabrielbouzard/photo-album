package client;


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
    
    public PhotoAlbum(int albumId, String title) {
    	this.albumId = albumId;
    	this.id = 0;
    	this.title = title;
    	this.url = "";
    	this.thumbnailUrl = "";
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
    
    @Override
    public String toString() {
    	return new Gson().toJson(this);
    }
		
}