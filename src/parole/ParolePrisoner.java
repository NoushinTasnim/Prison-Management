package parole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.PrisonerInfos;
import model.SqliteConnection;

public class ParolePrisoner {
	
	public static ParoleInfos parChk(String idNo)
	{
		ParoleInfos parInf = new ParoleInfos() ;
		
		try {            
			Connection con = SqliteConnection.ConnectDb();
			ResultSet rs = con.createStatement().executeQuery("SELECT id,name,dob,gender,height,bloodGrp,cell,crime,entry,rel FROM prisoners");
     	    
     	    
            	while (rs.next()) {
            		
            		if(rs.getString("id").equals(idNo) )
	            	{
            			parInf.setParNm(rs.getString("name"));
            			parInf.setParDob(rs.getString("dob"));
            			parInf.setParGen(rs.getString("gender"));
            			parInf.setParHgt(rs.getString("height"));
            			parInf.setParCell(rs.getString("cell"));
            			parInf.setParCrm(rs.getString("crime"));
            			parInf.setParEnt(rs.getString("entry"));
            			parInf.setParBg(rs.getString("bloodGrp"));
		                
	            		break;
	            	}
	            } 

            	con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
			System.out.println("Error loading table!!!");
        }
		return parInf;
	}
	
	public static boolean parolCk(String idNo)
	{
		boolean flag = false;
		try {
				Connection conn = SqliteConnection.ConnectDb();
			 
			 	ResultSet rs = conn.createStatement().executeQuery("SELECT id, rel FROM prisoners WHERE rel IS NULL");
			 	System.out.println("true33");
			 	while (rs.next()) {
			 		System.out.println("true22");
			 		if(rs.getString("id").equals(idNo) )
	            	{
			 			System.out.println("true");
				 		flag = true;
	            	}
			 	}
	            // update 
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return flag;
	}
	
	public static boolean parCk(String idNo)
	{
		boolean flag = false;
		
		try {            
			Connection con = SqliteConnection.ConnectDb();
			ResultSet rs = con.createStatement().executeQuery("SELECT Id FROM parole WHERE id = " + idNo);
			System.out.println("true12");
            	while (rs.next()) {
            		System.out.println("true222");
            		System.out.println("true221");
            			flag = true;
	            } 

            	con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
			System.out.println("Error loading table!!!");
        }
		return flag;
	}

	public static void paroleChecker(String idNo, String prlNm,String endDt)
	{
		Connection con = SqliteConnection.ConnectDb();
		
		if(con != null)
		{
			try {
				
				String query = 		"insert into parole (Id, Name, Start, End) "
								+ 	"values(?,?,?,?)" ;
				
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = con.createStatement().executeQuery("SELECT Id FROM parole");
				int idFromDb = 0;
				while (rs.next()) {
	            	idFromDb = rs.getInt("Id");
	            } 
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		        Calendar cal = Calendar.getInstance();
		        java.util.Date date = cal.getTime();
		        String todaysdate = dateFormat.format(date);
		        
				pst.setInt(1, idFromDb+1);
				pst.setString(2, prlNm);
				pst.setString(3, todaysdate);
				pst.setString(4, endDt);
				
				System.out.println("Uploaded");
				
				pst.execute();
				pst.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				System.out.println("Error loading data");
			}
		}	
	}
}
