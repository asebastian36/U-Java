package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Rectangulo;

/**
 *
 * @author asebastian36
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  procesamos los parametros

        //  creamos los JavaBean
        Rectangulo rectangulo = new Rectangulo(3, 7);

        //  agregamos el JavaBean a algun alcance
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        //  establecimos el alcance session del JavaBean
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rectangulo);
        
        //  redireccionar a la vista seleccionada
        
        //  obtenemos la vista a redireccionar
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        
        //  propagamos los objetos y response para recuperar la informacion
        rd.forward(request, response);
    }

}
