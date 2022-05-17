/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author tange
 */
public class mapaControlador implements Initializable {
    
    private Group zoomGroup;

    @FXML
    private Slider zoom_slider;
    @FXML
    private SplitPane splitPane;
    @FXML
    private ScrollPane map_scrollpane;
    @FXML
    private MenuButton map_pin;
    @FXML
    private MenuItem pin_info;
    @FXML
    private VBox rightPane;
    @FXML
    private Label posicion;
    @FXML
    private ImageView lapiz;
    @FXML
    private ImageView arco;
    @FXML
    private ImageView texto;
    @FXML
    private ImageView borrar;
    @FXML
    private ImageView transportador;
    @FXML
    private ImageView punto;
    @FXML
    private VBox bordeLapiz;
    @FXML
    private VBox bordeArco;
    @FXML
    private VBox bordeTexto;
    @FXML
    private VBox bordeBorrar;
    @FXML
    private VBox bordeCompas;
    @FXML
    private VBox bordePunto;
    
    public static boolean pulsado;
    public static boolean pulsadoArco;
    public static boolean pulsadoTexto;
    public static boolean pulsadoBorrar;
    public static boolean pulsadoCompas;
    public static boolean pulsadoPunto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zoom_slider.setMin(0.5);
        zoom_slider.setMax(1.5);
        zoom_slider.setValue(1.0);
        zoom_slider.valueProperty().addListener((o, oldVal, newVal) -> zoom((Double) newVal));
        
        //=========================================================================
        //Envuelva el contenido de scrollpane en un grupo para que 
        //ScrollPane vuelva a calcular las barras de desplazamiento tras el escalado
        Group contentGroup = new Group();
        zoomGroup = new Group();
        contentGroup.getChildren().add(zoomGroup);
        zoomGroup.getChildren().add(map_scrollpane.getContent());
        map_scrollpane.setContent(contentGroup);
        
        
        splitPane.setDividerPositions(0.03);
        splitPane.maxWidthProperty().multiply(0.03);
        rightPane.maxWidthProperty().bind(splitPane.widthProperty().multiply(0.03));
        
        
         pulsado = false;
         pulsadoArco = false;
         pulsadoTexto = false;
         pulsadoBorrar = false;
         pulsadoCompas = false;
         pulsadoPunto = false;
    }   

    @FXML
    private void zoomOut(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal + -0.1);
    }

    @FXML
    private void zoomIn(ActionEvent event) {
        double sliderVal = zoom_slider.getValue();
        zoom_slider.setValue(sliderVal += 0.1);
    }

    @FXML
    private void muestraPosicion(MouseEvent event) {
        posicion.setText("sceneX: " + (int) event.getSceneX() + ", sceneY: " + (int) event.getSceneY() + "\n"
                + "         X: " + (int) event.getX() + ",          Y: " + (int) event.getY());
    }
    
    
    private void zoom(double scaleValue) {
        //===================================================
        //guardamos los valores del scroll antes del escalado
        double scrollH = map_scrollpane.getHvalue();
        double scrollV = map_scrollpane.getVvalue();
        //===================================================
        // escalamos el zoomGroup en X e Y con el valor de entrada
        zoomGroup.setScaleX(scaleValue);
        zoomGroup.setScaleY(scaleValue);
        //===================================================
        // recuperamos el valor del scroll antes del escalado
        map_scrollpane.setHvalue(scrollH);
        map_scrollpane.setVvalue(scrollV);
    }

    @FXML
    private void opciones(ActionEvent event) {
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
            /*Node node = (Node) event.getSource();
            node.getScene().getWindow().hide();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void dibujar(MouseEvent event) {
        if(!pulsado & !(pulsadoArco | pulsadoTexto | pulsadoBorrar | pulsadoCompas | pulsadoPunto)) {
            bordeLapiz.getStylesheets().add("estilo/style.css");
            bordeLapiz.getStyleClass().remove("image-view-wrapper");
            bordeLapiz.getStyleClass().add("image-view-wrapper2");
            
            pulsado = true;
        }
        else{
            bordeLapiz.getStylesheets().add("estilo/style.css");
            bordeLapiz.getStyleClass().remove("image-view-wrapper2");
            bordeLapiz.getStyleClass().add("image-view-wrapper");
            pulsado = false;
        }
    }

    @FXML
    private void dibujarArco(MouseEvent event) {
        if(!pulsadoArco & !(pulsado | pulsadoTexto | pulsadoBorrar | pulsadoCompas | pulsadoPunto)) {
            bordeArco.getStylesheets().add("estilo/style.css");
            bordeArco.getStyleClass().remove("image-view-wrapper");
            bordeArco.getStyleClass().add("image-view-wrapper2");
            
            pulsadoArco = true;
        }
        else{
            bordeArco.getStylesheets().add("estilo/style.css");
            bordeArco.getStyleClass().remove("image-view-wrapper2");
            bordeArco.getStyleClass().add("image-view-wrapper");
            pulsadoArco = false;
        }
    }

    @FXML
    private void dibujarTexto(MouseEvent event) {
        if(!pulsadoTexto & !(pulsadoArco | pulsado | pulsadoBorrar | pulsadoCompas | pulsadoPunto)) {
            bordeTexto.getStylesheets().add("estilo/style.css");
            bordeTexto.getStyleClass().remove("image-view-wrapper");
            bordeTexto.getStyleClass().add("image-view-wrapper2");
            
            pulsadoTexto = true;
        }
        else{
            bordeTexto.getStylesheets().add("estilo/style.css");
            bordeTexto.getStyleClass().remove("image-view-wrapper2");
            bordeTexto.getStyleClass().add("image-view-wrapper");
            pulsadoTexto = false;
        }
    }

    @FXML
    private void dibujarBorrar(MouseEvent event) {
        if(!pulsadoBorrar & !(pulsadoArco | pulsadoTexto | pulsado | pulsadoCompas | pulsadoPunto)) {
            bordeBorrar.getStylesheets().add("estilo/style.css");
            bordeBorrar.getStyleClass().remove("image-view-wrapper");
            bordeBorrar.getStyleClass().add("image-view-wrapper2");
            
            pulsadoBorrar = true;
        }
        else{
            bordeBorrar.getStylesheets().add("estilo/style.css");
            bordeBorrar.getStyleClass().remove("image-view-wrapper2");
            bordeBorrar.getStyleClass().add("image-view-wrapper");
            pulsadoBorrar = false;
        }
    }

    @FXML
    private void dibujarTransportador(MouseEvent event) {
        if(!pulsadoCompas & !(pulsadoArco | pulsadoTexto | pulsadoBorrar | pulsado | pulsadoPunto)) {
            bordeCompas.getStylesheets().add("estilo/style.css");
            bordeCompas.getStyleClass().remove("image-view-wrapper");
            bordeCompas.getStyleClass().add("image-view-wrapper2");
            
            pulsadoCompas = true;
        }
        else{
            bordeCompas.getStylesheets().add("estilo/style.css");
            bordeCompas.getStyleClass().remove("image-view-wrapper2");
            bordeCompas.getStyleClass().add("image-view-wrapper");
            pulsadoCompas = false;
        }
    }

    @FXML
    private void dibujarPunto(MouseEvent event) {
        if(!pulsadoPunto & !(pulsadoArco | pulsadoTexto | pulsadoBorrar | pulsadoCompas | pulsado)) {
            bordePunto.getStylesheets().add("estilo/style.css");
            bordePunto.getStyleClass().remove("image-view-wrapper");
            bordePunto.getStyleClass().add("image-view-wrapper2");
            
            pulsadoPunto = true;
        }
        else{
            bordePunto.getStylesheets().add("estilo/style.css");
            bordePunto.getStyleClass().remove("image-view-wrapper2");
            bordePunto.getStyleClass().add("image-view-wrapper");
            pulsadoPunto = false;
        }
    }
}
