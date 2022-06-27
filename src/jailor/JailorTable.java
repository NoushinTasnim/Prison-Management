package jailor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.SqliteConnection;

public class JailorTable {

	public static ObservableList<JailorInfos> getJailorInfos() throws ClassNotFoundException, SQLException{
		
		ObservableList <JailorInfos> jailInf = FXCollections.observableArrayList() ;
		
		try {            
				Connection con = SqliteConnection.ConnectDb();
				Statement stat = con.createStatement();
				stat.executeUpdate("CREATE TABLE IF NOT EXISTS jailor ( id INTEGER, Name TEXT, Dob TEXT, Joined TEXT, Left	TEXT);");
	            ResultSet rs = con.createStatement().executeQuery("SELECT id, Name, Dob, Joined, Left FROM jailor");
	     	    
	            	while (rs.next()) {
	            		JailorInfos nt = new JailorInfos();
		            	nt.setJailNm(rs.getString("Name"));
		            	nt.setJailDb(rs.getString("Dob"));
		                nt.setJailJoin(rs.getString("Joined"));
		                nt.setJailLeft(rs.getString("Left"));
		            		               
		                
		                jailInf.add(nt);
		                
		            } 
	            	stat.close();
	            	con.close();

	        } catch (SQLException e) {
	        	e.printStackTrace();
				System.out.println("Error loading table!!!");
	        }
		 	return jailInf;
	}
}
