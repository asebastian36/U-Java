package test;

import domain.Persona;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author angel
 */

public class Test {
    //  Variables a utilizar
    private static final String URL_BASE = "http://localhost:8080/SGA-RS-WebService/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Persona persona;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        //  hice este test porque el otro es un desastre
        
        cliente = ClientBuilder.newClient();
        
        //  leer una persona (con metodo GET)
        webTarget = cliente.target(URL_BASE).path("/personas");
        
        //  Obtener registro con el id de la bd
        persona = webTarget.path("/18").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada: " + persona);
        
        persona.setApellido("Lopez Garcia");
        
        //  modificar (metodo PUT) usando la persona recuperada
        String pathId = "/" + persona.getIdPersona();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(persona, MediaType.APPLICATION_XML));
        System.out.println(response.getStatus());
        System.out.println("Persona modificada: " + response.readEntity(Persona.class));
        
        
    }
}
