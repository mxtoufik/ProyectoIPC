/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class ElegirPreguntaContolador implements Initializable {

    @FXML
    private Button pregunta1;
    @FXML
    private Button pregunta2;
    @FXML
    private Button pregunta3;
    @FXML
    private Button pregunta4;
    @FXML
    private Button botonPreguntaAleatoria;
    @FXML
    private ImageView botonPerfil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image foto = new Image("/resources/avatars/engra.png", 160, 160, false, true);
        botonPerfil.setImage(foto);
        
    }

    @FXML
    private void irAPreguntaAleatoria(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
    }


    @FXML
    private void irpregunta1(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void irpregunta2(ActionEvent event) {
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void irpregunta3(ActionEvent event) {
        
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            //stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void irpregunta4(ActionEvent event) {
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
    }

    @FXML
    private void IrAPerfil(MouseEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
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


}
