/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class DepartamentoDAO extends Conexion{
    
    public int agregarDepto(Departamento dept) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO departamento(nombreDepto) VALUES (?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, dept.getNombreDepto());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public int modificarDepto(Departamento dept) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE departamento SET nombreDepto = ? WHERE idDepto = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, dept.getNombreDepto());
            ps.setInt(2, dept.getIdDepto());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public ArrayList<Departamento> mostrarDeptos(){
        ArrayList<Departamento> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM departamento";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Departamento d = new Departamento();
                d.setIdDepto(rs.getInt(1));
                d.setNombreDepto(rs.getString(2));
                
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarDepto(Departamento depto){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM departamento WHERE idDepto = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, depto.getIdDepto());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
