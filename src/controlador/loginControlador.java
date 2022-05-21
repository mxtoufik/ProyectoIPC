
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import aplicacion.Aplicacion;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import model.Navegacion;
import model.Session;
import model.User;
import static model.User.checkNickName;

/**
 * FXML Controller class
 *
 * @author elena
 */
public class loginControlador implements Initializable {

    @FXML
    private TextField texto_usuario;
    @FXML
    private PasswordField texto_contrasena;
    @FXML
    private Button botonLog;
    @FXML
    private Text mensaje_usuario;
    private ImageView myImagView;
    @FXML
    private ImageView barcoImag;

    private static Navegacion base;
    @FXML
    private Button BotonReg;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imagenBarco = new Image("/resources/logo.png");
        barcoImag.setImage(imagenBarco);
        base = Aplicacion.base;
    }

    @FXML

    private void botonLog(ActionEvent event) throws NavegacionDAOException {
        String usuarioNombre = texto_usuario.getText();
        User usuario = base.getUser(usuarioNombre);
        String usuarioPassword = texto_contrasena.getText();
        if (checkNickName(usuarioNombre)) { //ver si existe el NICKNAME
            if (usuario.checkCredentials(usuarioNombre, usuarioPassword)) { //si el NICKNAME Y CONTRASEÑA coinciden
                try {

                    User user1 = base.loginUser(texto_usuario.getText(), texto_contrasena.getText());
                    FXMLLoader loaderLogin = new FXMLLoader(getClass().getResource("/vista/ElegirPregunta.fxml"));
                    Parent root = (Parent) loaderLogin.load();

                    ElegirPreguntaContolador controlador = loaderLogin.getController();
                    controlador.getUser(user1);

                    Stage stageLogin = new Stage();
                    stageLogin.setTitle("SAILAPP");
                    stageLogin.initModality(Modality.APPLICATION_MODAL);
                    stageLogin.setScene(new Scene(root));

                    stageLogin.setOnCloseRequest((new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent arg0) {
                            arg0.consume();
                            try {
                                int fallos = PreguntasController.getFallos();
                                int aciertos = PreguntasController.getAciertos();
                                Session sesion = new Session(LocalDateTime.now(), aciertos, fallos);
                                usuario.addSession(sesion);
                                Platform.exit();

                            } catch (Exception ex) {
                                System.out.print(ex.getMessage() + "\r\n");
                            }

                        }
                    }));

                    stageLogin.show();

                    Node nodeLogin = (Node) event.getSource();
                    nodeLogin.getScene().getWindow().hide();
                } catch (IOException ex) {
                    System.out.println("¡Error al Iniciar sesión!");
                }
            } else { //si es NICKNAME o CONTRASEÑA no coinciden
                mensaje_usuario.setText("Usuario o contraseña incorrectos");
            }
        } else {
            mensaje_usuario.setText("Usuario no encontrado");
        }
    }

    @FXML
    private void BotonReg(ActionEvent event) {
        try {
            FXMLLoader loaderReg = new FXMLLoader(getClass().getResource("/vista/registroRed.fxml"));
            Parent rootReg = (Parent) loaderReg.load();
            Stage stageReg = new Stage();
            stageReg.setTitle("SAILAPP");
            stageReg.initModality(Modality.APPLICATION_MODAL);
            stageReg.setScene(new Scene(rootReg));
            stageReg.show();

            Node nodeReg = (Node) event.getSource();
            nodeReg.getScene().getWindow().hide();
        } catch (IOException ex) {
            System.out.println("Error al Registrarse!");
        }
    }
}
