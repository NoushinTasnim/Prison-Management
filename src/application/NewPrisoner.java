package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AddNewPrisoner;
import model.PrisonerInfos;

public class NewPrisoner extends Prisoner implements Initializable{
	
	@FXML
	private TextField prisonerName, prisonerCrimeDes, prevcrimeDets;
	@FXML
	private ComboBox<String> prisonerBGroup, prisonerHeightFT, prisonerHeightIN, prisonerCellWing, prisonerCellNo;
	@FXML
	private ComboBox<String> prisonerCrime, prevcrimeType;
	@FXML
	private RadioButton prisonerMale, prisonerFemale;
	@FXML
	private Label message;
	@FXML
	private DatePicker prisonerEntry, prisonerDOB, prevEntry, prevRel;
	@FXML
	private AnchorPane prevRecs;
	
	String pDOB = null, pEntry = null, prEntry = null, prRel = null;
	public static int id_no = 1;
	boolean crimeHistory = false;
	
	public void prevCrimeDets(ActionEvent event) throws IOException{
		
		prevRecs.setVisible(true);
		crimeHistory = true;
	}
	public void prevCrimeDets1(ActionEvent event) throws IOException{
		
		prevRecs.setVisible(false);
		crimeHistory = false;
	}

	public void entryDate(ActionEvent event)
	{
		LocalDate prisoner_dob = prevEntry.getValue();
		prEntry = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public void releaseDate(ActionEvent event)
	{
		LocalDate prisoner_dob = prevRel.getValue();
		prRel = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void selectDOB(ActionEvent event)
	{
		LocalDate prisoner_dob = prisonerDOB.getValue();
		pDOB = prisoner_dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	public void addedNewPrisoner(ActionEvent event) throws IOException, SQLException{
		
		String priGender;
		if(prisonerMale.isSelected())
		{
			priGender = "Male";
		}
		else if(prisonerFemale.isSelected())
		{
			priGender = "Female";
		}
		else
		{
			priGender = null;
		}
		
		AddNewPrisoner obj = new AddNewPrisoner		(prisonerName.getText(), pDOB, priGender, prisonerHeightFT.getValue(), 
													prisonerHeightIN.getValue(), prisonerBGroup.getValue(), 
													prisonerCellWing.getValue(), prisonerCellNo.getValue(), 
													prisonerCrime.getValue(), prisonerCrimeDes.getText(), 
													prevcrimeType.getValue(),prevcrimeDets.getText(),prEntry,prRel);
		
		if(!obj.checkInfoEntries(crimeHistory))
		{
			message.setText("Please Enter All Input");
		}
		else
		{	
			obj.updateTable();
			
			id_no ++ ;
			
			Main m = new Main();
			
			m.changeScene("Prisoner.fxml");
		}		
	}
	
	public void goBack(ActionEvent e) throws IOException
	{
		Main m = new Main();
		m.changeScene("Prisoner.fxml");
	}
	
	public void prisonerGender(ActionEvent event)
	{
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<String> list = FXCollections.observableArrayList(PrisonerInfos.crime);
		prisonerCrime.setItems(list);		

		ObservableList<String> list0 = FXCollections.observableArrayList(PrisonerInfos.bg);
		prisonerBGroup.setItems(list0);
		
		ObservableList<String> list1 = FXCollections.observableArrayList(PrisonerInfos.heightFt);
		prisonerHeightFT.setItems(list1);	
		
		ObservableList<String> list2 = FXCollections.observableArrayList(PrisonerInfos.heightIn);
		prisonerHeightIN.setItems(list2);	
		
		ObservableList<String> list3 = FXCollections.observableArrayList(PrisonerInfos.wing);
		prisonerCellWing.setItems(list3);	
		
		ObservableList<String> list4 = FXCollections.observableArrayList(PrisonerInfos.cell_no);
		prisonerCellNo.setItems(list4);
		
		ObservableList<String> list5 = FXCollections.observableArrayList(PrisonerInfos.crime);
		prevcrimeType.setItems(list5);
	}
}