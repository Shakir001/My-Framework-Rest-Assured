package CRUD_withBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {

	@Test
	public void deleteProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		when()
			.delete("/projects/TY_PROJ_804")
		.then()
			.assertThat().statusCode(204)
			.log().all();
		System.out.println("deleted successfully");
	}
}
