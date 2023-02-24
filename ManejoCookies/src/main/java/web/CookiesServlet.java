package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
    //  ejercicio para revisar si un usuario ya a revisado nuestro sitio
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //suponemos que el usuario visita por primera vez el sitio
        boolean nuevoUsuario = true;

        //  obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();

        //  buscamos si ya existe una cookie creada con anterioridad
        //  llamada visitaRecurrente
        if (cookies != null) {
            //  recorremos las cookies
            for (Cookie cookie : cookies) {
                //  condicion para saber si el usuario es nuevo o recurrente
                if (cookie.getName().equals("visitanteRecurrente") && cookie.getValue().equals("si")) {
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        String mensaje = null;
        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Graciar por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "gracias por volver a visitarnos";
        }

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter salida = response.getWriter();

        salida.print(mensaje);
        salida.close();
    }
}
