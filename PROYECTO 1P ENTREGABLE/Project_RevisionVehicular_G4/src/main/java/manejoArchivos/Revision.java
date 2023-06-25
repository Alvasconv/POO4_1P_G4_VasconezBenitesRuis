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
    private int codigoRevision;
    private int cedula;
    private char placa;
    private Date fechaRevision;

    public Revision(int codigoRevision, int cedula, char placa, Date fechaRevision) {
        this.codigoRevision = codigoRevision;
        this.cedula = cedula;
        this.placa = placa;
        this.fechaRevision = fechaRevision;
    }

    public int getCodigoRevision() {
        return codigoRevision;
    }

    public void setCodigoRevision(int codigoRevision) {
        this.codigoRevision = codigoRevision;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public char getPlaca() {
        return placa;
    }

    public void setPlaca(char placa) {
        this.placa = placa;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }
    
    
}
