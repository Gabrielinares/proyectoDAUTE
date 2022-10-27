/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Proyecto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ProyectoDAO extends Conexion {

    public int agregarProyecto(Proyecto p) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO proyecto(nombreProyecto, costoProyecto, estadoProyecto, deptoId) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, p.getNombreProy());
            ps.setDouble(2, p.getValorProy());
            ps.setString(3, p.getEstado());
            ps.setInt(4, p.getDeptoId());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarProyecto(Proyecto p) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE proyecto SET nombreProyecto = ?, costoProyecto = ?, estadoProyecto = ?, motivoCancelacion = ?, deptoId = ? WHERE idProyecto = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, p.getNombreProy());
            ps.setDouble(2, p.getValorProy());
            ps.setString(3, p.getEstado());
            ps.setString(4, p.getMotivoCancel());
            ps.setInt(5, p.getDeptoId());
            ps.setInt(6, p.getIdProy());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Proyecto> mostrarProyectos() {
        ArrayList<Proyecto> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT p.idProyecto, p.nombreProyecto, p.costoProyecto, p.estadoProyecto, p.motivoCancelacion, d.nombreDepto, p.deptoId FROM proyecto AS p INNER JOIN departamento AS d ON (p.deptoId = d.idDepto)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proyecto p = new Proyecto();
                p.setIdProy(rs.getInt(1));
                p.setNombreProy(rs.getString(2));
                p.setValorProy(rs.getDouble(3));
                p.setEstado(rs.getString(4));
                p.setMotivoCancel(rs.getString(5));
                p.setDepto(rs.getString(6));
                p.setDeptoId(rs.getInt(7));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarProyecto(Proyecto p){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM proyecto WHERE idProyecto = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, p.getIdProy());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public int cancelarProyecto(String razon, int id){
        int res = 0;
        
        try {
            this.conectar();
            String sql = "UPDATE proyecto SET motivoCancelacion = ? WHERE idProyecto = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, razon);
            ps.setInt(2, id);
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
