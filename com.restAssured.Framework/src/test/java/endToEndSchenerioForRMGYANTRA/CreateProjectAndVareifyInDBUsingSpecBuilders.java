package endToEndSchenerioForRMGYANTRA;

import org.testng.Assert;
import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import genericUtility.BaseAPIClassWithBuilders;
import genericUtility.EndPointsUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVareifyInDBUsingSpecBuilders extends BaseAPIClassWithBuilders{

	@Test
	public void createProject() throws Throwable
	{
		//create data
		ProjectLibrary pLib=new ProjectLibrary("Ravi", "Project_100", "status", 35);
		
		//send request
		Response response = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post(EndPointsUtility.createProject);
		
		//API response------capture the response
		rLib.logAll(response);
		String projId = rLib.getJsonData(response, "projectId");
		System.out.println(projId);
		
		//validate response in database
		String query="select * from project";
		String data = dLib.executeQueryAndReturnData(query, 1, projId);
		
		Assert.assertEquals(projId, data);
	}
}







