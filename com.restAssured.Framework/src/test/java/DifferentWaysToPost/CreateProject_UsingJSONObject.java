package DifferentWaysToPost;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject_UsingJSONObject {
	@Test
	public void createProject()
	{
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		baseURI="http://localhost";
		port=8084;
		
		//create data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Shakir");
		jobj.put("projectName", "Rebus-"+ranNum);
		jobj.put("status", "Completed");
		jobj.put("teamSize", "8");
		
		//send request
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		//validate response	
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
