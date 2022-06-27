package CRUD_withoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {

	@Test
	public void createProject()
	{
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		//create necessary data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Salman");
		jobj.put("projectName", "BeingHuman"+ranNum);
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		//send the request
		RequestSpecification req = new RestAssured().given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response resp = req.post("http://localhost:8084/addProject");
		
		//validate the response
		ValidatableResponse val = resp.then();
		val.assertThat().statusCode(201);
		
		System.out.println("created successfully");
		
//		System.out.println(resp.asPrettyString());
//		System.out.println(resp.asString());
//		System.out.println(resp.prettyPrint());
//		System.out.println(resp.prettyPeek());
		
//		System.out.println(resp.getStatusCode());
//		System.out.println(resp.getContentType());
//		System.out.println(resp.getSessionId());
//		System.out.println(resp.getTime());
	
		System.out.println(val.log().all());
		
	}
}
