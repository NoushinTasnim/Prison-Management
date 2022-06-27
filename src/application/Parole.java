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
import parole.ParoleInfos;
import parole.ParoleTable;

public class Parole {
	
	@FXML
    private TableView<ParoleInfos> paroleTable;

    @FXML
    private TableColumn<ParoleInfos, String> paroleId;

    @FXML
    private TableColumn<ParoleInfos, String> paroleName;

    @FXML
    private TableColumn<ParoleInfos, String> paroleStart;

    @FXML
    private TableColumn<ParoleInfos, String> paroleEnd;

	public void newParole(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("NewParole.fxml");
	}
	
	public void backToPrisoner(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Prisoner.fxml");
	}

	@FXML
	public void initialize() throws Exception {
		
		FXCollections.observableArrayList();

		paroleId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getParId()));
		paroleName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getParNm()));
		paroleStart.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getParSt()));
		paroleEnd.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getParEn()));
		
		paroleTable.setItems(ParoleTable.getParoleInfos());
	           
	}
}
