package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Getrequestwithpara {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		
		RequestSpecification request = RestAssured.given();
		
		Response response = request.get("/6");
		
		String body = response.getBody().asString();
		
		System.out.println("Response body is " + body);
		
		Assert.assertTrue(body.contains("Tom"));
		
		JsonPath json = response.jsonPath();
		
		String name = json.get("name"); 
		
		Assert.assertEquals(name, "Tom");
		}

}


