package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DBTable {

	public static ObservableList<PrisonerInfos> getAllRecords() throws ClassNotFoundException, SQLException{
		
		ObservableList <PrisonerInfos> priInf = FXCollections.observableArrayList() ;
		
		try {            
				Connection con = SqliteConnection.ConnectDb();
				Statement stat = con.createStatement();
				stat.executeUpdate("CREATE TABLE IF NOT EXISTS prisoners ( id INTEGER, name	varchar(20), dob varchar(15), gender	varchar(10), height	varchar(10), bloodGrp varchar(10), cell	varchar(5), crime TEXT, entry	TEXT, rel	TEXT, des	TEXT, prevCrm	TEXT, prevDes	TEXT, prevEnt	TEXT, prevRel	TEXT);");
	            ResultSet rs = con.createStatement().executeQuery("SELECT id, name, dob, gender, height, cell, crime, entry, rel FROM prisoners");
	     	    
	            	while (rs.next()) {
		            	PrisonerInfos nt = new PrisonerInfos();
		            	nt.setPriId(rs.getString("id"));
		            	nt.setPriName(rs.getString("name"));
		                nt.setPriDob(rs.getString("dob"));
		                nt.setPriGen(rs.getString("gender"));
		                nt.setPriHgt(rs.getString("height"));
		                nt.setPriCell(rs.getString("cell"));
		                nt.setPriCrm(rs.getString("crime"));
		                nt.setPriEnt(rs.getString("entry"));
		                nt.setPriRel(rs.getString("rel"));
		               
		                priInf.add(nt);		           
		            } 
	            	stat.close();
	            	con.close();

	        } catch (SQLException e) {
	        	e.printStackTrace();
				System.out.println("Error loading table!!!");
	        }
		 	return priInf;
	}
}
