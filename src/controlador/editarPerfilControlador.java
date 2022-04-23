/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
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
public class editarPerfilControlador implements Initializable {

    @FXML
    private Text usuarioNombre;
    @FXML
    private TextField usuarioCorreo;
    @FXML
    private TextField usuarioNuevaContraseña;
    @FXML
    private ImageView usuarioAvatar;
    
    public User admin;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            Navegacion base = Navegacion.getSingletonNavegacion();
            admin = base.loginUser("Mohammed", "1234");
            
            
            usuarioNombre.setText(admin.getNickName());
            usuarioCorreo.setText(admin.getEmail());
            usuarioAvatar.setImage(admin.getAvatar());
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(opcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void btnAtras(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnCambiarFoto(ActionEvent event) {
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        String str = usuarioCorreo.getText();
        try {
            admin.setEmail(str);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(editarPerfilControlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(editarPerfilControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
