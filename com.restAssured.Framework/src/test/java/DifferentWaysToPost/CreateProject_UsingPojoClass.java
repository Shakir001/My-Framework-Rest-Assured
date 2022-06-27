package DifferentWaysToPost;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject_UsingPojoClass {
	@Test
	public void createProjectUsingPojoClass()
	{
		Random r=new Random();
		int ranNum = r.nextInt();
		
		baseURI="http://localhost";
		port=8084;
		
		//create data
		ProjectLibrary pLib=new ProjectLibrary("Sonu", "Dragon"+ranNum, "Completed", 17);
		
		//send data
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		//validate response
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
