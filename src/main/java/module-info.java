module com.example.table {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes to javafx.fxml;
    exports com.CT5057_Algorithms_and_Data_Structures_Unisalaries.Controller_Classes;
}