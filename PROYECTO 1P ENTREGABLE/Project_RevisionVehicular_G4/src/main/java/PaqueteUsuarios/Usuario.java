 
package PaqueteUsuarios;

import PaquetesEnum.UsuarioPerfil;


public abstract class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasenia;
    private int numTarjeta;
    private int puntosLicencia;

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public int getPuntosLicencia() {
        return puntosLicencia;
    }

    public void setPuntosLicencia(int puntosLicencia) {
        this.puntosLicencia = puntosLicencia;
    }
    
    //CONTRUCTORES

  

    public Usuario(String usuario, String contrasenia, int puntosLicencia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.puntosLicencia = puntosLicencia;
    }
    
    

    public Usuario(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
    // Implementacion de los getters ands setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
   // Metodo abstracto;
    
    public abstract void consultarMulta();
    
    
        
}
   