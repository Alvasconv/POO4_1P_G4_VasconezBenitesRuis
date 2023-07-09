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
public class Revision {
    private String codigoRevision;
    private String cedula;
    private String placa;
    private String fechaRevision;
    private double valoRevision;

    public Revision(String codigoRevision, String cedula, String placa, String fechaRevision,double valoRevision) {
        this.codigoRevision = codigoRevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
        this.valoRevision = valoRevision;
    }

    public double getValoRevision() {
        return valoRevision;
    }

    public void setValoRevision(double valoRevision) {
        this.valoRevision = valoRevision;
    }

    
    
    public String getCodigoRevision() {
        return codigoRevision;
    }

    public void setCodigoRevision(String codigoRevision) {
        this.codigoRevision = codigoRevision;
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

    public String getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(String fechaRevision) {
        this.fechaRevision = fechaRevision;
    }
    
    
}
