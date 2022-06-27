package CRUD_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjectsTest {

	@Test
	public void getAllProject()
	{
		//send request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//vaidate response
		resp.then().assertThat().statusCode(200).log().all();
	}
}
