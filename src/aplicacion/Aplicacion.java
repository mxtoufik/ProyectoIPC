/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author jsanchez
 */
public class Aplicacion extends Application {

    private Object primaryStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/aplicacion/ElegirPregunta.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
       // primaryStage.setScene(scene);
       // ElegirPreguntaControlador controller = loader.getController();
       // controller.setStage(primaryStage);
       // primaryStage.show();
        
        stage.setScene(scene);
        stage.setTitle("SAILAPP");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
