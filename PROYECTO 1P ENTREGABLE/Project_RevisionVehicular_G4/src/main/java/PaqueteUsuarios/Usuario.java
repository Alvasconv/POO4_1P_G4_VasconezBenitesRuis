 
package PaqueteUsuarios;

//import PaquetesEnum.UsuarioPerfil;

/**
 * Usuario
 * @author Elias Benites
 */
public abstract class Usuario {

    private UsuarioDatos usuarioDatos;
    private String usuario;
    private String contrasenia;
    private String perfil;
    
    /**
     * Instancia Usuario
     *
     * @param usuarioDatos usuarioDatos informacion del usuario.
     * @param usuario nick usuaio sistema.
     * @param contrasenia contraseña sistema.
     * @param perfil tipo de usuario.
     */
    public Usuario(UsuarioDatos usuarioDatos,String usuario, String contrasenia, String perfil) {
        this.usuarioDatos = usuarioDatos;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
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

    public UsuarioDatos usuarioDatos(){
        return usuarioDatos;
    }

    /**
     * Getter usuario.
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
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
        return usuarioDatos.toString()+ " " + usuario + " " + contrasenia + " " + perfil ;
    }
    
    /**
     * Metodo abstracto para consultar multas
     */
    public abstract void consultarMulta();
            
}