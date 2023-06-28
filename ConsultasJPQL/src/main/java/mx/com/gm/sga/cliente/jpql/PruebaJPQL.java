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
            //  log.debug("Persona = " + persona + ", idPersona = " + idPersona);
        }
        
        log.debug("consultar id de todas las personas todo lo demas en null");
        jpql = "select new mx.com.gm.sga.domain.Persona (p.idPersona) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        //  personas.forEach(System.out::println);
        
        log.debug("Obtener el valor maximo, minimo de un id y la cantidad de id que hay");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iterador = em.createQuery(jpql).getResultList().iterator();
        while (iterador.hasNext()) {
            tupla = (Object[]) iterador.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            //  log.debug("Valor minimo de id: " + idMin + ", valor maximo: " + idMax + " y total de id: " + count);
        }
        
        log.debug("contar el nombre de las personas que son distintos");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        //  System.out.println("contador: " + contador);
        
        log.debug("Concatenar y convertir a mayusculas el nombre y el apellido");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        //  nombres.forEach(System.out::println);
        
        log.debug("Obtiene el objeto persona con id igual al parametro proporcionado");
        int idPersona = 2;
        jpql = "select p from Persona p where p.idPersona = :id";
        query = em.createQuery(jpql);
        query.setParameter("id", idPersona);
        persona = (Persona) query.getSingleResult();
        //  System.out.println("persona = " + persona);
        
        log.debug("Obtener las personas que contengan una letra 'a' en el nombre, sea mayuscula o no");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%a%";
        query = em.createQuery(jpql);
        query.setParameter("parametro", parametro);
        personas = query.getResultList();
        //  personas.forEach(System.out::println);
        
        log.debug("Uso de between para obtener objetos desde un indice hasta otro");
        jpql = "select p from Persona p where p.idPersona between :param and :param1";
        query = em.createQuery(jpql);
        query.setParameter("param", 6);
        query.setParameter("param1", 15);
        personas = query.getResultList();
        //  personas.forEach(System.out::println);
        
        log.debug("Uso del ordenamiento");
        jpql = "select p from Persona p where p.idPersona > :param order by p.nombre desc, p.apellido desc";
        query = em.createQuery(jpql);
        int param = 6;
        query.setParameter("param", param);
        personas = query.getResultList();
        //  personas.forEach(System.out::println);
        
        log.debug("Uso de subquery");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        //  personas.forEach(System.out::println);
        
        log.debug("Uso de join con lazy loading para recuperar usuario con persona");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        //  usuarios.forEach(System.out::println);
    
        log.debug("Uso de left join con eager loading");
        
        jpql = "select u from Usuario u left join fetch u.persona";
        usuarios = em.createQuery(jpql).getResultList();
        usuarios.forEach(System.out::println);
    }
}
