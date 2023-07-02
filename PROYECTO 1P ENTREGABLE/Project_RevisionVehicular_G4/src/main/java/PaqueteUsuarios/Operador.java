
package PaqueteUsuarios;

import java.util.ArrayList;
import java.util.Scanner;

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
        
        if (transaccion == 1 && tipoPago == 1){
            System.out.print("Valor a pagar: ");
        }
        if (transaccion == 1 && tipoPago == 2){
            
        }
        
        
       
        
    }
    
    public void consultarUsuario(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
