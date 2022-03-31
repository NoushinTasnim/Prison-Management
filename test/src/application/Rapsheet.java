package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;

public class Rapsheet implements Initializable{
	
	@FXML
	private AnchorPane prevRecs;
	@FXML
	private ChoiceBox<String> crimeType;
	
	String[] crime = {	"Murder","Burglary","Kidnapping",
						"Antisocial Behaviour","Arson",
						"Domestic Abuse","Fraud",
						"Cyber Crime","Rape","Hate Crime",
						"Modern Slavery","Child Abuse"};
	
	public Rapsheet() {
		// TODO Auto-generated constructor stub
	}
	
	public void prevCrimeDets(ActionEvent event) throws IOException{
		
		prevRecs.setVisible(true);
	}

	public void newConvict(ActionEvent event) throws IOException{
		
		Main m = new Main();
			
		m.changeScene("Conviction.fxml");
		
	}
	public void prisonerDetails(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("AddPrisoner.fxml");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//crimeType.getItems().addAll(crime);
	}
}
