/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.User;

/**
 * FXML Controller class
 *
 * @author luism
 */
public class ElegirPreguntaContolador implements Initializable {

    @FXML
    private ImageView botonPerfil;

    private User usuario;
    private static Navegacion base;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image foto = new Image("/resources/engra.png", 160, 160, false, true);
        botonPerfil.setImage(foto);
        base = Aplicacion.base;

    }

    public int getRandom() {
        return (int) ((Math.random() * 17) + 1);
    }

    public void getUser(User usuarios) {
        usuario = usuarios;
    }

    @FXML
    private void irpregunta1(ActionEvent event) {
        irALaPregunta(event, 0);
    }

    @FXML
    private void irpregunta2(ActionEvent event) {
        irALaPregunta(event, 1);
    }

    @FXML
    private void irpregunta3(ActionEvent event) {
        irALaPregunta(event, 2);
    }

    @FXML
    private void irpregunta4(ActionEvent event) {
        irALaPregunta(event, 3);
    }

    @FXML
    private void irpregunta5(ActionEvent event) {
        irALaPregunta(event, 4);
    }

    @FXML
    private void irpregunta6(ActionEvent event) {
        irALaPregunta(event, 5);
    }

    @FXML
    private void irpregunta7(ActionEvent event) {
        irALaPregunta(event, 6);
    }

    @FXML
    private void irpregunta8(ActionEvent event) {
        irALaPregunta(event, 7);
    }

    @FXML
    private void irpregunta10(ActionEvent event) {
        irALaPregunta(event, 9);
    }

    @FXML
    private void irpregunta11(ActionEvent event) {
        irALaPregunta(event, 10);
    }

    @FXML
    private void irpregunta12(ActionEvent event) {
        irALaPregunta(event, 11);
    }

    @FXML
    private void irpregunta13(ActionEvent event) {
        irALaPregunta(event, 12);
    }

    @FXML
    private void irpregunta14(ActionEvent event) {
        irALaPregunta(event, 13);
    }

    @FXML
    private void irpregunta15(ActionEvent event) {
        irALaPregunta(event, 14);
    }

    @FXML
    private void irpregunta16(ActionEvent event) {
        irALaPregunta(event, 15);
    }

    @FXML
    private void irpregunta17(ActionEvent event) {
        irALaPregunta(event, 16);
    }

    @FXML
    private void irpregunta18(ActionEvent event) {
        irALaPregunta(event, 17);
    }

    @FXML
    private void irpregunta9(ActionEvent event) {
        irALaPregunta(event, 8);
    }

    @FXML
    private void irPreguntaAleatoria(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();

            PreguntasController controlador = fxmlLoader.getController();

            controlador.getUser(usuario);
            controlador.displayName(getRandom());
            controlador.showPregunta();

            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void irAPerfil(MouseEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            opcionesControlador controlador = fxmlLoader.getController();
            controlador.getUserr(usuario);
            controlador.setUserr();

            Scene scene = new Scene(root1);
            scene.setFill(Color.TRANSPARENT);
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void irALaPregunta(ActionEvent event, int i) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();

            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(i);
            controlador.showPregunta();
            controlador.getUser(usuario);

            Stage stage = new Stage();

            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
