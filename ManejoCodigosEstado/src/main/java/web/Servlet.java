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
        //  simulando los valores correctos
        String usuarioOK = "Angel";
        String passwordOK = "123";
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        PrintWriter salida = response.getWriter();
        
        if(usuarioOK.equals(usuario) && passwordOK.equals(password)) {
            salida.print("<h1>");
            salida.print("Datos correctos");
            salida.print("<br>Usuario:" + usuario);
            salida.print("<br>Password:" + password);
            salida.print("</h1>");
        } else {
            //  uso de codigo de estado
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
        }
        
        salida.close();
    }
}
