package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        String accion = request.getParameter("accion");

        //  creamos los JavaBean
        Rectangulo rectanguloReq = new Rectangulo(3, 7);
        Rectangulo rectanguloSess = new Rectangulo(4, 8);
        Rectangulo rectanguloAppl = new Rectangulo(5, 9);

        //  agregamos el JavaBean a algun alcance
        //  revisamos la accion proporcionada
        if ("agregarVariables".equals(accion)) {
            //  alcance request
            request.setAttribute("rectanguloRequest", rectanguloReq);

            //  alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", rectanguloSess);

            //  alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", rectanguloAppl);

            //  agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //  redireccionamos al jsp de index
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        } else if ("listarVariables".equals(accion)) {
            //  redireccionamos al jsp que despliega las variables, le mandamos la informacion con forward
            
            request.setAttribute("mensaje", "Las variables fueron listadas");
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        } else {
            //  redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);

            //  alternativa que no agrega informacion al JSP
            //  response.sendRedirect("index.jsp");
        }
    }
}
