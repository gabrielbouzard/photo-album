package client;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import client.PhotoAlbumURL;
import client.PhotoAlbumClient;

public class TestPhotoAlbumClient {
	
//	static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//	static JsonFactory JSON_FACTORY = new JacksonFactory();
//	
//	@Test
//	public void connected() {
//        given().when().get("").then().statusCode(200);
//	}
//	
//    @Test
//    public void invalidAlbum() {
//        given().params("albumId", "200").when().get().then().body(CoreMatchers.containsString("[]"));
//    }
//    
//    @Test
//    public void verifyAlbumId100() {  	
//    	given().params("albumId", "100").when().get().then().body(CoreMatchers.containsString("ut maxime reiciendis veritatis"));
//    }
//    
//    @Test
//    public void verifyNumberTracks() {  	
//    	String pa = given().params("albumId", "100").when().get().asString();
//		JsonParser parser = new JsonParser();
//		JsonElement je = parser.parse(pa);
//		JsonArray ja = je.getAsJsonArray();
//		assert(ja.size() == 50);		
//    }
//	
//	@Test
//	public void path() throws ClientProtocolException, IOException {
//				  
//	   HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
//           request.setParser(new JsonObjectParser(JSON_FACTORY));
//	   });
//	   
//	   Random rand = new Random();
//	   int n = rand.nextInt(1000) + 1;
//	   PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
//	   url.albumId = n;
//	   HttpRequest request = requestFactory.buildGetRequest(url);
//	   HttpResponse response = request.execute();
//	   assert(response.isSuccessStatusCode());
//		   
//	}
//	
//	@Test
//	public void contentType() throws ClientProtocolException, IOException {
//		
//		HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory((HttpRequest request) -> {
//			request.setParser(new JsonObjectParser(JSON_FACTORY));
//		});
//		  
//		PhotoAlbumURL url = new PhotoAlbumURL("https://jsonplaceholder.typicode.com/photos");
//		String jsonMimeType = "application/json";
//		HttpRequest request = requestFactory.buildGetRequest(url);
//		HttpResponse response = request.execute();
//		String mimeType = response.getContentType();
//		assert(mimeType.contains(jsonMimeType));
//		
//	}	
//	
	
	@Test
	public void nullOrEmpty() {
		// Arrange
		final boolean expected = false;
		// Act
		final String[] actual = {};
		// Assert
		Assert.assertNotEquals(client.PhotoAlbumClient.nullOrEmpty(actual), expected);
	}
	
	@Test
	public void notNullOrEmpty() {
		// Arrange
		final boolean expected = false;
		// Act
		final String[] actual = {"abc"};		
		// Assert
		Assert.assertEquals(client.PhotoAlbumClient.nullOrEmpty(actual), expected);
	}
	
	@Test
	public void isInteger() {
		// Arrange
		final boolean expected = true;
		// Act
		final String actual = "4";
		// Assert
		Assert.assertEquals(client.PhotoAlbumClient.isInteger(actual), expected);
	}
	
	@Test
	public void isNotInteger() {
		// Arrange
		final int expected = 4;
		// Act
		final String actual = "4.0";
		// Assert
		Assert.assertNotEquals(client.PhotoAlbumClient.isInteger(actual), expected);
	}
	
	@Test
	public void validURL() {
		// Arrange
		final boolean expected = true;
		// Act
		final String actual = "https://jsonplaceholder.typicode.com/photos";
		// Assert
		Assert.assertEquals(client.PhotoAlbumClient.validURL(actual), expected);
	}
	
	@Test
	public void notValidURL() {
		// Arrange
		final boolean expected = false;
		// Act
		final String actual = "jsonplaceholder.typicode.com/photos";
		// Assert
		Assert.assertEquals(client.PhotoAlbumClient.validURL(actual), expected);
	}
	
}
