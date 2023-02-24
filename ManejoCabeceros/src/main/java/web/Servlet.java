package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();

        String metodoHttp = request.getMethod();

        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Headers HTTP</title>");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Headers HTTP</h1>");

        //  aqui mando el primer header a salida
        salida.print("Metodo http: " + metodoHttp);
        salida.print("<br>");
        //  segunda salida de otro header
        String uri = request.getRequestURI();

        //  imprimimos todos los headers disponibles en esta peticion
        Enumeration cabeceros = request.getHeaderNames();

        //  iteramos los cabeceros obtenidos para su salida
        while (cabeceros.hasMoreElements()) {
            //  cabeceros es un objeto lo pasamos a cadena
            String nombreCabecero = (String) cabeceros.nextElement();
            //  imprimimos los cabeceros en esta linea
            salida.print("<b>" + nombreCabecero + "</b>");
            //  obtener los valores del cabecero
            salida.print(request.getHeader(nombreCabecero));
            salida.print("<br>");
        }
        salida.print("Uri solicitada: " + uri);
        salida.print("</body>");
        salida.print("</html>");
        salida.close();
    }
}
