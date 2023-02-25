package mx.com.gm.jdbc.test;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.datos.*;
import mx.com.gm.jdbc.domain.Persona;

/*
 * @author Angel Sebastian
 */
public class TestPersona {
    public static void main(String[] args) {
        Connection conexion = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
                
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            
            //  aqui empezamos las transacciones:
            
            //  instruccion para testear el rollback:
            //  personaDAO.insertar(new Persona("Palaalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UwU", "palaaa@mail.com", "5588226633"));
            personaDAO.actualizar(new Persona(2, "Sebastian", "Lopez", "sebastian@email.com", "1122334455"));
            personas = personaDAO.seleccionar();
            
            personas.forEach(persona -> {
                System.out.println("persona = " + persona);
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

