package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Driver driverRef;
	Connection conn;
	
	/**
	 * This method will establish connection with database
	 * @throws SQLException
	 */
	public void connectToDB() throws Throwable
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection(ConstantUtility.dbURL, ConstantUtility.dbUsername, ConstantUtility.dbPassword);
	}
	
	/**
	 * This method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		conn.close();
	}
	
	/**
	 * This method will execute the query
	 * It will compare the exp data with act data
	 * It will return the data if comparison is successful
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndReturnData(String query, int columnIndex, String expData) throws Throwable
	{
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(columnIndex);
			if(expData.equalsIgnoreCase(actData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data verification successful");
			return expData;
		}else {
			System.out.println("data verification failed");
			return "";
		}
	}
	
	
}






