/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;

/**
 *
 * @author vv
 */
public class Vehiculo {
    
    private String duenho;
    private String placa;
    private String modelo;
    private int año;
    private String chasis;
    private String color;
    private String marca;

    //Constructor
    public Vehiculo(String duenho, String placa, String modelo, String marca, int año, String chasis, String color) {
        this.duenho = duenho;
        this.placa = placa;
        this.modelo = modelo;
        this.año = año;
        this.chasis = chasis;
        this.color = color;
        this.marca = marca;
    }

    //Getters y Setters 

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getDuenho() {
        return duenho;
    }

    public void setDuenho(String duenho) {
        this.duenho = duenho;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return duenho +" "+ placa +" "+ modelo +" "+ año +" "+ chasis +" "+ color +" "+ marca ;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
