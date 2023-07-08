
package PaqueteUsuarios;

import Interfaz.SistemaVehicular;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import manejoArchivos.*;
import static Interfaz.SistemaVehicular.*;
import java.util.List;

public class Operador extends Usuario {
    
    private int sueldo;
   
    public Operador(String cedula, String nombre, String apellido, int edad,String usuario, String contrasenia, int sueldo, String perfil) {
        super(cedula,nombre,apellido,edad,usuario,contrasenia,perfil);
        this.sueldo = sueldo;
        
        
    }
    
    // metodos getters and setters

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    
    
    @Override
    public void consultarMulta(){
        System.out.println("***********************************************");
        System.out.println("               CONSULTAR MULTAS                ");
        System.out.println("***********************************************");
        Scanner sc=new Scanner (System.in);
        List meses=List.of("ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE");
        System.out.print("Ingrese el mes a consultar:");
        String mes=sc.nextLine();
        int ind=meses.indexOf(mes);
        for(Multa m:listaMultas){
            int m2=m.getFechaInfraccion().getMonth();
            if(m2==ind){
                System.out.println(m.getCedula()+"|"+m.getPlaca()+"|"+m.getInfraccion()+"|"+m.getValor()+"|"+m.getFechaInfraccion()+"|"+m.getFechaNotificacion()+"|"+m.getPuntos());
            }
        }
    }
    
    /* 
    CREACION DEL METODO REGISTRAR PAGO. NOTAA" FALTA DE HACER QUE A LO QUE REGISTRA EL PAGO LA MULTA DESAPARECE
    DE LA LISTA DE MULTAS
    */
    public void registrarPago(){
        Random r = new Random ();
        int aleatorio = r.nextInt(500000000);
        String codigoPago= String.valueOf(aleatorio);
        Scanner sc = new Scanner (System.in);
        System.out.println("********************************************************");
        System.out.println("*                   REGISTRAR PAGO                     *");
        System.out.println("********************************************************");
        System.out.println("");
        System.out.print("Por favor digite su numero de cedula: ");
        String cedu=sc.nextLine();
        double valorMulta = 0;
        for (Multa m: listaMultas){
            if (cedu.equals(m.getCedula())){
                valorMulta += m.getValor();
            }            
        }
        String continuarPago = "SI";
        while (continuarPago.equals("SI")){
            System.out.println("¿ Que desea pagar ?"+"\n1. Multas"+"\n2. Revision");
            System.out.println("");
            System.out.print("Elija una opcion: ");
            int transaccion = sc.nextInt();
            sc.nextLine();
            System.out.println("¿ Que modo de pago va a usar ?" + "\n1. Efectivo" + "\n2. Tarjeta de credito");
            System.out.println("");
            System.out.print("Elija una opcion: ");
            int tipoPago = sc.nextInt();
            sc.nextLine();
            if (transaccion == 1 && tipoPago == 1) {
                System.out.print("Valor final a pagar: " + valorMulta);
                sc.nextLine();
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");
                    ManejoArchivos.EscribirArchivo("pagos.txt", (codigoPago + " " + cedu + " " + valorMulta + " " + 'E' + " " + valorMulta + " " + "MULTA"));
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else {
                    System.out.println("Muchas gracias que tenga buen dia");
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }

            } else if (transaccion == 1 && tipoPago == 2) {
                System.out.print("Valor a pagar: " + valorMulta);
                double montoFinal = valorMulta + (valorMulta * 0.1);
                System.out.println("");
                System.out.println("Su pago final es de: " + montoFinal);
                System.out.println("");
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");
                    ManejoArchivos.EscribirArchivo("pagos.txt", (codigoPago + " " + cedu + " " + valorMulta + " " + 'T' + " " + montoFinal + " " + "MULTA"));
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else {
                    System.out.println("Muchas gracias que tenga buen dia");
                    System.out.println("Muchas gracias que tenga buen dia");
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }

            } else if (transaccion == 2 && tipoPago == 1) {

                System.out.print("Valor a pagar: ");
                double monto = sc.nextInt();
                sc.nextLine();
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");

                    ManejoArchivos.EscribirArchivo("pagos.txt", (codigoPago + " " + cedu + " " + monto + " " + 'E' + " " + monto + " " + "REVISION"));
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else {
                    System.out.println("Error de transaccion");
                    System.out.println("Muchas gracias que tenga buen dia");
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }

            } else if (transaccion == 2 && tipoPago == 2) {

                System.out.print("Valor a pagar: ");
                double monto = sc.nextInt();
                double montoFinal = monto + (monto * 0.1);
                System.out.println("Su pago final es de: " + montoFinal);
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");

                    ManejoArchivos.EscribirArchivo("pagos.txt", (codigoPago + " " + cedu + " " + monto + " " + 'T' + " " + montoFinal + " " + "REVISION"));
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else{
                    
                    System.out.println("Muchas gracias que tenga buen dia");
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
            
                }
         
        
          
           }
        }
        System.out.println("Muchas gracias. Que tenga buen dia");
        
        
       
        
    }
    @Override
    public String toString() {
        return super.getCedula()+" "+super.getNombre()+" "+ super.getApellido()+" " + super.getEdad()+ " " +super.getUsuario()+" "+super.getContrasenia()+" "+sueldo+" "+super.getPerfil() ;
    }
    
    public void consultarUsuarios(){
        System.out.println("***********************************************");
        System.out.println("              CONSULTAR USUARIO                ");
        System.out.println("***********************************************");
        for(Usuario u:usuarios){
            String nom=u.getNombre();
            String perfil;
            String ced;
            switch (u.getPerfil()) {
                case "S":
                    perfil="Cliente Estandar";
                    ced=u.getCedula();
                    System.out.println(nom+" | "+perfil+" | "+ced);
                    break;
                case "E":
                    perfil="Cliente Estrella";
                    ced=u.getCedula();
                    System.out.println(nom+" | "+perfil+" | "+ced);
                    break;
                default:
                    perfil="Operador";
                    Operador o=(Operador)u;
                    sueldo=o.getSueldo();
                    System.out.println(nom+" | "+perfil+" | "+sueldo);
                    break;
            }
        }
    }
    
    public void MostrarMenu(){
        System.out.println("1.Registar pagos");
        System.out.println("2.Consultar multas clientes");
        System.out.println("3.Consultar usuarios");
        System.out.println("4.Salir");
    }
    
    
  
    
}
