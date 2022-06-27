package CRUD_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;;

public class GetSingleProjectTest {

	@Test
	public void getSingleProject()
	{
		//send request
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_610");
		
		//validate the response
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(200).log().all();
	}
}
