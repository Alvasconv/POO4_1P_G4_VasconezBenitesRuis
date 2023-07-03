
package PaqueteUsuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;
import static manejoArchivos.ManejoArchivos.LeeFichero;
import manejoArchivos.Multa;
import manejoArchivos.Vehiculo;

public class Cliente extends Usuario {
    
    private Vehiculo vehiculo;
    private String tipoCliente;
    public boolean multa = true;
    
    
    
    //constructor de la clase cliente

    public Cliente(String usuario, String contrasenia, int puntosLicencia, Vehiculo vehiculo, String tipoCliente) {
        super(usuario, contrasenia, puntosLicencia);
        this.vehiculo = vehiculo;
        this.tipoCliente = tipoCliente;
    }
    
    // metodos getters and setters

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    @Override
    public void consultarMulta (){
        Scanner sc = new Scanner (System.in);
        System.out.println("Por favor favor digite cedula y placa del vehiculo");
        System.out.println("Ingrese cedula: ");
        String ci = sc.nextLine();
        System.out.println("Ingrese placa del vehiculo: ");
        String placa = sc.nextLine(); 
        ArrayList<String> lstMultas = ManejoArchivos.LeeFichero("multas.txt");
        double valortotal =0;
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("|                                                 DETALLE DE MULTAS                                                            |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("| CEDULA | MATRICULA | INFRACCION | VALOR A PAGAR | FECHA DE INFRACCION | FECHA DE INFRACCION | FECHA DE NOTIFICACION | PUNTOS |");
        System.out.println("|------------------------------------------------------------------------------------------------------------------------------|");
        for (String dato : lstMultas) {
            String[] elemento = dato.trim().split(",");
            // validamos si la cedula y placa ingresada estan en la lista de multas
            if (Arrays.asList(elemento).contains(ci) && Arrays.asList(elemento).contains(placa)) {

                for (int i = 0; i < elemento.length; i++) {
                    System.out.print(elemento[i] + " | ");
                }

                for (int i = 0; i < elemento.length; i++) {
                    if (i == 3) {
                        valortotal += Double.valueOf(Arrays.asList(elemento).get(i));

                    }
                }
            }
        } 
        
        System.out.println("TOTAL A PAGAR: " + valortotal);
        System.out.println(" ");
        System.out.println("PARA PAGAR PUEDE ACCEDER A LA AGENCIA MAS CERCANA.");
        
    }
    
    
    
    public void agendarRevision(){
        System.out.println("*********************************************************");
        System.out.println("*                   AGENDAR REVISION                    *");
        System.out.println("*********************************************************");
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite su cedula por favor: ");
        String cedula = sc.nextLine();
        ArrayList<String> datos = ManejoArchivos.LeeFichero("pagos.txt");
        for (String linea : datos) {
            String[] elementos = linea.trim().split(",");
            if (Arrays.asList(elementos).contains(cedula)&&(Arrays.asList(elementos).get(5).equals("MULTA"))){
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
                int horario=sc.nextInt();
                sc.nextLine();
                double valRevision=150.0;
                ArrayList<String> dato = ManejoArchivos.LeeFichero("usuarios.txt");
                for (String p: dato ){
                    String[] elemen = p.trim().split(",");
                    if (Arrays.asList(elemen).contains(cedula)){
                        if(elemen[6].equals('E')){
                            valRevision = valRevision-(valRevision*0.2);
                            
                        }if(elemen[6].equals('S')){
                            ArrayList<String> dato3 = ManejoArchivos.LeeFichero("multas.txt");
                            for (String dat: dato3 ){
                                String[] puntos = dat.trim().split(",");
                                if (Arrays.asList(puntos).contains(cedula)){
                                    valRevision = valRevision+(Integer.valueOf(puntos[6])*10);
                                }
                                
                        }
                    }
                }
                ArrayList<String> d = ManejoArchivos.LeeFichero("usuarios.txt");
                for (String name: d ){
                    String[] e = name.trim().split(",");
                    if (Arrays.asList(e).contains(cedula)){
                        String nombreCliente=e[1];
                         System.out.println("");
                        System.out.println("*******************************************************************************************");
                        System.out.println(nombreCliente+" ,se ha agendado su cita para el "+horario);
                        System.out.println("Valor a pagar: "+valRevision);
                        System.out.println("Puede pagar su cita hasta 24 horas antes de la cita. De lo contrario la cita se cancelara.");
                        System.out.println("*******************************************************************************************");
                    
                    
                    }
                
                }
               
                
                
                
                
                
                
                
            }
            
        
        
        }
        
    }        
    }
    
}
    
   
    

    
        
    
    
    
  
  
    

