# Paquete web

El paquete web contiene al servlet controlador el cual es encarga de hacer el listado de clientes y pasar la informacion
a otro JSP llamado `Clientes.jsp`. El metodo `doGet()` se encargara de recuperar el listado de clientes, compartira la informacion
en alguno de los alcances disponibles y posteriormente se hara un redirect a la pagina de clientes
