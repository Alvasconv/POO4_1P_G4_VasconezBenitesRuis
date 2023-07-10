/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;
import java.util.Date;

/**
 *Representa un amulta.
 * @author Angello Vasconez
 */
public class Multa {

    private String cedula;
    private String placa;
    private double valor;
    private int puntos;
    private String infraccion;
    private Date fechaInfraccion;
    private Date fechaNotificacion;

    /**
     * Instancia un objeto de tipo Multa.
     * @param cedula cedulad del cliente.
     * @param placa placa del vehiculo.
     * @param infraccion descripcion de la multa.
     * @param valor monto de la multa.
     * @param fechaInfraccion fecha cuando ocurrio la multa.
     * @param fechaNotificacion fecha cuando se notifico al duenho.
     * @param puntos puntos restados al duenho.
     */
    public Multa(String cedula,String placa,String infraccion,double valor,Date fechaInfraccion,Date fechaNotificacion,int puntos) {
        this.cedula = cedula;
        this.placa = placa;
        this.valor = valor;
        this.puntos = puntos;
        this.infraccion = infraccion;
        this.fechaInfraccion = fechaInfraccion;
        this.fechaNotificacion = fechaNotificacion;
    }
/**
 * Getter de cedula
 * @return cedula
 */
    public String getCedula() {
        return cedula;
    }

    /**
     * Getter de placa
     * @return placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Getter de valor de multa
     * @return valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * Getter de puntos 
     * @return puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Getter de infraccion
     * @return infraccion
     */
    public String getInfraccion() {
        return infraccion;
    }

    /**
     * Getter de fechaInfraccion
     * @return fechaInfraccion
     */
    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    /**
     * Getter de fechaNotificacion
     * @return fechaNotificacion
     */
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    /**
     * Metodo toString.
     * @return string
     */
    @Override
    public String toString() {
        return cedula + " " + placa + " " + infraccion + " " + valor +" "+fechaInfraccion + " " + fechaNotificacion + " "+puntos;
    }
    
    
    
    
    
    
}
