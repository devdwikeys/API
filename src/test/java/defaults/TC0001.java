package defaults;

import org.junit.runner.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC0001 {

	@Test
	void getApi() {
		
		//specify base URI
		RestAssured.baseURI = "https://api.punkapi.com/v2/beers?page=2&per_page=";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "20");
		Response response1 = httpRequest.request(Method.GET, "5");
		Response response2 = httpRequest.request(Method.GET, "1");
		
		String responseBody = response.getBody().asString();
		String responseBody1 = response1.getBody().asString();
		String responseBody2 = response2.getBody().asString();
		System.out.println("Response body [20] is : " + responseBody);
		System.out.println("Response body [5] is : " + responseBody1);
		System.out.println("Response body [1] is : " + responseBody2);
	}
}
