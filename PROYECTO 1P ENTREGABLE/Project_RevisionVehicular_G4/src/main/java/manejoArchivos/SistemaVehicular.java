/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;

import java.util.ArrayList;
import java.util.Scanner;
import PaqueteUsuarios.Usuario;
/**
 *
 * @author Julian Ruiz
 */
public class SistemaVehicular {
    ArrayList<Usuario> usuarios=new ArrayList<>();
    ArrayList<Vehiculo> vehiculos=new ArrayList<>();
    ArrayList<Multa> listaMultas=new ArrayList<>();
    
    public void IniciarSesion(){
         String entrada = "";
        Scanner sc=new Scanner(System.in);
        do {
            MostrarMenu();
            System.out.print("Ingrese opcion:");
            entrada = sc.nextLine();
            switch (entrada) {
                case "1":
                    //;
                    break;
                case "2":
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (!entrada.equals("2"));
    }
    
    
    public void MostrarMenu(){
        System.out.println("Bienvenido ");
        System.out.println("1.Iniciar sesion");
        System.out.println("2. Salir");
    }
    
    
    
    public void main(String[]args){
       
    }
}
