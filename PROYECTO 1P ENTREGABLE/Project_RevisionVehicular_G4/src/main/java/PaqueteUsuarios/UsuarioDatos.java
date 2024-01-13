package PaqueteUsuarios;

public class UsuarioDatos {
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;


    public UsuarioDatos(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }



    @Override
    public String toString() {
        return cedula + " " + nombre + " " + apellido + " " + edad;
    }

}
