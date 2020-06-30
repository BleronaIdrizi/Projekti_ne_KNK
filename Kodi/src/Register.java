package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;

public class Register extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Registration Form JavaFX Application");


        // Create the registration form grid pane
        GridPane gridPane = createRegistrationFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 800, 500);
        // Set the scene in primary stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private GridPane createRegistrationFormPane() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
    
      private void addUIControls(GridPane gridPane) {
        // Add Header
        Label headerLabel = new Label("Registration Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        // Add Name Label
        Label nameLabel = new Label("Full Name : ");
        gridPane.add(nameLabel, 0,1);
          
          // Add Name Text Field
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);
     
           // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 3);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 3);
        //language
        Label languagesLabel = new Label("Known languages:");
        CheckBox javaCheckBox = new CheckBox("Java");
        CheckBox cppCheckBox = new CheckBox("C++");
        CheckBox csharpCheckBox = new CheckBox("C#");
        CheckBox pythonCheckBox = new CheckBox("Python");
        gridPane.add(languagesLabel, 0, 4);
        gridPane.add(new HBox(15, javaCheckBox, cppCheckBox, csharpCheckBox,pythonCheckBox ), 1, 4, 2, 1);
          
          //radiobutton
        Label workingLabel = new Label("Gender:");
        ToggleGroup workinGroup = new ToggleGroup();
        ToggleButton MaleToggleButton = new ToggleButton("Male");
        ToggleButton FemaleToggleButton = new ToggleButton("Female");
        MaleToggleButton.setToggleGroup(workinGroup);
        FemaleToggleButton.setToggleGroup(workinGroup);
        gridPane.add(workingLabel, 0, 5);
        gridPane.add(new HBox(15, MaleToggleButton, FemaleToggleButton), 1, 5, 2, 1);
          
                // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 6, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 100,20,0));
  
  


    public static void main(String[] args) {
        launch(args);
    }
}

