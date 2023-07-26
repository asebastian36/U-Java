package Test;

import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;
import javax.xml.ws.BindingProvider;

/**
 *
 * @author angel
 */
 
public class TestSGAWebService {
    public static void main(String[] args) {
        PersonaServiceWS servicio = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        //  agregar la configuracion para pasar la seguridad
        ((BindingProvider)servicio).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)servicio).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        
        System.out.println("Ejecutando servicio de listar personas WS: ");
        List<Persona> personas = servicio.listarPersonas();
        for(Persona persona : personas) {
            System.out.println("Id: " + persona.getIdPersona() + ", Nombre completo: " + persona.getNombre() + " " + persona.getApellido() + ", Email: " + persona.getEmail() + ", Telefono: " + persona.getTelefono());
        }
        System.out.println("Fin del servicio");
    }
}
