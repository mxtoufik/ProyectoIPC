/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import aplicacion.Aplicacion;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.Session;
import model.User;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class estadisticasControlador implements Initializable {

    @FXML
    private DatePicker fechaInicio;
    @FXML
    private DatePicker fechaFinal;
    @FXML
    private ProgressBar aciertos;
    @FXML
    private ProgressBar fallos;
    @FXML
    private Text aciertosPer;
    @FXML
    private Text fallosPer;
    
    private User usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Navegacion baseD = Aplicacion.base;
            Session a = new Session(LocalDateTime.now(), 0, 0);
            fechaInicio.setShowWeekNumbers(false);
            fechaFinal.setDisable(true);
            fechaInicio.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    //fechaFinal.setDisable(true);
                    fechaFinal.setValue(null);
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) > 0);
                    if(fechaInicio.getValue() != null) {
                        fechaFinal.setDisable(false);
                    }
                }
            });
            
            fechaInicio.getValue();
            
            
            fechaFinal.setShowWeekNumbers(false);
            fechaFinal.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate hoy = LocalDate.now();

                    setDisable(empty || (date.compareTo(fechaInicio.getValue()) < 0) || (date.compareTo(hoy) > 0));
                }
            });
    }    
    
    public void getUser(User usuarios){
        usuario = usuarios;
    }
    

    @FXML
    private void btnAtras(ActionEvent event) {
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
            Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
