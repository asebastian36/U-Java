package mx.com.gm.jdbc.datos;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.domain.UsuarioDTO;

public class UsuarioDAOImpl implements UsuarioDAO{
    private static final String SQL_SELECT = "SELECT idusuario, username, password FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(username, password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE `test`.`usuario` SET `username` = ?, `password` = ? WHERE (`idusuario` = ?)";
    private static final String SQL_DELETE = "DELETE FROM `test`.`usuario` WHERE (`idusuario` = ?)";
    
    private Connection conexionTransacciones;

    public UsuarioDAOImpl(Connection conexionTransacciones) {
        this.conexionTransacciones = conexionTransacciones;
    }

    public UsuarioDAOImpl() {
    }
    
    public List<UsuarioDTO> select() throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();
            
            while(resultado.next()) {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setIdUsuario(resultado.getInt("idusuario"));
                usuario.setUsername(resultado.getString("username"));
                usuario.setPassword(resultado.getString("password"));
                
                usuarios.add(usuario);
            }
        } finally {
            Conexion.close(resultado);
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
        return usuarios;
    }
    
    public void insert(UsuarioDTO usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);
            
            instruccion.setString(1, usuario.getUsername());
            instruccion.setString(2, usuario.getPassword());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
    
    public void update(UsuarioDTO usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_UPDATE);
            
            instruccion.setString(1, usuario.getUsername());
            instruccion.setString(2, usuario.getPassword());
            instruccion.setInt(3, usuario.getIdUsuario());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
    
    public void delete(UsuarioDTO usuario) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_DELETE);
            
            instruccion.setInt(1, usuario.getIdUsuario());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
}
