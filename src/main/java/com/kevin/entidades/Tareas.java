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
public class Tareas {
    
    private int idtarea;
    private int idasignatura;
    private int idusuario_prof;
    private int idusuario_alum;
    private String nombre;
    private double nota;

    public Tareas(int idtarea, int idasignatura, int idusuario_prof, int idusuario_alum, String nombre, double nota) {
        this.idtarea = idtarea;
        this.idasignatura = idasignatura;
        this.idusuario_prof = idusuario_prof;
        this.idusuario_alum = idusuario_alum;
        this.nombre = nombre;
        this.nota = nota;
    }
    
    public Tareas(int idasignatura, int idusuario_prof, int idusuario_alum, String nombre, double nota) {
        this.idasignatura = idasignatura;
        this.idusuario_prof = idusuario_prof;
        this.idusuario_alum = idusuario_alum;
        this.nombre = nombre;
        this.nota = nota;
    }
    
    public Tareas(){
        
    }

    public int getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(int idtarea) {
        this.idtarea = idtarea;
    }

    public int getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(int idasignatura) {
        this.idasignatura = idasignatura;
    }

    public int getIdusuario_prof() {
        return idusuario_prof;
    }

    public void setIdusuario_prof(int idusuario_prof) {
        this.idusuario_prof = idusuario_prof;
    }

    public int getIdusuario_alum() {
        return idusuario_alum;
    }

    public void setIdusuario_alum(int idusuario_alum) {
        this.idusuario_alum = idusuario_alum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

   
    
    @Override
    public String toString() {
        return "Tareas{" + "id_tarea=" + idtarea + ", nom_tarea=" +nombre +'}'+ "\n";
    }   
    
}
