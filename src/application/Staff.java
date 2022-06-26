package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Staff extends SignIn implements Initializable{
	
	@FXML
	private Button signOut;
	@FXML
	private Button guardsBtn;
	
	public void userSignOut(ActionEvent event) throws IOException{
		Main main = new Main();
		
		main.changeScene("Main.fxml");
	}
	
	public void guardsDuty(ActionEvent event) throws IOException
	{
		Main main = new Main();
		
		main.changeScene("Guards.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
