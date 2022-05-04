/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.awt.event.WindowEvent;
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
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JFrame;
import model.Navegacion;
import model.User;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class opcionesControlador implements Initializable {

    @FXML
    private Text nombreUsuario;
    @FXML
    private ImageView usuarioAvatar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            /*String nombre = "Mohammed";
            String email = "tangertoufik@gmail.com";
            String contraseña = "1234";
            LocalDate birthdate = LocalDate.now().minusYears(18);
            */
            Navegacion base = Navegacion.getSingletonNavegacion();
            User admin = base.loginUser("Mohammed", "123");
            
            nombreUsuario.setText(admin.getNickName());
            usuarioAvatar.setImage(admin.getAvatar());
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(opcionesControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnModificar(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Cambios.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
      
            stage.setTitle("Editar Perfil del Usuario");
            stage.initModality(Modality.APPLICATION_MODAL);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnEstadisticas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/estadisticas.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setTitle("Ver estadísticas del Usuario");
            stage.initModality(Modality.APPLICATION_MODAL);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }

    @FXML
    private void btnCerrarSesion(ActionEvent event) {
        
    }

    @FXML
    private void btnCerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
