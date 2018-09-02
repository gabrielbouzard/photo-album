package photoAlbum;

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
    
    private static boolean isInteger(String input) {
		boolean integer = true;
		try {
			Integer.parseInt(input.trim());
		} catch(NumberFormatException e) {
			integer = false;
		}
		return integer;
	}
	
	public static void main(String args[]) throws Exception {
		
		Integer albumId = null;
		
		if (args.length == 0) {
			System.out.println("Proper Usage: photo-album <albumId>");
			System.exit(0);
		} else if (isInteger(args[0]) == false) {
			System.out.println("Proper Usage: photo-album <albumId>");
			System.exit(0);
		} else if (isInteger(args[0]) == true) {
			albumId = Integer.parseInt(args[0].trim());
		}	
	
		try {
			
	        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
	              request.setParser(new JsonObjectParser(JSON_FACTORY));
	        });
	        PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
	        url.albumId = albumId;
			HttpRequest request = requestFactory.buildGetRequest(url);
			java.lang.reflect.Type type = new TypeToken<List<PhotoAlbum>>() {}.getType();		
			@SuppressWarnings("unchecked")
			List<PhotoAlbum> photoAlbums = (List<PhotoAlbum>)request.execute().parseAs(type);
			for (var photoAlbum : photoAlbums) {
				System.out.println("[" + photoAlbum.getId() + "] " + photoAlbum.getTitle());
			}
			
		} catch (Exception e) {
			System.out.println("photo-album encountered an error. Please try again and contact the developer if the issue persists:  ");
		}
	}	
}
