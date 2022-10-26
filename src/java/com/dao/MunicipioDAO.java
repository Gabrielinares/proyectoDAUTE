/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Municipio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class MunicipioDAO extends Conexion {

    public int agregarMun(Municipio m) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO municipio(nombreMun, deptoId) VALUES (?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, m.getNombreMun());
            ps.setInt(2, m.getDeptoId());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int modificarMun(Municipio m) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE municipio SET nombreMun = ?, deptoId = ? WHERE idMunicipio = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, m.getNombreMun());
            ps.setInt(2, m.getDeptoId());
            ps.setInt(3, m.getIdMun());

            res = ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Municipio> mostrarMunicipios() {
        ArrayList<Municipio> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT m.idMunicipio, m.nombreMun AS municipio, d.nombreDepto, m.deptoId AS departamento FROM municipio AS m INNER JOIN departamento AS d ON (m.deptoId = d.idDepto);";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Municipio m = new Municipio();
                m.setIdMun(rs.getInt(1));
                m.setNombreMun(rs.getString(2));
                m.setDepto(rs.getString(3));
                m.setDeptoId(rs.getInt(4));
                
                lista.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarMun(Municipio m){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM municipio WHERE idMunicipio = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, m.getIdMun());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
