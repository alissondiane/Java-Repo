package com.arteaga.controller;

import com.arteaga.bean.Cliente;
import com.arteaga.dao.ClienteDao;
import com.arteaga.dao.impl.DaoFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    @FXML
    ComboBox<String> busquedaCombo;
    @FXML
    TableView tabla;
    @FXML
    TableColumn colCodigo;
    @FXML
    TableColumn colNombre;
    @FXML
    TableColumn colApellido;
    @FXML
    TableColumn colCorreo;
    @FXML
    TableColumn colTelefono;

    @FXML
    private TextField txtcod;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtape;

    @FXML
    private TextField txtcorr;

    @FXML
    private TextField txttele;

    @FXML
    private TextField txtcampo;

    @FXML
    private TextField txtcodigoEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private Button btnGrabar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnListar;

    private String tipoSeleccionado;

    ObservableList listaClientes= FXCollections.observableArrayList();

    @FXML
    private void btnListar_click(ActionEvent event){

        /*Limpiar la tabla*/

        listaClientes.clear();

        List<Cliente> lista = new ArrayList<>();

        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao = factory.getClienteDao(1);
        lista = dao.findAll();
        System.out.println("Listado de clientes:");
        for(Cliente p: lista){
            /*System.out.println(p.getNom());*/
            listaClientes.add(new ClienteTabla(p.getCodigo(),p.getNombre(),p.getApellido(),p.getCorreo(),p.getTelefono()));
        }

        // se asocia a cada columna la propierdad que se desea del objeto indicado en el PropertyValueFactory

        colCodigo.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<ClienteTabla, Integer>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<ClienteTabla,Double>("telefono"));

        // se asocia la lista de datos a la tabla
        tabla.setItems(listaClientes);
    }

    @FXML
    private void btnNuevo_click(ActionEvent event){

        /*Limpiar la tabla*/
        listaClientes.clear();

        List<Cliente> listado = new ArrayList<>();
        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);

        //Obtenemos tipo seleccionado:

        listado = dao.findByTipo(txtcampo.getText(),tipoSeleccionado);

        System.out.println("Listado de clientes segun filtro elegido:");

        for(Cliente p: listado){
            /*System.out.println(p.getNom());*/
            listaClientes.add(new ClienteTabla(p.getCodigo(),p.getNombre(),p.getApellido(),p.getCorreo(),p.getTelefono()));
        }

        // se asocia a cada columna la propierdad que se desea del objeto indicado en el PropertyValueFactory

        colCodigo.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<ClienteTabla, String>("apellido"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<ClienteTabla, Integer>("correo"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<ClienteTabla,Double>("telefono"));

        // se asocia la lista de datos a la tabla
        tabla.setItems(listaClientes);

        if(listado.size() == 0){
            txtcod.clear();
            txtnom.clear();
            txtape.clear();
            txtcorr.clear();
            txttele.clear();
        }

    }

    @FXML
    private void btnGrabar_click(ActionEvent event){
        boolean respuesta;

        Cliente p=new Cliente();
        p.setCodigo(txtcod.getText());
        p.setNombre(txtnom.getText());
        p.setApellido(txtape.getText());
        p.setCorreo(txtcorr.getText());
        p.setTelefono(txttele.getText());
        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        respuesta = dao.create(p);

        if(respuesta){
            mostrarAlertExito("Se creo el cliente exitosamente");
        }else{
            mostrarAlertError();
        }
    }
    @FXML
    private void btnModificar_click(ActionEvent event){

        boolean respuesta;

        Cliente p=new Cliente();
        p.setCodigo(txtcod.getText());
        p.setNombre(txtnom.getText());
        p.setApellido(txtape.getText());
        p.setCorreo(txtcorr.getText());
        p.setTelefono(txttele.getText());
        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao=factory.getClienteDao(1);
        respuesta = dao.update(p);
        if(respuesta){
            mostrarAlertExito("Se actualizo correctamente");
        }else{
            mostrarAlertError();
        }
    }
    @FXML
    private void btnEliminar_click(ActionEvent event){
        DaoFactory factory = DaoFactory.getInstance();
        ClienteDao dao = factory.getClienteDao(1);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro que deseas eliminar?");
        Optional<ButtonType> action = alert.showAndWait();

        // Si hemos pulsado en aceptar
        if (action.get() == ButtonType.OK) {
            //Procedemos a eliminar
            dao.delete(txtcodigoEliminar.getText());
            mostrarAlertExito("Se eliminó el cliente satisfactoriamentes!");
        }
    }

    @FXML
    private void mostrarAlertExito(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void mostrarAlertError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Ocurrio un error en la aplicación");
        alert.showAndWait();
    }

    @FXML
    private void mostrarAlertWarning(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setTitle("Warning");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Se inicializa el controller");

        tabla.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {

            ClienteTabla selectedItem = (ClienteTabla) tabla.getSelectionModel().getSelectedItem();

            txtcod.setText(selectedItem.getCodigo());
            txtnom.setText(selectedItem.getNombre());
            txtape.setText(selectedItem.getApellido());
            txtcorr.setText(selectedItem.getCorreo());
            txttele.setText(selectedItem.getTelefono());

        });

        busquedaCombo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                tipoSeleccionado = selected.getValue();
            }
        });

    }
}
