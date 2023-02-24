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
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF8");
        PrintWriter salida = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentarios");
        
        salida.print("<html>");
        salida.print("<head>");
        salida.print("<title>Resultado Servlet</title>");
        salida.print("</head>");
        salida.print("<body>");
        salida.print("<h1>Parametros procesados por el Servlet:</h1>");
        salida.print("<table border='1'>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Usuario");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(usuario);
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Password");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(password);
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Tecnologias");
        salida.print("</td>");
        salida.print("<td>");
        
        for(String tecnologia: tecnologias) {
            salida.print(tecnologia);
            salida.print(" / ");
        }
        
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Genero");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(genero);
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Ocupacion");
        salida.print("</td>");
        salida.print("<td>");
        salida.print(ocupacion);
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Musica favorita");
        salida.print("</td>");
        salida.print("<td>");
        
        if(musica != null) {
            for(String music: musica) {
                salida.print(music);
                salida.print(" / ");
            }
        } else salida.print("valor no proporcionado");
        
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("<tr>");
        salida.print("<td>");
        salida.print("Comentarios");
        salida.print("</td>");
        salida.print("<td>");
        if(comentarios != null) salida.print(ocupacion);
        else salida.print("valor no proporcionado");
        salida.print("</td>");
        salida.print("</tr>");
        
        salida.print("</table>");
        salida.print("</body>");
        salida.print("</html>");
    }
}
