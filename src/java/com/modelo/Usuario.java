package com.modelo;

import java.io.InputStream;

/**
 * Clase: Usuario
 * Version: 1.0
 * @author: gabriel
 */

public class Usuario {
    private int idUser;
    private String username;
    private String passw;
    private int estado;
    private String pathFoto;
    
    public Usuario(){
        
    }

    public Usuario(int idUser, String username, String passw, int estado, String pathFoto) {
        this.idUser = idUser;
        this.username = username;
        this.passw = passw;
        this.estado = estado;
        this.pathFoto = pathFoto;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getPathFoto() {
        return pathFoto;
    }

    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }

}
