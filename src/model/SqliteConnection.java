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
	
	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException{
		
		Statement st = null;
		ResultSet rs = null;
		//CachedRowSetImpl crs = null;
		
		
		try {
			ConnectDb();
			st = con.createStatement();
			st.executeQuery(sqlQuery);
		}
		catch(SQLException e)
		{
			System.out.println("problems occured at dbExecuteQuery operation"+e);
			throw e;
			
		}
		finally {
			if(st != null) {
				st.close();
			}
		}
		return rs;
	}

}
