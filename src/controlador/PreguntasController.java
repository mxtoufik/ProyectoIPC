/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Session;
import model.User;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class PreguntasController implements Initializable {

    @FXML
    private Button botonSalir;
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

    private User usuario;
    private Session sesion;
    private static int fallos;
    private static int aciertos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        base = Aplicacion.base;

        btnConfirm.setDisable(true);
    }
    
    public static void setCero(){
        fallos = 0;
        aciertos = 0;
    }
    
    public static int getFallos(){
        return fallos;
    }
    
    public static int getAciertos(){
        return aciertos;
    }

    public void displayName(int num) {
        elNum = num;
    }

    public void getUser(User usuarios) {
        usuario = usuarios;
    }

    public void showPregunta() {

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

    }

    @FXML
    private void SaliendoPreguntas(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/ElegirPregunta.fxml"));

            Parent root6 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();

            ElegirPreguntaContolador controlador = fxmlLoader.getController();
            controlador.getUser(usuario);
            stage.getIcons().add(new Image("resources/logo.ico"));
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
        switch (lares) {
            case 1:
                if (unoRes) {
                    aciertos = aciertos + 1;
                } else {
                    fallos = fallos + 1;
                }
                break;

            case 2:
                if (unoRes1) {
                    aciertos = aciertos + 1;
                } else {
                    fallos = fallos + 1;
                }
                break;

            case 3:
                if (unoRes2) {
                    aciertos = aciertos + 1;
                } else {
                    fallos = fallos + 1;
                }
                break;

            case 4:
                if (unoRes3) {
                    aciertos = aciertos + 1;
                } else {
                    fallos = fallos + 1;
                }
                break;
        }

        if (unoRes) {
            res1.setStyle("-fx-text-fill: green;");
            res2.setStyle("-fx-text-fill: red;");
            res3.setStyle("-fx-text-fill: red;");
            res4.setStyle("-fx-text-fill: red;");
        } else {
            res1.setStyle("-fx-text-fill: red;");
            if (unoRes1) {
                res2.setStyle("-fx-text-fill: green;");
                res3.setStyle("-fx-text-fill: red;");
                res4.setStyle("-fx-text-fill: red;");
            } else {
                res2.setStyle("-fx-text-fill: red;");
                if (unoRes2) {
                    res3.setStyle("-fx-text-fill: green;");
                    res4.setStyle("-fx-text-fill: red;");

                } else {
                    res3.setStyle("-fx-text-fill: red;");
                }
                if (unoRes3) {
                    res4.setStyle("-fx-text-fill: green;");

                } else {
                    res4.setStyle("-fx-text-fill: red;");
                }
            }
        }
        btnConfirm.setDisable(true);
        borrarbtn.setDisable(true);
        System.out.println(aciertos + " " + fallos);
    }

    @FXML
    private void abrirMapa(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/mapa.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1);

            Stage stage = new Stage();
            stage.getIcons().add(new Image("resources/logo.ico"));
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
