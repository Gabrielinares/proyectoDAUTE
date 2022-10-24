/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

/**
 *
 * @author gabriel
 */
public class Empleado {
    private int dui;
    private String nombreEmp;
    private String apellidoEmp;
    private String telefono;
    private double salario;
    private int disp;
    
    public Empleado(){
        
    }

    public Empleado(int dui, String nombreEmp, String apellidoEmp, String telefono, double salario, int disp) {
        this.dui = dui;
        this.nombreEmp = nombreEmp;
        this.apellidoEmp = apellidoEmp;
        this.telefono = telefono;
        this.salario = salario;
        this.disp = disp;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getApellidoEmp() {
        return apellidoEmp;
    }

    public void setApellidoEmp(String apellidoEmp) {
        this.apellidoEmp = apellidoEmp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDisp() {
        return disp;
    }

    public void setDisp(int disp) {
        this.disp = disp;
    }
    
    
}
