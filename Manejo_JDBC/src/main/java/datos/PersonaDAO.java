package datos;

//  DAO de data access object

import domain.Persona;
import java.sql.*;
import java.util.*;

//  hace operaciones sql sobre la tabla personas
public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE `test`.`persona` SET `nombre` = ?, `apellido` = ?, `email` = ?, `telefono` = ? WHERE (`idpersona` = ?)";
    private static final String SQL_DELETE = "DELETE FROM `test`.`persona` WHERE (`idpersona` = ?)";
    
    //  metodo para regresar una lista 
    public List<Persona> seleccionar() {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        ResultSet resultado = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            //  obtenemos la conexion con la bd
            conexion = Conexion.getConnection();
            
            //  le pasamos la instruccion de SQL
            instruccion = conexion.prepareStatement(SQL_SELECT);
            
            //  ejecutamos la instruccion
            resultado = instruccion.executeQuery();
            
            while(resultado.next()) {
                //  obtenemos la informacion del registro
                int idPersona = resultado.getInt("idpersona");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                
                //  la pasamos de la bd a la instancia de la clase entidad
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                
                //  se agrega a la lista de personas
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                //  las conexiones se cierran en orden inverso de como se crearon
                Conexion.close(resultado);
                Conexion.close(instruccion);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }
    
    //  para que este metodo funcione esta instancia ya debe tener valores
    public int insertar(Persona persona) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            instruccion = conexion.prepareStatement(SQL_INSERT);
            
            //  formando la cadena sql
            //  parametros correspondientes con los signos "?" de la cadena insert
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.getEmail());
            instruccion.setString(4, persona.getTelefono());
            
            //  para actualizar estado de la bd puede ejecutar sentencias sql 
            //  este metodo
            registros = instruccion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
        return registros;
    }
    
    public void actualizar(Persona persona) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        try {
            conexion = Conexion.getConnection();
            
            instruccion = conexion.prepareStatement(SQL_UPDATE);
            instruccion.setString(1, persona.getNombre());
            instruccion.setString(2, persona.getApellido());
            instruccion.setString(3, persona.getEmail());
            instruccion.setString(4, persona.getTelefono());
            instruccion.setInt(5, persona.getIdPersona());
            
            instruccion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
    }
    
    public void eliminar(Persona persona) {
        Connection conexion = null;
        PreparedStatement instruccion = null;
        try {
            conexion = Conexion.getConnection();
            
            instruccion = conexion.prepareStatement(SQL_DELETE);
            instruccion.setInt(1, persona.getIdPersona());
            
            instruccion.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(instruccion);
                Conexion.close(conexion);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }
    }
}
