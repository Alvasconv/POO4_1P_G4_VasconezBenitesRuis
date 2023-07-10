/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;
import java.util.Date;
/**
 *Revision
 * @author Angello Vasconez
 */
public class Revision {
    private String codigoRevision;
    private String cedula;
    private String placa;
    private Date fechaRevision;
    private double valoRevision;

    /**
     * Instancia revision
     * @param codigoRevision codigo.
     * @param cedula cedula.
     * @param placa placa.
     * @param fechaRevision fecha de la rebision.
     * @param valoRevision costo de la revision
     */
    public Revision(String codigoRevision, String cedula, String placa, Date fechaRevision,double valoRevision) {
        this.codigoRevision = codigoRevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
        this.valoRevision = valoRevision;
    }

    /**
     *  Getter valoRevision
     * @return valoRevision
     */
    public double getValoRevision() {
        return valoRevision;
    }
    
    
    /**
     * Getter codigoRevision
     * @return codigoRevision
     */
    public String getCodigoRevision() {
        return codigoRevision;
    }

    /**
     * Getter cedula
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Getter placa
     * @return placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Getter fechaRevision
     * @return fechaRevision
     */
    public Date getFechaRevision() {
        return fechaRevision;
    }


    /**
     * Metodo toString.
     * @return String
     */
    @Override
    public String toString() {
        return codigoRevision+","+cedula+","+ placa+","+ fechaRevision;
    }
    
    
    
    
}
