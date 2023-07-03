
package PaqueteUsuarios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import manejoArchivos.*;

public class Operador extends Usuario {
    
    private int sueldo;
    private ArrayList listaClientes;
    
    // contructor de la clase;
    
    /*
    revisar bien este contructor para saber si es necesario que este resiva ese array de listaClientes
    
    */

    public Operador(String usuario, String contrasenia, int puntosLicencia, int sueldo, ArrayList listaClientes) {
        super(usuario, contrasenia, puntosLicencia);
        this.sueldo = sueldo;
        this.listaClientes = listaClientes;
    }
    
    // metodos getters and setters

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    @Override
    public void consultarMulta(){
        
        System.out.println("HOLA SOY OPERADOR");  // ESTE TBN ES UN EJEMPLO NOMAS
        
    }
    
    public void registrarPago(){
        Random r = new Random ();
        int aleatorio = r.nextInt(500000000);
        String codigoPago= String.valueOf(aleatorio);
        Scanner sc = new Scanner (System.in);
        System.out.println("********************************************************");
        System.out.println("*                   REGISTRAR PAGO                     *");
        System.out.println("********************************************************");
        System.out.println("");
        System.out.println("¿ Que desea pagar ?"+"\n1. Multas"+"\n2. Revision");
        System.out.println("");
        System.out.print("Elija una opcion: ");
        int transaccion = sc.nextInt();
        sc.nextLine();
        System.out.println("¿ Que modo de pago va a usar ?"+"\n1. Efectivo"+"\n2. Tarjeta de credito");
        System.out.println("");
        System.out.print("Elija una opcion: ");
        int tipoPago = sc.nextInt();
        sc.nextLine();
        System.out.print("Por favor digite su numero de cedula: ");
        String cedu=sc.nextLine();
        
        if (transaccion == 1 && tipoPago == 1){
            System.out.print("Valor a pagar: ");
            double monto=sc.nextInt();
            //String converMonto = Double.valueOf(monto);
            sc.nextLine();
            
            System.out.println("¿ Desea proceder con el pago ?"+"\n1. Si"+"\n2. No");
            System.out.print("Elija una opcion: ");
            int confirmacion = sc.nextInt();
            sc.nextLine();
            if (confirmacion == 1){
                System.out.println("*********************************************************");
                System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                System.out.println("*********************************************************");
                
                ManejoArchivos.EscribirArchivo("pagos.txt",(codigoPago+" "+cedu+" "+monto+" "+'E'+" "+monto+" "+"MULTA")); 
            }else
                System.out.println("Error de transaccion");
   
        }
        else if (transaccion == 1 && tipoPago == 2){
            
            System.out.print("Valor a pagar: ");
            double monto=sc.nextInt();
            double montoFinal = monto+(monto*0.1);
            System.out.println("Su pago final es de: "+montoFinal);
            
            System.out.println("¿ Desea proceder con el pago ?"+"\n1. Si"+"\n2. No");
            System.out.print("Elija una opcion: ");
            int confirmacion = sc.nextInt();
            sc.nextLine();
            if (confirmacion == 1){
                System.out.println("*********************************************************");
                System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                System.out.println("*********************************************************");
                
                ManejoArchivos.EscribirArchivo("pagos.txt",(codigoPago+" "+cedu+" "+monto+" "+'T'+" "+montoFinal+" "+"MULTA")); 
            }else
                System.out.println("Error de transaccion");
        
        }    
        else if (transaccion == 2 && tipoPago == 1){
            
            System.out.print("Valor a pagar: ");
            double monto=sc.nextInt();
            //double montoFinal = monto+(monto*0.1);
            //System.out.println("Su pago final es de: "+montoFinal);
            sc.nextLine();
            System.out.println("¿ Desea proceder con el pago ?"+"\n1. Si"+"\n2. No");
            System.out.print("Elija una opcion: ");
            int confirmacion = sc.nextInt();
            sc.nextLine();
            if (confirmacion == 1){
                System.out.println("*********************************************************");
                System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                System.out.println("*********************************************************");
                
                ManejoArchivos.EscribirArchivo("pagos.txt",(codigoPago+" "+cedu+" "+monto+" "+'E'+" "+monto+" "+"REVISION")); 
            }else
                System.out.println("Error de transaccion");
            
        }
        else if (transaccion == 2 && tipoPago == 2){
            
            System.out.print("Valor a pagar: ");
            double monto=sc.nextInt();
            double montoFinal = monto+(monto*0.1);
            System.out.println("Su pago final es de: "+montoFinal);
            System.out.println("¿ Desea proceder con el pago ?"+"\n1. Si"+"\n2. No");
            System.out.print("Elija una opcion: ");
            int confirmacion = sc.nextInt();
            sc.nextLine();
            if (confirmacion == 1){
                System.out.println("*********************************************************");
                System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                System.out.println("*********************************************************");
                
                ManejoArchivos.EscribirArchivo("pagos.txt",(codigoPago+" "+cedu+" "+monto+" "+'T'+" "+montoFinal+" "+"REVISION")); 
            }else
                System.out.println("Error de transaccion");
            
        }
        
        
       
        
    }
    
    public void consultarUsuario(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
