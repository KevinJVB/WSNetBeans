/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevin.dao;

import com.kevin.entidades.Asignaturas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class DaoAsignatura implements IDAO<Asignaturas> {

    private PreparedStatement insetar, eliminar, listar, buscar, actualizar;
    private String sql = "";

    private static DaoAsignatura instancia;

    private DaoAsignatura() {
    }

    public static DaoAsignatura getInstanceAsignatura() {

        if (instancia == null) {
            instancia = new DaoAsignatura();
        }
        return instancia;
    }

    @Override
    public void insertar(Asignaturas entidad) throws SQLException {
        sql = "INSERT INTO asignaturas (nombre) VALUES ( ? )";

        if (insetar == null) {
            insetar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        insetar.setString(1, entidad.getNombre_asignatura());
        insetar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
      
        sql = "DELETE FROM asignaturas WHERE idasignatura = ?";

        if (eliminar == null) {
            eliminar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<Asignaturas> listar() throws SQLException {
      
        sql = "SELECT * FROM asignaturas";

        if (listar == null) {
            listar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Asignaturas> result = new ArrayList<>();

        while (set.next()) {
            result.add(cargar(set));
        }
        return result;
    }

    @Override
    public Asignaturas buscar(Integer id) throws SQLException {
        //Buscar por id
        sql = "SELECT * FROM asignaturas WHERE idasignatura = ?";

        if (buscar == null) {
            buscar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        buscar.setInt(1, id);

        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public Asignaturas cargar(ResultSet set) throws SQLException {

        Asignaturas asignatura = new Asignaturas();
        //Cargar Asigntura
        asignatura.setId_asignatura(set.getInt("idasignatura"));
        asignatura.setNombre_asignatura(set.getString("nombre"));

        return asignatura;
    }

    @Override
    public void actualizar(Asignaturas entidad) throws SQLException {

        sql = "UPDATE asignaturas SET "
                + "nombre = ? "
                + "WHERE idasignatura = ?";

        if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        actualizar.setString(1, entidad.getNombre_asignatura());
        actualizar.setInt(2, entidad.getId_asignatura());

        actualizar.executeUpdate();
    }

    @Override
    public Asignaturas buscarLogin(String usuario, String contrasena) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
