package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnection {
	
	private static Connection con = null;
	
	public static Connection ConnectDb()
	{		
		try {
			con = DriverManager.getConnection("jdbc:sqlite:prisonMgmt.db");
			System.out.println("CONNECTED");
			return con;
		}
		catch(SQLException e)
		{
			System.out.println("Error");
			e.printStackTrace();
			return null;
		}
	}
}
