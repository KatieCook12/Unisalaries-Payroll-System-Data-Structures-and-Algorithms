package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// Imports libraries
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee extends Print_Employee_Popup {

    // Creates the employee's properties
    private final IntegerProperty employeeRegistrationNumber = new SimpleIntegerProperty();
    private final StringProperty employeeTravelAllowance = new SimpleStringProperty();
    private final StringProperty employeeHourlySalary = new SimpleStringProperty();
    private final StringProperty employeeName = new SimpleStringProperty();
    private final StringProperty employeeAddress = new SimpleStringProperty();
    private final StringProperty employeePhoneNumber = new SimpleStringProperty();
    private final StringProperty employeeJoiningDate = new SimpleStringProperty();
    private final StringProperty employeeDesignation = new SimpleStringProperty();
    private StringProperty employeeGrade = new SimpleStringProperty();
    private StringProperty employeeLoan = new SimpleStringProperty();

    // Keeps track of the employee's registration number, allowing for access and to be changed in a safe way
    public final IntegerProperty employeeRegistrationNumberProperty() {
        return this.employeeRegistrationNumber;
    }

    // Gets the employee's registration number from the property defined above
    public final int getEmployeeRegistrationNumberProperty() {
        return this.employeeRegistrationNumberProperty().get();
    }

    // Resets the employee's registration number to a new value, converts the number to an integer
    public final void setEmployeeRegistrationNumber(final java.lang.String employeeRegistrationNumber) {
        this.employeeRegistrationNumberProperty().set(Integer.parseInt(employeeRegistrationNumber));
    }

    // Keeps track of the employee's name, allowing for access and to be changed in a safe way
    public final StringProperty employeeNameProperty() {
        return this.employeeName;
    }

    // Gets the employee's name from the property defined above
    public final java.lang.String getEmployeeName() {
        return this.employeeNameProperty().get();
    }

    // Resets the employee's name to a new value
    public final void setEmployeeName(final java.lang.String name) {
        this.employeeNameProperty().set(name);
    }

    // Keeps track of the employee's address, allowing for access and to be changed in a safe way
    public final StringProperty employeeAddressProperty() {
        return this.employeeAddress;
    }

    // Gets the employee's address from the property defined above
    public final java.lang.String getEmployeeAddress() {
        return this.employeeAddressProperty().get();
    }

    // Resets the employee's address to a new value
    public final void setEmployeeAddress(final java.lang.String employeeAddress) {
        this.employeeAddressProperty().set(employeeAddress);
    }

    // Keeps track of the employee's phone number, allowing for access and to be changed in a safe way
    public final StringProperty employeePhoneNumberProperty() {
        return this.employeePhoneNumber;
    }

    // Gets the employee's phone number from the property defined above
    public final java.lang.String getEmployeePhoneNumber() {
        return this.employeePhoneNumberProperty().get();
    }

    // Resets the employee's phone number to a new value
    public final void setEmployeePhoneNumber(final java.lang.String employeePhoneNumber) {
        this.employeePhoneNumberProperty().set(employeePhoneNumber);
    }

    // Keeps track of the employee's joining date, allowing for access and to be changed in a safe way
    public final StringProperty employeeJoiningDateProperty() {
        return this.employeeJoiningDate;
    }

    // Gets the employee's joining date from the property defined above
    public final java.lang.String getEmployeeJoiningDate() {
        return this.employeeJoiningDateProperty().get();
    }

    // Resets the employee's joining date to a new value
    public final void setEmployeeJoiningDate(final java.lang.String employeeJoiningDate) {
        this.employeeJoiningDateProperty().set(employeeJoiningDate);
    }

    // Keeps track of the employee's designation, allowing for access and to be changed in a safe way
    public final StringProperty employeeDesignationProperty() {
        return this.employeeDesignation;
    }

    // Gets the employee's designation from the property defined above
    public final java.lang.String getEmployeeDesignation() {
        return this.employeeDesignationProperty().get();
    }

    // Resets the employee's designation to a new value
    public final void setEmployeeDesignation(final java.lang.String employeeDesignation) {
        this.employeeDesignationProperty().set(employeeDesignation);
    }

    // Keeps track of the employee's grade, allowing for access and to be changed in a safe way
    public final StringProperty employeeGradeProperty() {
        return this.employeeGrade;
    }

    // Gets the employee's grade from the property defined above
    public final java.lang.String getEmployeeGrade() {
        return this.employeeGradeProperty().get();
    }

    // Resets the employee's grade to a new value
    public final void setEmployeeGrade(final java.lang.String employeeGrade) {
        this.employeeGradeProperty().set(employeeGrade);
    }

    // Keeps track of the employee's loan, allowing for access and to be changed in a safe way
    public final StringProperty employeeLoanProperty() {
        return this.employeeLoan;
    }

    // Gets the employee's loan from the property defined above
    public final java.lang.String getEmployeeLoan() {
        return this.employeeLoanProperty().get();
    }

    // Resets the employee's loan to a new value
    public final void setEmployeeLoan(final java.lang.String employeeLoan) {
        this.employeeLoanProperty().set(employeeLoan);
    }

    // Keeps track of the employee's travel allowance, allowing for access and to be changed in a safe way
    public final StringProperty employeeTravelAllowanceProperty() {
        return this.employeeTravelAllowance;
    }

    // Gets the employee's travel allowance from the property defined above
    public final java.lang.String getEmployeeTravelAllowance() {
        return this.employeeTravelAllowanceProperty().get();
    }

    // Resets the employee's travel allowance to a new value
    public final void setEmployeeTravelAllowance(final java.lang.String employeeTravelAllowance) {
        this.employeeTravelAllowanceProperty().set(employeeTravelAllowance);
    }

    // Keeps track of the employee's hourly salary, allowing for access and to be changed in a safe way
    public final StringProperty employeeHourlySalaryProperty() {
        return this.employeeHourlySalary;
    }

    // Gets the employee's hourly salary from the property defined above
    public final java.lang.String getEmployeeHourlySalary() {
        return this.employeeHourlySalaryProperty().get();
    }

    // Resets the employee's hourly salary to a new value
    public final void setEmployeeHourlySalary(final java.lang.String employeeHourlySalary) {
        this.employeeHourlySalaryProperty().set(employeeHourlySalary);
    }

    // Compares two employees' registration number
    private int compareTo(Employee other) {
        // Compare employees based on registration number
        return Integer.compare(employeeRegistrationNumber.get(), other.employeeRegistrationNumber.get());
    }

    // Returns the employee's name and registration number, overriding the toString() method
    @Override
    public String toString() {
        return employeeName + " (" + employeeRegistrationNumber + ")";
    }
}
