package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {

	@Test
	public void staticResponse()
	{
		baseURI="http://localhost";
		port=8084;
		
		//send request
		Response resp = when()
			.get("/projects");
		
		//validation
		String expData = "TY_PROJ_006";
		String actData = resp.jsonPath().get("[1].projectId");
		
		Assert.assertEquals(expData, actData);
		resp.then().assertThat().statusCode(200).log().all();
		System.out.println("data verification successful");
	}
}
