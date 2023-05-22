package mx.com.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

/**
 *
 * @author Angel Franco
 */

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listar() {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Angel", "Franco", "angel@mail.com", "1111111111"));
        personas.add(new Persona(2, "Diego", "Franco", "diego@mail.com", "2222222222"));
        return personas;
    }

    @Override
    public Persona buscar(int id) {
        List<Persona> personas = listar();
        
        return (Persona) personas.stream().filter(persona -> persona.getIdPersona() == id);
    }

    @Override
    public Persona buscar(String email) {
        List<Persona> personas = listar();
        
        return (Persona) personas.stream().filter(persona -> persona.getEmail().equals(email));
    }

    @Override
    public void registrar(Persona persona) {
    }

    @Override
    public void modificar(Persona persona) {
    }

    @Override
    public void eliminar(Persona persona) {
    }
}
