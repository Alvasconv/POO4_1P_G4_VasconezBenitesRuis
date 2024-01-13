
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
     *
     * @param usuarioDatos UsuariosDatos del cliente.
     * @param usuario nick del sistema de cliente.
     * @param contrasenia contraseña del sistema de cliente.
     * @param numTarjeta numero de tarjeta del cliente.
     * @param puntosLicencia puntos de licencia del cliente.
     * @param perfil tipo de perfil del Usuario
     * 
     */

    public Cliente(UsuarioDatos usuarioDatos ,String usuario, String contrasenia, String numTarjeta,int puntosLicencia, String perfil) {
        super(usuarioDatos, usuario, contrasenia,perfil);
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
        bannerDetallesConsulta();
        double valortotal = calcularPagoMultasdeUsuario(sc.nextLine());
        System.out.println("TOTAL A PAGAR: " + valortotal);
        System.out.println(" ");
        System.out.println("PARA PAGAR PUEDE ACCEDER A LA AGENCIA MAS CERCANA.");
    }

    public void bannerDetallesConsulta(){
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                 DETALLE DE MULTAS                                                            |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR | FECHA DE INFRACCION | FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
    }

    public double calcularPagoMultasdeUsuario(String cedula){
        double valortotal  = 0;
        for (Multa mult : listaMultas) {
            boolean validacionCedula  = cedula.equals(mult.getCedula());
            if (validacionCedula) {
                System.out.println(mult.getCedula()+" | "+ mult.getPlaca()+ " | " + mult.getInfraccion()+
                        " | " + mult.getValor() +" | "+new SimpleDateFormat("dd-MM-yyyy").format(mult.getFechaInfraccion()) +
                        " | " + new SimpleDateFormat("dd-MM-yyyy").format(mult.getFechaNotificacion()) + " | "+mult.getPuntos());
                valortotal += mult.getValor();
            }}
        return valortotal;
    }




    
    /**
     * Este metodo le permite a un usuario de tipo cliente agendar revision
     * para un vehiculo, ingresa la placa del vehiculo, escoge uno de los horarios
     * disponibles y muestra por pantalla un resumen de la reserva.
     */

    public void agendarRevision(){
        String codigoRevision= generarCodigoRevision();
        mensajeAgendarRevision();
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite su numero de placa por favor: ");
        String placa = sc.nextLine();
        if(tieneMultas(placa)){
            System.out.println("Lo sentimos, no puede realizar este proceso debido a que cuenta con una o mas multas vigentes.");
            System.out.println("Por favor acerquese con un operador para poder realizar el pago correspondiente.");
        }
        else{
            System.out.println("No tiene multas.");
            System.out.println(" ");
            mostrarHorariosDisponibles();
            int horario = elegirHorario();
            //variables predefinidas
            String nombreDuenho= obtenerNombreDueno(placa);
            String cedulaU= obtenerCedulaDuenho(placa);
            double valRevision =  calcularValorRevision(placa);
            String[] fechaSolicitada = horarios[horario-1].split("/");
            Date fechaSolici = obtenerFechaSolicitada(fechaSolicitada);
            String facturaRevision= (codigoRevision+","+cedulaU+","+placa+ ","+fechaSolicitada[0]+","+valRevision);
            Revision revision = new Revision(codigoRevision,cedulaU,placa, fechaSolici,valRevision);
            revisiones.add(revision);
            ManejoArchivos.EscribirArchivo("AgendaRevisiones.txt",facturaRevision);
            mostrarInformacion(nombreDuenho,valRevision,fechaSolicitada);
            }
        }
    private void mensajeAgendarRevision(){
        System.out.println("*********************************************************");
        System.out.println("*                   AGENDAR REVISION                    *");
        System.out.println("*********************************************************");
    }
    private String generarCodigoRevision(){
        return String.valueOf((int)(Math.random()*5000000+1000000));
    }
    private int elegirHorario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Elija un horario para la revision: ");
        return sc.nextInt();
    }
    private boolean tieneMultas(String placa) {
        for (Multa mult : listaMultas) {
            if (placa.equalsIgnoreCase(mult.getPlaca())) {
                return true;
            }
        }
        return false;
    }
    private void mostrarHorariosDisponibles(){
        System.out.println("             Horarios disponibles               ");
        int contador=1;
        for(String dates:horarios){
            String[] fechas = dates.split("/");
            System.out.println(contador+".    "+fechas[0]+"      " + fechas[1]);
            contador++;
        }
    }

    private double calcularValorRevision(String placa) {
        double valRevision = 150.0;
        for (Vehiculo v : lvehiculos) {
            boolean validarPlaca = v.getPlaca().equalsIgnoreCase(placa);
            if (validarPlaca) {
                for (Usuario u : lusuarios) {
                    boolean validarCedula =  v.getDuenho().equalsIgnoreCase(u.usuarioDatos().getCedula());
                    if (validarCedula) {
                        Cliente cl = (Cliente) u;
                        if (u.getPerfil().equalsIgnoreCase("S")) {
                            valRevision = valRevision + ((30 - cl.getPuntosLicencia()) * 10);
                        }
                        if (u.getPerfil().equalsIgnoreCase("E")) {
                            valRevision = valRevision - (valRevision * 0.2);
                        }
                    }
                }
            }
        }
        return valRevision;
    }
    private Date obtenerFechaSolicitada(String[] fechaSolicitada) {
        DateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaSolici = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(formato.parse(fechaSolicitada[0]));
            fechaSolici = cal.getTime();
        } catch (ParseException except) {
            except.printStackTrace();
        }
        return fechaSolici;
    }
    private String obtenerNombreDueno(String placa){
        for (Vehiculo v : lvehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                for (Usuario u : lusuarios) {
                    if (v.getDuenho().equalsIgnoreCase(u.usuarioDatos().getCedula())) {
                        return u.usuarioDatos().getNombre() + " " + u.usuarioDatos().getApellido();
                    }
                }
            }
        }
        return null;
    }
    private String obtenerCedulaDuenho(String placa) {
        for (Vehiculo v : lvehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                for (Usuario u : lusuarios) {
                    if (v.getDuenho().equalsIgnoreCase(u.usuarioDatos().getCedula())) {
                        return u.usuarioDatos().getCedula();
                    }
                }
            }
        }
        return null;
    }
    private void mostrarInformacion(String nombreDuenho, double valRevision,String[] fechaSolicitada){
        System.out.println("");
        System.out.println("*******************************************************************************************");
        System.out.println(nombreDuenho+ " ,se ha agendado su cita para el " + fechaSolicitada[0]);
        System.out.println("Valor a pagar: " + valRevision);
        System.out.println("Puede pagar su cita hasta 24 horas antes de la cita. De lo contrario la cita se cancelara.");
        System.out.println("*******************************************************************************************");
    }




    @Override
    public String toString() {
        return super.usuarioDatos().getCedula()+" "+super.usuarioDatos().getNombre()+" "+ super.usuarioDatos().getApellido()+" " + super.usuarioDatos().getEdad()+ " " +super.getUsuario()+" "+super.getContrasenia()+" "+numTarjeta+" "+ puntosLicencia +" "+super.getPerfil() ;
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