/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author gabriel
 */
public class DetalleMaquinaria {
    private int idDM;
    private String fechaInicio;
    private String fechaFin;
    private int ProyId;
    private int MaqId;
    private String proyecto;
    private String maquinaria;
    
    public DetalleMaquinaria(){
        
    }

    public DetalleMaquinaria(int idDM, String fechaInicio, String fechaFin, int ProyId, int MaqId) {
        this.idDM = idDM;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ProyId = ProyId;
        this.MaqId = MaqId;
    }

    public int getIdDM() {
        return idDM;
    }

    public void setIdDM(int idDM) {
        this.idDM = idDM;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getProyId() {
        return ProyId;
    }

    public void setProyId(int ProyId) {
        this.ProyId = ProyId;
    }

    public int getMaqId() {
        return MaqId;
    }

    public void setMaqId(int MaqId) {
        this.MaqId = MaqId;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(String maquinaria) {
        this.maquinaria = maquinaria;
    }
    
    
}
