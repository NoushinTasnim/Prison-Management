package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class Rapsheet {

	public Rapsheet() {
		// TODO Auto-generated constructor stub
	}

	public void newConvict(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Conviction.fxml");
		
	}
	
	public void prisonerDetails(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("AddPrisoner.fxml");
		
	}
}
