package mx.com.gm.jdbc.datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "L4c1b0rgv4c4#";
    private static BasicDataSource dataSource;
    
    public static DataSource getDataSource() {
        if(Conexion.dataSource == null) {
            Conexion.dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);

            //  Definimos el tamano inicial del pool de conexiones
            dataSource.setInitialSize(5);
        }
        
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet resultado) throws SQLException {
        resultado.close();
    }
    
    public static void close(PreparedStatement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(Statement instruccion) throws SQLException {
        instruccion.close();
    }
    
    public static void close(Connection conexion) throws SQLException {
        conexion.close();
    }
}
