package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

/**
 *
 * @author asebastian36
 */

public class ClienteDAOJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo" + " FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo " + "FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo) " + " VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente " + "SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    public List<Cliente> listar() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_SELECT);
            result = statement.executeQuery();
            
            while(result.next()) {
                int idCliente = result.getInt("id_cliente");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String telefono = result.getString("telefono");
                double saldo = result.getDouble("saldo");
                
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(result);
            Conexion.close(statement);
            Conexion.close(conexion);
        }
        return clientes;
    }
    
    public Cliente buscar(Cliente cliente) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, cliente.getIdCliente());
            result = statement.executeQuery();
            
            //  para posicionarse en el primer de la primer columna del registro
            //  encontrado
            result.absolute(1);
            String nombre = result.getString("nombre");
            String apellido = result.getString("apellido");
            String email = result.getString("email");
            String telefono = result.getString("telefono");
            double saldo = result.getDouble("saldo");
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
                     
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(result);
            Conexion.close(statement);
            Conexion.close(conexion);
        }
        return cliente;
    }
    
    public void insertar(Cliente cliente) {
        Connection conexion = null;
        PreparedStatement statement = null;
        
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getTelefono());
            statement.setDouble(5, cliente.getSaldo());
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(statement);
            Conexion.close(conexion);
        }
    }
    
    public void actualizar(Cliente cliente) {
        Connection conexion = null;
        PreparedStatement statement = null;
        
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_UPDATE);
            
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getTelefono());
            statement.setDouble(5, cliente.getSaldo());
            statement.setInt(6, cliente.getIdCliente());
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(statement);
            Conexion.close(conexion);
        }
    }
    
    public void eliminar(Cliente cliente) {
        Connection conexion = null;
        PreparedStatement statement = null;
        
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_DELETE);
            
            statement.setInt(1, cliente.getIdCliente());
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(statement);
            Conexion.close(conexion);
        }
    }
}
