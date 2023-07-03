package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

/**
 *
 * @author angel
 */

public class PruebaCriteria {
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        
        //  variables necesarias para ejecutar querys en el API de criteria
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        log.debug("Consulta de todas las personas");
        
        //  instanciar el criteriaBuilder con el EntityManager
        cb = em.getCriteriaBuilder();
        
        //  iniciar el criteria query con el criteriaBuilder
        criteriaQuery = cb.createQuery(Persona.class);
        
        //  crear el objeto raiz de query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //  seleccionar lo necesario del from
        criteriaQuery.select(fromPersona);
        
        //  creamos el query de tipo typeSafe
        query = em.createQuery(criteriaQuery);
        
        //  ejecutamos la consulta
        personas = query.getResultList();
        
        //  personas.forEach(System.out::println);
        
        log.debug("Consultar persona por id");
        //  con jpql "select p from Persona p where p.idPersona = 2"
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 2));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        
        //  System.out.println("persona = " + persona);
        
        log.debug("Consultar persona por id con predicados");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //  los predicados permiten agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        //  verificar si tenemos criterios que agregar
        Integer idPersonaParam = 6;
        ParameterExpression <Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        //  se agregaron criterios
        if(criterios.isEmpty()) throw new RuntimeException("Sin criterios");
        else if(criterios.size() == 1) criteriaQuery.where(criterios.get(0));
        else criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        
        //  inicializamos el query y pasamos el parametro
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //  se ejecuta el query
        persona = query.getSingleResult();
        
        System.out.println("persona = " + persona);
    }
}
