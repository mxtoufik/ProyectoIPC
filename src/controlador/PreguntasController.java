/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import DBAccess.NavegacionDAOException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Answer;
import model.Navegacion;
import model.Problem;

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
    @FXML
    private AnchorPane pantalla;
    @FXML
    private Text pregunta;
    @FXML
    private CheckBox res3;
    @FXML
    private CheckBox res2;
    @FXML
    private CheckBox res1;
    @FXML
    private CheckBox res4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            Navegacion base = Navegacion.getSingletonNavegacion();
            
            List<Problem> lista = base.getProblems();
            Problem a = lista.get(0);
            String lapregunta = a.getText();
            pregunta.setText(lapregunta);
            
            List<Answer> lista2 = a.getAnswers();
            Answer uno = lista2.get(0);
            res1.setText(uno.getText());
            
            Answer uno1 = lista2.get(1);
            res2.setText(uno1.getText());
            
            Answer uno2 = lista2.get(2);
            res3.setText(uno2.getText());
            
            Answer uno3 = lista2.get(3);
            res4.setText(uno3.getText());
            
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(PreguntasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    

    public void closeWindows() throws IOException{
        
       FXMLLoader loader = new FXMLLoader (getClass().getResource("/vista/ElegirPregunta.fxml"));
       Parent root = loader.load();
       //ElegirPreguntaControlador controlador = loader.getController();
       
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
         try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/ElegirPregunta.fxml"));
            
            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
         
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();
            Node node5 = (Node) event.getSource();
            System.out.println("1");
            node5.getScene().getWindow().hide();
            //stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

 
    
 
    
    
}
