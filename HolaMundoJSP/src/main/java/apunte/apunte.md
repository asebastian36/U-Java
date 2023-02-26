# Introduccion a JSP's

## Conceptos basicos de los JSP's

Son componentes del lado del servidor web, estos componentes estan especializados en manejar codigo HTML y a su vez incrustar codigo Java por medio de etiquetas conocidas como `tags`, los
JSP son utilizados como componentes de presentacion, es decir nos permiten mostrar la informacion procesada por otros componentes como pueden ser los servlets.

Un JSP al compilarse se crea de manera indirecta un servlet asociado a este JSP, este servlet se genera de forma automatica no se debe especificar nada para su creacion respecto a la compilacion
del JSP sino que de manera automatica se va a crear este servlet, termina siendo un `.class`, entonces un JSP termina siendo un servlet del lado del servidor web, por ello el ciclo de vida de un
JSP es similar al de un servlet.

## Beneficios de los JSP's

* Enfocarse en escribir codigo HTML, haciendo mas facil el mantenimiento de la capa de presentacion.
* Se pueden utilizar herramientas de diseño para crear visualmente las paginas HTML e incrustar las etiquetas dinamicas de los JSP's.
* Separa el codigo de presentacion del codigo Java.
* Cada miembro del equipo de desarrollo se puede enfocar en distintas tareas al separar las responsabilidades.

## Funciones de un JSP

> Dentro del mvc (modelo vista controlador)

* Capa web
  * JSP (Vista): Se usara como un componente de presentacion, mostrando lo que se recibe del servlet y a su vez mandando informacion al servlet.
  * JavaBean (Modelo)
  * Servlet (controlador)

## Ciclo de vida de un JSP

1. Se traduce el JSP a un servlet, compila y se carga la clase del servlet.
2. Se crea un subproceso del servlet.
3. Se ejecuta el metodo `init()`.
4. Se ejecuta el metodo `service()`.
5. Se ejecuta el metodo `destroy()`.
