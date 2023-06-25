package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class ClienteAsociacionesJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        //  metodo con con query de JPA para recuperar personas
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        //  cerrar la llamada al entity Manager
        em.close();
        
        //  for para mostrar personas y los usuarios
        personas.forEach(persona -> {
            log.debug(persona);
            for(Usuario usuario : persona.getUsuarioList()) log.debug(usuario);
        });
    }
}
