package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class AddPrisoner {

	public void newRapsheet(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Rapsheet.fxml");
	}
	
	public void addedNew(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Prisoner.fxml");
	}
}
