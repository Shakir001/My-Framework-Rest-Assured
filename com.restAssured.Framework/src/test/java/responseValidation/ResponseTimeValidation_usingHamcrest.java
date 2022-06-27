package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidation_usingHamcrest {

	@Test
	public void responseTimeValidation()
	{
		baseURI="http://localhost";
		port=8084;
		
		//send request
		Response resp = when()
							.get("/projects");
		
		//validate
		resp.then().assertThat().time(Matchers.lessThan(2500L), TimeUnit.MILLISECONDS)
				.statusCode(200)
				.log().all();
	}
}
