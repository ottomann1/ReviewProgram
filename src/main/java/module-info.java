module com.fyra.reviewprogram {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fyra.reviewprogram to javafx.fxml;
    exports com.fyra.reviewprogram;
}