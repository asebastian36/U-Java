# Patron de diseño MVC

## Conceptos del patron de diseño MVC

Un patron de diseño, **permite solucionar problemas comunes que se presentan al momento
de crear aplicaciones** y en particular en aplicaciones web interesa separar
la vista de los datos y unirlos por medio de un componente que hace las veces de
controlador y los datos hacen las veces del modelo, los servlets estan enfocados
en controlar el flujo de la aplicacion, en este caso procesan las peticiones HTTP, asi
como tambien utilizan los JavaBeans para almacenar la informacion y finalmente
redireccionar al JSP respectivo, Los JSP estan enfocados en desplegar la informacion
de la aplicacion web.

En este caso la informacion es proveida por medio de los servlets y la informacion que
se comparte entre estos componentes, es decir entre los servlets y JSP suelen manejarse
con JavaBeans.

El patron de diseño MVC (modelo vista controlador) nos permite integrar a los **JSP
(vista)**, a los **servlets (controlador)** y a los **JavaBeans (modelo)**. Para asi
crear aplicaciones web robustas y faciles de mantener.

## Frameworks que utilizan el patron MVC

* **JSP/Servlets:** Se implementa manualmente con ayuda del objeto `RequestDispatcher`
para controlar el flujo de la aplicacion.
* **Struts:** Es un framework de Apache, el cual utiliza JSP (vista) con tags de
Struts, ActionForm (modelo), Action (controlador), entre otros componentes.
* **JavaServer Faces (JSF):** Es una tecnologia que utiliza los conceptos como
JSP (vista) con tags JSF, ManagedBean (controlador) y JavaBeans (modelo).
* **SpringMVC:** Es una extension del framework de Spring, que utiliza JSP (vista) con
tags de Spring, Clases Java (controladores) y JavaBeans (modelo).

> Son solo algunos de los mas representativos. Un patron de diseño, simplemente es
> una guia general y cada framework define la especificacion, segun las mejores
> practicas, desde el punto de vista de cada framework.

## Arquitectura MVC con JSP y servlets

Desde el cliente se envia el formulario HTML (envio POST o GET), se procesa al
servidor (servlet controlador), una vez procesada la peticion nos apoyamos de JavaBeans
(modelo) para almacenar o procesar la informacion de logica de negocio o logica de
presentacion de nuestra aplicacion web, despues regresamos el control de la informacion
al servidor para colocar estos JavaBeans en algun alcance (scope) para compartir
informacion hacia un JSP, el JSP (vista) solo recuperara la informacion que le dio
el servidor, generara un envio de informacion segun el content type para regresar una
pagina resultado.

## Pasos generales de un servlet controlador

Procesamos y validamos los parametros (si aplica):

```java
request.getParameter("nombreParametro");
```

Realizamos la logica de presentacion almacenando el resultado en JavaBeans:

```java
Rectangulo rec = new Rectangulo();
```

Compartimos el objeto bean a utilizar en algun alcance (scope):

```java
request.setAttribute("rectanguloBean", rec);
```

Redireccionamos al JSP seleccionado:

```java
RequestDispatcher disparcher = request.getRequestDispatcher("resultado.jsp");
dispatcher.forward(request, response);
```
