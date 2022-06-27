package requestChaining;

import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class RequestChaining_CreateAndGet {

	@Test
	public void createDataAndGet()
	{
		baseURI="http://localhost";
		port=8084;
		
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		/*create data*/
		//step:1 create project using POST()
		ProjectLibrary pLib=new ProjectLibrary("Guru", "TestYantra"+ranNum, "Created", 50);
		
		Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject");
		
		//step:2 capture the response using jsonPath()
		//step: 3 store data in variable
		String projectIdCaptured = resp.jsonPath().get("projectId");
		
		System.out.println(projectIdCaptured);
		
		/*get the data*/
		//step:4 create another request and use the captured variable
		given()
			.pathParam("pid", projectIdCaptured)
			.when()
				.get("/projects/{pid}")
				
		//step:5 validate
		.then().assertThat().statusCode(200).log().all();
		
	}
}




