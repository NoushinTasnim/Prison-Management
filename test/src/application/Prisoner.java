package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class Prisoner {

	public Prisoner() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPrisoner(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("NewPrisoner.fxml");
		
	}

}
