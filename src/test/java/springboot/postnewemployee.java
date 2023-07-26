package springboot;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postnewemployee {

	@Test
	
	public void test1() {
		
	JSONObject requestBody = new JSONObject();
	requestBody.put("firstName", "John");
	requestBody.put("lastName", "Mehta");
	requestBody.put("salary", "30000");
	requestBody.put("email", "JohnM30@gmail.com");
	
	RestAssured.baseURI = "http://localhost:8088/employees";
	
	RequestSpecification request = RestAssured.given();
	
	Response response = request.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(requestBody.toString()).post();
	
	String body = response.getBody().asString();
	System.out.println("Response body is " + body);
	System.out.println("Response body is " + response.statusCode());

		
	}
}
