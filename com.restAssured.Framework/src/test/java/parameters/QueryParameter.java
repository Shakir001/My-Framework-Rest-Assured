package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void queryParameter()
	{
		baseURI="https://reqres.in";
		
		//step:1 prerequisite
		given()
			.queryParam("page", 4)
		
		//step:2 send request
		.when()
			.get("/api/users")
			
		//step:3 validation
		.then().assertThat().statusCode(200).log().all();
	}
}
