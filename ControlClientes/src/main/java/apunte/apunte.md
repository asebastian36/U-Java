# Aplicacion por capas

El **cliente** (capa web o navegador) hara una peticion al **servidor** pero el
servidor estara divido en en un **servlet** que sera el servlet controlador, el cual
recibira todas las peticiones hacia nuestra aplicacion web, recuperara informacion de
la base de datos, pero no directamente, sino que se creara una capa logica para
recuperar la informacion de la **capa de datos** de la tabla de clientes y todo lo que
tenga que ver con interactuar con la base de datos, asi que se crearan varias clases
para hacer la capa de datos logica y en esta capa de datos se aplicaran patrones de
diseño como: DAO, DTO y VO, en el servlet se aplicara el patron de diseño: MVC.

Una vez que el servlet se comunique con la capa de datos para recuperar la informacion
de clientes, entonces va a seleccionar al JSP el cual desplegara la informacion
finalmente hacia el cliente, para mostrar la informacion al cliente se usara el
framework de bootstrap.
