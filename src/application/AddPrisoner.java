package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class AddPrisoner extends Prisoner implements Initializable {
	
	@FXML
	private Label prisoner_name;

	public void newRapsheet(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Rapsheet.fxml");
	}
	
	public void addedNew(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene(".fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
}
