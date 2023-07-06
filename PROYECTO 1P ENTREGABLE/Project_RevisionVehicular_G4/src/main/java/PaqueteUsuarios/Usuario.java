 
package PaqueteUsuarios;

import PaquetesEnum.UsuarioPerfil;


public class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasenia;
    private String perfil;
    
    //CONTRUCTORES


  

    public Usuario(String cedula, String nombre, String apellido, int edad,String usuario, String contrasenia, String perfil) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.perfil=perfil;
    }
    
    
    // Implementacion de los getters ands setters
    
     public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

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
    

    @Override
    public String toString() {
        return cedula + " " + nombre + " " + apellido + " " + edad + " " + correo + " " + usuario + " " + contrasenia + " " + perfil ;
    }
    
    
   
    public void consultarMulta(){
        
    }
    
    
        
}
   