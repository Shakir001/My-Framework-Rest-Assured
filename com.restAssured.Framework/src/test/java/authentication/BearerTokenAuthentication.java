package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthentication {

	@Test
	public void bearerAuth()
	{
		baseURI="https://api.github.com";
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "IqbalRepo");
		jobj.put("description", "This is Good Repository");
		jobj.put("homepage", "ProductPage");
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
			.auth()
			.oauth2("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")
		.when()
			.post("/user/repos")
		.then()
			.assertThat().statusCode(201)
			.log().all();
	}
}
