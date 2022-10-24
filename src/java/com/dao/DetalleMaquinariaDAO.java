package com.dao;


import com.conexion.Conexion;
import com.modelo.DetalleMaquinaria;
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
public class DetalleMaquinariaDAO extends Conexion{
    public int agregarDM(DetalleMaquinaria dm) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO detallemaquinaria(fechaInicio, fechaFinal, proyectoId, maquinariaId) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, dm.getFechaInicio());
            ps.setString(2, dm.getFechaFin());
            ps.setInt(3, dm.getProyId());
            ps.setInt(4, dm.getMaqId());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarDM(DetalleMaquinaria dm) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE detallemaquinaria SET fechaInicio = ?, fechaFinal = ?, proyectoId = ?, maquinariaId = ? WHERE idDetalleMaquinaria = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, dm.getFechaInicio());
            ps.setString(2, dm.getFechaFin());
            ps.setInt(3, dm.getProyId());
            ps.setInt(4, dm.getMaqId());
            ps.setInt(5, dm.getIdDM());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<DetalleMaquinaria> mostrarDM() {
        ArrayList<DetalleMaquinaria> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT dm.idDetalleMaquinaria ,dm.fechaInicio, dm.fechaFinal, p.nombreProyecto as proyecto, m.nombreMaquinaria as maquinaria FROM detallemaquinaria as dm INNER JOIN proyecto as p ON (p.idProyecto = dm.proyectoId) INNER JOIN maquinaria as m ON (m.idMaquinaria = dm.maquinariaId); ";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleMaquinaria dm = new DetalleMaquinaria();
                dm.setIdDM(rs.getInt(1));
                dm.setFechaInicio(rs.getString(2));
                dm.setFechaFin(rs.getString(3));
                dm.setProyecto(rs.getString(4));
                dm.setMaquinaria(rs.getString(5));

                lista.add(dm);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarDM(DetalleMaquinaria dm){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM detallemaquinaria WHERE idDetalleMaquinaria = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, dm.getIdDM());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
