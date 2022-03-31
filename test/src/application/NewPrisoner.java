package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class NewPrisoner implements Initializable{
	
	Connection con;
	PreparedStatement pst;
	
	@FXML
	private TextField prisonerName;
	@FXML
	private DatePicker prisonerDOB;
	@FXML
	private ChoiceBox<String> prisonerBGroup;
	@FXML
	private ChoiceBox<String> prisonerHeightFT;
	@FXML
	private ChoiceBox<String> prisonerHeightIN;
	@FXML
	private RadioButton prisonerMale;
	@FXML
	private RadioButton prisonerFemale;
	@FXML
	private TextField prisonerCell;
	@FXML
	private Label message;
	
	String pDOB;
	
	String age[] = {"17 - 20","21 - 24","25 - 28","29 - 32","33 - 36","37 - 40","41 - 44","45 - 48","49 - 52","53 - 56","57 - 60"};
	String[] bg = {"A+","B+","AB+","O+","A-","B-","AB-","O-"};
	String[] heightIn = {"0","1","2","3","4","5","6","7","8","9","10","11"};
	String[] heightFt = {"3","4","5","6","7"};

	public NewPrisoner() {
		// TODO Auto-generated constructor stub
	}
	
	public void selectDOB(ActionEvent event)
	{
		LocalDate prisoner_dob = prisonerDOB.getValue();
		pDOB = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void newConvict(ActionEvent event) throws IOException, SQLException{
		
		if(prisonerName.getText().isEmpty())
		{
			message.setText("Please Enter Name.");
		}
		else if(prisonerDOB.getValue()==null)
		{
			message.setText("Please Enter Date of Birth");
		}
		else if(!prisonerMale.isSelected() && !prisonerFemale.isSelected())
		{
			message.setText("Please Enter Gender");
		}
		else if(prisonerHeightFT.getValue()==null || prisonerHeightIN.getValue()==null)
		{
			message.setText("Please Enter Height");
		}
		else if(prisonerCell.getText().isEmpty())
		{
			message.setText("Please Enter Cell No.");
		}
		else
		{
			String priName = prisonerName.getText();
			
			String pGender;
			if(prisonerMale.isSelected())
			{
				pGender = "Male";
			}
			else if(prisonerFemale.isSelected())
			{
				pGender = "Female";
			}
			Main m = new Main();
			
			m.changeScene("Conviction.fxml");
		}		
	}
	
	public void prisonerGender(ActionEvent event)
	{
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		prisonerHeightFT.getItems().addAll(heightFt);
		prisonerHeightIN.getItems().addAll(heightIn);
		prisonerBGroup.getItems().addAll(bg);		
	}
}
