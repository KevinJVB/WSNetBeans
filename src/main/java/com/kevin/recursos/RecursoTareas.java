/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.recursos;

import com.kevin.dao.DaoTareas;
import com.kevin.entidades.Tareas;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kevin
 */
@Path("tareas")
public class RecursoTareas {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tareas> get(){
 
        try {
            return DaoTareas.getInstanceTareas().listar();
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Tareas post(Tareas tareas) throws SQLException {
       
        try {
            DaoTareas.getInstanceTareas().insertar(tareas);
             return DaoTareas.getInstanceTareas().getUltimo();
        } catch (SQLException ex) {
            Logger.getLogger(DaoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id")Integer id){
        // Eliminar elemento
        try {
            DaoTareas.getInstanceTareas().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public Tareas put(@PathParam("id")Integer id, Tareas tareas){
        //Actualizar elemento
        tareas.setIdtarea(id);
        
        try {
            DaoTareas.getInstanceTareas().actualizar(tareas);
            return DaoTareas.getInstanceTareas().getUltimo();
        } catch (SQLException ex) {
            Logger.getLogger(RecursoTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
}
