package com.dao;

import com.conexion.Conexion;
import com.modelo.DetalleEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author gabriel
 */
public class DetalleEmpleadoDAO extends Conexion {

    public int agregarDE(DetalleEmpleado de) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO detalleempleado(fechaInicio, fechaFinal, proyectoId, empleadoDUI) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setDate(1, de.getFechaInicio());
            ps.setDate(2, de.getFechaFin());
            ps.setInt(3, de.getProyId());
            ps.setInt(4, de.getEmpDui());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarDE(DetalleEmpleado de) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE detalleempleado SET fechaInicio = ?, fechaFinal = ?, proyectoId = ?, empleadoDUI = ? WHERE idDetalleEmpleado = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setDate(1, de.getFechaInicio());
            ps.setDate(2, de.getFechaFin());
            ps.setInt(3, de.getProyId());
            ps.setInt(4, de.getEmpDui());
            ps.setInt(5, de.getIdDE());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<DetalleEmpleado> mostrarDE() {
        ArrayList<DetalleEmpleado> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT de.idDetalleEmpleado ,de.fechaInicio, de.fechaFinal, p.nombreProyecto as proyecto, e.nombreEmpleado as empleado, de.proyectoId, de.empleadoDUI FROM detalleempleado as de INNER JOIN proyecto as p ON (p.idProyecto = de.proyectoId) INNER JOIN empleado as e ON (e.dui = de.empleadoDUI); ";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleEmpleado de = new DetalleEmpleado();
                de.setIdDE(rs.getInt(1));
                de.setFechaInicio(rs.getDate(2));
                de.setFechaFin(rs.getDate(3));
                de.setProyecto(rs.getString(4));
                de.setEmpleado(rs.getString(5));
                de.setProyId(rs.getInt(6));
                de.setEmpDui(rs.getInt(7));

                lista.add(de);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int eliminarDE(DetalleEmpleado de) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM detalleempleado WHERE idDetalleEmpleado = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, de.getIdDE());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
