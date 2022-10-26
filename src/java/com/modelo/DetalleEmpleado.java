/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author gabriel
 */
public class DetalleEmpleado {
    private int idDE;
    private String fechaInicio;
    private String fechaFin;
    private int ProyId;
    private int EmpDui;
    private String proyecto;
    private String empleado;
    
    public DetalleEmpleado(){
        
    }

    public DetalleEmpleado(int idDE, String fechaInicio, String fechaFin, int ProyId, int EmpDui, String proyecto, String empleado) {
        this.idDE = idDE;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ProyId = ProyId;
        this.EmpDui = EmpDui;
        this.proyecto = proyecto;
        this.empleado = empleado;
    }

    public DetalleEmpleado(int codigo, String fechaI, String fechaF, int Emp, int ProyId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int getIdDE() {
        return idDE;
    }

    public void setIdDE(int idDE) {
        this.idDE = idDE;
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

    public int getEmpDui() {
        return EmpDui;
    }

    public void setEmpDui(int EmpDui) {
        this.EmpDui = EmpDui;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    
}
