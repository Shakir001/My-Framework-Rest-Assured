package genericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * This class contains pre and post conditions using spec builders
 * @author Shakir
 *
 */
public class BaseAPIClassWithBuilders {

	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public RestAssuredUtility rLib=new RestAssuredUtility();
	public RequestSpecification req;
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		requestSpec.setBaseUri("http://localhost:8084");
		requestSpec.setContentType(ContentType.JSON);
		
		req=requestSpec.build();
		
		dLib.connectToDB();
		System.out.println("==========database connected==============");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		System.out.println("========database closed===========");
	}
}







