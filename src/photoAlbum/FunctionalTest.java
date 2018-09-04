package photoAlbum;

import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.jayway.restassured.RestAssured;

public class FunctionalTest {
	
	@BeforeClass
    public static void setup() {
		
		String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(443);
        }
        
        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/photos";
        }
        RestAssured.basePath = basePath;
        
        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "https://jsonplaceholder.typicode.com";
        }
        RestAssured.baseURI = baseHost;
        System.out.println(baseHost+basePath+"?albumId=100");
        
	}
	
	public static void main(String[] args) {
      Result result = JUnitCore.runClasses(TestPhotoAlbum.class, TestPhotoAlbumClient.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
	
}
