/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Clases.*;
import ListTDA.ArrayListGroup9;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Abeni
 */
public class ListaContactosController implements Initializable {
    
    public static ArrayListGroup9<Contacto> lstcontactos = new ArrayListGroup9<>();

    @FXML
    private HBox hbCabezera;
    @FXML
    private Label lbcontactos;
    @FXML
    private TextField txBuscador;
    @FXML
    private VBox vblista;
    @FXML
    private ListView<Contacto> listContactos;
    @FXML
    private HBox hbAnadir;
    @FXML
    private ImageView imgPlus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void cargarContactos(){
        try(BufferedReader br = new BufferedReader(new FileReader(App.pathFiles+"Contactos.txt",StandardCharsets.UTF_8))){
            String linea= br.readLine();
            while (linea != null) {
                String p[]=linea.split(",");
                //lstcontactos.add(new Contacto(p[0].trim(),p[1].trim(),p[2].trim(), p[3].trim()));
                linea= br.readLine();
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("No se pudo encontrar el archivo");
        }
        catch(IOException e){
            System.out.println("ERROOOORRR.......");
        }
    }
    
}
