/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author gabriel
 */
public class Maquinaria {
    private int idMaquinaria;
    private String nombreMaquinaria;
    private String desc;
    private int cant;
    
    public Maquinaria(){
        
    }

    public Maquinaria(int idMaquinaria, String nombreMaquinaria, String desc, int cant) {
        this.idMaquinaria = idMaquinaria;
        this.nombreMaquinaria = nombreMaquinaria;
        this.desc = desc;
        this.cant = cant;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    
}
