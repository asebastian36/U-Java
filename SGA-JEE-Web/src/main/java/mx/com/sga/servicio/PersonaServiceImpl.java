package mx.com.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.domain.Persona;
import mx.com.sga.datos.PersonaDAO;

/**
 *
 * @author Angel Franco
 */

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaServiceLocal{

    @Inject
    private PersonaDAO repositorio;
    
    @Override
    public List<Persona> listar() {
        return repositorio.listar();
    }

    @Override
    public Persona buscar(int id) {
        return repositorio.buscar(id);
    }

    @Override
    public Persona buscar(String email) {
        return repositorio.buscar(email);
    }

    @Override
    public void registrar(Persona persona) {
        repositorio.insertar(persona);
    }

    @Override
    public void modificar(Persona persona) {
        repositorio.actualizar(persona);
    }

    @Override
    public void eliminar(Persona persona) {
        repositorio.eliminar(persona);
    }
}
