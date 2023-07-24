package test;

import domain.Persona;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

/**
 *
 * @author angel
 */

public class PruebaRestWS {
    public static void main(String[] args) {
        //  para pasar la autenticacion
        HttpAuthenticationFeature feature = HttpAuthenticationFeature
                .basicBuilder()
                .nonPreemptive()
                .credentials("admin", "admin")
                .build();
        
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.register(feature);
        
        Client cliente = ClientBuilder.newClient(clientConfig);
        
        
        //  para listar las personas
        WebTarget webTarget = cliente.target("http://localhost:8080/SGA-JEE-Seguridad/webservice").path("/personas");
        List<Persona> personas = webTarget.request(MediaType.APPLICATION_XML)
                .get(Response.class)
                .readEntity(new GenericType<List<Persona>>(){});
        System.out.println("personas = " + personas);
        
        //  para obtener una persona en especifico
        Persona persona = webTarget.path("2").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("persona = " + persona);
    }
}
