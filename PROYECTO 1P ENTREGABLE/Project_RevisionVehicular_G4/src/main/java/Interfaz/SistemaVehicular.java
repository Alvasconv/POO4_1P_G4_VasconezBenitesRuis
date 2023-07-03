/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import PaqueteUsuarios.Cliente;
import PaqueteUsuarios.Operador;
import java.util.ArrayList;
import java.util.Scanner;
import PaqueteUsuarios.Usuario;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejoArchivos.*;
import manejoArchivos.Multa;
//import manejoArchivos.Vehiculo;
/**
 *
 * @author Julian Ruiz
 */
public class SistemaVehicular {
    ArrayList<Usuario> usuarios=new ArrayList<>();
    ArrayList<Vehiculo> vehiculos=new ArrayList<>();
    //static ArrayList<Multa> listaMultas = new ArrayList<>();
 
    //ArrayList<String> datos = ManejoArchivos.LeeFichero("multas.txt");
           
    public void MostrarMenu(Cliente usuario){
        System.out.println("1.Consultar Multas");
        System.out.println("2. Agendar revision tecnica");
        System.out.println("3.Salir");
    }
    
    public void MostrarMenu(Operador usuario){
        System.out.println("1.Registar pagos");
        System.out.println("2.Consultar multas clientes");
        System.out.println("3.Consultar usuarios");
        System.out.println("4.Salir");
    }
    
     public void IniciarSesion(){
         System.out.println("************************************************");
         System.out.println("             Bienvenido al sistema              ");
         System.out.println("************************************************");
         Scanner sc=new Scanner(System.in);
         System.out.print("Usuario:");
         String usuario=sc.nextLine();
         sc.nextLine();
         System.out.print("Contrasenia:");
         String pasword=sc.nextLine();
         String entrada="";
         for(Usuario u:usuarios){
            if(u.getUsuario().equals(usuario)){
                if(u.getContrasenia().equals(pasword)){
                    if(u instanceof Cliente){
                        Cliente c=(Cliente)u;
                        do{
                            MostrarMenu(c);
                            System.out.print("Ingrese una opcion:");
                            entrada=sc.nextLine();
                            switch(entrada){
                                case"1":
                                    c.consultarMulta();
                                    break;
                                case"2":
                                    c.agendarRevision();
                                    break;
                                case"3":
                                    System.out.println("Adios");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                                }
                            }while(!entrada.equals("3"));
                    }else{
                        Operador o=(Operador)u;
                        do{
                            MostrarMenu(o);
                            System.out.print("Ingrese una opcion:");
                            entrada=sc.nextLine();
                            switch(entrada){
                                case"1":
                                    o.registrarPago();
                                    break;
                                case"2":
                                    o.consultarMulta();
                                    break;
                                case"3":
                                    o.consultarUsuario();
                                    break;
                                case"4":
                                    System.out.println("Adios");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                                }
                            }while(!entrada.equals("4"));
                        }   
                }
            }
        }
    }
     
     public static ArrayList mostrarListaMultas() {
        ArrayList<String> datos = ManejoArchivos.LeeFichero("multas.txt");
        ArrayList<Multa>listaMultas = new ArrayList<>(); 
        for (String linea : datos) {
            String[] elementos = linea.trim().split(",");
            int ced = Integer.valueOf(elementos[0]);
            String placa = elementos[1];
            String descr = elementos[2];
            double valor = Double.parseDouble(elementos[3]);
            
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            Date fechainfraccion = null;
            try {
                fechainfraccion = formato.parse(elementos[4]);
            } catch (ParseException ex) {
                Logger.getLogger(SistemaVehicular.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            SimpleDateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaNotificacion = null;
            try {
                fechaNotificacion = formato1.parse(elementos[5]);
            } catch (ParseException ex) {
                Logger.getLogger(SistemaVehicular.class.getName()).log(Level.SEVERE, null, ex);
            }
            int puntos = Integer.valueOf(elementos[6]);
            Multa m = new Multa(ced, placa, descr, valor,fechainfraccion, fechaNotificacion, puntos);
            listaMultas.add(m);
            }
        return listaMultas;
     }
    
     
     public static void main(String[] args) {
        ArrayList <String> o= mostrarListaMultas();
         System.out.println(o);
    }
}
