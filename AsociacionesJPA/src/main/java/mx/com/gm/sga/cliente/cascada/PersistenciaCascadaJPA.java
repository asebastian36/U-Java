package mx.com.gm.sga.cliente.cascada;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        //  inicio
        et.begin();
        
        //  aqui se relacionan el usuario y la persona
        Persona persona = new Persona("Angel Sebastian", "Franco Lopez", "angelfranco2017@hotmail.com", "1111111111");
        Usuario usuario = new Usuario("Chido Tuzo", "2323232323", persona);
        
        //  persistimos solo el objeto de usuario y persistira automaticamente la persona
        em.persist(usuario);
        
        //  commit
        et.commit();
        
        //  objetos en estado detached
        log.debug("persona " + persona);
        log.debug("usuario " + usuario);
        
        em.close();
    }
}
