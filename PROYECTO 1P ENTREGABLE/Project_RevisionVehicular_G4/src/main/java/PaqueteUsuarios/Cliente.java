
package PaqueteUsuarios;

import manejoArchivos.Vehiculo;

public class Cliente extends Usuario {
    
    private Vehiculo vehiculo;
    private String tipoCliente;
    public boolean multa;
    
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
        System.out.println("HOLA SOY CLIENTE"); // ESTE ES UN EJEMPLO NOMAS
        
    }
    
    public void descuentoPagoMultas(){
        
    }
    
    public void agendarRevision(){ // aqui si tiene que retorna algo segun lo que nosotros indicamos en el proyecto XD
        
    }
    
    public void pagarMulta(){
        
    }
    
    
    
    
    
    
}
