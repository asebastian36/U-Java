<%-- 
    Document   : index
    Created on : 28 feb. 2023, 16:32:08
    Author     : asebastian36
--%>
<%-- agregamos una declaracion de JSP, una vez definido formara parte del
servlet generado--%>
<%!
  //    Declaramos una variable con su metodo get
  private String usuario = "Angel";
  
  public String getUsuario() {
    return this.usuario;
  }

  //    declaramos un contador de visitas
  private int contadorVisitas = 1;

  //    al usar una declaracion estos elementos se definen en la clase (servlet)
  //    esto hace que podamos usar los metodos y atributos alrededor de la clase
  //    volviendolos metodos y atributos del servlet generado del JSP
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de Declaraciones con JSP</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSP</h1>
        <!-- Usando los elementos de la declaracion-->
        Usuario dado por la declaracion (llamando al atributo): <%=this.usuario%>
        <br>
        Usuario dado por la declaracion (llamando al metodo): <%=this.getUsuario()%>
        <br>
        <%-- Aumentando el contador de visitas al entrar a la pagina --%>
        Contador de visitas: <%=this.contadorVisitas++%>
    </body>
</html>
