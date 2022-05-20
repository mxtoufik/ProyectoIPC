/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.awt.Color;
import static java.awt.Color.BLACK;
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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import model.Answer;
import model.Navegacion;
import model.Problem;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private AnchorPane pantalla;
    @FXML
    private Text pregunta;
    @FXML
    private RadioButton res3;
    @FXML
    private RadioButton res2;
    @FXML
    private RadioButton res1;
    @FXML
    private RadioButton res4;

    private int elNum;

    public static int lares;

    private Navegacion base;
    @FXML
    private Text borrarbtn;
    @FXML
    private Button btnConfirm;

    public static Boolean unoRes;
    public static Boolean unoRes1;
    public static Boolean unoRes2;
    public static Boolean unoRes3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            System.out.print(elNum);
            Navegacion base = Navegacion.getSingletonNavegacion();

        } catch (NavegacionDAOException ex) {
            Logger.getLogger(PreguntasController.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnConfirm.setDisable(true);
    }

    public void displayName(int num) {
        elNum = num;
    }

    public void showPregunta() {
        try {
            Navegacion base = Navegacion.getSingletonNavegacion();
            List<Problem> lista = base.getProblems();
            Problem a = lista.get(elNum);
            String lapregunta = a.getText();
            pregunta.setText(lapregunta);

            List<Answer> lista2 = a.getAnswers();
            Answer uno = lista2.get(0);
            unoRes = uno.getValidity();
            res1.setText(uno.getText());

            Answer uno1 = lista2.get(1);
            unoRes1 = uno1.getValidity();
            res2.setText(uno1.getText());

            Answer uno2 = lista2.get(2);
            unoRes2 = uno2.getValidity();
            res3.setText(uno2.getText());

            Answer uno3 = lista2.get(3);
            unoRes3 = uno3.getValidity();
            res4.setText(uno3.getText());
            
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(PreguntasController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void SaliendoPreguntas(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/ElegirPreguntaReisazable.fxml"));

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
    private void clickres3(ActionEvent event) {
        res1.setDisable(true);
        res2.setDisable(true);
        res3.setDisable(true);
        res4.setDisable(true);
        btnConfirm.setDisable(false);

        lares = 3;
    }

    @FXML
    private void clickres2(ActionEvent event) {
        res1.setDisable(true);
        res2.setDisable(true);
        res3.setDisable(true);
        res4.setDisable(true);
        btnConfirm.setDisable(false);

        lares = 2;
    }

    @FXML
    private void clickres1(ActionEvent event) {
        res1.setDisable(true);
        res2.setDisable(true);
        res3.setDisable(true);
        res4.setDisable(true);
        btnConfirm.setDisable(false);

        lares = 1;
    }

    @FXML
    private void clickres4(ActionEvent event) {
        res1.setDisable(true);
        res2.setDisable(true);
        res3.setDisable(true);
        res4.setDisable(true);
        btnConfirm.setDisable(false);

        lares = 4;
    }

    @FXML
    private void borraSele(MouseEvent event) {
        System.out.println(lares);
        switch (lares) {
            case 1:
                res1.setSelected(false);
                break;

            case 2:
                res2.setSelected(false);
                break;

            case 3:
                res3.setSelected(false);
                break;

            case 4:
                res4.setSelected(false);
                break;
        }
        res1.setDisable(false);
        res2.setDisable(false);
        res3.setDisable(false);
        res4.setDisable(false);
        btnConfirm.setDisable(true);

    }

    @FXML
    private void confirmar(ActionEvent event) {

        if (unoRes) {
            res1.setStyle("-fx-text-fill: green;");
             res2.setStyle("-fx-text-fill: red;");
              res3.setStyle("-fx-text-fill: red;");
               res4.setStyle("-fx-text-fill: red;");
        } else {
            res1.setStyle("-fx-text-fill: red;");
            if (unoRes1) {
                res2.setStyle("-fx-text-fill: green;");

            } else {
                res2.setStyle("-fx-text-fill: red;");
                if (unoRes2) {
                    res3.setStyle("-fx-text-fill: green;");

                }
                else{
                    res3.setStyle("-fx-text-fill: red;");
                }
                if (unoRes3) {
                    res4.setStyle("-fx-text-fill: green;");

                }
                else{
                    res4.setStyle("-fx-text-fill: red;");
                }
            }
        }
        btnConfirm.setDisable(true);
        borrarbtn.setDisable(true);

    }

}
