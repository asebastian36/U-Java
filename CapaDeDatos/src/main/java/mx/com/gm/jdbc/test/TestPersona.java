package mx.com.gm.jdbc.test;

import java.sql.*;
import java.util.*;
import mx.com.gm.jdbc.datos.*;
import mx.com.gm.jdbc.domain.PersonaDTO;

/*
 * @author Angel Sebastian
 */
public class TestPersona {
    public static void main(String[] args) {
        Connection conexion = null;
        List<PersonaDTO> personas = new ArrayList<>();
        
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) conexion.setAutoCommit(false);
            
            //  Usamos la interfaz en la declaracion y el contenido es el especifico
            PersonaDAO personaDAO = new PersonaDAOImpl(conexion);
            
            //  aqui empezamos las transacciones:
            
            //  instruccion para testear el rollback:
            //  personaDAO.insert(new Persona("Palaalaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "UwU", "palaaa@mail.com", "5588226633"));
            
            personas = personaDAO.select();
            
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

