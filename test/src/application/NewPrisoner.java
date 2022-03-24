package application;

import java.io.IOException;

import javafx.event.ActionEvent;

public class NewPrisoner {

	public NewPrisoner() {
		// TODO Auto-generated constructor stub
	}

	public void newConvict(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Conviction.fxml");
		
	}
}
