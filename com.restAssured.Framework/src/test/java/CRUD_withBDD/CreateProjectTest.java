package CRUD_withBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectTest {
	@Test
	public void createProject() {
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		baseURI="http://localhost";
		port=8084;
		
		//create data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Anil");
		jobj.put("projectName", "Rebus"+ranNum);
		jobj.put("status", "Completed");
		jobj.put("teamSize", "8");
		
		//send request
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
				
	}
}
