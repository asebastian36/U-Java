package datos;

import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAO {    
    private final String SQL_SELECT = "SELECT * FROM test.usuario";
    private final String SQL_INSERT = "INSERT INTO test.usuario(username, password) VALUES(?, ?);";
    private final String SQL_UPDATE = "UPDATE test.usuario SET username = ?, password = ? WHERE (idusuario = ?);";
    private final String SQL_DELETE = "DELETE FROM test.usuario WHERE (idusuario = ?);";
    
    public List<Usuario> seleccionar() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        Usuario usuario = null;
        
        try {
            conexion = Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();
            
            while(resultado.next()) {
                int idUsuario = resultado.getInt("idusuario");
                String username = resultado.getString("username");
                String password = resultado.getString("password");
                
                usuario = new Usuario(idUsuario, username, password);
                
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(resultado);
                Conexion.close(instruccion);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return usuarios;
    }
    
    public void insertar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        
        try {
            conexion = Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);
            instruccion.setString(1, usuario.getUsername());
            instruccion.setString(2, usuario.getPassword());
            
            instruccion.executeUpdate(); 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void actualizar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        
        try {
            conexion = Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_UPDATE);
            instruccion.setString(1, usuario.getUsername());
            instruccion.setString(2, usuario.getPassword());
            instruccion.setInt(3, usuario.getIdUsuario());
            
            instruccion.executeUpdate(); 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void eliminar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        
        try {
            conexion = Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_DELETE);
            instruccion.setInt(1, usuario.getIdUsuario());
            
            instruccion.executeUpdate(); 
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
