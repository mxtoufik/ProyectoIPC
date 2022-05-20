/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import DBAccess.NavegacionDAOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Navegacion;



/**
 * FXML Controller class
 *
 * @author luism
 */
public class ElegirPreguntaContolador implements Initializable {

    @FXML
    private ImageView botonPerfil;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image foto = new Image("/resources/avatars/engra.png", 160, 160, false, true);
        botonPerfil.setImage(foto);
        
    }

    
    public int getRandom(){
        return (int) ((Math.random() * 17)+1);
    }
    
    
    private void irAPreguntaAleatoria(ActionEvent event) {
        
        
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            PreguntasController controlador = fxmlLoader.getController();
            System.out.println(getRandom());
            controlador.displayName(getRandom());
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        
        
    }


    @FXML
    private void irpregunta1(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            PreguntasController controlador = fxmlLoader.getController();
            
            controlador.displayName(0);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void irpregunta2(ActionEvent event) {
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(1);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void irpregunta3(ActionEvent event) {
        
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(2);
            controlador.showPregunta();
            
            
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            //stage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void irpregunta4(ActionEvent event) {
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(3);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        
        
    }

    private void IrAPerfil(MouseEvent event) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irpregunta5(ActionEvent event) {
    
         try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(4);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

    @FXML
    private void irpregunta6(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(5);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
    }

    @FXML
    private void irpregunta7(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(6);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }

    @FXML
    private void irpregunta8(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(7);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
    }

    @FXML
    private void irpregunta10(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(9);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
    }

    @FXML
    private void irpregunta11(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(10);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }

    @FXML
    private void irpregunta12(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(11);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
        
        
    }

    @FXML
    private void irpregunta13(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(12);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
        
    }

    @FXML
    private void irpregunta14(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(13);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
    }

    @FXML
    private void irpregunta15(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(14);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
    }

    @FXML
    private void irpregunta16(ActionEvent event) {
        
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(15);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
        
        
        
    }
    
    
    
    
    
    

    @FXML
    private void irpregunta17(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(16);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }

    @FXML
    private void irpregunta18(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(17);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
        
        
    }

    @FXML
    private void irpregunta9(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root7 = (Parent) fxmlLoader.load();
            
            
            PreguntasController controlador = fxmlLoader.getController();
            controlador.displayName(8);
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root7));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }

    @FXML
    private void irPreguntaAleatoria(ActionEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Preguntas.fxml"));
            Parent root6 = (Parent) fxmlLoader.load();
            
            PreguntasController controlador = fxmlLoader.getController();
            System.out.println(getRandom());
            controlador.displayName(getRandom());
            controlador.showPregunta();
            
            Stage stage = new Stage();
           
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root6));
            //stage.setResizable(false);
            stage.show();

            Node node5 = (Node) event.getSource();
            node5.getScene().getWindow().hide();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }

    @FXML
    private void irAPerfil(MouseEvent event) {
        
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vista/Opciones.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("SAILAPP");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root1));
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.showAndWait();
            
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }


}
