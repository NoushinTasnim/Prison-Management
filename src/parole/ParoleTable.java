package parole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.SqliteConnection;

public class ParoleTable {

	public static ObservableList<ParoleInfos> getParoleInfos() throws ClassNotFoundException, SQLException{
		
		ObservableList <ParoleInfos> parInf = FXCollections.observableArrayList() ;
		
		try {            
				Connection con = SqliteConnection.ConnectDb();
				Statement stat = con.createStatement();
				stat.executeUpdate("CREATE TABLE IF NOT EXISTS parole ( Id INTEGER, Name TEXT, Start TEXT, End TEXT);");
	            ResultSet rs = con.createStatement().executeQuery("SELECT Id, Name, Start, End FROM parole");
	     	    
	            	while (rs.next()) {
	            		ParoleInfos nt = new ParoleInfos();
		            	nt.setParId(rs.getString("Id"));
		            	nt.setParNm(rs.getString("Name"));
		                nt.setParSt(rs.getString("Start"));
		                nt.setParEn(rs.getString("End"));
		            		               
		                parInf.add(nt);
		            } 
	            	stat.close();
	            	con.close();

	        } catch (SQLException e) {
	        	e.printStackTrace();
				System.out.println("Error loading Parole Table!!!");
	        }
		 	return parInf;
	}
}
