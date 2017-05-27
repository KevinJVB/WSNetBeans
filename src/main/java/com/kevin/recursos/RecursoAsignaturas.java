/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.recursos;

import com.kevin.dao.DaoAsignatura;
import com.kevin.entidades.Asignaturas;
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
@Path("asignaturas")
public class RecursoAsignaturas {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignaturas> get(){
        //Listar componenentes
        try {
            return DaoAsignatura.getInstanceAsignatura().listar();
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post (Asignaturas asignatura){
        //Insertar
        try {
            DaoAsignatura.getInstanceAsignatura().insertar(asignatura);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("{id_tareas}")
    public void eliminar (@PathParam("id_tareas")Integer id_tareas){
        //Borrar
        try {
            DaoAsignatura.getInstanceAsignatura().eliminar(id_tareas);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    @PUT
    @Path("{id_asignatura}")
    public void actualizar(@PathParam("id_asignatura")Integer id_asignatura,Asignaturas asignatura){
        //Actualizar
        asignatura.setId_asignatura(id_asignatura);
        try {            
            DaoAsignatura.getInstanceAsignatura().actualizar(asignatura);
        } catch (SQLException ex) {
            Logger.getLogger(RecursoAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
