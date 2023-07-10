 
package PaqueteUsuarios;

//import PaquetesEnum.UsuarioPerfil;

/**
 * Usuario
 * @author Elias Benites
 */
public abstract class Usuario {
    
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private String correo;
    private String usuario;
    private String contrasenia;
    private String perfil;
    
    /**
     * Instancia Usuario
     * @param cedula cedula.
     * @param nombre nombre.
     * @param apellido apellido.
     * @param edad edad.
     * @param usuario nick usuaio sistema.
     * @param contrasenia contraseña sistema.
     * @param perfil tipo de usuario.
     */
    public Usuario(String cedula, String nombre, String apellido, int edad,String usuario, String contrasenia, String perfil) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.perfil=perfil;
    }
    
    /**
     * Getter perfil.
     * @return perfil
     */
     public String getPerfil() {
        return perfil;
    }
     
    /**
     * Setter perfil.
     * @param perfil perfil
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * Getter cedula.
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Getter nombre.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter apellido.
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Getter usuario.
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }
    
    /**
     * Getter edad.
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Getter contrasenia.
     * @return contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    
    /**
     * Metodo toString.
     * @return String
     */
    @Override
    public String toString() {
        return cedula + " " + nombre + " " + apellido + " " + edad + " " + correo + " " + usuario + " " + contrasenia + " " + perfil ;
    }
    
    /**
     * Metodo abstracto para consultar multas
     */
    public abstract void consultarMulta();
            
}