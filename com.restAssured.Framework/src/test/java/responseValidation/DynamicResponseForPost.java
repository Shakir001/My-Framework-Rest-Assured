package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class DynamicResponseForPost {

	@Test
	public void dynamicResponse()
	{
		String expData = "Successfully Added";
		baseURI="http://localhost";
		port=8084;
		
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		//create data
		ProjectLibrary pLib=new ProjectLibrary("Akshay", "Qalcon"+ranNum, "Created", 10);
		
		//send data
		 Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject");
			
		//validate response
		String actData = resp.jsonPath().get("msg");
		Assert.assertEquals(expData, actData);
		
		resp.then().log().all();
	}
}




