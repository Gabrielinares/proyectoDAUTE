package com.dao;

import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class UsuarioDAO extends Conexion {

    public ArrayList<Usuario> iniciarSesion(String usuario, String password) {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUser(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassw(rs.getString(3));
                u.setEstado(rs.getInt(4));
                u.setPathFoto(rs.getString(5));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error al extraer sesion: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int agregarUsuario(Usuario us) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO usuarios(username, password, estado, pathFoto) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, us.getUsername());
            ps.setString(2, us.getPassw());
            ps.setInt(3, us.getEstado());
            ps.setString(4, us.getPathFoto());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public int modificarUsuario(Usuario us) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE usuarios set username = ?, password = ?, estado = ?, pathFoto = ? WHERE idUser = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setString(1, us.getUsername());
            ps.setString(2, us.getPassw());
            ps.setInt(3, us.getEstado());
            ps.setString(4, us.getPathFoto());
            ps.setInt(5, us.getIdUser());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
    
    public ArrayList<Usuario> mostrarUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM usuarios";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                Usuario u = new Usuario();
                u.setIdUser(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassw(rs.getString(3));
                u.setEstado(rs.getInt(4));
                u.setPathFoto(rs.getString(5));
                
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    public int eliminarUsuario(Usuario us){
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM usuarios WHERE idUser = ?";
            PreparedStatement ps = this.getCon().prepareStatement(sql);
            ps.setInt(1, us.getIdUser());
            
            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
