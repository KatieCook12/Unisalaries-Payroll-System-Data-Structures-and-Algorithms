package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main_Menu_Page extends AbstractController implements Initializable {

    @FXML
    private TextField aprField1;

    @FXML
    private TextField aprField2;

    @FXML
    private TextField augField1;

    @FXML
    private Text healthAllowanceTF;

    @FXML
    private Text travelAllowanceTF;

    @FXML
    private ComboBox<String> gradeComboBox;

    @FXML
    private TextField augField2;

    @FXML
    private TextField hourWorkedPerDayTF;

    @FXML
    private TextField travelAllowance;

    @FXML
    private TextField hourlySalary;

    @FXML
    private Text daysWorked;

    @FXML
    private TextField decField1;

    @FXML
    private TextField decField2;

    @FXML
    private Text deductionsTF;

    @FXML
    private Text eightPercentTF;

    @FXML
    private Text employeeGrade1;

    @FXML
    private TextField febField1;

    @FXML
    private TextField febField2;

    @FXML
    private Text fivePercentTF;

    @FXML
    private Text grossPayTF;

    @FXML
    private Text hoursWorkedTF;

    @FXML
    private TextField id1;

    @FXML
    private TextField id11;

    @FXML
    private TextField janField1;

    @FXML
    private TextField janField2;

    @FXML
    private DatePicker joiningDate;

    @FXML
    private TextField julField1;

    @FXML
    private TextField julField2;

    @FXML
    private TextField junField1;

    @FXML
    private TextField junField2;

    @FXML
    private TextField marField1;

    @FXML
    private TextField marField2;

    @FXML
    private TextField mayField1;

    @FXML
    private TextField mayField2;

    @FXML
    private Text netSalaryTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField designationTF;

    @FXML
    private TextField novField1;

    @FXML
    private TextField novField2;

    @FXML
    private TextField octField1;

    @FXML
    private TextField octField2;

    @FXML
    private Text overtime;

    @FXML
    private TextField sepField1;

    @FXML
    private TextField sepField2;

    @FXML
    private TableColumn<Employee, String> employeeAddressProperty;

    @FXML
    private TableColumn<Employee, String> employeeDesignationProperty;

    @FXML
    private TextField searchEmployee;

    @FXML
    private AnchorPane parent;

    @FXML
    private TableColumn<Employee, String> employeeGradeProperty;

    @FXML
    private TableColumn<Employee, String> employeeJoiningDateProperty;

    @FXML
    private TableColumn<Employee, String> employeeLoanProperty;

    @FXML
    private TableColumn<Employee, String> employeeNameProperty;

    @FXML
    private Button addEmployeeButton;

    @FXML
    private TableColumn<Employee, String> employeeHourlySalaryProperty;

    @FXML
    private TableColumn<Employee, String> employeeTravelAllowanceProperty;

    @FXML
    private TableColumn<Employee, String> employeePhoneNumberProperty;

    @FXML
    private TableColumn<Employee, String> employeeRegistrationNumberProperty;

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private Label uploadFileLabel;

    private Scene scene;

    @FXML
    private Text basicSalaryTF;

    private Stage stage;

    @FXML
    private TextField address;

    @FXML
    private TextField grade;

    @FXML
    private TextField loan;

    @FXML
    private TextField name;

    @FXML
    private TextField number;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField designation;

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    // When a key is pressed a relevant action happens
    @FXML
    private void keyEvents(KeyEvent event) throws IOException {
        // Opens the add a new employee page and clears the table's filter
        if (event.getCode() == KeyCode.N) {
            clearFilter();
            addEmployee();
        }
        // Opens the modifies/ updates employee page and clears the table's filter
        if (event.getCode() == KeyCode.M) {
            clearFilter();
            updateEmployee();
        }
        // Opens the delete employee page and clears the table's filter
        if (event.getCode() == KeyCode.D) {
            clearFilter();
            deleteEmployee();
        }
        // Prints employee's pay salary slip
        if (event.getCode() == KeyCode.P) {
            printEmployee();
        }
        // Searches and displays employee's record and clears the table's filter
        if (event.getCode() == KeyCode.R) {
            clearFilter();
            searchEmployee();
        }
        // Displays a list of employees
        if (event.getCode() == KeyCode.L) {
            fileChooser();
        }
        // Displays the "about" window
        if (event.getCode() == KeyCode.I) {
            aboutWindow();
        }
        // Clears the table's filter
        if (event.getCode() == KeyCode.C) {
            clearFilter();
        }
        // Saves the data to a txt file and clears the table's filter
        if (event.getCode() == KeyCode.S) {
            clearFilter();
            saveTable();
        }
        // Quits the program
        if (event.getCode() == KeyCode.Q) {
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("FXMLs/login_page.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You've been successfully logged out.");
            alert.show();
        }
    }

    // Uses the merge sort algorithm to sort the employees' list
    private void mergeSort(ObservableList<Employee> list) {
        // Starts to sort the employees' list, if it has more than one entry
        if (list.size() > 1) {
            // Finds the middle index of the list, by splitting the list in half
            int mid = list.size() / 2;
            // Creates a new list, which is the left half of the original list
            ObservableList<Employee> left = FXCollections.observableArrayList(list.subList(0, mid));
            // Creates a new list, which is the right half of the original list
            ObservableList<Employee> right = FXCollections.observableArrayList(list.subList(mid, list.size()));
            // Calls the mergeSort function again on the left list
            mergeSort(left);
            // Calls the mergeSort function again on the right list
            mergeSort(right);
            // Create three integers (i, j and k), keeping track of the indexes within the original list, left and right
            int i = 0, j = 0, k = 0;
            // If both right and left lists contain items, each item in the list will be compared to the employee registration number
            while (i < left.size() && j < right.size()) {
                // If the employee registration number in the left list is less than that of the employee registration number in the right list, the left employee will be added to the original list
                if (left.get(i).getEmployeeRegistrationNumberProperty() < right.get(j).getEmployeeRegistrationNumberProperty()) {
                    // Adds the employee in the left list to the original list, index (k) is then increased by one
                    list.set(k++, left.get(i++));
                    // Else, if the employee registration number in the right list is less than or equal to the employee registration number in the left list, the correct employee will be added to the original list
                } else {
                    // Adds the employee in the right list to the original  list, index (k) is then increased by one
                    list.set(k++, right.get(j++));
                }
            }
            // Any remaining employees within the left list, will be subsequently added to the original list
            while (i < left.size()) {
                // Adds the employee in the left list to the original list, index (k) is incremented by one
                list.set(k++, left.get(i++));
            }
            // Any remaining employees within the right list, will be subsequently added to the original list
            while (j < right.size()) {
                // Adds the employee in the right list to the original list, index (k) is incremented by one
                list.set(k++, right.get(j++));
            }
        }
    }

    // Calls the addEmployee() method when the add employee button is clicked
    @FXML
    private void addEmployeeButton(ActionEvent event) {
        addEmployee();
    }

    // Adds a new employee to the 'employeeList' list using an insertion sort algorithm
    private void addEmployee() {
        // Clears the table's filter
        clearFilter();
        // Creates an alert pop-up window displaying information
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Checks if the employee's list is empty
        if (tableView.getItems().size() == 0) {
            // Sets the text content of the alert pop up
            alert.setContentText("Please upload a file first.");
            // Displays the alert
            alert.show();
        } else {
            // Displays a pop-up window, where the employers can enter the new employee's information. The information from this window is stored in a hashmap called resultMap
            HashMap<String, Object> resultMap = showAddEmployeeWindow();
            // For loop that searches through each employee in the list
            for (int i = 1; i < employeeList.size(); i++) {
                // Gets the current employee in the list
                Employee current = employeeList.get(i);
                // Sets the variable 'j' to the previous employee's index within the list
                int j = i - 1;
                // Checks if the previous employee has a greater registration number than the current selected employee
                while (j >= 0 && employeeList.get(j).getEmployeeRegistrationNumberProperty() > current.getEmployeeRegistrationNumberProperty()) {
                    // Moves the previous employee one position down the list
                    employeeList.set(j + 1, employeeList.get(j));
                    // Decreases j's value by one
                    j--;
                }
                // Inserts the employee into the correct position within the list
                employeeList.set(j + 1, current);
            }
            // Checks whether the resultMaps are empty
            if ((resultMap.get("address") == null) &&
                    (resultMap.get("designation") == null) &&
                    (resultMap.get("loan") == null) &&
                    (resultMap.get("phoneNumber") == null) &&
                    (resultMap.get("joiningDate") == null) &&
                    (resultMap.get("name") == null) &&
                    (resultMap.get("number") == null) &&
                    (resultMap.get("hourlySalary") == null) &&
                    (resultMap.get("travelAllowance") == null) &&
                    (resultMap.get("grade") == null))
                    // Terminates the method if the fields are empty
                    return;
            else {
                // Retrieves the HashMap's employee's registration number
                int number = Integer.parseInt((String) resultMap.get("number"));
                // Utilises the binary search algorithm to check whether the registration number already exists
                int[] indicesToDelete = binarySearchRegistrationNumber(employeeList, (number));
                // If the registration number already exists a pop-up alert is displayed, stating that the registration number already exists
                if (indicesToDelete.length >= 1) {
                    alert.setContentText("Registration number already exists.");
                    alert.show();
                    // The method is stopped
                    return;
                }
                // Creates a new employee object
                Employee addEmployee = new Employee();
                // Gets the result map fields' values
                addEmployee.setEmployeeAddress((String) resultMap.get("address"));
                addEmployee.setEmployeeDesignation((String) resultMap.get("designation"));
                addEmployee.setEmployeeLoan((String) resultMap.get("loan"));
                addEmployee.setEmployeePhoneNumber((String) resultMap.get("phoneNumber"));
                addEmployee.setEmployeeJoiningDate((String) resultMap.get("joiningDate"));
                addEmployee.setEmployeeName((String) resultMap.get("name"));
                addEmployee.setEmployeeRegistrationNumber(String.valueOf(Integer.parseInt(resultMap.get("number").toString())));
                addEmployee.setEmployeeGrade((String) resultMap.get("grade"));
                addEmployee.setEmployeeTravelAllowance((String) resultMap.get("travelAllowance"));
                addEmployee.setEmployeeHourlySalary((String) resultMap.get("hourlySalary"));
                // Inserts the employee using the insertion sort method
                insertionSort(addEmployee, employeeList);
                // Shows an alert message confirming that the employee has been successfully added
                alert.setContentText("New employee has been successfully added.");
                alert.show();
            }
        }
    }

    // Calls the insertion sort method
    private void insertionSort(Employee newEmployee, List<Employee> employeeList) {
        // Inserts new employee into correct position using insertion sort
        int insertIndex = 0;
        // Checks each employee within the list and then finds the right place to add the new employee
        while (insertIndex < employeeList.size() && employeeList.get(insertIndex).getEmployeeRegistrationNumberProperty() < newEmployee.getEmployeeRegistrationNumberProperty()) {
            insertIndex++;
        }
        // Adds the employee at the correct index
        employeeList.add(insertIndex, newEmployee);
    }

    // Creates a pop-up window to add a new employee
    private HashMap<String, Object> showAddEmployeeWindow() {
        // Creates an empty HashMap called resultMap
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // Creates a new object loader
        FXMLLoader loader = new FXMLLoader();
        // Sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/add_employee_page.fxml"));
        // Creates a new newEmployeePopup object, responsible for controlling the pop-up window
        New_Employee_Popup newEmployeePopup = new New_Employee_Popup();
        // Connects the FXML file with the controller that manages the file
        loader.setController(newEmployeePopup);
        // Represents the layout's root of the pop-up window
        Parent layout;
        // Loads the layout file, creates a new scene object. This section represent the content of the pop up window
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            Stage popupStage = new Stage();
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            // Sets the icon
            popupStage.getIcons().add(icon);
            // Sets the stage's title
            popupStage.setTitle("  Add New Employee");
            // Centers the stage in the middle of the screen
            popupStage.centerOnScreen();
            newEmployeePopup.setStage(popupStage);
            // Set the drop-down menu's options
            newEmployeePopup.gradeComboBox.setItems(FXCollections.observableArrayList("I", "II", "III", "IV"));
            // Sets the pop up window's owner
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            // Shows the pop-up window, sets the scene to be displayed, sets the modality of the pop-up window
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
            // If there's an error loading the file, it prints out an error message to the console
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        // Returns the pop-up window's HashMap data
        return newEmployeePopup.getResult();
    }

    // Calls the deleteEmployee method when the deleteEmployeeButton is activated
    @FXML
    private void deleteEmployeeButton(ActionEvent event) {
        clearFilter();
        deleteEmployee();
    }

    // Deletes employee using binary search code
    private void deleteEmployee() {
        // Creates a new alert box
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // If the employeeList is empty, an alert message is shown stating that there are no employees to delete
        if (employeeList.size() == 0) {
            alert.setContentText("No employees to delete, please upload a file first.");
            alert.show();
            return;
        // Else, a new pop-up window is displayed, a employer can select an employee to delete based of their employee ID, the employee's ID is stored in a HashMap called resultMap
        } else {
            HashMap<String, Object> resultMap = showDeleteEmployeeWindow();
            // If the employer provides no ID number to delete employee, the method is terminated
            if (resultMap.get("number") == null) {
                return;
            }
            // Gets the employee ID from the resultMap
            Object deleteEmployeeID = resultMap.get("number");
            // Searches for the employee ID using a binary search code within the employeeList
            // Stores the employee's ID's index position within an array called indicesToDelete
            int[] indicesToDelete = binarySearchRegistrationNumber(employeeList, Integer.parseInt((String) deleteEmployeeID));
            // If no employee ID was found within the employee List, an alert pop is shown and the method is terminated
            if (indicesToDelete.length == 0) {
                alert.setContentText("Employee with the registration number " + deleteEmployeeID + " does not exist.");
                alert.show();
                return;
            /* Else, loops through each index within the indicesToDelete array
                Displays a pop-up window asking the employer whether they are sure that they want to delete the employee
                If the employee confirms that they want to delete the employer, the employee record is removed from the
                employees list */
            } else {
                for (int i : indicesToDelete) {
                    Alert alertTwo = new Alert(Alert.AlertType.CONFIRMATION);
                    alertTwo.setTitle("Delete Employee");
                    alertTwo.setHeaderText("Are you sure you want to delete employee " + deleteEmployeeID.toString() + "?");
                    Optional<ButtonType> option = alertTwo.showAndWait();
                    if (option.get() == ButtonType.OK) {
                        employeeList.remove(i);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Employee successfully deleted.");
                        alert.show();
                    }
                    // If the employer clicks cancel, the method stops running
                    else {
                        return;
                    }
                }
            }
        }
    }

    // Creates a pop-up window to delete an employee
    private HashMap<String, Object> showDeleteEmployeeWindow() {
        // Creates an empty HashMap called resultMap
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // Creates a new object loader
        FXMLLoader loader;
        loader = new FXMLLoader();
        // Sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/delete_employee_page.fxml"));
        // Creates a new deleteEmployeePopup object, responsible for controlling the pop-up window
        Delete_Employee_Popup deleteEmployeePopup = new Delete_Employee_Popup();
        // Connects the FXML file with the controller that manages the file
        loader.setController(deleteEmployeePopup);
        // Represents the layout's root of the pop-up window
        Parent layout;
        // Loads the layout file, creates a new scene object. This section represent the content of the pop-up window
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            Stage popupStage = new Stage();
            // Sets the icon
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            popupStage.getIcons().add(icon);
            // Sets the stage's title
            popupStage.setTitle("  Delete Employee");
            // Centers the stage in the middle of the screen
            popupStage.centerOnScreen();
            deleteEmployeePopup.setStage(popupStage);
            // Sets the pop up window's owner
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            // Shows the pop-up window, sets the scene to be displayed, sets the modality of the pop-up window
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
            // If there's an error loading the file, it prints out an error message to the console
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        // Returns the pop-up window's HashMap data
        return deleteEmployeePopup.getResult();
    }

    // Calls the fileChooser method when the listEmployeesButton is activated
    @FXML
    private void listEmployeesButton(ActionEvent event) throws IOException {
        fileChooser();
    }

    // Calls the fileChooser method
    private void fileChooser() throws IOException {
        // Removes any employees that are in the JavaFX table
        for (int i = 0; i < tableView.getItems().size(); i++) {
            tableView.getItems().clear();
        }
        // Allows users to select only 'TXT' and 'txt' files from their computer
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        // Saves the file's location the user selects. If a file isn't selected the method stop
        File f = fc.showOpenDialog(null);
        if (f == null) {
            return;
        } else {
            // The label next to the 'Upload File' button is set to the name of the file the user has selected
            uploadFileLabel.setText(f.getName());
            try {
                /* Reads the txt file's content, creating a list of Employee objects
                   The txt file is read line by line and split into sections using / as a divider
                   Each index of the split line is allocated to an attribute of an employee
                 */
                Collection<Employee> list = Files.readAllLines(new File(f.toURI()).toPath()).stream()
                        .map(line -> {
                            String[] details = line.split("/");
                            Employee cd = new Employee();
                            cd.setEmployeeRegistrationNumber(details[0]);
                            cd.setEmployeeName(details[1]);
                            cd.setEmployeeAddress(details[2]);
                            cd.setEmployeePhoneNumber(details[3]);
                            cd.setEmployeeJoiningDate(details[4]);
                            cd.setEmployeeDesignation(details[5]);
                            cd.setEmployeeGrade(details[6]);
                            cd.setEmployeeLoan(details[7]);
                            cd.setEmployeeTravelAllowance(details[8]);
                            cd.setEmployeeHourlySalary(details[9]);
                            return cd;
                        })
                        .collect(Collectors.toList());
                // Sorts the employees by ascending registration number using the merge sort algorithm
                employeeList.addAll(list);
                mergeSort(employeeList);
            /* If there's an error creating the list, the label next to the 'Upload File' button is set to
            'Incorrect file type uploaded */
            } catch (Exception e) {
                uploadFileLabel.setText("Incorrect file type uploaded.");
            }
        }
    }

    // When the exit button is clicked, the user is redirected to the login page
    @FXML
    private void exitButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/login_page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    // When the search employee button is clicked, it calls the clearFilter() and searchEmployee() methods
    @FXML
    private void searchEmployeeButton(ActionEvent event) {
        clearFilter();
        searchEmployee();
    }

    // Calls the searchEmployee method
    @FXML
    private void searchEmployee() {
        // Creates a new alert instance
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // If the employee's list is empty, an alert is displayed to 'Please upload a file first'.
        if (employeeList.size() == 0) {
            alert.setContentText("Please upload a file first.");
            alert.show();
            return;
        }
        // Creates a pop-up which the user can input a registration number
        HashMap<String, Object> resultMap = showSearchEmployeeWindow();
        // If the user doesn't supply a registration number the method is terminated
        if (resultMap.get("number") == null) {
            return;
        }
        // Converts the user's supplied registration number into an integer
        Integer number = Integer.parseInt((String) resultMap.get("number"));
        // Searches the 'employeeList' for the user's provided registration number, using a binary search, and provides an indices array where the number was found
        int[] indices = binarySearchRegistrationNumber(employeeList, number);
        /* Creates a new list, including only the indices from the employees' list where the registration number provided by the user
        matches the employee's registration number within the 'employeeList' */
        ObservableList<Employee> filteredData = FXCollections.observableArrayList();
        for (int index : indices) {
            filteredData.add(employeeList.get(index));
        }
        // If no registration number match was found, an alert is displayed informing the user that the 'Registration number does not exist within the table.'
        if (filteredData.size() == 0) {
            alert.setContentText("Registration number does not exist within the table.");
            alert.show();
            return;
        }
        // Sets the filtered data to the JavaFX table
        tableView.setItems(filteredData);
    }

    // Searches for employees' registration number using a binary search algorithm
    private static int[] binarySearchRegistrationNumber(ObservableList<Employee> employees, int id) {
        // Create a new array that will store the indices that match the employee's registration number
        List<Integer> indicesList = new ArrayList<>();
        // Defines the boundaries of the search
        int left = 0;
        int right = employees.size() - 1;
        /* A while loop is used to split the range in half repeatedly until it discovers a matching employee registration number or decides that the registration does not exist in the list. If the registration
        number is discovered in the list, the corresponding employee's index position is added to the indicesList array. It then searches to the left and right of matching to locate any additional matched employees.
        If the registration is not found, the loop will continue to search until the range is exhausted. */
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currentId = employees.get(mid).getEmployeeRegistrationNumberProperty();
            if (currentId == id) {
                indicesList.add(mid);
                // Searches left of match
                for (int i = mid - 1; i >= 0 && employees.get(i).getEmployeeRegistrationNumberProperty() == id; i--) {
                    indicesList.add(i);
                }
                // Searches right of match
                for (int i = mid + 1; i < employees.size() && employees.get(i).getEmployeeRegistrationNumberProperty() == id; i++) {
                    indicesList.add(i);
                }
                break;
            } else if (currentId < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        /* This code creates a new integer array named indices and copies the indices from the indicesList into it. The method then returns the indices array, which contains the indices of any workers that matched the search ID. */
        int[] indices = new int[indicesList.size()];
        for (int i = 0; i < indicesList.size(); i++) {
            indices[i] = indicesList.get(i);
        }
        return indices;
    }

    // Calls the clearFiler() and updateEmployee() methods when the update employee button is clicked
    @FXML
    private void updateEmployeeButton(ActionEvent event) {
        clearFilter();
        updateEmployee();
    }

    // Updates employee method
    private void updateEmployee() {
        // Creates a new alert pop-up instance
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // If the JavaFX table has no employees within it, it shows a pop-up alert stating 'No employees to update, please upload a file first.'
        if (tableView.getItems().size() == 0) {
            alert.setContentText("No employees to update, please upload a file first.");
            alert.show();
        } else {
            // Opens a new pop-up window where the employee can submit a registration number to search
            HashMap<String, Object> resultMap = showUpdateEmployeeWindow();
            // Retrieves the HashMap's new employee's registration number
            int number = Integer.parseInt((String) resultMap.get("number"));
            // Utilises the binary search algorithm to check whether the new registration number already exists
            int[] indicesToUpdate = binarySearchRegistrationNumber(employeeList, (number));
            // If the provided registration number does not exist a pop-up alert is displayed, stating that the registration number does not exists
            if (indicesToUpdate.length < 1) {
                alert.setContentText("Employee with the ID " + number + " does not exist.");
                alert.show();
                // The method is terminated
                return;
            }
            // Retrieves the HashMap's new employee's registration number
            String newNumberString = (String) resultMap.get("newNumber");
            // If the user doesn't supply a new registration number
            if (!newNumberString.isEmpty()) {
                // Converts the new registration number to an integer
                int newnumber = Integer.parseInt(newNumberString);
                // Utilises the binary search algorithm to check whether the new registration number already exists
                int[] indicesToUpdateTwo = binarySearchRegistrationNumber(employeeList, (newnumber));
                // If the new provided registration number already exists a pop-up alert is displayed, stating that the registration number already exists
                if (indicesToUpdateTwo.length >= 1) {
                    alert.setContentText("Registration number already exists within the database.");
                    alert.show();
                    // The method is terminated
                    return;
                }
            }
            // 'updateEmployeeID' equals the registration number the employee provided within the pop-up window
            Object updateEmployeeID = resultMap.get("number");
            /* A new int array is created, storing all indices within employeeList that have the same registration number
               that the user supplied within the pop-up window. The employeeList is searched to find these indices using a
               binary search code algorithm */
            int[] indicesToUpdateThree = binarySearchRegistrationNumber(employeeList, Integer.parseInt((String) updateEmployeeID));
            // Creates a new list to store the indices found within indicesToDelete
            List<Integer> rowArrayTwo = new ArrayList<>();
            for (int index : indicesToUpdateThree) {
                rowArrayTwo.add(index);
            }
            // A pop-up is displayed showing a successful updation of data.
                /* For each employee indices stored within rowArrayTwo, the table's information is updated from the information that the
                user supplied within the pop-up window */
            for (Integer i : rowArrayTwo) {
                Employee newUpdateEmployee = tableView.getItems().get(i);
                if (!resultMap.get("address").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeAddress((String) resultMap.get("address"));
                }
                if (!resultMap.get("hourlySalary").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeHourlySalary((String) resultMap.get("hourlySalary"));
                }
                if (!resultMap.get("travelAllowance").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeTravelAllowance((String) resultMap.get("travelAllowance"));
                }
                if (!resultMap.get("designation").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeDesignation((String) resultMap.get("designation"));
                }
                if (!resultMap.get("newNumber").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeRegistrationNumber((String) resultMap.get("newNumber"));
                }
                if (!resultMap.get("loan").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeLoan((String) resultMap.get("loan"));
                }
                if (!resultMap.get("phoneNumber").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeePhoneNumber((String) resultMap.get("phoneNumber"));
                }
                if (!resultMap.get("name").toString().isEmpty()) {
                    newUpdateEmployee.setEmployeeName((String) resultMap.get("name"));
                }
                if (!(resultMap.get("grade") == null)) {
                    newUpdateEmployee.setEmployeeGrade((String) resultMap.get("grade"));
                }
                if (!(resultMap.get("joiningDate") == null)) {
                    newUpdateEmployee.setEmployeeJoiningDate((String) resultMap.get("joiningDate"));
                }
                // Shows an alert when the employee has been successfully updated
                alert.setContentText("Employee successfully updated.");
                alert.show();
            }
        }
    }

    // Creates a pop-up window to update an employee
    private HashMap<String, Object> showUpdateEmployeeWindow() {
        // Creates an empty HashMap called resultMap
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // Creates a new object loader
        FXMLLoader loader = new FXMLLoader();
        // Sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/update_employee_page.fxml"));
        // Creates a new updateEmployeePopup object, responsible for controlling the pop-up window
        Update_Employee_Popup updateEmployeePopup = new Update_Employee_Popup();
        // Connects the FXML file with the controller that manages the file
        loader.setController(updateEmployeePopup);
        // Represents the layout's root of the pop-up window
        Parent layout;
        // Loads the layout file, creates a new scene object. This section represent the content of the pop up window
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            // This is the popup's stage
            Stage popupStage = new Stage();
            // Sets the stage's icon
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            popupStage.getIcons().add(icon);
            // Sets the stage's title
            popupStage.setTitle("  Update Employee");
            // Centre's the stage on the centre of the screen
            popupStage.centerOnScreen();
            updateEmployeePopup.setStage(popupStage);
            // Adds items to the drop-down selection field, within the pop-up window
            updateEmployeePopup.gradeComboBox.setItems(FXCollections.observableArrayList("I", "II", "III", "IV"));
            // Sets the pop up window's owner
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            // Shows the pop-up window, sets the scene to be displayed, sets the modality of the pop-up window
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
            // If there's an error loading the file, it prints out an error message to the console
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        // Returns the pop-up window's HashMap data
        return updateEmployeePopup.getResult();
    }

    // Calls the aboutWindow() method when the about button is activated
    @FXML
    private void aboutButton(ActionEvent event) {
        aboutWindow();
    }

    // Creates a pop-up window to display information about Unisalaries
    private HashMap<String, Object> aboutWindow() {
        // Creates a new object loader
        FXMLLoader loader = new FXMLLoader();
        // Sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/about_page.fxml"));
        // Creates a new aboutPopup object, responsible for controlling the pop-up window
        About_Popup aboutPopup = new About_Popup();
        // Connects the FXML file with the controller that manages the file
        loader.setController(aboutPopup);
        // Represents the layout's root of the pop-up window
        Parent layout;
        // Loads the layout file, creates a new scene object. This section represent the content of the pop-up window
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            // This is the popup's stage
            Stage popupStage = new Stage();
            // Sets the stage's icon
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            popupStage.getIcons().add(icon);
            // Sets the stage's title
            popupStage.setTitle("  About Us");
            aboutPopup.setStage(popupStage);
            // Sets the pop up window's owner
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            // Centre's the about pop up window in the centre of the screen
            popupStage.centerOnScreen();
            // Shows the pop-up window, sets the scene to be displayed, sets the modality of the pop-up window
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        // If there's an error loading the file, it prints out an error message to the console
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        return aboutPopup.getResult();
    }

    // Calls the saveFile() method when the save file button is activated
    @FXML
    private void saveFile(ActionEvent event) throws IOException {
        saveTable();
    }

    // Saves the table to a TXT or txt file
    private void saveTable() throws IOException {
        // Creates a new alert pop up
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // If there is no employees within the JavaFX table, an alert pop-up is displayed
        if (tableView.getItems().size() == 0) {
            alert.setContentText("No employees to save, please upload a file first.");
            alert.show();
        }
        // Else,
        else {
            // A file chooser is created, allowing a user to pick a file from their computer
            FileChooser fc = new FileChooser();
            // The user can only select TXT or txt files from their computer
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
            // Shows the filechooser window, the chosen file is then stored in a variable called 'f'
            File f = fc.showOpenDialog(null);
            // If the user has selected a file
            if (f != null) {
                // Creates a file writer to write the chosen file's information
                FileWriter fw = new FileWriter(f.getPath());
                // Loops through each row within the JavaFX table
                for (int i = 0; i < tableView.getItems().size(); i++) {
                    // For each row within the JavaFX table, each column is stored in it's allocated variable
                    String registrationNumber = employeeRegistrationNumberProperty.getCellObservableValue(i).getValue();
                    String name = employeeNameProperty.getCellObservableValue(i).getValue();
                    String address = employeeAddressProperty.getCellObservableValue(i).getValue();
                    String phoneNumber = employeePhoneNumberProperty.getCellObservableValue(i).getValue();
                    String joining = employeeJoiningDateProperty.getCellObservableValue(i).getValue();
                    String designation = employeeDesignationProperty.getCellObservableValue(i).getValue();
                    String grade = employeeGradeProperty.getCellObservableValue(i).getValue();
                    String loan = employeeLoanProperty.getCellObservableValue(i).getValue();
                    String travelAllowance = employeeTravelAllowanceProperty.getCellObservableValue(i).getValue();
                    String hourlySalary = employeeHourlySalaryProperty.getCellObservableValue(i).getValue();
                    // All variables above are combined into a single line, each separated by a /
                    String line = registrationNumber + "/" + name + "/" + address + "/" + phoneNumber + "/" + joining + "/"
                            + designation + "/" + grade + "/" + loan + "/" + travelAllowance + "/" + hourlySalary;
                    // Writes each string to a file, with a new line added to the end
                    fw.write(line + "\n");
                }
                // Closes the file writer
                fw.close();
                // An alert pop-up is displayed, confirming the JavaFX's data has been successfully saved
                alert.setContentText("File successfully saved.");
                alert.show();
            }
        }
    }

    // Calls the clearFilter() method, when the clear filter button is activated
    @FXML
    private void clearFilterButton(ActionEvent event) {
        clearFilter();
    }

    // Clears the filter, by setting the original employee list (employeeList) to the JavaFX table
    private void clearFilter() {
        tableView.setItems(employeeList);
    }

    // Displays the search employee window
    private HashMap<String, Object> showSearchEmployeeWindow() {
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // Creates a new object loader
        FXMLLoader loader = new FXMLLoader();
        // Sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/search_employee_page.fxml"));
        // Creates a new searchEmployeePopup object, responsible for controlling the pop-up window
        Search_Employee_Popup searchEmployeePopup = new Search_Employee_Popup();
        // Connects the FXML file with the controller that manages the file
        loader.setController(searchEmployeePopup);
        // Represents the layout's root of the pop-up window
        Parent layout;
        // Loads the layout file, creates a new scene object. This section represent the content of the pop-up window
        try {
            layout = loader.load();
            Scene scene = new Scene(layout);
            // This is the popup's stage
            Stage popupStage = new Stage();
            // Sets the stage's icon
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            popupStage.getIcons().add(icon);
            // Sets the stage's title
            popupStage.setTitle("  Search Employee");
            // Centre's the search employee pop up window in the centre of the screen
            popupStage.centerOnScreen();
            searchEmployeePopup.setStage(popupStage);
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
        // If there's an error loading the file, it prints out an error message to the console
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        return searchEmployeePopup.getResult();
    }

    private void printEmployee() {
        // Creates a new alert object
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Creates a list of the "normalHoursTextFields" text fields
        List<TextField> normalHoursTextFields = new ArrayList<>();
        normalHoursTextFields.add(janField1);
        normalHoursTextFields.add(febField1);
        normalHoursTextFields.add(marField1);
        normalHoursTextFields.add(aprField1);
        normalHoursTextFields.add(mayField1);
        normalHoursTextFields.add(junField1);
        normalHoursTextFields.add(julField1);
        normalHoursTextFields.add(augField1);
        normalHoursTextFields.add(sepField1);
        normalHoursTextFields.add(octField1);
        normalHoursTextFields.add(novField1);
        normalHoursTextFields.add(decField1);
        // Creates a list of the "overtimeHoursWorked" text fields
        List<TextField> overtimeHoursWorked = new ArrayList<>();
        overtimeHoursWorked.add(janField2);
        overtimeHoursWorked.add(febField2);
        overtimeHoursWorked.add(marField2);
        overtimeHoursWorked.add(aprField2);
        overtimeHoursWorked.add(mayField2);
        overtimeHoursWorked.add(junField2);
        overtimeHoursWorked.add(julField2);
        overtimeHoursWorked.add(augField2);
        overtimeHoursWorked.add(sepField2);
        overtimeHoursWorked.add(octField2);
        overtimeHoursWorked.add(novField2);
        overtimeHoursWorked.add(decField2);
        // For every text field with the "normalHoursTextFields" list
        for (TextField field : normalHoursTextFields) {
            // If any text field is empty, sets the field's value to 0
            if (field.getText().isEmpty()) {
                field.setText("0");
            }
            // If the text field's value aren't whole number, an alert pop-up is shown, terminates the method
            if (!field.getText().matches("\\d+")) {
                alert.setContentText("Incorrect normal hours format (must be integers).");
                alert.show();
                return;
            }
            // If the values over 30 an alert is shown, terminates the method
            if (Integer.parseInt(field.getText()) > 30) {
                alert.setContentText("Normal hours out of bounds.");
                alert.show();
                return;
            }
        }
        // For every text field with the "normalHoursTextFields" list
        for (TextField field : normalHoursTextFields) {
            // If any text field is empty, sets the field's value to 0
            if (field.getText().isEmpty()) {
                field.setText("0");
            }
            // If the text field's value aren't whole number, an alert pop-up is shown, terminates the method
            if (!field.getText().matches("\\d+")) {
                alert.setContentText("Incorrect overtime hours format (must be integers).");
                alert.show();
                return;
            }
        }
        // If the "joiningDate" text field's empty shows an alert, terminates the method
        if (joiningDate.getValue() == null) {
            alert.setContentText("Please insert the date.");
            alert.show();
            return;
        }
        // If the "nameTF" text field's empty shows an alert, terminates the method
        if (nameTF.getText().toString().isEmpty()) {
            alert.setContentText("Please insert the employee's name.");
            alert.show();
            return;
        }
        // If the "designationTF" text field's empty shows an alert, terminates the method
        if (designationTF.getText().toString().isEmpty()) {
            alert.setContentText("Please insert the employee's designation.");
            alert.show();
            return;
        }
        // If the "gradeComboBox" text field's empty shows an alert, terminates the method
        if (gradeComboBox.getValue() == null || gradeComboBox.getValue().isEmpty()) {
            alert.setContentText("Please insert the employee's grade.");
            alert.show();
            return;
        }
        // If the employeeList is empty, an alert message is shown stating that there are no employees to delete
        if (employeeList.size() == 0) {
            alert.setContentText("No employees to print, please upload a file first.");
            alert.show();
            return;
        // Else, a new pop-up window is displayed, an employer can select an employee to print based of their employee ID, the employee's ID is stored in a HashMap called resultMap
        } else {
            HashMap<String, Object> resultMap = showPrintEmployeeWindow();
            // If the employer provides no ID number to print an employee, the method is terminated
            if (resultMap.get("number") == null) {
                return;
            }
            // Gets the employee ID from the resultMap
            Object printEmployeeID = resultMap.get("number");
            // Searches for the employee ID using a binary search code within the employeeList
            // Stores the employee's ID's index position within an array called indicesToDelete
            int[] indicesToPrint = binarySearchRegistrationNumber(employeeList, Integer.parseInt((String) printEmployeeID));
            // If no employee ID was found within the employee List, an alert pop is shown and the method is terminated
            if (indicesToPrint.length == 0) {
                alert.setContentText("Employee does not exist.");
                alert.show();
                return;
            // If the employee exists, their salary and travel allowance is set to the "basicSalaryTF" and "travelAllowanceTF" text fields
            } else {
                for (int i : indicesToPrint) {
                    basicSalaryTF.setText(employeeList.get(i).getEmployeeHourlySalary());
                    travelAllowanceTF.setText(employeeList.get(i).getEmployeeTravelAllowance());
                }
                // Calls the calculate method
                calculate();
            }
        }
    }

    // Prints the employees payslip to a physical printer
    private void print() {
        // Gets the joining date selected from a date picker
        LocalDate selectedDate = joiningDate.getValue();
        // Creates the date in the format of (dd/MMY/yyyy)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Formats the  printer's data
        String printData = "Date: " + (selectedDate.format(formatter).toString()) + "\n" +
                // Gets the text field's name
                "Name: " + nameTF.getText() + "\n" +
                // Gets the designation field's name
                "Designation: " + designationTF.getText() + "\n" +
                // Gets the grade field's value
                "Grade: " + gradeComboBox.getValue() + "\n" +
                // Gets the hours worked per day
                "Hours Worked Per Day: " + hourWorkedPerDayTF.getText() + " hours" + "\n" +
                // Gets the total days worked per year
                "Total Days Worked Per Year: " + daysWorked.getText() + "\n" +
                // Gets the total overtime hours per year
                "Total Overtime Hours Per Year: " + overtime.getText() + "\n" +
                // Gets the gross pay
                "Gross Pay: " + "£" + grossPayTF.getText() + "\n" +
                // Displays thhe house allowance heading
                "House Allowance: " + "\n" +
                // Gets the 5% allowance
                "Five Percent: " + "£" + fivePercentTF.getText() + "\n" +
                // Gets the travel allowance
                "Travel Allowance: " + "£" + travelAllowanceTF.getText() + "\n" +
                // Gets the health allowance (8%)
                "Health Allowance (8%): " + "£" + healthAllowanceTF.getText() + "\n" +
                // Gets the deductions (20%)
                "Deductions (20%): " + "£" + deductionsTF.getText() + "\n" +
                // Gets the net salary
                "Net Salary: " + "£" + netSalaryTF.getText();
        // Creates a printer job
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new OutputPrinter(printData));
        // Shows the print dialog
        boolean doPrint = job.printDialog();
        // If you user requests to print
        if (doPrint) {
            try {
                // Prints the printable content
                job.print();
            } catch (PrinterException e) {
                // Catches the exception if there's a problem with the printer job
            }
        }
    }

    // When the print button is clicked the printEmployee() method is called
    @FXML
    private void printEmployeeButton(ActionEvent event) {
        printEmployee();
    }

    // Shows the print employee pop up window
    private HashMap<String, Object> showPrintEmployeeWindow() {
        // Creates a new HashMap
        HashMap<String, Object> resultMap = new HashMap<String, Object>();
        // Creates a new FXMLLoader Object
        FXMLLoader loader = new FXMLLoader();
        // For the pop-up window sets the location of the FXML file
        loader.setLocation(getClass().getResource("FXMLs/print_employee_page.fxml"));
        // initializing the controller
        Print_Employee_Popup printEmployeePopup = new Print_Employee_Popup();
        // Makes the Print_Employee_Popup object the FXML file's controller
        loader.setController(printEmployeePopup);
        Parent layout;
        try {
            // Loads the FXML file and sets it the pop up window's layout
            layout = loader.load();
            // New Scene object is created to accommodate the layout
            Scene scene = new Scene(layout);
            // Makes a new Stage object that displays the pop-up window
            Stage popupStage = new Stage();
            // Changes the pop-up window's icon to the Unisalaries icon.
            Image icon = new Image(getClass().getResource("Images/Icon.png").toString());
            // Adds the icon to the stage
            popupStage.getIcons().add(icon);
            // Sets the title of the stage
            popupStage.setTitle("  Print Employee");
            // When the stage is loaded, centers it in the middle of the screen
            popupStage.centerOnScreen();
            // If there is a main stage (which there should be), the pop up window is configured to be a modal window
            printEmployeePopup.setStage(popupStage);
            if (this.main != null) {
                popupStage.initOwner(main.getPrimaryStage());
            }
            popupStage.initModality(Modality.WINDOW_MODAL);
            popupStage.setScene(scene);
            popupStage.showAndWait();
            // If there's an error displaying the pop-up window an alert is displayed
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "There was an error trying to load the popup fxml file.").show();
        }
        // Returns the HashMap outcome of the pop-up window
        return printEmployeePopup.getResult();
    }

    // Calculates the employee's payslip
    private void calculate() {
        // Creates a new alert instance
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        // Create two ArrayLists, including one for normal hours worked and the other for overtime hours worked
        List<TextField> normalHoursTextFields = new ArrayList<>();
        normalHoursTextFields.add(janField1);
        normalHoursTextFields.add(febField1);
        normalHoursTextFields.add(marField1);
        normalHoursTextFields.add(aprField1);
        normalHoursTextFields.add(mayField1);
        normalHoursTextFields.add(junField1);
        normalHoursTextFields.add(julField1);
        normalHoursTextFields.add(augField1);
        normalHoursTextFields.add(sepField1);
        normalHoursTextFields.add(octField1);
        normalHoursTextFields.add(novField1);
        normalHoursTextFields.add(decField1);
        List<TextField> overtimeHoursWorked = new ArrayList<>();
        overtimeHoursWorked.add(janField2);
        overtimeHoursWorked.add(febField2);
        overtimeHoursWorked.add(marField2);
        overtimeHoursWorked.add(aprField2);
        overtimeHoursWorked.add(mayField2);
        overtimeHoursWorked.add(junField2);
        overtimeHoursWorked.add(julField2);
        overtimeHoursWorked.add(augField2);
        overtimeHoursWorked.add(sepField2);
        overtimeHoursWorked.add(octField2);
        overtimeHoursWorked.add(novField2);
        overtimeHoursWorked.add(decField2);
        // Initialises the variable for normal hours worked
        int normalHoursWorked = 0;
        // Goes through all the normalHoursTextFields text fields and gets their text
        for (TextField field : normalHoursTextFields) {
            normalHoursWorked += Integer.parseInt(field.getText());
        }
        // Initialises the variable for overtime worked
        int overtimeWorked = 0;
        // Goes through all the overtimeHoursWorked text fields and gets their text
        for (TextField field : overtimeHoursWorked) {
            overtimeWorked += Integer.parseInt(field.getText());
        }
        // Sets the dayWorked text field, to the total number of days worked
        daysWorked.setText(String.valueOf(normalHoursWorked) + " days");
        // Sets the overtime text field, to the total number of overtime hours worked
        overtime.setText(String.valueOf(overtimeWorked) + " hours");
        // Creates a formatter for currency values
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        // Gets the texts of the basicSalary text field
        double basicSalaryPerHour = Double.parseDouble(basicSalaryTF.getText());
        // Gets the text of the hoursWorkedPerDayTF text field
        double hoursADays = Double.parseDouble(hourWorkedPerDayTF.getText());
        // Calculates the gross pay
        double grossPayment = (overtimeWorked * basicSalaryPerHour) + ((normalHoursWorked * hoursADays) * basicSalaryPerHour);
        // Sets the grossPayTF text field to the calculated gross pay
        grossPayTF.setText((String.valueOf(decimalFormat.format(grossPayment))));
        // Calculates five percent of the gross pay
        double fivePercent = (Double.parseDouble(String.valueOf(grossPayment * 0.05)));
        // Sets the fivePercentTF text field to the calculated five percent
        fivePercentTF.setText((String.valueOf(decimalFormat.format(fivePercent))));
        // Calculates the health allowance
        double healthAllowance = (grossPayment * 0.08);
        // Sets the healthAllowanceTF to the calculated health allowance
        healthAllowanceTF.setText((String.valueOf(decimalFormat.format(healthAllowance))));
        // Calculates the deductions
        double deductions = (grossPayment + fivePercent + healthAllowance + 25) * 0.20;
        // Sets the deductionsTF to the calculated deductions
        deductionsTF.setText((String.valueOf(decimalFormat.format(deductions))));
        // Calculates the net salary
        double netSalary = (grossPayment + fivePercent + healthAllowance + 25) - deductions;
        // Sets the netSalaryTF text field to the calculated net salary
        netSalaryTF.setText((String.valueOf(decimalFormat.format(netSalary))));
        // Calls the print method
        print();
    }

    // Method is called as the class is initialised
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Checks if the variables are null, if they are the method is terminated
        if (employeeAddressProperty == null || employeeAddressProperty == null || employeeDesignationProperty == null ||
                employeeGradeProperty == null || employeeJoiningDateProperty == null || employeeLoanProperty == null ||
                employeeNameProperty == null || employeePhoneNumberProperty == null || employeeRegistrationNumberProperty == null
                || employeeTravelAllowanceProperty == null || employeeHourlySalaryProperty == null) {
            return;
        }
        // Sets the JavaFXs table's columns
        employeeAddressProperty.setCellValueFactory(data -> data.getValue().employeeAddressProperty());
        employeeDesignationProperty.setCellValueFactory(data -> data.getValue().employeeDesignationProperty());
        employeeGradeProperty.setCellValueFactory(data -> data.getValue().employeeGradeProperty());
        employeeJoiningDateProperty.setCellValueFactory(data -> data.getValue().employeeJoiningDateProperty());
        employeeLoanProperty.setCellValueFactory(data -> data.getValue().employeeLoanProperty());
        employeeNameProperty.setCellValueFactory(data -> data.getValue().employeeNameProperty());
        employeePhoneNumberProperty.setCellValueFactory(data -> data.getValue().employeePhoneNumberProperty());
        employeeTravelAllowanceProperty.setCellValueFactory(data -> data.getValue().employeeTravelAllowanceProperty());
        employeeHourlySalaryProperty.setCellValueFactory(data -> data.getValue().employeeHourlySalaryProperty());
        employeeRegistrationNumberProperty.setCellValueFactory(data -> Bindings.convert(data.getValue().employeeRegistrationNumberProperty()));
        // Displays the above information to the JavaFX's table
        tableView.setItems(employeeList);
        // Sets the combo boxes options
        gradeComboBox.setItems(FXCollections.observableArrayList("I", "II", "III", "IV"));
        // When the ESC key is pressed all text fields are deselected
        parent.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                // Clears focus from all text fields
                janField1.getParent().requestFocus();
            }
        });
    }
}



    


