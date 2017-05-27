
import com.kevin.dao.DaoUsuario;
import com.kevin.entidades.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin
 */
public class testInsertar {

 public static void main(String[] args) {
        //Que paso? 
        DaoUsuario daoUsuario = DaoUsuario.getInstanceUsuario();
        
        try {
            daoUsuario.insertar(
                    new Usuarios("Abc","AL","123","est"));
            
        } catch (SQLException ex) {
            Logger.getLogger(testInsertar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
