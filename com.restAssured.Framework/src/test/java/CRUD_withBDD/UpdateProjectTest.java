package CRUD_withBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		//create data
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Iqbal");
		jobj.put("projectName", "Iqbal_Proj_01");
		jobj.put("status", "Completed");
		jobj.put("teamSize", "90");
		
		//send request
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.put("/projects/TY_PROJ_803")
		.then()
			.assertThat().statusCode(200)
			.log().all();
		
	}
}
