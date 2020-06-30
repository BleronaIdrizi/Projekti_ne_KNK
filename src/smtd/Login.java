package smtd;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login extends Application {

	TextField txtUser = new TextField();
	PasswordField txtPass = new PasswordField();
	Stage stage = new Stage();
	
	public void loginUser(TextField txtUser,TextField txtPass)
	{		
		String query = "SELECT * FROM Login WHERE Stud_ID = ? AND Stud_Password= ?";
		String queryprof = "SELECT * FROM Profesori WHERE Profesori = ? AND Prof_Password= ?";
		
		try {
			PreparedStatement preparedStatement = Databaza.getConnection().prepareStatement(queryprof);
			preparedStatement.setString(1, txtUser.getText());
			preparedStatement.setString(2, txtPass.getText());
			
			ResultSet result = preparedStatement.executeQuery();

			if(result.next()) {
				Admin admin = new Admin(txtUser.getText());
				admin.start(stage);	
			}
			else
			{
				preparedStatement = Databaza.getConnection().prepareStatement(query);
				preparedStatement.setString(1, txtUser.getText());
				preparedStatement.setString(2, txtPass.getText());
				result = preparedStatement.executeQuery();

				if(result.next())
				{
					//Kryesore kryesore = new Kryesore(txtUser.getText());
					//kryesore.start(stage);
				}
				else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login result");
				alert.setHeaderText(null);
				alert.setContentText("ID or password is wrong!");
				alert.showAndWait();
				
				}
			}

			

		} catch (Exception e) {
			// TODO: handle exception
		}
	};
	public void showLoginScreen() throws FileNotFoundException
	{
		
		int scrW = (int) Screen.getPrimary().getBounds().getWidth();
		int scrH = (int) Screen.getPrimary().getBounds().getHeight();
		StackPane pane = new StackPane();
		Rectangle rectangle = new Rectangle(0,0,scrW-100,scrH-100);
		rectangle.setStyle("-fx-stroke:darkgray;-fx-border:10px;-fx-border-color:blue;-fx-stroke-width:5;-fx-fill:white;-fx-border-radius:50px;");
		Region rekt = new Region();
		rekt.setMaxSize(500, 500);
		rekt.setStyle("-fx-border: 10px;-fx-background-color:white;-fx-border-color:darkgray;-fx-border-radius: 50px;");
		InnerShadow shadow = new InnerShadow();
		shadow.setColor(Color.GRAY);
		shadow.setRadius(50);

		rectangle.setEffect(shadow);
		pane.setPadding(new Insets(5,5,5,5));
		pane.getChildren().add(rectangle);
		pane.getChildren().add(rekt);

		VBox vbox = new VBox();
		Image image = new Image(new FileInputStream("Foto/universiteti-logo.png"));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(300);
		imageView.setFitWidth(300);
		txtUser.setPrefColumnCount(1);
		txtUser.setMaxWidth(200);
		txtUser.setPromptText("Username");
		txtPass.setPrefColumnCount(1);
		txtPass.setMaxWidth(200);
		txtPass.setPromptText("Password");
		Button btnLogin = new Button("Login");
		Platform.runLater(()->imageView.requestFocus());
		
		btnLogin.setOnMouseEntered(e->{
			btnLogin.setCursor(Cursor.HAND);
		});
		btnLogin.setOnMouseClicked(e->{
			loginUser(txtUser,txtPass);
		});
		vbox.getChildren().addAll(imageView,txtUser,txtPass,btnLogin);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		pane.getChildren().add(vbox);
		
		Scene scene = new Scene(pane);
		stage.setResizable(false);
		stage.setTitle("SEMD"); 
		stage.setScene(scene); 
		stage.show();
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		showLoginScreen();
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}