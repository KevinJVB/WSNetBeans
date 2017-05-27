
package com.kevin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kevin
 */
public class Conexion {
    
    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String usuario = "root";
    private final String contrasena = "root";
    private final String urlBaseDatos = "jdbc:mysql://localhost:3306/data_base_examen_9?serverTimezone=UTC"
            + "&autoReconnect=true&useSSL=false";

    private static Conexion conexion;

    private Conexion() {
        //constructor vacio
    }

    public static Conexion getIntance() throws SQLException {
   
        if (conexion == null) {
            conexion = new Conexion();
        }
        conexion.conectar();
        return conexion;
    }

    private void conectar() throws SQLException {
        //Conectar a la base de datos
        if (con == null || con.isClosed()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(urlBaseDatos, usuario, contrasena);
        }
    }

    public Boolean existeConexion() throws SQLException {
        return con != null && !con.isClosed();
    }

    public Connection getCon() {
        // returna la conexion
        return con;
    }
    
}
