package client;

import java.net.URL;
import java.util.List;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.reflect.TypeToken;

public class PhotoAlbumClient {
	
	static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	static JsonFactory JSON_FACTORY = new JacksonFactory();
	
    static boolean isInteger(String input) {
		boolean integer = true;
		try {
			Integer.parseInt(input.trim());
		} catch(NumberFormatException e) {
			integer = false;
		}
		return integer;
	}
    
    static boolean nullOrEmpty(String[] args) {
         if(args == null || args.length == 0) {
             return true;
         }
         return false;
    }
    
    static boolean validURL(String url) { 
        try { 
            new URL(url).toURI(); 
            return true; 
        } 
        catch (Exception e) { 
            return false; 
        } 
    }
    	
	public static void main(String[] args) {
		
		Integer albumId = null;
		
		if (nullOrEmpty(args) || !isInteger(args[0])) {
			System.out.println("Proper Usage: photo-album <albumId>");
			System.exit(0);
		} else {
			albumId = Integer.parseInt(args[0].trim());
		}	
	
		try {
			
	        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> 
	        	request.setParser(new JsonObjectParser(JSON_FACTORY)));
	        
	        String apiURL = "https://jsonplaceholder.typicode.com/photos";
	        if (validURL(apiURL)) {
	        	PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
		        url.albumId = albumId;
				HttpRequest request = requestFactory.buildGetRequest(url);
				java.lang.reflect.Type type = new TypeToken<List<PhotoAlbum>>() {}.getType();	
				Object response = request.execute().parseAs(type);
				@SuppressWarnings("unchecked")
				List<PhotoAlbum> photoAlbums = (List<PhotoAlbum>)response;
				for(PhotoAlbum photoAlbum : photoAlbums) {
					System.out.println("[" + photoAlbum.getId() + "] " + photoAlbum.getTitle());
				}
	        } else {
	        	System.out.println("photo-album encountered an error. Please ensure the API base URL is valid.");
	        }
		
		} catch (Exception e) {
			System.out.println("photo-album encountered an error. Please try again and contact the developer if the issue persists: https://github.com/gabrielbouzard/photo-album.git");
		}
	}
}
