module ksaito.study.murata {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens ksaito.study2023.murata to javafx.fxml;
    exports ksaito.study2023.murata;
    opens ksaito.study2023.murata.controller to javafx.fxml;
    opens ksaito.study2023.murata.domain.model to javafx.base;
}