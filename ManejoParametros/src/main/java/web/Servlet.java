package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  leer los parametros del formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //  esto solo se vera en la consola del servidor de aplicaciones
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        //  esto si lo vera el navegador
        PrintWriter salida = response.getWriter();
        
        //  agregamos HTML, no se revisa sintaxis
        salida.print("<html>");
        salida.print("<body>");
        salida.print("Usuario:" + usuario);
        salida.print("<br>");
        salida.print("Password:" + password);
        salida.print("</body>");
        salida.print("</html>");
        salida.close();
    
    }
}
