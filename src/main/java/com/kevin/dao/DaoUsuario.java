/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.dao;

import com.kevin.entidades.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class DaoUsuario implements IDAO<Usuarios>{
    
    private PreparedStatement listar,buscar,borrar,actualizar,insertar, 
            buscarLogin;
    private String sql ="";

    private static DaoUsuario instancia;

    private DaoUsuario() {
    }
    
    public static DaoUsuario getInstanceUsuario(){        
        if (instancia == null) {
            instancia = new DaoUsuario();
        }        
        return instancia;
    }      
    
    
    @Override
    public void insertar(Usuarios entidad) throws SQLException {
        //Encargado de insertar los usuarios
        sql = "INSERT INTO usuarios "
                + "(username,"
                + "nombre,"
                + "contrasena,"
                + "rol)"
                + "VALUES (?,?,?,?)";
        
        if (insertar== null) {
            insertar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
        
        insertar.setString(1, entidad.getUsername());
        insertar.setString(2, entidad.getNombre());
        insertar.setString(3, entidad.getPassword());
        insertar.setString(4, entidad.getRol());
                
        insertar.executeUpdate();
        
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Elimina el usuario
        sql = "DELETE FROM usuarios WHERE idusuario = ?";
        
        if (borrar == null) {
            borrar = Conexion.getIntance().getCon().prepareStatement(sql);
        }        
        borrar.setInt(1, id);
        borrar.executeUpdate();
    }
    

    @Override
    public List<Usuarios> listar() throws SQLException {
        //Listar Usuarios        
        sql = "SELECT * FROM usuarios";
        
        if (listar == null) {            
            listar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
                       
        ResultSet set = listar.executeQuery();
        ArrayList<Usuarios> result = new ArrayList<>();
        
        while (set.next()){
            result.add(cargar(set));
        }        
        return result;        
    }

    @Override
    public Usuarios buscar(Integer id) throws SQLException {
        // Buscar Usuario
        sql = "SELECT * FROM usuarios WHERE idusuario = ?";
        
        if (buscar == null) {
            buscar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
            
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;

    }
    
    
    @Override
    public Usuarios buscarLogin(String usuario, String contrasena) throws SQLException {
        // Buscar Usuario      
        
        sql = "SELECT * FROM usuarios"
                + " WHERE username = ?"
                + " AND contrasena = ?";
        
        if (buscarLogin == null) {
            buscarLogin = Conexion.getIntance().getCon().prepareStatement(sql);
        }
            
        buscarLogin.setString(1, usuario);
        buscarLogin.setString(2, contrasena);
        
        ResultSet set = buscarLogin.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;

    }
    
    
    @Override
    public void actualizar(Usuarios entidad) throws SQLException {
        //Encnargada de actualizar usuario
        sql = " UPDATE usuarios SET "
                + "username = ?,"
                + "nombre = ?,"
                + "contrasena = ?,"
                + "rol = ? "
                + "WHERE idusuario = ?";       
               
        if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        actualizar.setString(1, entidad.getUsername());
        actualizar.setString(2, entidad.getNombre());
        actualizar.setString(3, entidad.getPassword());
        actualizar.setString(4, entidad.getRol());
        
        
        actualizar.executeUpdate();
    }
    
    public Usuarios cargar (ResultSet set) throws SQLException{
        
        Usuarios usuarios = new Usuarios();
        
        usuarios.setId_usuario(set.getInt("idusuario"));
        usuarios.setUsername(set.getString("username"));
        usuarios.setNombre(set.getString("nombre"));
        usuarios.setPassword(set.getString("contrasena"));
        usuarios.setRol(set.getString("rol"));
        
        return usuarios;
    }
    
}
