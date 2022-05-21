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
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
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
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("SAILAPP");
        stage.getIcons().add(new Image("resources/Icono.png"));
        
        stage.setOnCloseRequest((new EventHandler<WindowEvent>(){

        @Override
        public void handle(WindowEvent arg0) {
                            arg0.consume();
            try
            {
             System.out.println("Hola");
             Platform.exit();

                            }
            catch(Exception ex)
            {
                System.out.print(ex.getMessage()+"\r\n");
            }

        }
    }));

        stage.show();
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
