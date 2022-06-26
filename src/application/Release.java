package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.ReleasePrisoner;
import model.SqliteConnection;

public class Release {

	@FXML
	private TextField releasePrisonerID;
	
	@FXML
	private Button checkBtn;
	
	@FXML
	private Label relName;
	
	@FXML
	private Label relDob;
	
	@FXML
	private Label relBG;
	
	@FXML
	private Label relCrm;
	
	@FXML
	private Label relHgt;
	
	@FXML
	private Label relGen;
	
	@FXML
	private Label relEnt;
	
	@FXML
	private Label relRel;
	
	@FXML
	private Label relCell;
	
	boolean flag = false;
	
	public void checkRelease(ActionEvent event) throws Exception{
		
		relName.setText(("-----"));
		relDob.setText(("-----"));
		relGen.setText(("-----"));
		relHgt.setText(("-----"));
		relCell.setText(("-----"));
		relCrm.setText(("-----"));
		relEnt.setText(("-----"));
		relRel.setText(("-----"));
		relBG.setText(("-----"));
		
		try {            
			Connection con = SqliteConnection.ConnectDb();
			ResultSet rs = con.createStatement().executeQuery("SELECT id,name,dob,gender,height,bloodGrp,cell,crime,entry,rel FROM prisoners");
     	    
            	while (rs.next()) {
            		
            		if(rs.getString("id").equals(releasePrisonerID.getText()) )
	            	{
            			flag = true;
            			
	            		relName.setText(rs.getString("name"));
	            		relDob.setText(rs.getString("dob"));
	            		relGen.setText(rs.getString("gender"));
	            		relHgt.setText(rs.getString("height"));
	            		relCell.setText(rs.getString("cell"));
	            		relCrm.setText(rs.getString("crime"));
	            		relEnt.setText(rs.getString("entry"));
	            		relRel.setText(rs.getString("rel"));
	            		relBG.setText(rs.getString("bloodGrp"));
		                
		                break;
	            	}
            		flag = false;
	            } 

            	con.close();
        } catch (SQLException e) {
        	e.printStackTrace();
			System.out.println("Error loading table!!!");
        }
	}
	
	public void releaseBtn(ActionEvent event) throws Exception{
		
		System.out.println("here");
		
		if(flag==true)
		{
			ReleasePrisoner.releaseChecker(releasePrisonerID.getText());
			System.out.println("checked");
		}
	}
	
	public void backBtn(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Prisoner.fxml");
	}
}
