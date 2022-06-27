package DifferentWaysToPost;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject_UsingHashmap {
	@Test
	public void createProject()
	{
		Random r=new Random();
		int ranNum = r.nextInt(500);
		baseURI="http://localhost";
		port=8084;
		
		//create data
		HashMap map=new HashMap();
		map.put("createdBy", "Shakir");
		map.put("projectName", "Rebus-"+ranNum);
		map.put("status", "Completed");
		map.put("teamSize", "8");
		
		//send request
		given()
			.body(map)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
		
	}
}
