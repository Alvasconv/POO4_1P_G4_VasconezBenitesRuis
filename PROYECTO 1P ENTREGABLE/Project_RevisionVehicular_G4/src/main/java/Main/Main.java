/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Interfaz.SistemaVehicular;


/**
 *Clase main donde se corre el programa.
 * @author Julian Ruiz
 */
public class Main {
    /**
     * Metodo main del sistema.
     * @param args ingreso de argumentos.
     */
    public static void main(String[]args){
        
        SistemaVehicular veg= new SistemaVehicular ();
        veg.inicioSesion();
    }
}