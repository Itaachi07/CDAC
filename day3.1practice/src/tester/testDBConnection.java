package tester;
import java.sql.*;
import java.sql.Connection;
import static Utils.DBUtils.openConnection;

public class testDBConnection {

	public static void main(String[] args) {
		try(Connection cn = openConnection())
		{
			System.out.println("Connected to DB "+cn);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
