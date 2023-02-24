package mx.com.gm.jdbc.datos;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.domain.Persona;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE `test`.`persona` SET `nombre` = ?, `apellido` = ?, `email` = ?, `telefono` = ? WHERE (`idpersona` = ?)";
    private static final String SQL_DELETE = "DELETE FROM `test`.`persona` WHERE (`idpersona` = ?)";
    
    private Connection conexionTransacciones;

    public PersonaDAO(Connection conexionTransacciones) {
        this.conexionTransacciones = conexionTransacciones;
    }

    public PersonaDAO() {
    }
    
    public List<Persona> seleccionar() throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_SELECT);
            resultado = instruccion.executeQuery();
            
            while(resultado.next()) {
                Persona persona = new Persona();
                persona.setIdPersona(resultado.getInt("idpersona"));
                persona.setNombre(resultado.getString("nombre"));
                persona.setApellido(resultado.getString("apellido"));
                persona.setEmail(resultado.getString("email"));
                persona.setTelefono(resultado.getString("telefono"));
                
                personas.add(persona);
            }
        } finally {
            Conexion.close(resultado);
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
        return personas;
    }
    
    public void insertar(Persona persona) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);
            
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.getEmail());
            instruccion.setString(4, persona.getTelefono());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
    
    public void actualizar(Persona persona) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_UPDATE);
            
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.getEmail());
            instruccion.setString(4, persona.getTelefono());
            instruccion.setInt(5, persona.getIdPersona());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
    
    public void eliminar(Persona persona) throws SQLException {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        
        try {
            conexion = this.conexionTransacciones != null? this.conexionTransacciones : Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_DELETE);
            
            instruccion.setInt(1, persona.getIdPersona());
            
            instruccion.executeUpdate();
        } finally {
            Conexion.close(instruccion);
            if (this.conexionTransacciones == null) Conexion.close(conexion);
        }
    }
}
