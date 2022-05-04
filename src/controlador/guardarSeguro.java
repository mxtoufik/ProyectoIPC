/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.User;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class guardarSeguro implements Initializable {

    @FXML
    private String usuarioCorreo;
    private LocalDate fecha;
    private String nuevaContra;

    public User admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            Navegacion base = Navegacion.getSingletonNavegacion();
            admin = base.loginUser("Mohammed", "123");

        } catch (NavegacionDAOException ex) {
            Logger.getLogger(opcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayName(String username, LocalDate fechas, String password) {
        usuarioCorreo = username;
        fecha = fechas;
        nuevaContra = password;
    }

    @FXML
    private void btnSi(ActionEvent event) throws NavegacionDAOException {
        admin.setEmail(usuarioCorreo);
        admin.setBirthdate(fecha);
        admin.setPassword(nuevaContra);
        Node node = (Node) event.getSource();
        node.getScene().getWindow().hide();
    }

    @FXML
    private void btnNo(ActionEvent event) {
        Node node = (Node) event.getSource();
        node.getScene().getWindow().hide();
    }

}
