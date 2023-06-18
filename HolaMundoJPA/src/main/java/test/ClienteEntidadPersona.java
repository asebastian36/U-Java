package test;

import javax.persistence.*;
import mx.com.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        //  esa cadena esta en persistence.xml en persistence-unit
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        
        //  iniciar la transaccion
        entityTransaction.begin();
        
        //  no se debe especificar el id
        Persona persona = new Persona("Barbara", "Franco", "barbara@mail.com", "7777777777");
        log.debug("objeto a persistir: " + persona);
        
        //  agregar a la bd
        entityManager.persist(persona);
        
        //  finaliza la transaccion y se guarda el registro  
        entityTransaction.commit();
        log.debug("objeto persistido: " + persona);
        entityManager.close();
    }
}
