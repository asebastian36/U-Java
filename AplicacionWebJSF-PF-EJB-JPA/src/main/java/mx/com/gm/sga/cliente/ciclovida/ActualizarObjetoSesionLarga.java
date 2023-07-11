package mx.com.gm.sga.cliente.ciclovida;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //  inicia la transaccion
        tx.begin();
        
        //  ejecutar el select
        Persona persona = em.find(Persona.class, 8);
        
        log.debug("Objeto encontrado: " + persona);
        
        //  cambiar valores
        persona.setNombre("Ruben");
        persona.setApellido("Franco Amador");
        
        tx.commit();
        
        // objeto ya modificado que se quedara en la bd
        log.debug("Objeto modificado: " + persona);
        
        //  cerrar el em
        em.close();
    }
}
