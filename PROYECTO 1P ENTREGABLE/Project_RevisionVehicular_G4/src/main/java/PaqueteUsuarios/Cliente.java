
package PaqueteUsuarios;
import static Interfaz.SistemaVehicular.*;
import java.util.ArrayList;
import java.util.Arrays;
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
                        
            }
        }
        System.out.println("TOTAL A PAGAR: " + valortotal);
        System.out.println(" ");
        System.out.println("PARA PAGAR PUEDE ACCEDER A LA AGENCIA MAS CERCANA.");
        
        
    }
    
    // METODO AGENDAR REVISION. NOTA " TODAVIA FALTA DE MODIFICAR COSAS ";
    public void agendarRevision(){
        System.out.println("*********************************************************");
        System.out.println("*                   AGENDAR REVISION                    *");
        System.out.println("*********************************************************");
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite su numero de placa por favor: ");
        String placa = sc.nextLine();
        System.out.println("No tiene multas.");
        System.out.println(" ");
        System.out.println("             Horarios disponibles               ");
        System.out.println("1. 10-06-2023    09:00");
        System.out.println("2. 10-06-2023    11:00");
        System.out.println("3. 10-06-2023    13:00");
        System.out.println("4. 10-06-2023    15:00");
        System.out.println("5. 11-06-2023    09:30");
        System.out.println("6. 11-06-2023    12:00");
        System.out.println("7. 11-06-2023    16:30");
        System.out.println("8. 15-06-2023    09:00");
        System.out.println("9. 15-06-2023    10:30");
        System.out.println("10. 15-06-2023    15:30");
        System.out.println("11. 18-06-2023    09:00");
        System.out.println("12. 19-06-2023    09:00");
        System.out.println("13. 19-06-2023    12:15");
        System.out.println("14. 19-06-2023    17:30");
        System.out.println("15. 20-06-2023    10:20");
        System.out.println("");
        System.out.print("Elija un horario para la revision: ");
        int horario = sc.nextInt();
        sc.nextLine();
        double valRevision = 150.0;
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                for(Usuario u:usuarios){
                    if(v.getDuenho().equals(u.getCedula())&& u.getPerfil().equals('S')){
                        for (Multa m: listaMultas){
                            valRevision = valRevision +(m.getPuntos()*10);
                        }
                    }else if (v.getDuenho().equals(u.getCedula())&& u.getPerfil().equals('E')){
                        valRevision = valRevision - (valRevision*0.2);
                    }
                    
                }       
            }

        
        System.out.println("");
        System.out.println("*******************************************************************************************");
        System.out.println(v.getDuenho() + " ,se ha agendado su cita para el " + horario);
        System.out.println("Valor a pagar: " + valRevision);
        System.out.println("Puede pagar su cita hasta 24 horas antes de la cita. De lo contrario la cita se cancelara.");
        System.out.println("*******************************************************************************************");
        }
                                
    }
               
    @Override
    public String toString() {
        return super.getCedula()+" "+super.getNombre()+" "+ super.getApellido()+" " + super.getEdad()+ " " +super.getUsuario()+" "+super.getContrasenia()+" "+numTarjeta+" "+ puntosLicencia +" "+super.getPerfil() ;
    }
    
 
    
    
    
  
}
    
   
    

    
        
    
    
    
  
  
    

