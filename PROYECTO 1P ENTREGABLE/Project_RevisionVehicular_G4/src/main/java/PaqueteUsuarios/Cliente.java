
package PaqueteUsuarios;
import static Interfaz.SistemaVehicular.*;
import java.util.ArrayList;
import java.util.Scanner;
import manejoArchivos.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import java.util.Calendar;
import PaquetesEnum.*;
import Interfaz.SistemaVehicular;
/**
 * Representa un ususario de tipo cliente.
 * 
 * @author Alex Benites
 */
public class Cliente extends Usuario {
    
    private Vehiculo vehiculo;
    private String numTarjeta;
    private int puntosLicencia;
    /**
     * Lista de objetos tipo Revision.
     */
    public static ArrayList <Revision> revisiones=new ArrayList<>();

    ArrayList<Vehiculo> lvehiculos = SistemaVehicular.vehiculos;
    ArrayList<Usuario> lusuarios = SistemaVehicular.usuarios;
    String[] horarios = {"10-06-2023/09:00","10-06-2023/11:00","10-06-2023/13:00",
                "10-06-2023/13:00","10-06-2023/15:00","11-06-2023/09:30","11-06-2023/12:30",
                "11-06-2023/16:30","15-06-2023/09:00","15-06-2023/10:30","15-06-2023/15:30","18-06-2023/09:00",
            "19-06-2023/09:00","19-06-2023/12:15","19-06-2023/17:30","20-06-2023/10:20"};
    
    /**
     * Constructor de la clase cliente.Instancia objetos tipo Cliente.
     * @param cedula cedula del cliente.
     * @param nombre nombre del cliente.
     * @param apellido apellido del cliente.
     * @param edad edad del cliente.
     * @param usuario nick del sistema de cliente.
     * @param contrasenia contraseña del sistema de cliente.
     * @param numTarjeta numero de tarjeta del cliente.
     * @param puntosLicencia puntos de licencia del cliente.
     * @param perfil tipo de perfil del Usuario
     * 
     */

    public Cliente(String cedula, String nombre, String apellido, int edad,String usuario, String contrasenia, String numTarjeta,int puntosLicencia, String perfil) {
        super(cedula, nombre,  apellido, edad, usuario, contrasenia,perfil);
        this.numTarjeta= numTarjeta;
        this.puntosLicencia = puntosLicencia;    
    }
    
    /**
     * Getter de atributo Vehiculo.
     * @return Vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Getter de atributo numTarjeta.
     * @return numTarjeta
     */
    public String getNumTarjeta() {
        return numTarjeta;
    }

    /**
     * Getter de atributo puntosLicencia.
     * @return puntosLicencia
     */
    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    /**
     * Este metodo le permite a un usuario de tipo cliente ingresar una cedula
     * para revisar las multas que tiene ese cliente.
     */
    @Override
    public void consultarMulta (){
        Scanner sc = new Scanner (System.in);
        System.out.println("Por favor ingrese su cedula");
        System.out.println("Ingrese cedula: ");
        String ci = sc.nextLine();
        double valortotal =0;
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                 DETALLE DE MULTAS                                                            |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR | FECHA DE INFRACCION | FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        for (Multa mult : listaMultas) {
            // validamos si la cedula ingresada esta en la lista de multas
            if (ci.equals(mult.getCedula())) {
                System.out.println(mult.getCedula()+" "+ mult.getPlaca()+ " " + mult.getInfraccion()+ " " + mult.getValor() +" "+mult.getFechaInfraccion() + " " + mult.getFechaNotificacion() + " "+mult.getPuntos());
                valortotal += mult.getValor();
            }
            
        }
        System.out.println("TOTAL A PAGAR: " + valortotal);
        System.out.println(" ");
        System.out.println("PARA PAGAR PUEDE ACCEDER A LA AGENCIA MAS CERCANA.");
        
        
    }
    
    /**
     * Este metodo le permite a un usuario de tipo cliente agendar revision
     * para un vehiculo, ingresa la placa del vehiculo, escoge uno de los horarios
     * disponibles y muestra por pantalla un resumen de la reserva.
     */
    public void agendarRevision(){

        String codigoRevision= String.valueOf((int)(Math.random()*5000000+1000000));
        System.out.println("*********************************************************");
        System.out.println("*                   AGENDAR REVISION                    *");
        System.out.println("*********************************************************");
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite su numero de placa por favor: ");
        String placa = sc.nextLine();
        boolean debeMulta=false;
        
        for (Multa mult : listaMultas) {
            // validamos si la placa ingresada esta en la lista de multas
            if (placa.equalsIgnoreCase(mult.getPlaca())) {
                System.out.println("Lo sentimos, no puede realizar este proceso debido a que cuenta con una o mas multas vigentes.");
                System.out.println("Por favor acerquese con un operador para poder realizar el pago correspondiente.");
                debeMulta=true;
                break;
            }
        }
        
        //Si el cliente no tiene multa se sigue el proceso de agendar Revision
        if(debeMulta==false){
            
            System.out.println("No tiene multas.");
            System.out.println(" ");
            System.out.println("             Horarios disponibles               ");
            
            //for para mostrar los horarios disponibles para la revision
            int contador=1;
            for(String dates:horarios){
              String[] fechas = dates.split("/");
              System.out.println(contador+".    "+fechas[0]+"      " + fechas[1]);
              contador++;
            }
            System.out.print("Elija un horario para la revision: ");
            int horario = sc.nextInt();
            sc.nextLine();
            //variables predefinidas
            double valRevision = 150.0;
            String nombreDuenho=null;
            String cedulaU=null ;
            
            //Busca vehiculo para accceder a los datos del dueño/usuario
            for (Vehiculo v : lvehiculos) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    for(Usuario u:lusuarios){
                        //compara la cedula de cada usuario buscando la igual a la 
                        //ced. del dueño del vehiculo con la misma placa
                        if(v.getDuenho().equalsIgnoreCase(u.getCedula())){
                            nombreDuenho=u.getNombre()+" "+u.getApellido();
                            cedulaU = u.getCedula();
                            Cliente cl = (Cliente)u;
                            //Dependiendo el tipo de cliente se le asignara un valor a pagar
                            if (u.getPerfil().equalsIgnoreCase("S")){
                                valRevision = valRevision +((30-cl.getPuntosLicencia())*10);
                            }
                            if (u.getPerfil().equalsIgnoreCase("E")){
                                valRevision = valRevision - (valRevision*0.2);
                            }
                        }                           
                    }
                }       
            }
            String[] fechaSolicitada = horarios[horario-1].split("/");
            
            //Crear Variable tipo Date para asignarlo en la clase Revision

            DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            Date fechaSolici = null;
            try {
            // instancia de util.Calendar
                Calendar cal = Calendar.getInstance();
            // Parsing date
              cal.setTime(formato.parse(fechaSolicitada[0]));
              fechaSolici = cal.getTime();
            }
            // Catch block to handle the exceptions
            catch (ParseException except) {

            // Excepcion usando printStackTrace() 
              except.printStackTrace();
            }
            String facturaRevision= (codigoRevision+","+cedulaU+","+placa+ ","+fechaSolici+","+valRevision);
            Revision revision = new Revision(codigoRevision,cedulaU,placa, fechaSolici,valRevision);
            revisiones.add(revision);
            ManejoArchivos.EscribirArchivo("AgendaRevisiones.txt",facturaRevision);
            
            System.out.println("");
            System.out.println("*******************************************************************************************");
            System.out.println(nombreDuenho+ " ,se ha agendado su cita para el " + fechaSolicitada[0]);
            System.out.println("Valor a pagar: " + valRevision);
            System.out.println("Puede pagar su cita hasta 24 horas antes de la cita. De lo contrario la cita se cancelara.");
            System.out.println("*******************************************************************************************");        
            }
    }
                          
    @Override
    public String toString() {
        return super.getCedula()+" "+super.getNombre()+" "+ super.getApellido()+" " + super.getEdad()+ " " +super.getUsuario()+" "+super.getContrasenia()+" "+numTarjeta+" "+ puntosLicencia +" "+super.getPerfil() ;
    }
    
    /**
    *Este metodo muestra por pantalla el menu de opciones que un usuario cliente
    * puede acceder al ingresar al sistema.
    **/ 
    public void MostrarMenuUsuario(){
        System.out.println("|--------- MENU CLIENTES -------|");
        System.out.println("1.Consultar Multas");
        System.out.println("2.Agendar revision tecnica");
        System.out.println("3.Salir");   
    }
}