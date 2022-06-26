package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Guards extends Staff{
	
	@FXML
	private Button backBtn;
	
	public void staffList(ActionEvent event) throws IOException
	{
		Main main = new Main();
		main.changeScene("Staff.fxml");
	}

}
