package application;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jailor.AddNewJailor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewJailor {
	
	@FXML
	private TextField newJailorName;
	
	@FXML
	private DatePicker newJailorDob;
	
	@FXML
	private Label msg;
	
	String jailor_dob;
	
	public void jailorDob(ActionEvent event)
	{
		LocalDate dob = newJailorDob.getValue();
		jailor_dob = dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public void backToJailor(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Jailor.fxml");
	}
	
	public void newJailorUpdate(ActionEvent event) throws IOException, SQLException{
		
		
			AddNewJailor obj = new AddNewJailor	(newJailorName.getText(),jailor_dob);
			
			if(!obj.checkInfoEntries())
			{
				msg.setText("Please Enter All Input");
			}
			else
			{	
				obj.prevJailorLeft();
				
				obj.updateJailorTable();
								
				Main m = new Main();
				
				m.changeScene("Jailor.fxml");
			}		
	}
}
