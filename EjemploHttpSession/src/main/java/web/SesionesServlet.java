package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author asebastian36
 */

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //  Obtenemos la sesion
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //  pedir el atributo contador visitas
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //  puede regresar null, si es asi, es la primera vez que visita el sitio
        if(contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido de vuelta";
        }
        
        //  agregamos el atributo a la sesion
        sesion.setAttribute("contadorVisitas",contadorVisitas);
        
        //  los valores de una sesion se almacenan como un mapa
        
        //  salida de la respuesta al cliente
        PrintWriter salida = response.getWriter();
        salida.print(titulo);
        salida.print("<br>");
        salida.print("No. de accesos al recurso: " + contadorVisitas);
        salida.print("<br>");
        salida.print("ID de la sesion: " + sesion.getId());
        salida.close();
        
        //  en el web.xml de web inf se dice que la informacion
        //  solo durara 30min si ya no hace uso de la sesion
    }
}
