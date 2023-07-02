
package PaqueteUsuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;
import manejoArchivos.Vehiculo;

public class Cliente extends Usuario {
    
    private Vehiculo vehiculo;
    private String tipoCliente;
    public boolean multa ;
    
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
    
    
    public void descuenPagoMultas(){
        
        
    }
    
    public void agendarRevision(){ // aqui si tiene que retorna algo segun lo que nosotros indicamos en el proyecto XD
        
    }
    
    public void pagarMulta(){
       
        
        
        
    }
    
    
    
    
    
    
}
