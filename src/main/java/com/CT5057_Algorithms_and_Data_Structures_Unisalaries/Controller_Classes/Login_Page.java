package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class Login_Page {

    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    private Scene scene;
    private Stage stage;
    private String username;
    private String password;

    // When the Enter key is activated the following operations are performed
    @FXML
    private void keyEvents(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            // Gets the text from the username and password fields
            username = tf_username.getText();
            password = tf_password.getText();
            // Alert message is shown if the username and password field is empty
            if (username.isEmpty() | password.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Password or/ and username field is empty.");
                alert.show();
            }
            // Alert message is shown if the login credentials are correct
            else if (username.equals("admin") && password.equals("admin")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("You've been successfully logged in.");
                alert.show();
                // Loads the 'Main-Menu.fxml' page
                Parent root = FXMLLoader.load(getClass().getResource("FXMLs/main_menu_page.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }
            // Alert message is shown if the incorrect login credentials have been submitted
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Incorrect username and password combination.");
                alert.show();
            }
        }
    }

    // When the "loginButton" is clicked, the following operations are performed
    @FXML
    private void loginButton(ActionEvent event) throws IOException {
        // Gets the text from the username and password fields
        username = tf_username.getText();
        password = tf_password.getText();
        // Alert message is shown if the username and password field is empty
        if (username.isEmpty() | password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Password or/ and username field is empty.");
            alert.show();
        }
        // Alert message is shown if the login credentials are correct
        else if (username.equals("admin") && password.equals("admin")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You've been successfully logged in.");
            alert.show();
            // Loads the 'Main-Menu.fxml' page
            Parent root = FXMLLoader.load(getClass().getResource("FXMLs/main_menu_page.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        // Alert message is shown if the incorrect login credentials have been submitted
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Incorrect username and password combination.");
            alert.show();
        }
    }
}









