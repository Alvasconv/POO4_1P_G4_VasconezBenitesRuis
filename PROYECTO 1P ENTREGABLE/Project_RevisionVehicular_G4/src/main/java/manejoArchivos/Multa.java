/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;
import java.util.Date;

/**
 *
 * @author vv
 */
public class Multa {

    private String cedula;
    private String placa;
    private double valor;
    private int puntos;
    private String infraccion;
    private Date fechaInfraccion;
    private Date fechaNotificacion;

    public Multa(String cedula,String placa,String infraccion,double valor,Date fechaInfraccion,Date fechaNotificacion,int puntos) {
        this.cedula = cedula;
        this.placa = placa;
        this.valor = valor;
        this.puntos = puntos;
        this.infraccion = infraccion;
        this.fechaInfraccion = fechaInfraccion;
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public Date getFechaInfraccion() {
        return fechaInfraccion;
    }

    public void setFechaInfraccion(Date fechaInfraccion) {
        this.fechaInfraccion = fechaInfraccion;
    }

    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    @Override
    public String toString() {
        return cedula + " " + placa + " " + infraccion + " " + valor +" "+fechaInfraccion + " " + fechaNotificacion + " "+puntos;
    }
    
    
    
    
    
    
}
