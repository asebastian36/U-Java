# Introduccion a JSF

## Que es JavaServerFaces?

JavaServerFaces es una tecnologia que fue **creada para la construccion de la interfaz de usuario para aplicaciones web Java**
uno de los puntos clave fue el apoyo de las herramientas creadas para este tipo de aplicaciones JavaServerFaces tiene el apoyo de
IDEs tales como Eclipse, Intellij Idea, Netbeans, MyEclipse, Oracle JDeveloper, etc. Ademas cuenta con un fuerte apoyo en servidores
de aplicaciones Java, con el **objetivo de soportar y desplegar las aplicaciones creadas en JSF**.

**JavaServerFaces (JSF) es el marco de aplicaciones web estandar para Java Enterprise Edition (Java EE)**, al ser un estandar de Java, la
tecnologia cuenta con el apoyo de una industria muy solida, La tecnologia ha crecido en su uso a nivel mundial, se cuenta con un
fuerte apoyo de IDEs de Java, asi como servidores de aplicaciones para su despliegue.

## Caracteristicas de JSF

* **MVC:** Implementa el patron de diseño Modelo-Vista-Controlador.
* **RAD:** Desarrollo rapido en aplicaciones para web.
* **Componentes de interfaz de usuario:** JSF tiene desarrollados componentes reutilizables listos para utilizarse.
* **Render-Kits:** Los componentes pueden desplegarse no solamente en navegadores web, sino en dispositivos moviles u otros tipos de
clientes.
* **Extensibilidad:** JSF es altamente extensible debido a su arquitectura.
* **Internacionalizacion:** Las vistas pueden mostrarse en distintos idiomas.

### Nuevas caracteristicas de JSF

* Manejo de condiciones por default mas inteligentes.
* Manejo de anotaciones para varias configuraciones.
* Soporte nativo para AJAX.
* Soporte por default para Facelets.
* Mas componentes y validadores.

## Arquitectura JavaServerFaces

**Capa del cliente** en la cual se visualiza el resultado de la aplicacion al interactuar con la aplicacion, se pasa a la **capa web (JSF)** con
componentes como los `Managed Bean` (controlador), `JavaBean` (modelo), `Facelets/JSP` (vista), posteriormente se pasa a la **capa de negocio**
usando clases nativas de Java, despues se pasa a la **capa de datos**.

> JavaServerFaces implementa el patron de diseño MVC con una clara separacion de responsabilidades

## Patron de diseño MVC con JSF

* **Modelo (managed Bean de modelo):** Contiene datos de la interfaz de usuario y es el responsable de almacenar los datos de la aplicacion web se puede
implementar con clases de Java (POJO Plain Old Java Object) o con ManegedBean de modelo. No contienen logica de la aplicacion ni administran
el flujo de la misma.

* **Vista (Facelets o JSPs):** Define la interfaz de usuario con una jerarquia de componentes utiliza la libreria estandar de `JSF` tambien
usa tecnologias como `EL`, `JSTL` para facilitar el despliegue de la informacion del modelo.

* **Controlador (Managed Bean controlador):** Maneja las interaciones del usuario y la navegacion o flujo de la aplicacion se implementa con managed Bean
de control.

### Tecnologias de los Facelets

Los Facelets son la tecnologia estandar de despliegue en JSF, pueden ser hasta 30% mas rapidos en el analisis, contruccion y elaboracion de paginas de
despliegue en la tecnologia de JSF, fueron creados tomando en cuenta el ciclo de vida de JSF, Al ejecutar un Facelet, todos los componentes JSF se
convierten a instancias Java y son administradas por un `Component Tree` (tambien es una clase de Java), todos los componentes JSF se derivan de
la clase abstracta `javax.faces.component.UIComponent`, el estado de los componentes (Component Tree) puede almacenarse del lado del cliente o del
lado del servidor, ademas al utilizar facelets es mas sencillo encapsular codigo y asi crear componentes reutilizables, los facelets permiten crear
plantillas y asi definir mas vistas a partir de plantillas ya definidas.

### Flujo de navegacion en JSF

1. El framework inicia una peticion GET a una pagina.
2. Una vez que ya estamos dentro del contexto de JSF el usuario recibe el contenido de respuesta y envia nuevamente una peticion POST o una peticion
GET al servidor web, en esta peticion el usuario esta solicitando cierto recurso.
3. El servidor web recibe la peticion y revisa los managed Bean involucrados en la peticion, si es necesario crea una instancia de ellos dependiendo
de su alcance y en este momento, tambien si es necesario se mandan a llamar los metodos setters de las propiedades del Bean que se deben de llenar.
4. Se ejecuta el metodo que procesa la peticion solicitada por el cliente en este momento ya deben estar instanciados los Managed Bean involucrados
en la peticion (si es que los hay).
5. Se ejecuta la logica de negocio con el objetivo de obtener el modelo de nuestra aplicacion (informacion que se va a desplegar o manipular dentro
de la aplicacion).
6. Se selecciona el paso de navegacion especifico y se redirecciona a la vista correspondiente, en este caso la vista puede ser una pagina
facelets o puede ser un jsp.
7. la vista utiliza la informacion de modelo que le compartio la aplicacion JSF para finalmente regresar la respuesta solicitada al cliente,
opcionalmente podria simplemente redireccionarse a algun caso de navegacion, es decir pasar de la peticion 2 directamente al paso 6 simplemente
para seleccionar una pagina a redireccionar.
