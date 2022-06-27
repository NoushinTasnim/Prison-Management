package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReleasePrisoner {
	
	public static PrisonerInfos relChk(String idNo)
	{
		PrisonerInfos priInf = new PrisonerInfos() ;
		
		try {            
			Connection con = SqliteConnection.ConnectDb();
			ResultSet rs = con.createStatement().executeQuery("SELECT id,name,dob,gender,height,bloodGrp,cell,crime,entry,rel FROM prisoners");
     	    
     	    
            	while (rs.next()) {
            		
            		if(rs.getString("id").equals(idNo) )
	            	{
            			priInf.setPriName(rs.getString("name"));
            			priInf.setPriDob(rs.getString("dob"));
            			priInf.setPriGen(rs.getString("gender"));
            			priInf.setPriHgt(rs.getString("height"));
            			priInf.setPriCell(rs.getString("cell"));
            			priInf.setPriCrm(rs.getString("crime"));
            			priInf.setPriEnt(rs.getString("entry"));
            			priInf.setPriRel(rs.getString("rel"));
            			priInf.setPriBg(rs.getString("bloodGrp"));
		                
	            		break;
	            	}
	            } 

            	con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
			System.out.println("Error loading table!!!");
        }
		return priInf;
	}
	
	public static boolean relCk(String idNo)
	{
		boolean flag = false;
		
		try {            
			Connection con = SqliteConnection.ConnectDb();
			ResultSet rs = con.createStatement().executeQuery("SELECT id FROM prisoners");
     	    
            	while (rs.next()) {
            		
            		if(rs.getString("id").equals(idNo) )
	            	{
            			flag = true;
	            		break;
	            	}
	            } 

            	con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
			System.out.println("Error loading table!!!");
        }
		return flag;
	}

	public static void releaseChecker(String idNo)
	{
		try {
			
			Connection conn = SqliteConnection.ConnectDb();
		 
		 	ResultSet rs = conn.createStatement().executeQuery("SELECT id, rel FROM prisoners WHERE id = " + idNo);
     	    
		 	while (rs.next()) {
		 		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		        Calendar cal = Calendar.getInstance();
		        java.util.Date date = cal.getTime();
		        String todaysdate = dateFormat.format(date);
		 		PreparedStatement pstmt = conn.prepareStatement("UPDATE prisoners SET rel = \'" + todaysdate + "\' WHERE id = " + rs.getInt("id"));
		 		pstmt.executeUpdate();
		 	}
            // update 
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}