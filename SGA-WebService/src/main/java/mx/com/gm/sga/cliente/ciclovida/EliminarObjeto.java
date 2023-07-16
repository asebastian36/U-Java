package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class EliminarObjeto {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //  inicia la transaccion
        tx.begin();
        
        //  obtener el objeto de la bd
        Persona persona = em.find(Persona.class, 1);
        
        // eliminar el objeto obtenido  
        em.remove(persona);
        
        //  commit de la transaccion
        tx.commit();
        
        //  cerrar el em
        em.close();
    }
}
