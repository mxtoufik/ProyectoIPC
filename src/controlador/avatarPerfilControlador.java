/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Navegacion;

/**
 *
 * @author elena
 */
public class avatarPerfilControlador {

    @FXML
    private Button botonSelecArchivo;
    @FXML
    private Button botonGuardar;
    @FXML
    private Button botonAtras;
    final FileChooser fileChooser1 = new FileChooser();
    /*FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg & .gif &.png", "jpg", "gif", "png");
    fileChooser1.setFileFilter(filtro);
    fileChooser1.setFileSelectionMode(fileChooser.FILES_ONLY);*/
    @FXML
    private ImageView imagAvatar1;
    @FXML
    private ImageView imagAvatar2;
    @FXML
    private ImageView imagAvatar3;
    @FXML
    private ImageView imagAvatar4;
    
    private ImageView laFoto;
    
    public static Image foto1;
    public static Image foto2;
    public static Image foto3;
    public static Image foto4;
    @FXML
    private Button prueba;
    
    public void initialize(URL url, ResourceBundle rb) {
        Image foto1 = new Image("/avatars/resources/avatar1.png");
        Image foto2 = new Image("/avatars/resources/avatar2.png");
        Image foto3 = new Image("/avatars/resources/avatar3.png");
        Image foto4 = new Image("/avatars/resources/avatar4.png");
        imagAvatar1.setImage(foto1);
        imagAvatar2.setImage(foto2);
        imagAvatar3.setImage(foto3);
        imagAvatar4.setImage(foto4);
        
    }
    @FXML
    private void botonSelecArchivo(ActionEvent event) {
        File file = fileChooser1.showOpenDialog(null);
    }

    @FXML
    private void botonGuardar(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Guardar cambios");
        alert.setContentText("¿Seguro que quieres guardar cambios?");
        Optional<ButtonType> result = alert.showAndWait();
        if(!result.isPresent()) {
            //
        }else if((result.get() == ButtonType.OK) && laFoto != null){
            //Image avatarOld = usuarioAvatar.getImage();
            //Image avatarNew = imagenAvatar1.getImage();
            
        }
        else if(result.get() == ButtonType.CANCEL){
                
        }
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/registro.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("SAILAPP");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                Node node = (Node) event.getSource();
                node.getScene().getWindow().hide();
    }

    @FXML
    private void botonAtras(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/registro.fxml"));
                Parent root = (Parent) loader.load();
                Stage stage = new Stage();
                stage.setTitle("SAILAPP");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                //stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                Node node = (Node) event.getSource();
                node.getScene().getWindow().hide();
    }



    @FXML
    private void imagenAvatar1(MouseEvent event){
         // imagAvatar2.setImage(foto1);
    }

    @FXML
    private void imagAvatar2(MouseEvent event) {
        //laFoto = foto2;
    }

    @FXML
    private void imagAvatar3(MouseEvent event) {
        //laFoto = foto3;
    }
    @FXML
    private void imagAvatar4(MouseEvent event) {
        //laFoto = foto4;
    }

    @FXML
    private void prueba(ActionEvent event) {
        /*FileChooser archivo = new FileChooser();
        File seleccion = archivo.showOpenDialog(null);
        if(seleccion != null) {
            String path = "avatars/" + seleccion.getName();
            Image avatar = new Image(path);
            usuarioAvatar.setImage(avatar);
            usuarioAvatar.imageProperty().setValue(avatar);*/
    }
    
    
}
