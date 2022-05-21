/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
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

    private String usuarioCorreo;
    private LocalDate fecha;
    private String nuevaContra;

    public User usuario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Navegacion base = Aplicacion.base;
        
    }

    public void displayName(String username, LocalDate fechas, String password) {
        usuarioCorreo = username;
        fecha = fechas;
        nuevaContra = password;
    }
    
    public void getUser(User usuarios){
        usuario = usuarios;
    }

    @FXML
    private void btnSi(ActionEvent event) throws NavegacionDAOException {
        usuario.setEmail(usuarioCorreo);
        usuario.setBirthdate(fecha);
        usuario.setPassword(nuevaContra);
        Node node = (Node) event.getSource();
        node.getScene().getWindow().hide();
    }

    @FXML
    private void btnNo(ActionEvent event) {
        Node node = (Node) event.getSource();
        node.getScene().getWindow().hide();
    }

}
