/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.dao;

import com.kevin.entidades.Tareas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class DaoTareas implements IDAO<Tareas>{
    
     private PreparedStatement listar,buscar,borrar,actualizar,insertar, 
            buscarLogin;
    private String sql = "";

    private static DaoTareas instancia;

    private DaoTareas() {
    }

    public static DaoTareas getInstanceTareas() {

        if (instancia == null) {
            instancia = new DaoTareas();
        }
        return instancia;
    }

    @Override
    public void insertar(Tareas entidad) throws SQLException {
         sql = "INSERT INTO tareas "
               // + "(idtarea,"
                + "(idasignatura,"
                 + "idusuario_prof,"
                + "idusuario_alum,"
                + "nombre,"
                + "nota)"
                + "VALUES (?,?,?,?,?)";
        
        if (insertar== null) {
            insertar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
        
       // insertar.setInt(1, entidad.getIdtarea());
        insertar.setInt(1, entidad.getIdasignatura());
        insertar.setInt(2, entidad.getIdusuario_prof());
        insertar.setInt(3, entidad.getIdusuario_alum());
        insertar.setString(4, entidad.getNombre());
        insertar.setDouble(5, entidad.getNota());        
        insertar.executeUpdate();
        
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        sql = "DELETE FROM tareas WHERE idtarea = ?";

        if (borrar == null) {
            borrar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        borrar.setInt(1, id);
        borrar.executeUpdate();
    }

    @Override
    public List<Tareas> listar() throws SQLException {
        sql = "SELECT * FROM tareas";
        
        if (listar == null) {            
            listar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
                       
        ResultSet set = listar.executeQuery();
        ArrayList<Tareas> result = new ArrayList<>();
        
        while (set.next()){
            result.add(cargar(set));
        }        
        return result;        
    }

    @Override
    public Tareas buscar(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Tareas buscarLogin(String usuario, String contrasena) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizar(Tareas entidad) throws SQLException {
        sql = "UPDATE tareas SET "
                + "idasignatura = ?,"
                + "idusuario_prof = ?,"
                + "idusuario_alum = ?,"
                + "nombre = ? ,"
                + "nota = ? "
                + "WHERE idtarea = ?";
        
         if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareCall(sql);            
        }        
        
         actualizar.setInt(1, entidad.getIdasignatura());
         actualizar.setInt(2, entidad.getIdusuario_prof());
         actualizar.setInt(3, entidad.getIdusuario_alum());
         actualizar.setString(4, entidad.getNombre());
         actualizar.setDouble(5, entidad.getNota());
         actualizar.setInt(6, entidad.getIdtarea());
         
        actualizar.executeUpdate();
    }

 public Tareas cargar (ResultSet set) throws SQLException{
        
        Tareas tarea = new Tareas();
       
        tarea.setIdtarea(set.getInt("idtarea"));
        tarea.setIdasignatura(set.getInt("idasignatura"));
        tarea.setIdusuario_prof(set.getInt("idusuario_prof"));
        tarea.setIdusuario_alum(set.getInt("idusuario_alum"));
        tarea.setNombre(set.getString("nombre"));
        tarea.setNota(set.getDouble("nota"));
        
        return tarea;
    }
 
   public Tareas getUltimo() throws SQLException {
    String query = "SELECT * FROM tareas "
    + "ORDER BY idtarea DESC "
    + "LIMIT 1";
    
    PreparedStatement last = Conexion.getIntance().getCon().prepareStatement(query);
    ResultSet resultSet = last.executeQuery();

    return resultSet != null && resultSet.next() ? cargar(resultSet) : null;
}
   
    
}

