module com.avirup.determinantsolver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.avirup.determinantsolver to javafx.fxml;
    exports com.avirup.determinantsolver;
}