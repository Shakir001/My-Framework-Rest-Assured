package genericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * This class contains all the pre and post conditions
 * @author Shakir
 *
 */
public class BaseAPIClass {

	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public RestAssuredUtility rLib=new RestAssuredUtility();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI="http://localhost";
		port=8084;
		
		dLib.connectToDB();
		
		System.out.println("============database connection successful===========");
	}
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
		
		System.out.println("===========database connection closed===========");
	}
}
