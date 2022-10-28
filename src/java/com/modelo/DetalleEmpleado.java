/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import java.sql.Date;

/**
 *
 * @author gabriel
 */
public class DetalleEmpleado {
    private int idDE;
    private Date fechaInicio;
    private Date fechaFin;
    private int ProyId;
    private int EmpDui;
    private String proyecto;
    private String empleado;
    
    public DetalleEmpleado(){
        
    }

    public DetalleEmpleado(int idDE, Date fechaInicio, Date fechaFin, int ProyId, int EmpDui) {
        this.idDE = idDE;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ProyId = ProyId;
        this.EmpDui = EmpDui;
    }

    public int getIdDE() {
        return idDE;
    }

    public void setIdDE(int idDE) {
        this.idDE = idDE;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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
