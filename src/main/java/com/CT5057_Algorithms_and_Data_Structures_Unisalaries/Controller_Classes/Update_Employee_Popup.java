package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Update_Employee_Popup extends AbstractController implements Initializable {

    @FXML
    private TextField address;

    public ComboBox<String> gradeComboBox;

    @FXML
    private DatePicker joiningDate;

    @FXML
    private TextField loan;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField newNumber;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField hourlySalary;

    @FXML
    private TextField travelAllowance;

    @FXML
    private Button submitNewEmployee;

    @FXML
    private TextField designation;

    private Stage stage = null;

    private HashMap<String, Object> result = new HashMap<String, Object>();

    // Defines a method that gets called automatically as the pop-up window starts to run
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // When the "submitNewEmployee" button is clicked, the following operations are performed
        submitNewEmployee.setOnAction((event) -> {
            // Removes the HashMap's result
            result.clear();
            // Gets values from text fields and assigns relevant keys to those values
            result.put("address", address.getText());
            result.put("name", name.getText());
            result.put("number", number.getText());
            result.put("newNumber", newNumber.getText());
            result.put("phoneNumber", phoneNumber.getText());
            result.put("loan", loan.getText());
            result.put("designation", designation.getText().toString());
            result.put("travelAllowance", travelAllowance.getText());
            result.put("hourlySalary", hourlySalary.getText());
            // If the user does not supply a registration number the method is terminated
            if (number.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Provide the employee's registration number to update.");
                alert.show();
                return;
            }
            // If the user does not supply the travel allowance the method is terminated
            if (!travelAllowance.getText().isEmpty()) {
                if (!travelAllowance.getText().matches("\\d+")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Travel allowance must be a whole number.");
                    alert.show();
                    return;
                }
            }
            // If the user does not supply the hourly salary the method is terminated
            if (!hourlySalary.getText().isEmpty()) {
                if (!hourlySalary.getText().matches("\\d+")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Hourly salary must be a whole number.");
                    alert.show();
                    return;
                }
            }
            // Checks if the user selects an option from the "gradeComboBox", if they have a HashMap is created
            if (gradeComboBox.getSelectionModel().getSelectedItem() != null) {
                result.put("grade", gradeComboBox.getSelectionModel().getSelectedItem().toString());
            }
            // If the user supplies a joining date, if they have a HashMap is created
            if (joiningDate.getValue() != null) {
                result.put("joiningDate", joiningDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            }
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
