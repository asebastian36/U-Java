package mx.com.gm.jdbc.test;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.datos.*;
import mx.com.gm.jdbc.domain.UsuarioDTO;

/*
 * @author Angel Sebastian
 */
public class TestUsuario {
    public static void main(String[] args) {
        Connection conexion = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
                
            UsuarioDAO usuarioDAO = new UsuarioDAOImpl(conexion);
            
            //  aqui empezamos las transacciones
            
            //  si funciona
//            usuarioDAO.insertar(new Usuario("Palaalaa", "1NintendoSwitch"));
//            usuarioDAO.actualizar(new Usuario(1, "asebastian36", "1ManzanaGrande"));
            usuarios = usuarioDAO.select();
            
            usuarios.forEach(usuario -> {
                System.out.println("usuario = " + usuario);
            });
            
            conexion.commit();
            System.out.println("se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
