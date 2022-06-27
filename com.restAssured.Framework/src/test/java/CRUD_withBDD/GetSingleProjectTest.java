package CRUD_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest {
	@Test
	public void fetchSingleProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
			.get("/projects/TY_PROJ_805")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
