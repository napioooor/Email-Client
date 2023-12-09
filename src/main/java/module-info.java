module com.kurs.emailclient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;
    //requires java.activation;
    requires java.mail;


    opens com.kurs.emailclient to javafx.fxml;
    exports com.kurs.emailclient;
    exports com.kurs.emailclient.controller;
    opens com.kurs.emailclient.controller to javafx.fxml;
    exports com.kurs.emailclient.model;
    exports com.kurs.emailclient.view;
}