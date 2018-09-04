package photoAlbum;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

public class TestPhotoAlbumClient extends FunctionalTest {
	
	static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	static JsonFactory JSON_FACTORY = new JacksonFactory();
	
	@Test
	public void connected() {
        given().when().get("").then().statusCode(200);
	}
	
    @Test
    public void invalidAlbum() {
        given().params("albumId", "200").when().get().then().body(CoreMatchers.containsString("[]"));
    }
    
    @Test
    public void verifyAlbumId100() {  	
    	given().params("albumId", "100").when().get().then().body(CoreMatchers.containsString("ut maxime reiciendis veritatis"));
    }
	
	@Test
	public void path() throws ClientProtocolException, IOException {
				  
	   HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
           request.setParser(new JsonObjectParser(JSON_FACTORY));
	   });
	   
	   Random rand = new Random();
	   int n = rand.nextInt(1000) + 1;
	   PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
	   url.albumId = n;
	   HttpRequest request = requestFactory.buildGetRequest(url);
	   HttpResponse response = request.execute();
	   assert(response.isSuccessStatusCode());
		   
	}
	
	@Test
	public void contentType() throws ClientProtocolException, IOException {
		
		HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
			request.setParser(new JsonObjectParser(JSON_FACTORY));
		});
		  
		PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
		String jsonMimeType = "application/json";
		HttpRequest request = requestFactory.buildGetRequest(url);
		HttpResponse response = request.execute();
		String mimeType = response.getContentType();
		assert(mimeType.contains(jsonMimeType));
		
	}	
}
