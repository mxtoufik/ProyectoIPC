/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.Session;
import model.User;
import static model.User.checkEmail;
import static model.User.checkNickName;
import static model.User.checkPassword;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class registroControlador implements Initializable {

    @FXML
    private Button botonAceptarReg;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textCorreo;
    private DatePicker textCalendario;
    private PasswordField textContraseña;
    private PasswordField textContraseñaCon;
    boolean existeMail;
    boolean existePass;
    private TextField mensajeCorreo;
    private TextField mensajeContraseña;
    private TextField prueba;
    @FXML
    private Text errorNombre;
    @FXML
    private Text errorCorreo;
    @FXML
    private Text errorContraseña;
    private PasswordField textConfContraseña;
    @FXML
    private DatePicker textFecha;
    @FXML
    private Text errorFecha;

    private static Image laFoto2;

    public static Navegacion baseD;
    @FXML
    private ImageView usuarioAvatar;
    private TextField textContrasena;
    private TextField textConfContrasena;
    @FXML
    private PasswordField textPassword;
    private PasswordField textConfPassword;
    @FXML
    private MenuButton elegirAvatar;
    @FXML
    private Button seleccionarArchivo;
    @FXML
    private ImageView avatar1;
    @FXML
    private ImageView avatar2;
    @FXML
    private ImageView avatar3;
    @FXML
    private ImageView avatar4;
    @FXML
    private ImageView avatar5;
    private ImageView myImagView;
    private Stage stage;
    @FXML
    private Button volverButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        baseD = Aplicacion.base;

        Session a = new Session(LocalDateTime.now(), 0, 0);
        textFecha.setShowWeekNumbers(false);
        textFecha.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) > 0);

            }
        });

        seleccionarArchivo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Buscar Imagen");
                //agregar filtros para la búsqueda
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Images", "*.*"),
                        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                        new FileChooser.ExtensionFilter("PNG", "*.png")
                );
                //obtener la imagen seleccionada
                File imgFile = fileChooser.showOpenDialog(stage);
                //mostrar la imagen
                if (imgFile != null) {
                    Image image = new Image("file:" + imgFile.getAbsolutePath());
                    myImagView.setImage(image);
                }
            }
        });
    }


    @FXML
    private void accionAceptarReg(MouseEvent event) throws IOException {
        try {
            
            errorNombre.setText("");
            errorContraseña.setText("");
            errorCorreo.setText("");
            
            boolean nicknameBien = false;
            boolean passwordBien = false;
            boolean emailBien = false;
            boolean fechaBien = false;
            String nickName = textNombre.getText();
            String email = textCorreo.getText();
            String password = textPassword.getText();
            LocalDate birthdate = textFecha.getValue();
            Image perfil = myImagView.getImage();
            if (checkNickName(nickName)) {
                nicknameBien = true;
            } else { //si el NICKNAME no es valido
                errorNombre.setText("El nombre de usuario no es válido.");
            }
            if (checkPassword(password)) {
                passwordBien = true;
            } else {//si la CONTRASEÑA no es valida
                errorContraseña.setText("La contraseña no es valida.");
            }
            if (checkEmail(email)) {
                emailBien = true;
            } else { //si el CORREO no es válido
                errorCorreo.setText("Correo no válido.");
            }
            if (nicknameBien && passwordBien && emailBien) {
                baseD.registerUser(nickName, email, password, perfil, birthdate);
                FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("/vista/login.fxml"));
                Parent root = (Parent) loaderLogin.load();
                Stage stageLogin = new Stage();
                stageLogin.setTitle("SAILAPP");
                stageLogin.initModality(Modality.APPLICATION_MODAL);
                stageLogin.setScene(new Scene(root));
                stageLogin.show();
                
                Node nodeLogin = (Node) event.getSource();
                nodeLogin.getScene().getWindow().hide();
            }
        } catch (NavegacionDAOException e) {
            errorNombre.setText("El nombre de usuario ya existe");
        }
    }


    @FXML
    private void avatar1(ActionEvent event) {
        Image imagen1 = new Image("/avatars/avatar1.png");
        usuarioAvatar.setImage(imagen1);
    }

    @FXML
    private void avatar2(ActionEvent event) {
        Image imagen2 = new Image("/avatars/avatar2.png");
        usuarioAvatar.setImage(imagen2);
    }

    @FXML
    private void avatar3(ActionEvent event) {
        Image imagen3 = new Image("/avatars/avatar3.png");
        usuarioAvatar.setImage(imagen3);
    }

    @FXML
    private void avatar4(ActionEvent event) {
        Image imagen4 = new Image("/avatars/avatar4.png");
        usuarioAvatar.setImage(imagen4);
    }

    @FXML
    private void avatar5(ActionEvent event) {
        Image imagen5 = new Image("/avatars/default.png");
        usuarioAvatar.setImage(imagen5);
    }

    @FXML
    private void volverButton(ActionEvent event) {
    }

}
