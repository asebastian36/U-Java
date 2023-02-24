package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        //  para conectarse a la bd
        //  1. escribir cadena de conexion
        
        //  local host es la ip de la bd, luego el puerto, 
        //  despues el nombre de la bd, parametros extra de seguridad
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //  paso extra no obligatorio en algunas aplicaciones web aun se ocupa. este paso arroja una excepcion
            //Class.forName("com.mysql.cj.jdbc.Driver");
            
            //  este otro igual arroja una excepcion
            
            //  primera conexion abierta
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            
            //  segunda conexion abierta
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            
            //  tercera conexion abierta
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()) {
                System.out.print("Id Persona:" + resultado.getInt("id_persona"));
                System.out.print(" Nombre:" + resultado.getString("nombre") + " ");
                System.out.print(" Apellido:" + resultado.getString("apellido") + " ");
                System.out.print(" Email:" + resultado.getString("email") + " ");
                System.out.print(" Telefono:" + resultado.getString("telefono") + "\n");
            }
            
            //  tercera conexion abierta primera que se debe cerrar
            resultado.close();
            
            //  segunda conexion abierta segunda en cerrarse
            instruccion.close();
            
            //  primera conexion abierta ultima en cerrarse
            conexion.close();
            //  nota las conexiones se cierran desde la ultima que abriste hasta la primera
        } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
                 
        }
    }
}
