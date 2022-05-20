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
import model.Navegacion;


public class Aplicacion extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Navegacion jugador = Navegacion.getSingletonNavegacion();
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/vista/login.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
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
