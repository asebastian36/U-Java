package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class PersistirObjeto {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //  crear objeto
        Persona persona = new Persona("Salomon", "Franco Amador", "salomon@email.com", "1919191919");
        
        //  inicia la transaccion
        tx.begin();
        
        //  persistir el objeto
        em.persist(persona);
        log.debug("Objeto persistido sin commit: " + persona);
        
        //  commit de la transaccion
        tx.commit();
        
        //  objeto en estado detached
        log.debug("Objeto persistido: " + persona);
        
        //  cerrar el em
        em.close();
    }
}
