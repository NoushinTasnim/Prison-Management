package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReleasePrisoner {

	public static void releaseChecker(String idNo)
	{
		 try (Connection conn = SqliteConnection.ConnectDb();
	                
				PreparedStatement pstmt = conn.prepareStatement("UPDATE prisoners SET rel = ?")) {
			 
			 ResultSet rs = conn.createStatement().executeQuery("SELECT id,name,dob,gender,height,bloodGrp,cell,crime,entry,rel FROM prisoners");
	     	    
         		while (rs.next()) {
         		
         			if(rs.getString("id").equals(idNo))
	            	{
         				System.out.println(rs.getString("id"));
	            		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    		        Calendar cal = Calendar.getInstance();
	    		        java.util.Date date = cal.getTime();
	    		        String todaysdate = dateFormat.format(date);
	    	            rs.updateString(1, todaysdate);
	            	}
         		
	            } 
	            // update 
	            pstmt.executeUpdate();
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
}