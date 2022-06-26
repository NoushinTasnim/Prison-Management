package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.SignInModel;

public class SignIn {
	
	Connection con;
	PreparedStatement pst;
	
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
		
		SignInModel obj = new SignInModel(username.getText(),password.getText());
		
		String chk = obj.loginCheck();
		
		if(chk == "1")
		{
			m.changeScene("Staff.fxml");
		}
		else if(chk == "2")
		{
			m.changeScene("Prisoner.fxml");
		}
		else
		{
			wrongPass.setText(chk);
		}
	}
}