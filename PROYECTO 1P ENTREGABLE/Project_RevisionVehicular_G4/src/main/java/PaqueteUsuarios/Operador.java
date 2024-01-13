
package PaqueteUsuarios;

import Interfaz.SistemaVehicular;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import manejoArchivos.*;
import static Interfaz.SistemaVehicular.*;
import static PaqueteUsuarios.Cliente.*;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 
 * @author Alex Benites
 */
public class Operador extends Usuario {
    private int sueldo;
   
    /**
     * Instancia un objeto de tipo operador
     * @param usuarioDatos datos del circuito.
     * @param usuario nick del sistema de cliente.
     * @param contrasenia contraseña del sistema de cliente.
     * @param sueldo sueldo del operador.
     * @param perfil perfil de usuario.
     */
    public Operador(UsuarioDatos usuarioDatos,String usuario, String contrasenia, int sueldo, String perfil) {
        super(usuarioDatos,usuario,contrasenia,perfil);
        this.sueldo = sueldo;

    }
    
    /**
     * Getter de sueldo
     * @return sueldo
     */
    public int getSueldo() {
        return sueldo;
    }

    /**
    *Este metodo le permite a un usuario de tipo operador consultar las multas
    * por mes.
    **/ 
    @Override 
    public void consultarMulta(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Ingrese un mes para consultar las multas: ");
        String mes = sc.nextLine();  // MAYO
        mes = mes.toUpperCase();
        
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                 CONDUCTORES MULTADOS DEL MES " + mes+ "                                           |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR | FECHA DE INFRACCION | FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        
        List meses = List.of("ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE");
   
        int ind = meses.indexOf(mes);
        for (Multa mult : listaMultas) {
            // validamos si la cedula y placa ingresada estan en la lista de multas
                int m = mult.getFechaInfraccion().getMonth();               
                if(m == ind){
                    String fechaInfraccion =new SimpleDateFormat("dd-MM-yyyy").format(mult.getFechaInfraccion());
                    String fechaNotificacion=new SimpleDateFormat("dd-MM-yyyy").format(mult.getFechaInfraccion());
                    System.out.println(mult.getCedula()+" | "+ mult.getPlaca()+ " | " + mult.getInfraccion()+ " | " + mult.getValor() +" | "+fechaInfraccion + " | " + fechaNotificacion + " | "+mult.getPuntos());
                }
           }
        System.out.println("No tiene multas");
        }

    /**
    *Este metodo le permite a un usuario de tipo operador registrar los pagos
    * de multas y revisiones de los clientes, con la cedula busca todas las deudas
    * de multas y revisiones.El usuario indica que pago realizar.
    **/ 
    public void registrarPago(){
        
        String codigoPago= String.valueOf((int)(Math.random()*500000000+100000000));
        Scanner sc = new Scanner (System.in);
        System.out.println("********************************************************");
        System.out.println("*                   REGISTRAR PAGO                     *");
        System.out.println("********************************************************");
        System.out.println("");
        System.out.print("Por favor digite numero de cedula: ");
        String cedu=sc.nextLine();
        double valorMulta = 0.0;
        for (Multa m: listaMultas){
            if (cedu.equals(m.getCedula())){
                valorMulta += m.getValor();
            }            
        }
        double valorRevision=0.0;
        for (Revision revi : revisiones){
             if(cedu.equals(revi.getCedula())){
                 valorRevision+=revi.getValoRevision();
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
                System.out.println("Valor final a pagar: " + valorMulta);
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");
                    String facturaPagoMulta= codigoPago+","+cedu+","+valorMulta+","+"E"+","+valorMulta+","+"MULTA";
                    ManejoArchivos.EscribirArchivo("pagos.txt", facturaPagoMulta);
//                  Al confirmarse el pago esta linea deberia eliminar ese objeto de la lista de multa
                    ArrayList<Multa> listaMultaCopia=new ArrayList<>();
                   for(int i =0;i<listaMultas.size();i++){
                       if(cedu.equals(listaMultas.get(i).getCedula())){
                           listaMultaCopia.add(listaMultas.get(i));
                       }
                   }
                   for(int i=0;i<listaMultaCopia.size();i++){
                       if(listaMultas.contains(listaMultaCopia.get(i))){
                           listaMultas.remove(listaMultaCopia.get(i));
                       }
                   }
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }
                else {
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }


            } else if (transaccion == 1 && tipoPago == 2) {   
                System.out.println("Valor a pagar: " + valorMulta);
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
                    String facturaPagoMulta= codigoPago+","+cedu+","+valorMulta+","+"T"+","+montoFinal+","+"MULTA";
                    ManejoArchivos.EscribirArchivo("pagos.txt", facturaPagoMulta);
                    //Al confirmarse el pago esta linea deberia eliminar el objeto tipo multa de la lista
                    ArrayList<Multa> listaMultaCopia=new ArrayList<>();
                    for(int i =0;i<listaMultas.size();i++){
                       if(cedu.equals(listaMultas.get(i).getCedula())){
                           listaMultaCopia.add(listaMultas.get(i));
                       }
                   }
                   for(int i=0;i<listaMultaCopia.size();i++){
                       if(listaMultas.contains(listaMultaCopia.get(i))){
                           listaMultas.remove(listaMultaCopia.get(i));
                       }
                   }
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                    
                } else {
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }

            } else if (transaccion == 2 && tipoPago == 1) {
                
                System.out.println("Valor a pagar: "+ valorRevision);
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");
                    String facturaRevision= codigoPago+","+cedu+","+valorRevision+","+"E"+","+valorRevision+","+"REVISION";
                    ManejoArchivos.EscribirArchivo("pagos.txt", facturaRevision);
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else {
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                }

            } else if (transaccion == 2 && tipoPago == 2) {

                System.out.println("Valor a pagar: "+valorRevision);
                double montoFinal = valorRevision + (valorRevision * 0.1);
                System.out.println("Su pago final es de: " + montoFinal);
                System.out.println("¿ Desea proceder con el pago ?" + "\n1. Si" + "\n2. No");
                System.out.print("Elija una opcion: ");
                int confirmacion = sc.nextInt();
                sc.nextLine();
                if (confirmacion == 1) {
                    System.out.println("*********************************************************");
                    System.out.println("Se ha realizado el pago. Ahora puede proceder a la revion");
                    System.out.println("*********************************************************");
                    String facturaRevision= codigoPago+","+cedu+","+valorRevision+","+"T"+","+montoFinal+","+"REVISION";
                    ManejoArchivos.EscribirArchivo("pagos.txt", facturaRevision);
                    System.out.println("¿ Desea realizar otros pagos ?"+"\nSi" + "\nNo");
                    System.out.println("Elija una opcion: ");
                    String rsta = sc.nextLine().toUpperCase();
                    continuarPago=rsta;
                } else{
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
        return super.usuarioDatos().getCedula()+" "+super.usuarioDatos().getNombre()+" "+
                super.usuarioDatos().getApellido()+" " + super.usuarioDatos().getEdad()+ " " +
                super.getUsuario()+" "+super.getContrasenia()+" "+sueldo+" "+super.getPerfil() ;
    }
    
    /**
    *Este metodo le permite a un usuario de tipo operador consultar los datos de
    * todos los usuarios.Muestra por pantalla el perfil y cedula de los clientes
    * y de los operadores el perfil y su sueldo.
    **/ 
    public void consultarUsuarios(){
        System.out.println("***********************************************");
        System.out.println("              CONSULTAR USUARIO                ");
        System.out.println("***********************************************");
        for(Usuario u:usuarios){
            String nom=u.usuarioDatos().getNombre();
            String perfil;
            String ced;
            switch (u.getPerfil()) {
                case "S":
                    perfil="Cliente Estandar";
                    ced=u.usuarioDatos().getCedula();
                    System.out.println(nom+" | "+perfil+" | "+ced);
                    break;
                case "E":
                    perfil="Cliente Estrella";
                    ced=u.usuarioDatos().getCedula();
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
    
    /**
    *Este metodo muestra por pantalla el menu de opciones que un usuario operador
    * puede acceder al ingresar al sistema.
    **/ 
    public void MostrarMenuOperador(){
        System.out.println("|-------------- Menu del Operador ------------|");
        System.out.println("1.Registar pagos");
        System.out.println("2.Consultar multas clientes");
        System.out.println("3.Consultar usuarios");
        System.out.println("4.Salir");
        
    }
    
    
  
    
}
