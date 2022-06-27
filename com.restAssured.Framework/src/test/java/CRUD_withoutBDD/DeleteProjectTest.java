package CRUD_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProjectTest {

	@Test
	public void deleteProject()
	{
		//send request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_802");
		
		//validate
		resp.then().assertThat().statusCode(204).log().all();
	}
}
