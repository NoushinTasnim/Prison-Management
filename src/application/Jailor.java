package application;

import java.io.IOException;

import jailor.JailorInfos;
import jailor.JailorTable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.SignInModel;

public class Jailor {

	@FXML
    private TableView<JailorInfos> prevJailors;

    @FXML
    private TableColumn<JailorInfos, String> prevJailorName;

    @FXML
    private TableColumn<JailorInfos, String> prevJailorDob;

    @FXML
    private TableColumn<JailorInfos, String> prevJailorJoined;

    @FXML
    private TableColumn<JailorInfos, String> prevJailorLeft;

	public void doneJailor(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Main.fxml");
	}
	
	public void newJailor(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("newJailor.fxml");
	}
	
	public void goToPrisoner(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("Prisoner.fxml");
	}

	@FXML
	public void initialize() throws Exception {
		
		FXCollections.observableArrayList();

		prevJailorName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getJailNm()));
		prevJailorDob.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getJailDb()));
		prevJailorJoined.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getJailJoin()));
		prevJailorLeft.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getJailLeft()));
		
		prevJailors.setItems(JailorTable.getJailorInfos());       
	}	
}
