/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import DBAccess.NavegacionDAOException;
import controlador.opcionesControlador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;
import model.User;

/**
 *
 * @author jsanchez
 */
public class Aplicacion extends Application {
    public static Navegacion base;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        base = Navegacion.getSingletonNavegacion();
        
        
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setTitle("SAILAPP");
        //stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setResizable(false);
        stage.getIcons().add(new Image("resources/Icono.png"));
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
