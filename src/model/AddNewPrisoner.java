package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNewPrisoner {
	
	static String name, dob, gender, heightFt, heightIn, bgroup, cell1, cell2;
	static String crime, crimeDes, prevcrmTyp, prevcrmDes, prevEntry, prevRelease;

	public AddNewPrisoner(	String n, String d, String g, String h1, String h2, String b, 
							String c1, String c2, String crm, String crmds,
							String prC, String prCD, String prE, String prR)
	{
		name = n;
		dob = d;
		gender = g;
		heightFt = h1;
		heightIn = h2;
		bgroup = b;
		cell1 = c1;
		cell2 = c2;
		crime = crm;
		crimeDes = crmds;
		prevcrmTyp = prC;
		prevcrmDes = prCD;
		prevEntry = prE;
		prevRelease = prR;
	}
	
	public boolean checkInfoEntries(boolean prevRecs)
	{
		if(name==null || dob==null || gender==null || heightFt==null || heightIn==null || bgroup==null || cell1==null || cell2 == null || crime==null || crimeDes==null)
		{
			return false;
		}
		else if(prevRecs)
		{
			if(prevcrmTyp==null || prevcrmDes==null || prevEntry==null || prevRelease==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else 
		{
			return true;
		}
	}
	
	public void updateTable()
	{
		Connection con = SqliteConnection.ConnectDb();
		
		if(con != null)
		{
			try {
				
				String query = 		"insert into prisoners (id, name, dob, gender, height, bloodGrp, cell, "
								+ 	"crime, entry,	des, "
								+ 	"prevCrm, prevDes, prevEnt, prevRel) "
								+ 	"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
				
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = con.createStatement().executeQuery("SELECT id FROM prisoners");
				int idFromDb = 0;
				while (rs.next()) {
	            	idFromDb = rs.getInt("id");
	            } 
				
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		        Calendar cal = Calendar.getInstance();
		        java.util.Date date = cal.getTime();
		        String todaysdate = dateFormat.format(date);
		        
				pst.setInt(1, idFromDb+1);
				pst.setString(2, name);
				pst.setString(3, dob);
				pst.setString(4, gender);
				pst.setString(5, heightFt + " " + heightIn );
				pst.setString(6, bgroup);
				pst.setString(7, cell1 + cell2);
				pst.setString(8, crime);
				pst.setString(9, todaysdate);
				pst.setString(10, crimeDes);
				pst.setString(11, prevcrmTyp);
				pst.setString(12, prevcrmDes);
				pst.setString(13, prevEntry);
				pst.setString(14, prevRelease);
				
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
