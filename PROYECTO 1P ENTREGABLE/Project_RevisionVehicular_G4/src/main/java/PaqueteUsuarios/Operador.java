
package PaqueteUsuarios;

import java.util.ArrayList;

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
        
    }
    
    public void consultarUsuario(){
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
