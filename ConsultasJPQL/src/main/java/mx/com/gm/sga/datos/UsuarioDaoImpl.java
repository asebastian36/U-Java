package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author angel
 */

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;
    
    @Override
    public List<Usuario> findAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findByIdUsuario(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public Usuario findByUsername(Usuario usuario) {
        Query query = em.createQuery("from Usuario u where u.userName =: username");
        query.setParameter("username", usuario.getUsername());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public Usuario findByPassword(Usuario usuario) {
        Query query = em.createQuery("from Usuario u where u.password =: password");
        query.setParameter("password", usuario.getPassword());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
}
