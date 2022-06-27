package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.PrisonerInfos;
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
	
	public void relText(PrisonerInfos priInf) throws Exception{
		
		relName.setText(priInf.getNameProp());
		relDob.setText(priInf.getDobProp());
		relGen.setText(priInf.getGenProp());
		relHgt.setText(priInf.getHgtProp());
		relCell.setText(priInf.getCellProp());
		relCrm.setText(priInf.getCrmProp());
		relEnt.setText(priInf.getEntProp());
		relRel.setText(priInf.getRelProp());
		relBG.setText(priInf.getBgProp());
	}	
	
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
		
		relText( ReleasePrisoner.relChk(releasePrisonerID.getText()));
	}
	
	public void releaseBtn(ActionEvent event) throws Exception{
		
		System.out.println("here");
		
		if(ReleasePrisoner.relCk(releasePrisonerID.getText())==true)
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