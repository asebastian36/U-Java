<%-- 
    Document   : reporteExcel
    Created on : 4 mar. 2023, 12:35:26
    Author     : asebastian36
--%>
<%-- 
    Se recomienda que el JPS que procese los errores sea privado
    (que no se pueda acceder por el navegador) se recomienda crearlo
    en la carpeta web inf, entonces si sucede un error se redirigira a 
    manejo errores JSP
--%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<% 
    //  indicamos que descargaremos un excel llamado reporte.xls
    String nombreArchivo = "reporte.xls";
    //  inline para que se pueda procesar la excepcion y se descargue
    //  attachment para descargar
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripcion</th>
                <th>Fecha</th>
            </tr>

            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis basica de Java</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>

            <tr>
                <td>2. Programacion con Java</td>
                <td>Pondremos en ptractica conceptos de la programacion orientada a objetos</td>
                <td><%= Conversiones.format(new Date()) %></td>
            </tr>
        </table>
    </body>
</html>
