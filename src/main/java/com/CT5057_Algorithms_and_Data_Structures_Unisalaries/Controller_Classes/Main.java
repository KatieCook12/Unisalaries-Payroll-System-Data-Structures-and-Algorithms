package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

// Defines a class called "Main" extending "Application"
public class Main extends javafx.application.Application {

    private Stage primaryStage;

    // Defines a method that gets called automatically when the program starts running
    @Override
    public void start(Stage stage) throws IOException {
        // Loads the "login_page.fxml" file
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("FXMLs/login_page.fxml"));
        // Create a new scene in the size (872 x 759), displaying the "login_page.fxml"
        Scene scene = new Scene(fxmlLoader.load(), 872, 759);
        // Loads the "Icon.png"
        Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
        // Adds the icon to the stage
        stage.getIcons().add(icon);
        // Sets the title of the stage
        stage.setTitle("  Unisalaries");
        // Makes the stage non-resizeable
        stage.setResizable(false);
        // Centers the stage in the middle of the screen automatically
        stage.centerOnScreen();
        // Sets the scene to the stage
        stage.setScene(scene);
        // Displays the stage
        stage.show();
    }

    // Launches the application
    public static void main(String[] args) {
        launch();
    }

    // Defines a method returning the "primaryStage" variable
    public Stage getPrimaryStage() {
        return primaryStage;
    }
}