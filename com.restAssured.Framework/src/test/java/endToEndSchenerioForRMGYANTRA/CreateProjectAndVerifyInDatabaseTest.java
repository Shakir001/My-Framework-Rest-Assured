package endToEndSchenerioForRMGYANTRA;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import genericUtility.BaseAPIClass;
import genericUtility.EndPointsUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDatabaseTest extends BaseAPIClass {

	@Test
	public void createProject() throws Throwable
	{
		//create data
		ProjectLibrary pLib=new ProjectLibrary("Kumar", "Proj_001"+jLib.getRandomNumber(), "Created", 25);
		
		//send request
		Response response = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post(EndPointsUtility.createProject);
		
		//API response----capture the response
		String projId = rLib.getJsonData(response, "projectId");
		System.out.println(projId);
		
		//validate the response in database
		String query="select * from project";
		String data = dLib.executeQueryAndReturnData(query, 1, projId);
		
		Assert.assertEquals(projId, data);
	}
}







