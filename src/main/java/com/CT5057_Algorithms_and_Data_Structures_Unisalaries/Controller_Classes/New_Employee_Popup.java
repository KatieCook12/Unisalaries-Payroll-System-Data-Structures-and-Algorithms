package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ResourceBundle;

public class New_Employee_Popup extends AbstractController implements Initializable {

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

    // Method that is automatically initialised
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submitNewEmployee.setOnAction((event) -> {
            // Clears the existing result hashmap
            result.clear();
            // Using the corresponding keys, adds the input fields to the result hashmap
            result.put("address", address.getText());
            result.put("name", name.getText());
            result.put("number", number.getText());
            result.put("phoneNumber", phoneNumber.getText());
            result.put("loan", loan.getText());
            result.put("designation", designation.getText().toString());
            result.put("hourlySalary", hourlySalary.getText());
            result.put("travelAllowance", travelAllowance.getText());
            // Creates an alert for displaying errors
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            DecimalFormat decimalFormat = new DecimalFormat("##");
            // If the address field is empty, show an error alert message
            if (address.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the name field is empty, show an error alert message
            else if (name.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the number field is empty, show an error alert message
            else if (number.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the phone number field is empty, show an error alert message
            else if (phoneNumber.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the grade box field is empty, show an error alert message
            else if (gradeComboBox.getSelectionModel().getSelectedItem() == null) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the loan field is empty, show an error alert message
            else if (loan.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the joining date field is empty, show an error alert message
            else if (joiningDate.getValue() == null) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the designation field is empty, show an error alert message
            else if (designation.getText().isEmpty()) {
                alert.setContentText("Error adding employee, please fill out all text fields.");
                alert.show();
            }
            // If the number date field is empty, show an error alert message
            else if (!number.getText().matches("\\d+")) {
                alert.setContentText("Registration number must be a number.");
                alert.show();
            }
            // If the travel allowance isn't in the correct format, shows an error alert message
            else if (!travelAllowance.getText().matches("\\d+")) {
                alert.setContentText("Travel allowance must be a whole number.");
                alert.show();
                return;
            }
            // If the hourly salary isn't in the correct format, shows an error alert message
            else if (!hourlySalary.getText().matches("\\d+")) {
                alert.setContentText("Hourly salary must be a whole number.");
                alert.show();
                return;
            }
            // Else, adds the joiningDate and grade fields to the result hashmap
            else {
                result.put("joiningDate", joiningDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                result.put("grade", gradeComboBox.getSelectionModel().getSelectedItem().toString());
                closeStage();
            }
        });
    }

    // Returns the HashMap's result
    HashMap<String, Object> getResult() {
        return this.result;
    }

    // Sets the stage
    void setStage(Stage stage) {
        this.stage = stage;
    }

    // Closes the stage
    private void closeStage() {
        if (stage != null) {
            stage.close();
        }
    }

}
