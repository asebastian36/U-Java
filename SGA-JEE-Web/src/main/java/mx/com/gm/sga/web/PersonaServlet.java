package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.sga.servicio.PersonaServiceLocal;

/**
 *
 * @author Angel Franco
 */

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    
    @Inject
    PersonaServiceLocal personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Persona> personas = personaService.listar();
        personas.forEach(System.out::println);
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}
