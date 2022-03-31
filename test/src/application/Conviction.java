package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Conviction  implements Initializable{
	
	@FXML
	private ChoiceBox<String> prisonerCrime;
	@FXML
	private TextField prisonerCrimeDes;
	@FXML
	private DatePicker prisonerEntry;
	@FXML
	private DatePicker prisonerRelease;
	@FXML
	private Label errorInfo;
	
	String pEntry, pRelease;
	
	String[] crime = {	"Murder","Burglary","Kidnapping",
						"Antisocial Behaviour","Arson",
						"Domestic Abuse","Fraud",
						"Cyber Crime","Rape","Hate Crime",
						"Modern Slavery","Child Abuse"};

	public Conviction() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPrisoner(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("NewPrisoner.fxml");
		
	}

	public void newRapsheet(ActionEvent event) throws IOException{
		
		if(prisonerCrime.getValue()==null)
		{
			errorInfo.setText("Please Select Crime");
		}
		else if(prisonerEntry.getValue()==null)
		{
			errorInfo.setText("Please Select Entry Date ");
		}
		else if(prisonerRelease.getValue()==null)
		{
			errorInfo.setText("Please Select Release Date ");
		}
		else
		{
			Main m = new Main();
			
			m.changeScene("Rapsheet.fxml");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		prisonerCrime.getItems().addAll(crime);		
	}
	
	public void EntryDatePick(ActionEvent event)
	{
		LocalDate prisoner_dob = prisonerEntry.getValue();
		pEntry = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public void ReleaseDatePick(ActionEvent event)
	{
		LocalDate prisoner_dob = prisonerRelease.getValue();
		pRelease = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

}
