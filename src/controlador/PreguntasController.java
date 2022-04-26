/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.ElegirPreguntaControlador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class PreguntasController implements Initializable {

    
   
    private Stage stage;
    @FXML
    private Text mensaje_usuario;
    @FXML
    private Button botonSalir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public void closeWindows() throws IOException{
        
       FXMLLoader loader = new FXMLLoader (getClass().getResource("/aplicacion/ElegirPregunta.fxml"));
       Parent root = loader.load();
       ElegirPreguntaControlador controlador = loader.getController();
       
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       
       stage.setScene(scene);
       stage.show();
       //stage.setOnCloseRequest(e -> controlador.closeWindows());
       
       Stage myStage = (Stage) this.botonSalir.getScene().getWindow();
       myStage.close();
    
    
    }

    @FXML
    private void SaliendoPreguntas(ActionEvent event) {
    }
            
            
    
    
}
