
package PaqueteUsuarios;
import static Interfaz.SistemaVehicular.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;
import manejoArchivos.*;
//import static manejoArchivos.ManejoArchivos.LeeFichero;
//import manejoArchivos.Multa;
//import manejoArchivos.Vehiculo;

public class Cliente extends Usuario {
    
    private Vehiculo vehiculo;
    private String numTarjeta;
    private int puntosLicencia;
    public boolean multa = true;
    public static ArrayList <Revision> revisiones=new ArrayList<>();
    

    
    //constructor de la clase cliente

    public Cliente(String cedula, String nombre, String apellido, int edad,String usuario, String contrasenia, String numTarjeta,int puntosLicencia, String perfil) {
        super(cedula, nombre,  apellido, edad, usuario, contrasenia,perfil);
        this.numTarjeta= numTarjeta;
        this.puntosLicencia = puntosLicencia;
        
    }
    
    // metodos getters and setters

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }
    
    // METODO CONSULTAR MULTA PARA EL CLIENTE
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
                        
//            }else{
//                System.out.println("USTED NO POSEE MULTAS");
//                break;
            }
            
        }
        System.out.println("TOTAL A PAGAR: " + valortotal);
        System.out.println(" ");
        System.out.println("PARA PAGAR PUEDE ACCEDER A LA AGENCIA MAS CERCANA.");
        
        
    }
    
    // METODO AGENDAR REVISION. NOTA " TODAVIA FALTA DE MODIFICAR COSAS ";
    public void agendarRevision(){
        String horarioSeleccionado= null;
        String codigoRevision= String.valueOf((int)(Math.random()*5000000+1000000));
        System.out.println("*********************************************************");
        System.out.println("*                   AGENDAR REVISION                    *");
        System.out.println("*********************************************************");

        // creo una lista con 20 fechas para que el usurio elija una
        ArrayList <String> horarios = new ArrayList <>();
        int numeroFechas = 20;
        for (int i = 0; i < numeroFechas; i++) {
            String numopcion= String.valueOf(i+1);
            String hora= String.valueOf((int)(Math.random()*12+1));
            String minuto=String.valueOf((int)(Math.random()*59+10));
            String anio= "2023";
            String mes = String.valueOf((int)(Math.random()*12+1));
            String dia= String.valueOf((int)(Math.random()*31+1));
            String turno = numopcion+". "+dia+"-"+mes+"-"+anio+"   "+hora+":"+minuto;
            horarios.add(turno);
        }
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite su numero de placa por favor: ");
        String placa = sc.nextLine();
        placa = placa.toUpperCase();
        double valRevision = 150.0;
        int puntosMul=0;
        ArrayList<String> bool=new ArrayList<>();
        boolean tieneMulta=false;
        for (Multa m: listaMultas){
            if (m.getPlaca().equals(placa)){
                puntosMul+=m.getPuntos();
                String x="S";
                bool.add(x);
            }else{
                String x="N";
                bool.add(x);
            }
        }
        for(String s:bool){
            if(s.equals("S")){
            tieneMulta=true;
            break;
            }
        }
        if(tieneMulta){
                System.out.println("Usted posee multas pendientes, por favor acercarse a pagar");
                
        }else{
 
                System.out.println("No tiene multas.");
                System.out.println(" ");
                System.out.println("              Horarios disponibles               ");
                for ( String t : horarios){
                    System.out.println(t);
                }
                System.out.println(" ");
                System.out.print("Elija un horario para la revision: ");
                int horario = sc.nextInt();
                sc.nextLine();
                
                horarioSeleccionado= horarios.get(horario-1);
        
                // estos atributos son para mi objeto de tipo revision
                String name="null";
                String identifi ="null";
                String matricula="null";
                
                for (Vehiculo v : vehiculos) {
                    if (v.getPlaca().equalsIgnoreCase(placa)) {
                        String id= v.getDuenho();
                        identifi=id;
                        matricula=v.getPlaca();
                        for (Usuario u : usuarios) {
                            if (id.equals(u.getCedula()) && u.getPerfil().equals("S")) {
                                valRevision = valRevision + (puntosMul * 10);
                                name= u.getNombre()+" "+u.getApellido();
                                
                            } else if (id.equals(u.getCedula()) && u.getPerfil().equals("E")) {
                                valRevision = valRevision - (valRevision * 0.2);
                                name= u.getNombre()+" "+u.getApellido();
                            }

                        }
                    }
                }   
                
                System.out.println("******************************************************************************************");
                System.out.println(name+", se ha agendado su cita para el horario "+horarioSeleccionado);
                System.out.println("Valor a pagar: "+valRevision);
                System.out.println("Puede pagar su cita hasta 24 horas antes de la cita.");
                System.out.println("De lo contrario la cita se cancelara.");
                System.out.println("******************************************************************************************");
                String ticketRevision= codigoRevision+","+identifi+","+matricula+","+horarioSeleccionado+","+valRevision;
                Revision review = new Revision (codigoRevision,identifi,matricula,horarioSeleccionado,valRevision);
                revisiones.add(review);
                ManejoArchivos.EscribirArchivo("AgendaRevisiones.txt",ticketRevision);
            }
        
        }
                         

        
    @Override
    public String toString() {
        return super.getCedula()+" "+super.getNombre()+" "+ super.getApellido()+" " + super.getEdad()+ " " +super.getUsuario()+" "+super.getContrasenia()+" "+numTarjeta+" "+ puntosLicencia +" "+super.getPerfil() ;
    }
    
     public void MostrarMenuUsuario(){
         System.out.println("|--------- MENU CLIENTES -------|");
        System.out.println("1.Consultar Multas");
        System.out.println("2.Agendar revision tecnica");
        System.out.println("3.Salir");
        
    }
 
    
    
    
  
}
    
   
    

    
        
    
    
    
  
  
    

