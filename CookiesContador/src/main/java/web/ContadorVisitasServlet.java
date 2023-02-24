package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  indicar al cliente el numero de veces que ha visto el sitio
        int contador = 0;
        
        //  revisar si la cookie contador visitar ya existe
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(cookie.getValue());
                }
            }
        }
        
        //  incrementar el contador
        contador++;
        
        //  agregarlo a la respuesta 
        Cookie cookie = new Cookie("contadorVisitas", Integer.toString(contador));
        
        //  la cookie solo se almacenara en el cliente por una hora
        cookie.setMaxAge(3600);
        
        response.addCookie(cookie);
        
        //  se manda la respuesta al navegador
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter salida = response.getWriter();
        salida.print("contador de visitas de cada cliente: " + contador);
    }

}
