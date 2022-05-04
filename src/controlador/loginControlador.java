
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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import static model.User.checkNickName;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class loginControlador implements Initializable {

    @FXML
    private TextField texto_usuario;
    @FXML
    private Text mensaje_usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Navegacion base = Navegacion.getSingletonNavegacion();

        } catch (NavegacionDAOException ex) {
            Logger.getLogger(loginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void pulsadoIniciar(ActionEvent event) {
        String nombre = texto_usuario.getText();
        Boolean existe = checkNickName(nombre);
        if(existe){
            try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
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
    }

}
