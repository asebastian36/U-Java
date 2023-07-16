package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

/**
 *
 * @author angel
 */

public class TestPersonaServiceRS {
    //  Variables a utilizar
    private static final String URL_BASE = "http://localhost:8080/SGA-RS-WebService/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static List<Persona> personas;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        //  leer una persona (con metodo GET)
        webTarget = cliente.target(URL_BASE).path("/personas");
        
        //  Proporcionar un id valido
        persona = webTarget.path("/2").request(MediaType.APPLICATION_XML).get(Persona.class);
        //  System.out.println("Persona recuperada: " + persona);
        
        //  Leer todas las personas (metodo GET readEntity)
        personas = webTarget.request(MediaType.APPLICATION_XML)
                .get(Response.class)
                .readEntity(new GenericType<List<Persona>>(){});
        
        personas.forEach(System.out::println);
        
        //  agregar una persona
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Chucho");
        nuevaPersona.setApellido("Lopez Garcia");
        nuevaPersona.setEmail("chucho@email123.com");
        nuevaPersona.setTelefono("0202020202");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println(response.getStatus());
        
        //  recuperamos la persona agregada para modificarla y eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona agregada: " + personaRecuperada);
        
        //  modificar (metodo PUT) usando la persona recuperada
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Lopez");
        
        String pathId = "/" + personaModificar.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        System.out.println(response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        
        //  eliminar una persona 
        Persona personaEliminar = personaRecuperada;
        String pathEliminar = "/" + personaEliminar.getIdPersona();
        invocationBuilder = webTarget.path(pathEliminar).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println(response.getStatus());
        System.out.println("Persona eliminada: " + personaEliminar);
        
        //  Eliminar registro repetido
        pathEliminar = "/" + 19;
        invocationBuilder = webTarget.path(pathEliminar).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println(response.getStatus());
    }
    
}
