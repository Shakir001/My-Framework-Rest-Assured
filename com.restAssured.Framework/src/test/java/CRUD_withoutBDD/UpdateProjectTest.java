package CRUD_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProject()
	{
		//create project
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sagar");
		jobj.put("projectName", "Sagar_Proj_01");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 50);
		
		//send request
		RequestSpecification req = new RestAssured().given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_803");
		
		//validate
		resp.then().assertThat().statusCode(200).log().all();
	}
}
