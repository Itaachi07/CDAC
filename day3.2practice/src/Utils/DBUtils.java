package utils;
import java.sql.*;

public class DBUtils {
	private static Connection connection;
	//open connection
	public static Connection openConnection() throws /* ClassNotFoundException, */SQLException
	{
		//load JDBC driver in the Method area : optional (no longer required : kept only for as exam objective!)
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		//get FIXED DB connection from the DB thro JDBC driver
		//API : DriverManager : public static Connection getConnection(String url,String userName,String pwd) throws SQLException
		String url = "jdbc:mysql://localhost:3306/sunbeam22?useSSL=false&allowPublicKeyRetrieval=true";
		return DriverManager.getConnection(url, "root", "root");
	}
	//get connection : to be used in future
	public static Connection getConnection() {
		return connection;
	}
	
	//close connection : to be used in future
	public static void closeConnection() throws SQLException
	{
		if(connection != null)
			connection.close();
	}
	
	

}
