/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class Fecha {
    
    private String tipoFecha;
    private Date fecha;
    
    @Override
    public String toString(){
        return tipoFecha + ":" + fecha;
    }

    public Fecha(String tipoFecha, Date fecha) {
        this.tipoFecha = tipoFecha;
        this.fecha = fecha;
    }

    public String getTipoFecha() {
        return tipoFecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setTipoFecha(String tipoFecha) {
        this.tipoFecha = tipoFecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
