/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;

/**
 *Representa Vehiculo
 * @author Angello Vasconez
 */
public class Vehiculo {
    
    private String duenho;
    private String placa;
    private String modelo;
    private int año;
    private String chasis;
    private String color;
    private String marca;

    /**
     * Instancia Vehiculo
     * @param duenho cedula dueño.
     * @param placa placa.
     * @param modelo modelo,
     * @param marca marca.
     * @param año año.
     * @param chasis chasis.
     * @param color color.
     */
    public Vehiculo(String duenho, String placa, String modelo, String marca, int año, String chasis, String color) {
        this.duenho = duenho;
        this.placa = placa;
        this.modelo = modelo;
        this.año = año;
        this.chasis = chasis;
        this.color = color;
        this.marca = marca;
    }
 
    /**
     * Getter duenho
     * @return duenho
     */
    public String getDuenho() {
        return duenho;
    }


    /**
     * Getter placa
     * @return placa
     */
    public String getPlaca() {
        return placa;
    }


    /**
     * Metodo toString.
     * @return String
     */
    @Override
    public String toString() {
        return duenho +" "+ placa +" "+ modelo +" "+ año +" "+ chasis +" "+ color +" "+ marca ;
    }

}
