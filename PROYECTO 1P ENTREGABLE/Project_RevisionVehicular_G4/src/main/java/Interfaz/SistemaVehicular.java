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
import manejoArchivos.Multa;
import manejoArchivos.Vehiculo;
/**
 *
 * @author Julian Ruiz
 */
public class SistemaVehicular {
    ArrayList<Usuario> usuarios=new ArrayList<>();
    ArrayList<Vehiculo> vehiculos=new ArrayList<>();
    ArrayList<Multa> listaMultas=new ArrayList<>();

    
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
     
     
     public static void main (String[]args){
         
     }
}
