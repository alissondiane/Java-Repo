package com.arteaga.views;

import com.arteaga.bean.Cliente;
import com.arteaga.dao.ClienteDao;
import com.arteaga.dao.impl.DaoFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ClienteView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableView<Cliente> tableView = new TableView<Cliente>();

        Parent root = FXMLLoader.load(getClass().getResource("/com/arteaga/viewsfxml/Clientefxml.fxml"));
        primaryStage.setTitle("Mantenimiento Clientes");
        primaryStage.setScene(new Scene(root, 780, 370));
        primaryStage.show();

    }
}
