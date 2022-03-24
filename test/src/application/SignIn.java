package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignIn {
	
	@FXML
	private Button signIn;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label wrongPass;
	
	public void userSignIn(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		if (username.getText().isEmpty() && password.getText().isEmpty()) 
		{
			wrongPass.setText("Fields cannot be empty");
		}
		else if(username.getText().toString().equals("admin") && password.getText().toString().equals("staff1234")) 
		{
			wrongPass.setText("Signed In Successfully to view Staff");
			
			m.changeScene("Staff.fxml");
		}
		else if(username.getText().toString().equals("admin") && password.getText().toString().equals("prisoner5678")) 
		{
			wrongPass.setText("Signed In Successfully to view prisoners");
			
			m.changeScene("Prisoner.fxml");
		}
		else
		{
			wrongPass.setText("Wrong credentials");
		}
	}
}
