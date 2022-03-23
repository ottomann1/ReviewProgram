module com.fyra.reviewprogram {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires transitive org.hibernate.orm.core;
    requires javafx.base;
    requires java.naming;
    requires java.desktop;
    requires transitive javafx.graphics;
    requires java.base;


    opens com.fyra.reviewprogram to javafx.fxml;
    exports com.fyra.reviewprogram;
    opens entity to javafx.fxml, org.hibernate.orm.core;
    exports entity;
    opens com.fyra.reviewprogram.database to javafx.fxml;
    exports com.fyra.reviewprogram.database;
}