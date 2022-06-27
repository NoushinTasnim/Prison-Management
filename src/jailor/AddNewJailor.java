package jailor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import model.SqliteConnection;

public class AddNewJailor {

	static String name, dob, joined;
	
	public AddNewJailor(String n, String d)
	{
		name = n;
		dob = d;
	}
	
	public boolean checkInfoEntries()
	{
		if(name==null || dob==null)
		{
			return false;
		}
		else 
		{
			return true;
		}
	}
	
	public void updateJailorTable() throws SQLException
	{
		Connection con = SqliteConnection.ConnectDb();
		
		if(con != null)
		{
			try {
					
				ResultSet rs = con.createStatement().executeQuery("SELECT id FROM jailor");
				int idFromDb = 0;
				while (rs.next()) {
	            	idFromDb = rs.getInt("id");
	            } 
				
				String query = 		"insert into jailor (id, Name, Dob, Joined )"
						+ 	"values(?,?,?,?)" ;
		
				PreparedStatement pst = con.prepareStatement(query);
		
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		        Calendar cal = Calendar.getInstance();
		        java.util.Date date = cal.getTime();
		        String todaysdate = dateFormat.format(date);
		        
				pst.setInt(1, idFromDb+1);
				pst.setString(2, name);
				pst.setString(3, dob);
				pst.setString(4, todaysdate);
				
				System.out.println("Uploaded");
				
				pst.execute();
				pst.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Error loading data");
			}
			finally {
				  if (con != null) {
				      con.close();
				  }
			}
		}
	}
	
	public void prevJailorLeft()
	{
		try {
			
				Connection conn = SqliteConnection.ConnectDb();
			 
			 	ResultSet rs = conn.createStatement().executeQuery("SELECT id, Left FROM jailor WHERE Left IS NULL");
	     	    
			 	while (rs.next()) {
			 		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			        Calendar cal = Calendar.getInstance();
			        java.util.Date date = cal.getTime();
			        String todaysdate = dateFormat.format(date);
			 		PreparedStatement pstmt = conn.prepareStatement("UPDATE jailor SET Left = \'" + todaysdate + "\' WHERE id = " + rs.getInt("id"));
			 		pstmt.executeUpdate();
			 	}
	            // update 
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
}
