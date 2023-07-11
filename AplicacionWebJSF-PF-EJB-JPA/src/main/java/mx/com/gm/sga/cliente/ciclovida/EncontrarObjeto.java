package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class EncontrarObjeto {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //  inicia la transaccion
        tx.begin();
        
        //  hacer la busqueda por id (es el numero)
        Persona persona = em.find(Persona.class, 3);
        
        //  commit de la transaccion
        tx.commit();
        
        log.debug("objeto encontrado: " + persona);
        
        //  cerrar el em
        em.close();
    }
}
