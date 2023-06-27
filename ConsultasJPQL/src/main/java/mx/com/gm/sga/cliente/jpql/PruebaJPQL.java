package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class PruebaJPQL {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        //  definir el query
        String jpql = null;
        Query query = null;
        
        //  variables en las que guardaremos los resultados de las consultas
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iterador = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        //  para poder conectarnos a la bd
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        log.debug("Obtener todos los objetos persona");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //  personas.forEach(instancia -> log.debug(instancia));
        
        log.debug("Obtener objeto por id");
        jpql = "select p from Persona p where p.idPersona = 2";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        //  log.debug(persona);
        
        log.debug("Obtener persona por nombre");
        jpql = "select p from Persona p where p.nombre = 'Barbara'";
        personas = em.createQuery(jpql).getResultList();
        //  personas.forEach(instancia -> log.debug(instancia));
        
        log.debug("Consulta de datos individuales tupla de tipo Object de 3 columnas");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        iterador = em.createQuery(jpql).getResultList().iterator();
        
        while (iterador.hasNext()) {
            tupla = (Object[]) iterador.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            //  log.debug("nombre = " + nombre + ", apellido = " + apellido + " y correo = " + email);
        }
        
        log.debug("Obtener el objeto Persona y el id, con un arreglo Object de 2 columnas");
        jpql = "select p, p.idPersona from Persona p";
        iterador = em.createQuery(jpql).getResultList().iterator();
        
        while(iterador.hasNext()) {
            tupla = (Object[]) iterador.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Persona = " + persona + ", idPersona = " + idPersona);
        }
    }
}
