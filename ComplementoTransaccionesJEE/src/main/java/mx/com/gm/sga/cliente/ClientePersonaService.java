package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/TransaccionesJEE/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = personaService.listarPersonas();
            
            personas.forEach(System.out::println);
            
            System.out.println("\nFin llamada al EJB desde el cliente");
            
        } catch (NamingException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
}
