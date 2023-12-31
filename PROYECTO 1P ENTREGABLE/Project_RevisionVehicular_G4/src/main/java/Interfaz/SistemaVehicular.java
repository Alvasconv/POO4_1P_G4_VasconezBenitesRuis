/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import PaqueteUsuarios.Cliente;
import static PaqueteUsuarios.Cliente.*;
import PaqueteUsuarios.Operador;
import static PaqueteUsuarios.Operador.*;
import java.util.ArrayList;
import java.util.Scanner;
import PaqueteUsuarios.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejoArchivos.*;

/**
 *Sistema Vehicular
 * @author Julian Ruiz
 */
public class SistemaVehicular {
    
    /**
    * Cada elemento de este arraylist es un objeto de tipo Usuario.
    */
    public static ArrayList <Usuario> usuarios=new ArrayList<>();  // cada elemento de este arraylist es un objeto ya sea de tipo cliente o tipo operador
    /**
    * Cada elemento de este arraylist es un objeto de tipo Vehiculo.
    */
    public static ArrayList<Vehiculo> vehiculos=new ArrayList<>(); // cada elemento de este arraylist es un objeto de tipo vehiculo
    /**
    * Cada elemento de este arraylist es un objeto de tipo Multa.
    */
    public static ArrayList<Multa> listaMultas = new ArrayList<>(); //cada elemento de este arraylist es un objeto de tipo multa
    
    
    
    
    
    /**
     * Instancia SistemaVehicular.
     */
    public SistemaVehicular (){    
        // A CONTINUACION PROCEDO A CARGAR MI LISTA DE MULTAS CON LOS DATOS DEL ARCHIVO MULTAS.TXT
        
        ArrayList<String> datosMultas = ManejoArchivos.LeeFichero("multas.txt");
        
        for (String linea : datosMultas) {
            String[] elementos = linea.trim().split(",");
            String ced = (elementos[0]);
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
            Multa m = new Multa(ced, placa, descr, valor, fechainfraccion, fechaNotificacion, puntos);
            listaMultas.add(m);
        }
        
        /* 
        A continuacion cargo la lista de usuarios con objetos tanto de tipo cliente como de tipo operador
        con mi archivo usuarios.txt
        */
        ArrayList<String> datoscli = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> datosUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> datosOperadores = ManejoArchivos.LeeFichero("operadores.txt");
        for (String line : datosUsuarios) {
            String[] elementos = line.trim().split(",");
            if (Arrays.asList(elementos).contains("S") || Arrays.asList(elementos).contains("E")) {
                String ced = (elementos[0]);
                String nombre = elementos[1];
                String apellido = elementos[2];
                int edad = Integer.parseInt(elementos[3]);
                String usuario = elementos[5];
                String contraseña = elementos[6];
                String perfi = elementos[7];
                for (String linea : datoscli) {
                    String[] cli = linea.trim().split(",");
                    if (Arrays.asList(cli).contains(ced)) {
                        String tarj = (cli[1]);
                        int ptslicencia = Integer.parseInt(cli[2]);
                        Usuario usu = new Cliente(ced, nombre, apellido, edad, usuario, contraseña, tarj, ptslicencia, perfi);
                        usuarios.add(usu);
                    }
                }
            }
        }
        for (String line : datosUsuarios) {
            String[] elementos = line.trim().split(",");
            if (Arrays.asList(elementos).contains("O")) {
                String ced = elementos[0];
                String nombre = elementos[1];
                String apellido = elementos[2];
                int edad = Integer.parseInt(elementos[3]);
                String usuario = elementos[5];
                String contraseña = elementos[6];
                String perfi = elementos[7];
                for (String lineOP : datosOperadores) {
                    String[] eleOP = lineOP.trim().split(",");
                    if (Arrays.asList(eleOP).contains(ced)) {
                        int suel = Integer.parseInt(eleOP[1]);
                        Usuario usu = new Operador(ced, nombre, apellido, edad, usuario, contraseña, suel, perfi);
                        usuarios.add(usu);
                    }
                }

            }
        }
        

        // A continuacion cargo la lista de vehiculos con los datos de mi archivo vehiculos.txt
        ArrayList<String> datosVehiculo = ManejoArchivos.LeeFichero("vehiculos.txt");

        for (String lineVehi : datosVehiculo) {
            String[] carros = lineVehi.trim().split(",");
            String duenioVehicu = (carros[0]);
            String placa = carros[1];
            String marca = carros[2];
            String modelo = carros[3];
            int anio = Integer.parseInt(carros[4]);
            String chasis = carros[5];
            String color = carros[6];

            Vehiculo car = new Vehiculo(duenioVehicu, placa, marca, modelo, anio, chasis, color);
            vehiculos.add(car);

        }
    } //pilas con este corchete no va    
        // A continuacion presento el menu
    /**
     * Este metodo genera el menu y las opciones para los usuarios y operadores
     * y llama las variables de las otras clases
     */
    public void inicioSesion(){
        boolean ingreso = false;
        while (!ingreso){
            System.out.println("************************************************");
            System.out.println("             Bienvenido al sistema              ");
            System.out.println("************************************************");
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Usuario:");
            String usuario = sc.nextLine();
            System.out.print("Contrasenia:");
            String pasword = sc.nextLine();
            String entrada = "";
            for (Usuario u : usuarios) {
                if ((usuario.equals(u.getUsuario())) && (pasword.equals(u.getContrasenia()))) {
                    if (u instanceof Cliente) {
                        Cliente c = (Cliente) u;
                        do {
                            c.MostrarMenuUsuario();
                            System.out.print("Ingrese una opcion:");
                            entrada = sc.nextLine();
                            switch (entrada) {
                                case "1":
                                    c.consultarMulta();
                                    break;
                                case "2":
                                    c.agendarRevision();
                                    break;
                                case "3":
                                    System.out.println("Que tenga buen dia");
                                    
                                    break;
                                    
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        } while (!entrada.equals("3"));
                            
                    ingreso=false;
                    break;
                    } 
                    else {
                        Operador o = (Operador) u;
                        do {
                            o.MostrarMenuOperador();
                            System.out.print("Ingrese una opcion:");
                            entrada = sc.nextLine();
                            switch (entrada) {
                                case "1":
                                    o.registrarPago();
                                    break;
                                case "2":
                                    o.consultarMulta();
                                    break;
                                case "3":
                                    o.consultarUsuarios();
                                    break;
                                case "4":
                                    System.out.println("Que tenga buen dia");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        } while (!entrada.equals("4"));
                         break;
                    }
                   
                }

            }
        }
    }
    
} 



