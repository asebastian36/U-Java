package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import mx.com.gm.sga.domain.Persona;
import mx.com.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author Angel Franco
 */

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/SGA-JEE/PersonaServiceImpl!mx.com.sga.servicio.PersonaServiceRemote");
            List<Persona> personas = personaService.listar();
            
            personas.forEach(System.out::println);
            
            System.out.println("fin de la llamada al EJB desde el cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
