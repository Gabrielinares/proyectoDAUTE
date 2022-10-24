/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class EmpleadoDAO extends Conexion {

    public int agregarEmpleado(Empleado emp) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO empleado(dui, nombreEmpleado, apellidoEmpleado, disponible, salario, telefono) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, emp.getDui());
            ps.setString(2, emp.getNombreEmp());
            ps.setString(3, emp.getApellidoEmp());
            ps.setInt(4, emp.getDisp());
            ps.setDouble(5, emp.getSalario());
            ps.setString(6, emp.getTelefono());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarEmpleado(Empleado emp) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE empleado SET nombreEmpleado = ?, apellidoEmpleado = ?, disponible = ?, salario = ?, telefono = ? WHERE dui = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, emp.getNombreEmp());
            ps.setString(2, emp.getApellidoEmp());
            ps.setInt(3, emp.getDisp());
            ps.setDouble(4, emp.getSalario());
            ps.setString(5, emp.getTelefono());
            ps.setInt(6, emp.getDui());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Empleado> mostrarEmpleados() {
        ArrayList<Empleado> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM empleado";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setDui(rs.getInt(1));
                emp.setNombreEmp(rs.getString(2));
                emp.setApellidoEmp(rs.getString(3));
                emp.setDisp(rs.getInt(4));
                emp.setSalario(rs.getDouble(5));
                emp.setTelefono(rs.getString(6));
                
                lista.add(emp);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarEmpleado(Empleado emp){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM empleado WHERE dui = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, emp.getDui());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
