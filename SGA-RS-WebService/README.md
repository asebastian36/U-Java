# Notas

Se copio el proyecto anterior **SGA-WebService**.

## Cambios

* Se agrego la dependencia de JAX-RS al `pom.xml`.
* Creacion de la clase `PersonaServiceRS` en el paquete de `servicio`.
* Modificaciones a la clase de entidad `Persona`.
* Cambios en el archivo `web.xml` en la carpeta `Web pages/WEB-INF`

## REST Web Services en Java EE

REST (Representational State Transfer) es un estilo arquitectónico para la creación de servicios web. REST se basa en la idea de utilizar HTTP como protocolo de transporte y los recursos web como modelo de datos.

Los servicios web REST se pueden crear utilizando una variedad de lenguajes de programación, incluyendo Java. Para crear un servicio web REST en Java, puede utilizar la API JAX-RS (Java API for RESTful Web Services).

JAX-RS es una API que facilita el desarrollo de servicios web REST en Java. JAX-RS proporciona una serie de clases y métodos que pueden utilizarse para crear servicios web REST que sean interoperables y fáciles de usar.

Para crear un servicio web REST con JAX-RS, debe crear una clase que extienda la clase javax.ws.rs.core.Response. La clase debe contener métodos que devuelvan objetos javax.ws.rs.core.Response.

Los métodos de la clase deben definir las operaciones que el servicio web ofrece. Los métodos deben devolver objetos javax.ws.rs.core.Response. El objeto javax.ws.rs.core.Response puede utilizarse para devolver datos al cliente, establecer el estado de la respuesta y establecer las cabeceras de la respuesta.

Una vez que haya creado la clase, debe anotarla con las anotaciones JAX-RS. Las anotaciones JAX-RS se utilizan para describir la interfaz del servicio web.

Para publicar el servicio web, debe desplegarlo en un servidor de aplicaciones. El servidor de aplicaciones debe soportar JAX-RS.

Una vez que el servicio web se haya publicado, los clientes pueden acceder a él y utilizar sus operaciones. Los clientes pueden ser aplicaciones web, aplicaciones móviles o cualquier otra aplicación que soporte el uso de servicios web REST.

Aquí hay algunos beneficios de utilizar servicios web REST:

* **Fáciles de usar:** Los servicios web REST son fáciles de usar porque se basan en HTTP, que es un protocolo bien conocido y utilizado.
* **Interoperables:** Los servicios web REST son interoperables porque se basan en estándares abiertos.
* **Escalables:** Los servicios web REST son escalables porque se basan en HTTP, que es un protocolo escalable.
* **Económicos:** Los servicios web REST son económicos porque se basan en HTTP, que es un protocolo gratuito.

Si está desarrollando servicios web, entonces debe considerar utilizar servicios web REST. Los servicios web REST pueden ayudar a garantizar que los servicios web sean fáciles de usar, interoperables, escalables y económicos.

## Principios de una arquitectura REST

Los principios de la arquitectura REST son los siguientes:

* **Cliente-servidor:** La arquitectura REST está basada en el modelo cliente-servidor, lo que significa que el cliente solicita información al servidor y el servidor proporciona la información solicitada.
* **Estadoless:** La arquitectura REST es stateless, lo que significa que el servidor no mantiene ningún estado sobre las solicitudes del cliente. Esto facilita la escalabilidad de los servicios REST.
* **Cacheable:** La arquitectura REST es cacheable, lo que significa que el cliente puede almacenar los resultados de una solicitud en caché y reutilizarlos para solicitudes posteriores. Esto puede mejorar el rendimiento de los servicios REST.
* **Consistencia:** La arquitectura REST es consistente, lo que significa que las operaciones realizadas sobre los recursos web siempre deben tener el mismo resultado. Esto facilita el desarrollo de aplicaciones que utilizan servicios REST.
* **Seguridad:** La arquitectura REST es segura, lo que significa que los servicios REST deben estar protegidos de acceso no autorizado. Esto se puede hacer utilizando mecanismos de seguridad HTTP, como HTTP Basic Auth o OAuth.
* **Usabilidad:** La arquitectura REST debe ser fácil de usar. Esto se puede hacer utilizando un lenguaje claro y conciso para las URI y proporcionando documentación clara para los servicios REST.

## Peticion y respuesta HTTP

Una solicitud HTTP es un mensaje que se envía desde un cliente a un servidor. La solicitud contiene información sobre lo que el cliente quiere que haga el servidor. Una respuesta HTTP es un mensaje que se envía desde un servidor a un cliente. La respuesta contiene información sobre lo que el servidor ha hecho con la solicitud del cliente.

Una solicitud HTTP se compone de las siguientes partes:

* **Método:** El método es el tipo de operación que el cliente quiere que realice el servidor. Los métodos HTTP más comunes son GET, POST, PUT y DELETE.
* **URL:** La URL es la dirección del recurso que el cliente quiere que acceda el servidor.
* **Cabeceras:** Las cabeceras son información adicional que se envía con la solicitud. Las cabeceras pueden utilizarse para proporcionar información sobre el cliente, el servidor, la solicitud o la respuesta.
* **Cuerpo:** El cuerpo es la información real que el cliente quiere que procese el servidor. El cuerpo puede estar en formato de texto, binario o XML.

Una respuesta HTTP se compone de las siguientes partes:

* **Código de estado:** El código de estado es un número que indica el resultado de la solicitud. Los códigos de estado HTTP más comunes son 200 (OK), 400 (Bad Request), 404 (Not Found) y 500 (Internal Server Error).
* **Cabeceras:** Las cabeceras son información adicional que se envía con la respuesta. Las cabeceras pueden utilizarse para proporcionar información sobre el servidor, la solicitud o la respuesta.
* **Cuerpo:** El cuerpo es la información real que el servidor envía al cliente. El cuerpo puede estar en formato de texto, binario o XML.

Aquí hay un ejemplo de una solicitud HTTP:

```http
GET /index.html HTTP/1.1
Host: www.example.com
```

Este es un ejemplo de una respuesta HTTP:

```html
HTTP/1.1 200 OK
Content-Type: text/html
Content-Length: 100

<html>
<head>
<title>Example</title>
</head>
<body>
This is an example of an HTML document.
</body>
</html>
```

## Cliente JAX-RS en Java EE

JAX-RS (Java API for RESTful Web Services) es una API que facilita el desarrollo de servicios web RESTful en Java. JAX-RS proporciona una serie de clases y métodos que pueden utilizarse para crear servicios web RESTful que sean interoperables y fáciles de usar.

Para crear un cliente JAX-RS en Java EE, debe crear una clase que extienda la clase javax.ws.rs.client.Client. La clase debe contener métodos que devuelvan objetos javax.ws.rs.client.Client.

Los métodos de la clase deben definir las operaciones que el cliente quiere realizar. Los métodos deben devolver objetos javax.ws.rs.client.Client. El objeto javax.ws.rs.client.Client puede utilizarse para realizar solicitudes al servicio web RESTful, recibir respuestas del servicio web RESTful y procesar las respuestas del servicio web RESTful.

Una vez que haya creado la clase, debe anotarla con las anotaciones JAX-RS. Las anotaciones JAX-RS se utilizan para describir la interfaz del cliente.

Para publicar el cliente, debe desplegarlo en un servidor de aplicaciones. El servidor de aplicaciones debe soportar JAX-RS.

Una vez que el cliente se haya publicado, los clientes pueden acceder a él y utilizar sus operaciones. Los clientes pueden ser aplicaciones web, aplicaciones móviles o cualquier otra aplicación que soporte el uso de clientes JAX-RS.

Aquí hay algunos beneficios de utilizar clientes JAX-RS:

* **Fáciles de usar:** Los clientes JAX-RS son fáciles de usar porque se basan en la API JAX-RS, que es una API bien documentada y fácil de usar.
* **Interoperables:** Los clientes JAX-RS son interoperables porque se basan en la API JAX-RS, que es una API estándar.
* **Escalables:** Los clientes JAX-RS son escalables porque se basan en la API JAX-RS, que es una API escalable.
* **Económicos:** Los clientes JAX-RS son económicos porque se basan en la API JAX-RS, que es una API gratuita.

Si está desarrollando un cliente para un servicio web RESTful, entonces debe considerar utilizar un cliente JAX-RS. Los clientes JAX-RS ofrecen una serie de ventajas sobre otros tipos de clientes, como los clientes HTTP.

## Cliente REST Web service

Un cliente REST Web Service es una aplicación que utiliza un protocolo de transferencia de estado representacional (REST) para comunicarse con un servicio web. Un cliente REST Web Service puede ser una aplicación web, una aplicación móvil o cualquier otra aplicación que pueda enviar y recibir solicitudes HTTP.

Los clientes REST Web Service se utilizan para acceder a los datos y las funcionalidades que se ofrecen por un servicio web. Los clientes REST Web Service pueden utilizarse para realizar una serie de operaciones, como:

* **Obtener datos:** Los clientes REST Web Service pueden utilizarse para obtener datos de un servicio web. Los datos se pueden obtener en formato JSON, XML o cualquier otro formato que sea compatible con el servicio web.
* **Enviar datos:** Los clientes REST Web Service pueden utilizarse para enviar datos a un servicio web. Los datos se pueden enviar en formato JSON, XML o cualquier otro formato que sea compatible con el servicio web.
* **Actualizar datos:** Los clientes REST Web Service pueden utilizarse para actualizar datos en un servicio web. Los datos se pueden actualizar en formato JSON, XML o cualquier otros formato que sea compatible con el servicio web.
* **Eliminar datos:** Los clientes REST Web Service pueden utilizarse para eliminar datos de un servicio web. Los datos se pueden eliminar en formato JSON, XML o cualquier otro formato que sea compatible con el servicio web.

Los clientes REST Web Service se pueden desarrollar utilizando una variedad de lenguajes de programación, incluyendo Java, Python, C# y Ruby. Hay una serie de bibliotecas y frameworks disponibles que pueden facilitar el desarrollo de clientes REST Web Service.

## Integracion de REST Web service y EJB's en Java EE

Claro. La integración de REST Web Service y EJB's en Java EE es un proceso que permite a los desarrolladores crear servicios web RESTful que se integren con las aplicaciones empresariales existentes.

El proceso de integración de REST Web Service y EJB's en Java EE consta de los siguientes pasos:

1. Crear un servicio web RESTful utilizando la API JAX-RS.
2. Crear un EJB que implemente la funcionalidad del servicio web RESTful.
3. Inyectar el EJB en el servicio web RESTful.
4. Publicar el servicio web RESTful en un servidor de aplicaciones Java EE.

Una vez que el servicio web RESTful esté publicado, los clientes pueden acceder a él y utilizar sus operaciones. Los clientes pueden ser aplicaciones web, aplicaciones móviles o cualquier otra aplicación que soporte el uso de servicios web RESTful.

## Representaciones con REST

En REST, una representación es la forma en que se presenta la información a un cliente. Las representaciones más comunes son JSON y XML, pero también se pueden utilizar otros formatos, como HTML, CSV o texto.

Las representaciones se utilizan para devolver datos de un servidor a un cliente. La representación se elige en función del cliente y de los datos que se devuelven. Por ejemplo, si el cliente es un navegador web, se devolverá una representación HTML. Si el cliente es una aplicación móvil, se devolverá una representación JSON o XML.

Las representaciones también se utilizan para enviar datos de un cliente a un servidor. Por ejemplo, si un cliente quiere crear un nuevo registro, enviará una representación JSON o XML del registro al servidor.

Las representaciones son una parte importante de REST. Proporcionan una forma estándar de representar la información, lo que facilita a los clientes y a los servidores comunicarse entre sí.

Aquí hay algunos ejemplos de representaciones:

* **JSON:** JSON es un formato ligero de texto que se utiliza para representar datos. JSON es fácil de leer y escribir, y se puede utilizar en una variedad de lenguajes de programación.
* **XML:** XML es un lenguaje de marcado que se utiliza para representar datos. XML es más complejo que JSON, pero también más poderoso. XML se puede utilizar para representar datos complejos, como árboles de datos o gráficos.
* **HTML:** HTML es un lenguaje de marcado que se utiliza para crear páginas web. HTML se puede utilizar para representar datos de una manera que sea fácil de ver para los humanos.
* **CSV:** CSV es un formato de texto que se utiliza para representar datos en forma tabular. CSV es fácil de leer y escribir, y se puede utilizar en una variedad de aplicaciones.
* **Texto:** El texto es una forma básica de representar datos. El texto es fácil de leer y escribir, pero no es tan potente como otros formatos, como JSON o XML.

El formato de representación que se utiliza depende del cliente y de los datos que se devuelven. Por ejemplo, si el cliente es un navegador web, se devolverá una representación HTML. Si el cliente es una aplicación móvil, se devolverá una representación JSON o XML.

Las representaciones son una parte importante de REST. Proporcionan una forma estándar de representar la información, lo que facilita a los clientes y a los servidores comunicarse entre sí.

## Anotaciones en JAX-RS

JAX-RS (Java API for RESTful Web Services) es una API que facilita el desarrollo de servicios web RESTful en Java. JAX-RS proporciona una serie de anotaciones que se pueden utilizar para describir la interfaz de un servicio web RESTful.

Las anotaciones JAX-RS más comunes son las siguientes:

* **@Path:** La anotación @Path se utiliza para asociar una ruta a un método. La ruta se utiliza para identificar el método en el servicio web RESTful.
* **@GET:** La anotación @GET se utiliza para asociar un método con la solicitud HTTP GET. La solicitud HTTP GET se utiliza para recuperar datos del servicio web RESTful.
* **@POST:** La anotación @POST se utiliza para asociar un método con la solicitud HTTP POST. La solicitud HTTP POST se utiliza para crear nuevos datos en el servicio web RESTful.
* **@PUT:** La anotación @PUT se utiliza para asociar un método con la solicitud HTTP PUT. La solicitud HTTP PUT se utiliza para actualizar datos existentes en el servicio web RESTful.
* **@DELETE:** La anotación @DELETE se utiliza para asociar un método con la solicitud HTTP DELETE. La solicitud HTTP DELETE se utiliza para eliminar datos del servicio web RESTful.

Las anotaciones JAX-RS se pueden utilizar para describir la interfaz de un servicio web RESTful de una manera clara y concisa. Esto facilita a los clientes de un servicio web RESTful entender qué métodos están disponibles y cómo se utilizan.

Aquí hay un ejemplo de cómo se puede utilizar la anotación @Path para asociar una ruta a un método:

```Java
@Path("/products")
public class ProductResource {

    @GET
    public Response getProducts() {
        // Get all products from the database.
    }

    @POST
    public Response createProduct(Product product) {
        // Create a new product in the database.
    }

    @PUT
    public Response updateProduct(Product product) {
        // Update an existing product in the database.
    }

    @DELETE
    public Response deleteProduct(Long productId) {
        // Delete a product from the database.
    }
}
```

En este ejemplo, la anotación @Path se utiliza para asociar la ruta "/products" al método `getProducts()`. La anotación @GET se utiliza para asociar el método `getProducts()` con la solicitud HTTP GET.

Las anotaciones JAX-RS son una herramienta poderosa que se puede utilizar para describir la interfaz de un servicio web RESTful.

## Integracion REST WS y una aplicacion web

Claro. La integración de REST WS y una aplicación web es el proceso de conectar un servicio web RESTful a una aplicación web. Esto permite que la aplicación web acceda a los datos y las funcionalidades que se ofrecen por el servicio web RESTful.

El proceso de integración de REST WS y una aplicación web consta de los siguientes pasos:

1. Crear un servicio web RESTful.
2. Crear una aplicación web que utilice el servicio web RESTful.
3. Probar la integración.

Crear un servicio web RESTful es el proceso de desarrollar un servicio web que se comunique con los clientes utilizando el protocolo HTTP. Hay una serie de herramientas y frameworks que se pueden utilizar para desarrollar servicios web RESTful.

Crear una aplicación web que utilice el servicio web RESTful es el proceso de desarrollar una aplicación web que pueda comunicarse con el servicio web RESTful. Hay una serie de lenguajes de programación y frameworks que se pueden utilizar para desarrollar aplicaciones web.

Probar la integración es el proceso de probar que el servicio web RESTful y la aplicación web se comunican correctamente. Esto se puede hacer realizando una serie de pruebas, como pruebas unitarias, pruebas de integración y pruebas de aceptación.

Aquí hay algunos beneficios de integrar REST WS y una aplicación web:

* **Facilidad de desarrollo:** La integración de REST WS y una aplicación web facilita el desarrollo de aplicaciones web que puedan acceder a los datos y las funcionalidades que se ofrecen por los servicios web RESTful.
* **Escalabilidad:** La integración de REST WS y una aplicación web permite que las aplicaciones web se escalen fácilmente para satisfacer las necesidades cambiantes del negocio.
* **Seguridad:** La integración de REST WS y una aplicación web permite que las aplicaciones web se protejan de acceso no autorizado.
* **Rendimiento:** La integración de REST WS y una aplicación web permite que las aplicaciones web se ejecuten de manera eficiente.

Si está desarrollando una aplicación web que necesita acceder a los datos y las funcionalidades que se ofrecen por un servicio web RESTful, entonces debe considerar integrar REST WS y una aplicación web. La integración de REST WS y una aplicación web ofrece una serie de ventajas que pueden ayudarle a desarrollar aplicaciones web que sean escalables, seguras y eficientes.

## Integracion EJB y JAX-RS

La integración de EJB y JAX-RS es el proceso de conectar un EJB a un recurso RESTful. Esto permite que el recurso RESTful acceda a los datos y las funcionalidades que se ofrecen por el EJB.

El proceso de integración de EJB y JAX-RS consta de los siguientes pasos:

1. Crear un EJB.
2. Crear un recurso RESTful que utilice el EJB.
3. Probar la integración.

Crear un EJB es el proceso de desarrollar un objeto empresarial que se pueda utilizar en una aplicación Java EE. Hay una serie de herramientas y frameworks que se pueden utilizar para desarrollar EJB.

Crear un recurso RESTful que utilice el EJB es el proceso de desarrollar un recurso RESTful que pueda comunicarse con el EJB. Hay una serie de lenguajes de programación y frameworks que se pueden utilizar para desarrollar recursos RESTful.

Probar la integración es el proceso de probar que el EJB y el recurso RESTful se comunican correctamente. Esto se puede hacer realizando una serie de pruebas, como pruebas unitarias, pruebas de integración y pruebas de aceptación.

Aquí hay algunos ejemplos de cómo se puede integrar EJB y JAX-RS:

* **Se puede utilizar un EJB para proporcionar datos a un recurso RESTful.** Por ejemplo, si está desarrollando un recurso RESTful que proporciona información sobre productos, puede utilizar un EJB para proporcionar datos sobre los productos de una base de datos.
* **Se puede utilizar un EJB para procesar solicitudes de un recurso RESTful.** Por ejemplo, si está desarrollando un recurso RESTful que permite a los usuarios crear nuevos productos, puede utilizar un EJB para procesar las solicitudes de creación de productos.
* **Se puede utilizar un EJB para proporcionar seguridad a un recurso RESTful.** Por ejemplo, si está desarrollando un recurso RESTful que sólo está disponible para usuarios autenticados, puede utilizar un EJB para proporcionar la autenticación y autorización de los usuarios.

La integración de EJB y JAX-RS es una herramienta poderosa que se puede utilizar para desarrollar recursos RESTful que sean escalables, seguros y eficientes.
