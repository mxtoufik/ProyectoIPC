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
import java.util.List;
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
        
        aciertosPer.setVisible(false);
        fallosPer.setVisible(false);
        fechaInicio.setShowWeekNumbers(false);
        fechaFinal.setDisable(true);
        fechaInicio.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {

                fechaFinal.setValue(null);
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                List<Session> laLista = usuario.getSessions();
                Session sesion = laLista.get(0);
                sesion.getLocalDate();

                setDisable(empty || date.compareTo(today) > 0 || (date.compareTo(sesion.getLocalDate()) < 0));
                if (fechaInicio.getValue() != null) {
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

    public void getUser(User usuarios) {
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
    

    @FXML
    private void buscar(ActionEvent event) {
        
        aciertosPer.setVisible(true);
        fallosPer.setVisible(true);

        List<Session> laLista = usuario.getSessions();
        int a = 0;
        int f = 0;
        for (int i = 0; i < laLista.size(); i++) {
            Session sesion = laLista.get(i);
            int fecha = (fechaInicio.getValue().compareTo(fechaFinal.getValue()) * -1);
            System.out.println("La diferencia " + fecha);
            int b = fecha * -1;
            for (int j = fecha; j >= 0; j--) {
                
                System.out.println("Con los días menos " + fechaInicio.getValue().minusDays(b));
                System.out.println("La sesión " + sesion.getLocalDate());
                if (sesion.getLocalDate().equals(fechaInicio.getValue().minusDays(b))) {
                    a = sesion.getHits() + a;
                    f = sesion.getFaults() + f;
                }
                b++;
            }
            aciertosPer.setText(Integer.toString(a));
            fallosPer.setText(Integer.toString(f));
            
            aciertos.setProgress(a / 10);
            fallos.setProgress(0.3);
        }

    }
}
