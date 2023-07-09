/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoArchivos;

import static PaquetesEnum.prueba.modilista;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Verónica
 */
public class TrabajoConArchivos {

    public static ArrayList<String> da= new ArrayList<>();

//    public static ArrayList<String> getDa() {
//        return da;
//    }
//
//    public static void setDa(ArrayList<String> da) {
//        TrabajoConArchivos.da = da;
//    }
    
    
    
     public static void main(String[] arg) {
        
       
        da.add("hola");
        da.add("pepe");
        da.add("maria");
        da.add("hotgrrd");
        System.out.println(da);
        
        modilista();
        
        
        System.out.println(da);
        
        
        
    }
    
}
