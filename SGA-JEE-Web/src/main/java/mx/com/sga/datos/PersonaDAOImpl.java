package mx.com.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author angel
 */

@Stateless
public class PersonaDAOImpl implements PersonaDAO{
    //  Esta parte permite la interaccion con la bd
    @PersistenceContext(unitName="PersonaPU")
    EntityManager entityManager;

    @Override
    public List<Persona> listar() {
        return entityManager.createNamedQuery("Persona.listar").getResultList();
    }

    @Override
    public Persona buscar(int id) {
        return entityManager.find(Persona.class, id);
    }

    @Override
    public Persona buscar(String email) {
        Query query = entityManager.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", email);
        
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertar(Persona persona) {
        entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        //  primero se actualiza y luego se elimina
        entityManager.remove(entityManager.merge(persona));
    }
}
