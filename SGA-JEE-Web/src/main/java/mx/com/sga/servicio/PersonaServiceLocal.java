package mx.com.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author Angel Franco
 */

@Local
public interface PersonaServiceLocal {
    public List<Persona> listar();
    public Persona buscar(int id);
    public Persona buscar(String email);
    public void registrar(Persona persona);
    public void modificar(Persona persona);
    public void eliminar(Persona persona);
}
