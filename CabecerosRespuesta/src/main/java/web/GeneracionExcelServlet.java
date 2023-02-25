 package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/*
 * @author Angel Sebastian
 */
@WebServlet("/GeneracionExcelServlet")
 public class GeneracionExcelServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //  indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //  para un uso profesional de excel poi.apache.org
        
        //  cabeceros para no guardar cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        
        //  para que la informacion expire de manera inmediata
        response.setDateHeader("Expires",  -1);
        
        //  desplegar la informacion
        PrintWriter salida = response.getWriter();
        salida.println("\tValores");
        salida.println("\t1");
        salida.println("\t2");
        salida.println("Total\t=SUMA(b2:b3)");
        salida.close();
    }

}
