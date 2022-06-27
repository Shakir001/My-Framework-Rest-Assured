package DifferentWaysToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProject_UsingJSONFile {
	@Test
	public void createProject()
	{
		baseURI="http://localhost";
		port=8084;
		
		//create data
		File file=new File(".\\data.json");
		
		//send data
		given()
			.body(file)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
