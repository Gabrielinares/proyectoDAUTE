/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author gabriel
 */
public class Proyecto {
    private int idProy;
    private String nombreProy;
    private String estado;
    private double valorProy;
    private String motivoCancel;
    private int munId;
    private String muni;
    private String depto;
    
    public Proyecto(){
        
    }

    public Proyecto(int idProy, String nombreProy, String estado, double valorProy, String motivoCancel, int deptoId) {
        this.idProy = idProy;
        this.nombreProy = nombreProy;
        this.estado = estado;
        this.valorProy = valorProy;
        this.motivoCancel = motivoCancel;
        this.munId = deptoId;
    }

    public int getIdProy() {
        return idProy;
    }

    public void setIdProy(int idProy) {
        this.idProy = idProy;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorProy() {
        return valorProy;
    }

    public void setValorProy(double valorProy) {
        this.valorProy = valorProy;
    }

    public String getMotivoCancel() {
        return motivoCancel;
    }

    public void setMotivoCancel(String motivoCancel) {
        this.motivoCancel = motivoCancel;
    }

    public int getMunId() {
        return munId;
    }

    public void setMunId(int munId) {
        this.munId = munId;
    }

    
    
    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getMuni() {
        return muni;
    }

    public void setMuni(String muni) {
        this.muni = muni;
    }
    
    
}
