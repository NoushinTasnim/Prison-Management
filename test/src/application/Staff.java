package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Staff {
	
	@FXML
	private Button signOut;
	
	public void userSignOut(ActionEvent event) throws IOException{
		Main main = new Main();
		
		main.changeScene("Main.fxml");
	}

}
