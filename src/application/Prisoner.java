package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javax.swing.table.DefaultTableModel;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DBTable;
import model.PrisonerInfos;
import model.SqliteConnection;

public class Prisoner extends SignIn{
	
	@FXML
    private TableView<PrisonerInfos> prisonerTable;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_id;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_name;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_dob;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_gender;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_height;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_crime;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_entry_date;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_release_date;

    @FXML
    private TableColumn<PrisonerInfos, String> prisoner_cell;

	public void addPrisoner(ActionEvent event) throws IOException{
		
		Main m = new Main();
		
		m.changeScene("NewPrisoner.fxml");	
	}
	
	public void paroleBtn(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Parole.fxml");
	}
	
	public void userSignOut(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Main.fxml");
	}
	
	public void releasePage(ActionEvent event) throws IOException{
		
		Main main = new Main();
		
		main.changeScene("Release.fxml");
	}

	@FXML
	public void initialize() throws Exception {
		
		FXCollections.observableArrayList();

		prisoner_id.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getIdProp()));
		prisoner_name.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNameProp()));
		prisoner_dob.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDobProp()));
		prisoner_gender.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getGenProp()));
		prisoner_height.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getHgtProp()));
		prisoner_crime.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCrmProp()));
		prisoner_entry_date.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEntProp()));
		prisoner_release_date.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getRelProp()));
		prisoner_cell.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCellProp()));
		
		prisonerTable.setItems(DBTable.getAllRecords());
	           
	}
}