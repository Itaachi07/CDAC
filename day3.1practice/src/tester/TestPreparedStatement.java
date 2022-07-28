package tester;
import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;

import static Utils.DBUtils.openConnection;

public class TestPreparedStatement {

	public static void main(String[] args) {
		
		try(Connection cn = openConnection();
				Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Connected to DB "+cn);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
