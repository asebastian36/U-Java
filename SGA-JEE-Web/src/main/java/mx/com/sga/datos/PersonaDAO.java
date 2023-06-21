package mx.com.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author angel
 */

public interface PersonaDAO {
    public List<Persona> listar();
    public Persona buscar(int id);
    public Persona buscar(String email);
    public void insertar(Persona persona);
    public void actualizar(Persona persona);
    public void eliminar(Persona persona);
}
