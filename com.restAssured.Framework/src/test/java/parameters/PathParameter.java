package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {

	@Test
	public void pathParameter()
	{
		baseURI="http://localhost";
		port=8084;
		
		//step:1 prerequisite
		given()
			.pathParam("pId", "TY_PROJ_618")
		
		//step:2 send request
		.when()
			.get("/projects/{pId}")
			
		//step:3 validate data
		.then()
			.assertThat().statusCode(200).log().all();
	}
}
