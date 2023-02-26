package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author asebastian36
 */
@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //  creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();

        //  recuperar la lista de articulos previos
        //  si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        //  verificamos si la lista de articulos existe
        //  si no esta inicializada, se inicia
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //  procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        //  revisamos y agregamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        //  metemos el print en un try y nos ahorramos cerrar
        //  el flujo con close, es opcional
        try ( //  imprimimos la lista de articulos
                PrintWriter salida = response.getWriter()) {
            salida.print("<h1>Lista de Articulos");
            salida.print("<br>");
            
            //  se iteran los articulos
            for (String articulo : articulos) {
                salida.print("<li>" + articulo + "</li>");
            }
            
            //  agregamos link de regreso al inicio
            salida.print("<br>");
            salida.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }
    }
}
