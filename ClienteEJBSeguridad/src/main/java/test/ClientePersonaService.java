package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;

/**
 *
 * @author angel
 */

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
        String authFile = "login.conf";
        
        //  proporcionamos la seguridad y un usuario
        System.setProperty("java.security.auth.login.config", authFile);
        ProgrammaticLogin progammaticLogin = new ProgrammaticLogin();
        
        //  el API solicita la contrasena en un arreglo
        progammaticLogin.login("admin", "admin".toCharArray());
        
        try {
            //  para obtener la instancia del EJB
            Context jndi = new InitialContext();
            PersonaServiceRemote servicio = (PersonaServiceRemote) jndi.lookup("java:global/SGA-JEE-Seguridad/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            List<Persona> personas = servicio.listarPersonas();
            
            personas.forEach(System.out::println);
            
            System.out.println("Fin de la llamada al EJB desde el cliente");
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
