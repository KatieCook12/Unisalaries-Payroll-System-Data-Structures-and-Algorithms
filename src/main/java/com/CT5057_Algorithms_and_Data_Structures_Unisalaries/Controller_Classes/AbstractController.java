package com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;

// An abstract class that the controller classes (such as the pop-up windows) can extend, allows the classes to access an instance of the "Main" class
public abstract class AbstractController {

    protected Main main;

    private void setMainApp(Main main) {
        this.main = main;
    }

}
