module Practica03 {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens com.arteaga.viewsfxml;
    opens com.arteaga.controller;
    opens com.arteaga.views;

}