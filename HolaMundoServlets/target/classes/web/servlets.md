# Conceptos basicos de los servlets

Un **servlet** es una clase de Java que permite procesar peticiones web por medio del protocolo `HTTP`, cuando el cliente hace una peticion a nuestro
`servidor web` por medio de un servlet vamos a poder `procesar dicha peticion`, en la peticion pueden ir parametros como resultado de ejecutar un link
o informacion que provenga de un `formulario HTML` y de esta manera es que se comienza la comunicacion entre cliente y servidor.

Una vez que el **servlet** procesa la `peticion del cliente` y recupera los parametros, normalmente realiza un procesamiento como es `recuperar
informacion` de una base de datos o realizar algun calculo del lado del servidor y como resultado del proceso se vuelve a mostrar informacion hacia
el cliente que hizo la peticion respectiva.

Un **servlet** permite leer informacion del cliente web, es decir los `parametros de una peticion`, tambien nos permite `generar una respuesta` para
mostrar al cliente, es decir generar el codigo HTML y archivos binarios como pueden ser PDF, audio, video, etc.

## Funciones de un servlet

El servlet su uso mas comun es cuando queremos `controlar el flujo de la aplicacion web`. Por ejemplo en el modelo `MVC` el servlet tiene la funcion
de controlador. Un servlet `contiene codigo Java` y `puede generar codigo HTML` de manera embebida, esto quiere decir que los servlets `no sera la mejor
opcion para generar codigo HTML` debido a que sera mas complejo embeber el codigo HTML en nuestro codigo Java (para estos casos es mejor el uso de
los JSP's).

## Metodos HTTP y procesamiento con servlets

En total son 8 los metodos soportados por el protocolo HTTP. Los cuales son: **Options, Get, Head, Post, Put, Delete, Trace y Connect**. Los metodos
mas utilizados son **GET** y **POST**.

### GET

* Enviar informacion por una URL
* El metodo que usa el servlet es doGet()

### POST

* Envia informacion en el cuerpo del mensaje, no el URL
* El metodo que usa el servlet es doPost()

> un servlet hereda de la clase `HTTPServlet` y tiene que sobreescribir los metodos **GET** y **POST**.

## Ciclo de vida de un servlet

1. Se compila y se carga la clase
2. Se crea un subproceso (hilo) del servlet
3. Se ejecuta el metodo init(), solo se ejecuta al llamar por primera vez al servlet
4. Se ejecuta el metodo service(), se encarga de llamar indirectamente los metodos **GET** y **POST**, NO se debe sobreescribir ya que sino
ya no llamara a los metodos **GET** y **POST**, solo sobreescribir en caso de necesidades avanzadas
5. Se ejecuta el metodo destroy(), solo se ejecuta al procesar todas las peticiones del usuario, puede ser una o muchas
