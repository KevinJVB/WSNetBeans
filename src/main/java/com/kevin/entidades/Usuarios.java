/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.entidades;

/**
 *
 * @author kevin
 */

public class Usuarios {
    
    private int id_usuario;
    private String username;
    private String nombre;
    private String password;
    private String rol;

    public Usuarios(int id_usuario, String username, String nombre, String password, String rol) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    public Usuarios(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Usuarios() {
       
    }
    //Constructor del post
    public Usuarios(String username, String nombre, String password, String rol) {
        this.username = username;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
        public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
    @Override
    public String toString() {
        return "Usuarios{" + " nom_usuario=" + nombre + ", pass_usuario=" + password + ", rol_user=" + rol + ", username=" + username +'}'+"\n\n";
    }
    
    
    
}
