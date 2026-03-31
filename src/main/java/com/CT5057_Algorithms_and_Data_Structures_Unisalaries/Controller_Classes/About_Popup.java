package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.stage.Stage;
import java.util.HashMap;

// Defines a method that gets called automatically as the pop-up window starts to run
public class About_Popup extends AbstractController{

    private Stage stage = null;
    private HashMap<String, Object> result = new HashMap<String, Object>();

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
