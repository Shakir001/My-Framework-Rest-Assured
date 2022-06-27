package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamicResponse()
	{
		String expData = "TY_PROJ_803";
		baseURI="http://localhost";
		port=8084;
		
		//send request
		Response resp = when()
							.get("/projects");
		
		//capture all the project id
		boolean flag=false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list)
		{
			if(actData.equals(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verified");
		}else {
			System.out.println("data not verified");
		}
		Assert.assertEquals(true, flag);
		resp.then().log().all();
	}
}




