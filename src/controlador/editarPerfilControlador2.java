/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.User;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class editarPerfilControlador2 implements Initializable {

    @FXML
    private ImageView usuarioAvatar;
    @FXML
    private Text usuarioNombre;
    @FXML
    private TextField usuarioCorreo;
    @FXML
    private Text correoIncorrecto;
    @FXML
    private PasswordField usuarioContraseña;
    @FXML
    private Text contrasenaIncorrecta;
    @FXML
    private PasswordField usuarioNuevaContraseña;
    @FXML
    private Text repetirContrasenaIncorrecta;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Text repetirContrasenaIncorrecta1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            datePicker.setShowWeekNumbers(false);
            datePicker.setDayCellFactory(picker -> new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();

                    setDisable(empty || date.compareTo(today) > 0);
                }
            });
            Navegacion base = Navegacion.getSingletonNavegacion();
            User admin = base.loginUser("Mohammed", "123");

            usuarioNombre.setText(admin.getNickName());
            usuarioCorreo.setText(admin.getEmail());
            usuarioAvatar.setImage(admin.getAvatar());
            usuarioContraseña.setText(admin.getPassword());
            usuarioNuevaContraseña.setText(admin.getPassword());
            datePicker.setValue(admin.getBirthdate());
        } catch (NavegacionDAOException ex) {

        }
    }

    @FXML
    private void btnAtras(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
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
    private void btnCambiarFoto(ActionEvent event) {

    }

    public String getCorreo() {
        String elCorreo = usuarioCorreo.getText();

        return elCorreo;
    }

    @FXML
    private void btnGuardar(ActionEvent event) throws InterruptedException {

        correoIncorrecto.setVisible(false);
        contrasenaIncorrecta.setVisible(false);
        repetirContrasenaIncorrecta.setVisible(false);

        String passwordRepetida = usuarioNuevaContraseña.getText();
        String password = usuarioContraseña.getText();
        String regex = "^[A-Za-z0-9+_.-]+@+[A-Za-z0-9+_.-]+.+[A-Za-z0-9+_.-]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(usuarioCorreo.getText());
        Boolean coincide = matcher.matches();
        if (coincide) {
            String username = usuarioCorreo.getText();
            LocalDate fecha = datePicker.getValue();

           String regex2 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
           Pattern pattern2 = Pattern.compile(regex2);
           Matcher matcher2 = pattern.matcher(password);
           Boolean coincide2 = matcher2.matches();
            
            if ((password.equals(passwordRepetida) && coincide2)) {

                try {
                    //admin.setEmail(str);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Seguro.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();

                    guardarSeguro controlador = fxmlLoader.getController();
                    controlador.displayName(username, fecha, password);

                    Scene scene = new Scene(root1);
                    scene.setFill(Color.TRANSPARENT);
                    Stage stage = new Stage();
                    stage.setTitle("SAILAPP");
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.showAndWait();

                    FXMLLoader elLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
                    Parent root = (Parent) elLoader.load();
                    Scene scene2 = new Scene(root);
                    scene2.setFill(Color.TRANSPARENT);
                    Stage stage2 = new Stage();
                    stage2.setTitle("SAILAPP");
                    stage2.initModality(Modality.APPLICATION_MODAL);
                    stage2.setScene(scene2);
                    stage2.setResizable(false);
                    stage2.initStyle(StageStyle.TRANSPARENT);
                    stage2.show();
                    Node node = (Node) event.getSource();
                    node.getScene().getWindow().hide();
                } catch (IOException ex) {

                }

            } else {
                repetirContrasenaIncorrecta.setVisible(true);
                repetirContrasenaIncorrecta.setText("Las contraseñas introducidas no coinciden");
            }
        } else {
            correoIncorrecto.setVisible(true);

            correoIncorrecto.setText("El correo introducido es incorrecto");
        }
    }
}
