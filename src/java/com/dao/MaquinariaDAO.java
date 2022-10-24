/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Maquinaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class MaquinariaDAO extends Conexion {

    public int agregarMaquinaria(Maquinaria m) {
        int res = 0;

        try {
            this.conectar();
            String sql = "INSERT INTO maquinaria(nombreMaquinaria, descripcionMaquinaria, cantidad) VALUES(?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, m.getNombreMaquinaria());
            ps.setString(2, m.getDesc());
            ps.setInt(3, m.getCant());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarMaquinaria(Maquinaria m) {
        int res = 0;

        try {
            this.conectar();
            String sql = "UPDATE maquinaria SET nombreMaquinaria = ?, descripcionMaquinaria = ?, cantidad = ? WHERE idMaquinaria = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, m.getNombreMaquinaria());
            ps.setString(2, m.getDesc());
            ps.setInt(3, m.getCant());
            ps.setInt(4, m.getIdMaquinaria());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Maquinaria> mostraMaquinarias() {
        ArrayList<Maquinaria> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM maquinaria";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Maquinaria m = new Maquinaria();
                m.setIdMaquinaria(rs.getInt(1));
                m.setNombreMaquinaria(rs.getString(2));
                m.setDesc(rs.getString(3));
                m.setCant(rs.getInt(4));

                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarMaquinaria(Maquinaria m){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM maquinaria WHERE idMaquinaria = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, m.getIdMaquinaria());
            
            res = ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
