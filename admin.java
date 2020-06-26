package smtd;

import javafx.application.Application;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Admin extends Application {
	private Label ID = new Label("ID:");
	private TextField id = new TextField();
	private Label Lenda = new Label("Lenda:");
	private TextField lenda = new TextField();
	private Label Nota = new Label("Nota:");
	private TextField nota = new TextField();
	private Label ects = new Label("ECTS:");
	private TextField ECTS = new TextField();
	
	private TableView tabela = new TableView();
	
	String ProfEmri;
	
	public Admin(String rezultati) {
		this.ProfEmri = rezultati;
	}
	
public void showNota() {
		ArrayList<DataAdmin> dataAdmin = DataAdmin.getDataAdmin(ProfEmri);
		
		ObservableList<DataAdmin> dataAdminList = FXCollections.observableArrayList();
		
		for(int i = 0; i < dataAdmin.size(); i++) {
			dataAdminList.add(dataAdmin.get(i));
		}
		
		tabela.setItems(dataAdminList);
	}
@Override
	public void start(Stage primaryStage) throws Exception {
		MenuBar menubar = new MenuBar();
		Menu file = new Menu("File");
		MenuItem exit = new MenuItem("Exit");
		exit.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
		exit.setOnAction(e->{
			System.exit(0);
		});
		file.getItems().add(exit);
		menubar.getMenus().add(file);
		
		GridPane gridpane = new GridPane();
		
		gridpane.addRow(0, ID, id);
		gridpane.addRow(1, Lenda, lenda);
		gridpane.addRow(2, ects, ECTS);
		gridpane.addRow(3, Nota, nota);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setOnAction(e->{
			if(DataAdmin.deleteNota(id.getText(), lenda.getText())) {
				showNota();
			}
		});
		
		Button btnClear = new Button("Clear All");
		btnClear.setOnAction(e->{
			id.clear();
			ECTS.clear();
			lenda.clear();
			nota.clear();
		});
		Button btnUpdate = new Button("PUSH");
		btnUpdate.setOnAction(e->{
			try 
			{
				String query = "SELECT * FROM Notat WHERE Stud_ID = ? AND Lenda = ?";
				PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(query);
				preparedStatement.setString(1, id.getText());
				preparedStatement.setString(2, lenda.getText());

				ResultSet result = preparedStatement.executeQuery();
