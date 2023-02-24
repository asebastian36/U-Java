package datos;

import java.sql.*;

public class Conexion {
    //  Establecer variables para conectarnos a la bd
    private static final String  JDBC_URL= "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    //  para obtener la conexion con la bd
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    //  sobrecarga del metodo close para cerrar conexiones
    public static void close(ResultSet resultado) throws SQLException {
        resultado.close();
    }
    
    public static void close(Statement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(PreparedStatement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(Connection conexion) throws SQLException {
        conexion.close();
    }
}
