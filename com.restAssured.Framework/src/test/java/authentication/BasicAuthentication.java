package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthentication {
	

	@Test
	public void basicAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
			.auth()
			.basic("rmgyantra", "rmgy@9999")
		.when()
			.get("/login")
		.then()
			.log().all();
	}
	
	@Test
	public void preEmptiveAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
			.auth()
			.preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
			.get("/login")
		.then()
			.log().all();		
	}
	
	@Test
	public void digestiveAuth()
	{
		baseURI="http://localhost";
		port=8084;
		
		given()
			.auth()
			.digest("rmgyantra", "rmgy@9999")
		.when()
			.get("/login")
		.then()
			.log().all();
	}
}




