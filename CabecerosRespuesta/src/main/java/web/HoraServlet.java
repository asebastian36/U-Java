package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */

@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //  para que se repita cada segundo
        response.setHeader("refresh", "1");
        
        //  obtenemos la hora
        Date hora = new Date();
        
        //  instanciamos el objeto para dar el formato
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        
        String horaFormat = formato.format(hora);
        
        //  salida
        PrintWriter salida = response.getWriter();
        salida.print(horaFormat);
        
    }
}
