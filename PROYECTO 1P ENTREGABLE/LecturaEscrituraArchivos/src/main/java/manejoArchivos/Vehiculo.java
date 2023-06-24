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
    private char placa;
    private int modelo;
    private int año;
    private String chasis;
    private String color;

    //Constructor
    public Vehiculo(String duenho, char placa, int modelo, int año, String chasis, String color) {
        this.duenho = duenho;
        this.placa = placa;
        this.modelo = modelo;
        this.año = año;
        this.chasis = chasis;
        this.color = color;
    }

    //Getters y Setters 
    public String getDuenho() {
        return duenho;
    }

    public void setDuenho(String duenho) {
        this.duenho = duenho;
    }

    public char getPlaca() {
        return placa;
    }

    public void setPlaca(char placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
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

    public void setColor(String color) {
        this.color = color;
    }
}
