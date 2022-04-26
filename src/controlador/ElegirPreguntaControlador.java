/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class ElegirPreguntaControlador implements Initializable {

    
    
    private Stage stage;
    @FXML
    private Button botonPreguntaAleatoria;
    @FXML
    private Button botonPerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irAPreguntaAleatoria(ActionEvent event)throws IOException {
        
       FXMLLoader loader = new FXMLLoader (getClass().getResource("/aplicacion/Preguntas.fxml"));
       Parent root = loader.load();
       PreguntasController controlador = loader.getController();
       
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       
       stage.setScene(scene);
       stage.show();
       
       //stage.setOnCloseRequest(e -> controlador.closeWindows());
       
       
       
       Stage myStage = (Stage) this.botonPreguntaAleatoria.getScene().getWindow();
       myStage.close();
        
        
        
    }

    @FXML
    private void irAPerfil(ActionEvent event) {
        
        
        
        
    }

    public void setStage(Stage primaryStage) {
       stage = primaryStage;
    }
    
   
   }
