/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Answer;
import model.Navegacion;
import model.Problem;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class preguntasControlador implements Initializable {

    @FXML
    private Text mensaje_usuario;
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
            Logger.getLogger(preguntasControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
