package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Print_Employee_Popup extends AbstractController implements Initializable {

    @FXML
    private Button printEmployee;

    @FXML
    private TextField number;

    private Stage stage = null;

    private HashMap<String, Object> result = new HashMap<String, Object>();

    // Defines a method that gets called automatically as the pop-up window starts to run
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // When the "printEmployee" button is clicked, the following operations are performed
        printEmployee.setOnAction((event) -> {
            // Removes the HashMap's result
            result.clear();
            // Adds the text fields value to the "result" HashMap, which has a key "number"
            result.put("number", number.getText());
            // Closes the stage
            closeStage();
        });
    }

    // Returns the "result" HashMap
    public HashMap<String, Object> getResult() {
        return this.result;
    }

    // Sets the stage of the pop-up window
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Closes the stage of the pop-up window
    private void closeStage() {
        if (stage != null) {
            stage.close();
        }
    }
}

