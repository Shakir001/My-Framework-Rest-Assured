package dataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PojoClass.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMultipleProjects_usingDataProvider {

	@Test(dataProvider = "getData")
	public void createMultipleProject(String createdBy,String projectName,String status, int teamSize)
	{
		baseURI="http://localhost";
		port=8084;
		
		Random r=new Random();
		int ranNum = r.nextInt(500);
		
		//step:1 read data from data provider
		ProjectLibrary pLib=new ProjectLibrary(createdBy, projectName+ranNum, status, teamSize);
		
		//step:2 send request
		Response resp = given()
			.body(pLib)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject");
		
		//validate the response
		String actData = resp.jsonPath().get("msg");
		Assert.assertEquals("Successfully Added", actData);
		resp.then().log().all();
	}
	@DataProvider(name="getData")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		
		data[0][0]="iqbal";
		data[0][1]="Accionlabs";
		data[0][2]="Created";
		data[0][3]=20;
		
		data[1][0]="bibhu";
		data[1][1]="Amcods";
		data[1][2]="Created";
		data[1][3]=25;
		
		data[2][0]="rakesh";
		data[2][1]="Infosys";
		data[2][2]="Created";
		data[2][3]=30;
		
		return data;
		
	}
}
