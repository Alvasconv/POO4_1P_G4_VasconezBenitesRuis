/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Carlos
 */
public class Email {
    
    private String tipo;
    private String direccion;

    public Email(String tipo, String direccion) {
        this.tipo = tipo;
        this.direccion = direccion;
    }
    
    @Override
    public String toString(){
        return tipo + ":" + direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}
