/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
import static aplicacion.Aplicacion.base;
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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafx.stage.StageStyle.TRANSPARENT;
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
    private Navegacion Base;
    private User admin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setShowWeekNumbers(false);
        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) > 0);
            }
        });
        Navegacion base = Aplicacion.base;
        User admin = base.loginUser("Mohammed", "Holahola1@");
        usuarioNombre.setText(admin.getNickName());
        usuarioCorreo.setText(admin.getEmail());
        usuarioAvatar.setImage(admin.getAvatar());
        usuarioContraseña.setText(admin.getPassword());
        usuarioNuevaContraseña.setText(admin.getPassword());
        datePicker.setValue(admin.getBirthdate());
    }

    @FXML
    private void btnAtras(ActionEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones3.fxml"));
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
        //Deshabilita los mensajes de error para actualizarlos cada vez que se pulse el botón de guardar.

        correoIncorrecto.setVisible(false);
        contrasenaIncorrecta.setVisible(false);
        repetirContrasenaIncorrecta.setVisible(false);
        repetirContrasenaIncorrecta1.setVisible(false);

        //Se encarga de ver si el correo introducido cumple con la estructura de uno propio.
        boolean correoBien = admin.checkEmail(usuarioCorreo.getText());
        /*
        String regexCorreo = "^[A-Za-z0-9+_.-]+@+[A-Za-z0-9+_.-]+.+[A-Za-z0-9+_.-]$";
        Pattern pattern = Pattern.compile(regexCorreo);
        Matcher matcherCorreo = pattern.matcher(usuarioCorreo.getText());
        Boolean coincideRegexCorreo = matcherCorreo.matches();
         */

        if (correoBien) {

            String password = usuarioContraseña.getText();
            String passwordRepetida = usuarioNuevaContraseña.getText();
            boolean passwordBien = admin.checkPassword(usuarioContraseña.getText());
            //Se encarga de ver si la contraseña introducida cumple con los requisitos previamente otorgados por el profesor.
            /*String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.* )(?=.*[@#$%]).{8,20}$";
            Pattern pattern2 = Pattern.compile(regexPassword);
            Matcher matcherPassword = pattern2.matcher(password);
            Boolean coincideRegexPassword = matcherPassword.matches();
             */
            if (passwordBien) {
                if (password.equals(passwordRepetida)) {

                    String username = usuarioCorreo.getText();
                    LocalDate fecha = datePicker.getValue();

                    try {
                        
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

                        FXMLLoader elLoader = new FXMLLoader(getClass().getResource("/vista/Opciones3.fxml"));
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

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                //alert.setColor(TRANSPARENT);
                alert.initStyle(StageStyle.TRANSPARENT);
                
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(
                getClass().getResource("/estilo/menu.css").toExternalForm());
                dialogPane.getScene().setFill(Color.TRANSPARENT);
                dialogPane.setOpaqueInsets(Insets.EMPTY);
                dialogPane.getStyleClass().add("elborde2");
                //dialogPane.getStyleClass().add("boton2");
                alert.setTitle("Error Contraseña incorrecta");
                alert.setContentText("La contraseña debe incluir: \n" + "• De 8 a 20 caractéres.\n" + "• Al menos una letra mayúscula.\n"
                        + "• Al menos una letra minúscula.\n" + "• Al menos un dígito.\n" + "• Al menos un caracter especial tal que: !@#$%&*()-+=.\n"
                        + "• Ningún espacio en blanco.\n");
                alert.showAndWait();

            }
        } else {
            correoIncorrecto.setVisible(true);
            correoIncorrecto.setText("El correo introducido es incorrecto");
        }
    }
}
