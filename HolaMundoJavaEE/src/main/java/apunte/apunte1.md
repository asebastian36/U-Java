# Java Enterprise edition

En una aplicacion JEE podemos utilizar tecnologias como EJB, JPA, Web Services, etc.

| Tecnologia | Uso |
|:---:|:---|
| JSF 2.2 (Facelets) | Presentacion |
| CDI | Inyeccion de dependencias |
| EJB 3.2 | Servicios de negocio |
| JAX-RS | REST |
| JAX-WS | SOAP |
| JPA 2.1 | Persistencia |

## Arquitectura multicapas en Java EE

Una aplicacion empresarial en Java se compone de distintas capas, cada capa tiene una
funcion muy especifica, dividir una aplicacion tiene varias ventajas como son: separacion
de responsabilidades, mejor mantenimiento a la aplicacion, especializacion de los
programadores en cada capa, etc. La version empresarial de Java brinda un API distinta
para cada capa de una aplicacion empresarial, desde la capa de presentacion, la capa de
negocio y la capa de datos.

### Capas de una aplicacion Java EE

* **Capa de presentacion:** El cliente interactua por medio de un navegador web, un movil
o una aplicacion de escritorio con la aplicacion, la capa puede recidir en el servidor,
las tecnologias mas basicas son los: JSP, Servlet, **JSF**.
* **Capa de negocio:** En esta capa la tecnologia utilizada son los **EJB** (tambien expuestos
como servicios web), esto para que otro tipo de clientes puedan consumir la informacion
de la aplicacion.
* **Capa de datos:** Se utilizan tecnologias como JDBC o **JPA**. Este codigo permite
comunicarnos con nuestra base de datos para leer y almacenar informacion en ella.
* **Capas extra:** Se podria agregar seguridad a todas las capas
