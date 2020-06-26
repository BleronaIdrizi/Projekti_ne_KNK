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
