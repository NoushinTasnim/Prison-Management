package application;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.PrisonerInfos;
import model.ReleasePrisoner;
import parole.ParoleInfos;
import parole.ParolePrisoner;

public class NewParole {

	@FXML
	private TextField prlId;
	
	@FXML
	private DatePicker prlEndDate;
	
	@FXML
	private Label prlName;
	
	@FXML
	private Label prlDob;
	
	@FXML
	private Label prlBG;
	
	@FXML
	private Label prlCrm;
	
	@FXML
	private Label prlHgt;
	
	@FXML
	private Label prlGen;
	
	@FXML
	private Label prlEnt;
	
	@FXML
	private Label prlRel;
	
	@FXML
	private Label prlCell;
	
	boolean flag = false;
	String parPriName;
	String parEndDate;
	
	public void endDate(ActionEvent event)
	{
		LocalDate prisoner_dob = prlEndDate.getValue();
		parEndDate = prisoner_dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public void paroleText(ParoleInfos parInf) throws Exception{
		
		prlName.setText(parInf.getParNm());
		prlDob.setText(parInf.getParDob());
		prlGen.setText(parInf.getParGen());
		prlHgt.setText(parInf.getParHgt());
		prlCell.setText(parInf.getParCell());
		prlCrm.setText(parInf.getParCrm());
		prlEnt.setText(parInf.getParEnt());
		prlBG.setText(parInf.getParBg());
	}	
	
	public void checkPar (ActionEvent event) throws Exception{
		
		prlName.setText(("-----"));
		prlDob.setText(("-----"));
		prlGen.setText(("-----"));
		prlHgt.setText(("-----"));
		prlCell.setText(("-----"));
		prlCrm.setText(("-----"));
		prlEnt.setText(("-----"));
		prlRel.setText(("-----"));
		prlBG.setText(("-----"));
		
		paroleText( ParolePrisoner.parChk(prlId.getText()));
		
		//if((ParolePrisoner.parCk(prlId.getText())==true))
		//{
			if(ParolePrisoner.parolCk(prlId.getText())==true )
			{
				prlEndDate.setVisible(true);
			}
		//}
	}
	
	public void sendOnParole(ActionEvent event) throws Exception{
		
		//if((ParolePrisoner.parCk(prlId.getText())==true))
		//{
			if(ParolePrisoner.parolCk(prlId.getText())==true )
			{
				ParolePrisoner.paroleChecker(prlId.getText(),prlName.getText(),parEndDate);
				System.out.println("checked parole");
			}
		//}
				
		Main main = new Main();
				
		main.changeScene("Parole.fxml");
		
	}
	
	public void backToParole(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Parole.fxml");
	}
}
