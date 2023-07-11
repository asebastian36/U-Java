# Notas

Se copio el proyecto anterior **TransaccionesJEE**.

## Cambios

## Rol de JSF en Java EE

JSF (JavaServer Faces) es un marco de trabajo de Java para construir interfaces de usuario basadas en la web. Forma parte de Java EE (Enterprise Edition) y se utiliza para desarrollar aplicaciones empresariales.

El rol de JSF en Java EE es proporcionar una plataforma para desarrollar aplicaciones web basadas en componentes reutilizables. JSF simplifica la creación de interfaces de usuario al separar la lógica de presentación de la lógica de negocio.

A continuación se enumeran algunas características y roles clave de JSF en Java EE:

1. Modelo de programación basado en componentes: JSF utiliza un modelo de programación basado en componentes, lo que significa que las interfaces de usuario se construyen utilizando componentes reutilizables. Estos componentes encapsulan la lógica de presentación y se pueden combinar para crear páginas web complejas.

2. Administración del ciclo de vida: JSF maneja automáticamente el ciclo de vida de una solicitud web, lo que implica procesar la solicitud, actualizar el estado de los componentes, validar los datos, ejecutar acciones y renderizar la respuesta.

3. Vínculo de datos: JSF proporciona capacidades de enlace de datos bidireccional entre los componentes de la interfaz de usuario y los objetos de respaldo en el lado del servidor. Esto permite una fácil sincronización de datos entre la interfaz de usuario y el servidor.

4. Validación de datos: JSF ofrece un mecanismo integrado para validar los datos ingresados por el usuario antes de enviarlos al servidor. Puede utilizar validaciones predefinidas o personalizadas para garantizar la integridad de los datos.

5. Administración del estado: JSF gestiona automáticamente el estado de la interfaz de usuario entre las solicitudes web. Esto significa que no es necesario rastrear manualmente el estado de los componentes en las aplicaciones JSF.

6. Soporte para internacionalización y accesibilidad: JSF proporciona mecanismos integrados para admitir aplicaciones localizadas e internacionalizadas. También se esfuerza por cumplir con los estándares de accesibilidad web para garantizar que las aplicaciones sean accesibles para personas con discapacidades.

## Prime faces

PrimeFaces es una biblioteca de componentes de interfaz de usuario (UI) para JavaServer Faces (JSF). Es una extensión de JSF que proporciona una amplia gama de componentes y características adicionales para mejorar y agilizar el desarrollo de aplicaciones web.

PrimeFaces ofrece una colección de componentes de interfaz de usuario altamente funcionales y estéticamente atractivos, como botones, campos de entrada, tablas, paneles, menús desplegables, calendarios y muchos más. Estos componentes son altamente personalizables y pueden adaptarse fácilmente a los requisitos de diseño y estilo de una aplicación.

Además de los componentes estándar de JSF, PrimeFaces agrega componentes avanzados, como gráficos interactivos, árboles, paneles deslizantes, diálogos modales y arrastrar y soltar. Estos componentes proporcionan una experiencia de usuario rica y mejoran la usabilidad de las aplicaciones web.

PrimeFaces también ofrece características adicionales que simplifican el desarrollo de aplicaciones. Algunas de estas características incluyen:

1. Ajax y actualización parcial: PrimeFaces utiliza Ajax (Asynchronous JavaScript and XML) para permitir la actualización parcial de componentes en una página sin tener que recargar toda la página. Esto mejora la capacidad de respuesta y la eficiencia de las aplicaciones web.

2. Manejo de eventos: PrimeFaces facilita el manejo de eventos de los componentes. Puedes definir acciones y acciones de retroalimentación para responder a eventos específicos, como hacer clic en un botón o seleccionar un elemento de una lista desplegable.

3. Temas y personalización: PrimeFaces ofrece una variedad de temas predefinidos que permiten cambiar rápidamente la apariencia de las aplicaciones. Además, se puede personalizar fácilmente el estilo de los componentes utilizando hojas de estilo CSS.

4. Integración con tecnologías de vanguardia: PrimeFaces se integra bien con otras tecnologías web modernas. Por ejemplo, admite integración con bibliotecas de JavaScript populares como jQuery y ofrece compatibilidad con componentes de Bootstrap.

5. Soporte para dispositivos móviles: PrimeFaces Mobile es una extensión de PrimeFaces que proporciona componentes optimizados para dispositivos móviles y técnicas de respuesta para el desarrollo de aplicaciones web móviles.

## AJAX en JSF

AJAX (Asynchronous JavaScript and XML) es una técnica que permite realizar intercambios de datos asincrónicos entre el navegador y el servidor, sin tener que recargar toda la página. Es especialmente útil para mejorar la experiencia del usuario al proporcionar respuestas rápidas y actualizaciones dinámicas en una página web.

En el contexto de JSF (JavaServer Faces), AJAX se utiliza para realizar operaciones de forma asíncrona en los componentes de la interfaz de usuario, lo que significa que se pueden actualizar partes específicas de una página sin tener que recargarla por completo. JSF proporciona una integración nativa con AJAX a través de la librería JavaScript de JSF, que se encarga de manejar las solicitudes y respuestas AJAX.

Para utilizar AJAX con JSF, puedes seguir estos pasos:

1. Configurar el componente JSF: Asegúrate de tener un componente JSF al que deseas aplicar AJAX. Esto podría ser un botón, un enlace, un campo de entrada o cualquier otro componente que necesite una funcionalidad AJAX.

2. Agregar un evento AJAX: JSF proporciona un conjunto de eventos AJAX predefinidos que puedes utilizar en los componentes. Por ejemplo, puedes utilizar el evento "action" para manejar acciones de botones o el evento "valueChange" para manejar cambios de valor en campos de entrada. Agrega el evento AJAX correspondiente al componente que deseas utilizar.

3. Definir el comportamiento AJAX: Dentro del evento AJAX, puedes definir qué acciones se deben realizar y qué partes de la página deben actualizarse cuando se active el evento. Puedes especificar acciones de servidor, como invocar un método de respaldo en el servidor, y actualizar componentes específicos en la respuesta AJAX.

4. Manejar la respuesta AJAX: Una vez que se complete la solicitud AJAX, JSF manejará la respuesta y actualizará automáticamente los componentes especificados. Puedes utilizar diferentes opciones para actualizar componentes, como actualizar un solo componente, actualizar varios componentes o incluso ejecutar scripts de JavaScript después de la respuesta.

JSF proporciona una abstracción y una capa de manejo AJAX simplificada, lo que significa que no es necesario escribir código JavaScript manualmente para realizar solicitudes AJAX. El framework se encarga de generar el código JavaScript necesario para interactuar con el servidor de manera asíncrona.

La utilización de AJAX con JSF permite crear aplicaciones web más interactivas y responsivas, ya que proporciona una forma eficiente de realizar actualizaciones parciales en la interfaz de usuario sin tener que recargar toda la página.

## Integracion de JSF y EJB

La integración de JSF (JavaServer Faces) y EJB (Enterprise JavaBeans) es una combinación común en el desarrollo de aplicaciones empresariales en Java. JSF se utiliza para construir la interfaz de usuario, mientras que EJB se encarga de la lógica de negocio y el acceso a los datos.

Aquí tienes algunos aspectos clave de la integración de JSF y EJB:

1. Inyección de dependencias: JSF y EJB se pueden integrar mediante la inyección de dependencias. Puedes utilizar la anotación `@Inject` de CDI (Contexts and Dependency Injection) para inyectar EJB en los controladores de JSF. Esto permite acceder a los componentes EJB desde los controladores JSF de manera sencilla y sin necesidad de realizar una configuración adicional.

2. Lógica de negocio: Los EJB se utilizan para encapsular la lógica de negocio en una aplicación Java EE. Puedes definir clases EJB para implementar operaciones de negocio complejas, como operaciones de base de datos, transacciones, validaciones y cálculos. Desde los controladores de JSF, puedes invocar los métodos de los EJB para acceder a esta lógica de negocio.

3. Transacciones: Los EJB ofrecen soporte integrado para el manejo de transacciones en aplicaciones Java EE. Puedes anotar tus métodos EJB con `@Transactional` para definir los límites de transacción. Esto te permite mantener la integridad de los datos y garantizar la consistencia en las operaciones de la base de datos realizadas desde la capa de JSF.

4. Acceso a datos: Los EJB también se pueden utilizar para acceder a los datos en una aplicación Java EE. Puedes definir EJB de sesión que actúen como fachadas para acceder a los componentes de persistencia, como JPA (Java Persistence API) o JDBC (Java Database Connectivity). Esto ayuda a mantener una separación clara entre la lógica de negocio y el acceso a los datos en una aplicación.

5. Transmisión de datos entre JSF y EJB: Puedes pasar datos entre JSF y EJB mediante parámetros de métodos o mediante el uso de modelos de datos compartidos. Por ejemplo, puedes utilizar objetos de valor (Value Objects) o DTOs (Data Transfer Objects) para transferir datos entre los controladores JSF y los EJB.

6. Pruebas unitarias: Al integrar JSF y EJB, es importante realizar pruebas unitarias para garantizar que la funcionalidad de la aplicación funcione correctamente. Puedes utilizar frameworks de pruebas como JUnit y Mockito para escribir pruebas unitarias de los controladores de JSF y los métodos EJB.

La integración de JSF y EJB permite crear aplicaciones empresariales robustas y escalables en Java EE. JSF se encarga de la capa de presentación, mientras que EJB maneja la lógica de negocio y el acceso a los datos. Esta combinación proporciona un enfoque claro y estructurado para desarrollar aplicaciones web empresariales.
