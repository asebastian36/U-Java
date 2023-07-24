# Notas

Se copio el proyecto anterior **SGA-RS-WebService**.

## Cambios

* Cambios en la implementacion de la interfaz del paquete de `servicio` para implementar seguridad a la clase y a los respectivos metodos.
* Cambios en el `web.xml`.
* Cambios en el `index.xhtml`.
* Se verifico que estuviera habilitada una funcion importante en el servidor de glassfish ruta de la configuracion: `view domain admin console -> configurations -> server-config -> security` para habilitar la opcion `Default Principal To Role Mapping`.
* Despues se agregaron usuarios con roles asignados en el servidor en la ruta `view domain admin console -> configurations -> server-config -> security -> Realms -> file -> manage users`.
* Se agrego el usuario admin, user y guest con la claves admin, user y guest con los roles de `ROLE_ADMIN, ROLE_USER, ROLE_GUEST`.

## Seguridad en Java EE

La seguridad en Java EE es un conjunto de características y configuraciones que ayudan a proteger las aplicaciones Java EE de ataques. Estas características incluyen:

* Autenticación: el proceso de verificar la identidad de un usuario.
* Autorización: el proceso de determinar qué recursos puede acceder un usuario.
* Encriptación: el proceso de convertir datos en un formato ilegible para evitar que se roben o modifiquen.
* Control de acceso: el proceso de determinar quién puede acceder a qué recursos y cómo pueden acceder a ellos.
* Auditación: el proceso de seguimiento de las actividades de los usuarios para detectar posibles violaciones de seguridad.

La seguridad en Java EE es importante porque ayuda a proteger las aplicaciones Java EE de los siguientes ataques:

* Ataques de inyección: los ataques de inyección son un tipo de ataque en el que el atacante introduce código malicioso en una aplicación Java EE. Este código malicioso puede luego ser ejecutado por la aplicación, lo que puede conducir a la pérdida de datos, el robo de identidad o la denegación de servicio.
* Ataques de fuerza bruta: los ataques de fuerza bruta son un tipo de ataque en el que el atacante intenta adivinar las contraseñas de los usuarios. Este tipo de ataque puede ser muy efectivo si las contraseñas de los usuarios son débiles.
* Ataques de vulnerabilidad: los ataques de vulnerabilidad son un tipo de ataque en los que el atacante explota una vulnerabilidad en una aplicación Java EE para obtener acceso no autorizado a la aplicación.

La seguridad en Java EE es una parte importante del desarrollo de aplicaciones Java EE. Al implementar las características de seguridad de Java EE, los desarrolladores pueden ayudar a proteger sus aplicaciones de ataques y garantizar que los datos de sus usuarios estén seguros.

Aquí hay algunos consejos para mejorar la seguridad de las aplicaciones Java EE:

* Utilice contraseñas fuertes y únicas para cada aplicación.
* Active la autenticación de dos factores cuando sea posible.
* Mantenga sus aplicaciones actualizadas con las últimas versiones.
* Use una firewall para proteger su aplicación de ataques externos.
* Implemente el control de acceso para restringir el acceso a los recursos a los usuarios autorizados.
* Realice auditorías de seguridad regularmente para identificar posibles vulnerabilidades.

Al seguir estos consejos, los desarrolladores pueden ayudar a mejorar la seguridad de sus aplicaciones Java EE y proteger los datos de sus usuarios.

## Usuarios, grupos y roles

En el esquema de seguridad de Java EE, los usuarios son las personas que utilizan la aplicación. Los grupos son conjuntos de usuarios que tienen los mismos permisos. Los roles son conjuntos de permisos que se pueden asignar a usuarios o grupos.

Los usuarios pueden ser autenticados utilizando una variedad de métodos, incluyendo el nombre de usuario y la contraseña, el certificado digital o el token de seguridad. Una vez que un usuario ha sido autenticado, se le puede asignar uno o más roles. Los roles se utilizan para controlar el acceso a los recursos de la aplicación.

Por ejemplo, un rol puede tener el permiso de leer datos de una base de datos, mientras que otro rol puede tener el permiso de escribir datos en la base de datos. Los usuarios se pueden asignar a roles utilizando el archivo de configuración de seguridad de la aplicación.

El esquema de seguridad de Java EE es una forma flexible y potente de controlar el acceso a los recursos de las aplicaciones. Al utilizar usuarios, grupos y roles, los desarrolladores pueden crear aplicaciones que sean seguras y fáciles de usar.

## Autenticacion y autorizacion en Java EE

En Java EE, la autenticación es el proceso de verificar la identidad de un usuario. Esto se puede hacer mediante el nombre de usuario y la contraseña del usuario, un certificado digital o un token de seguridad. Una vez que un usuario ha sido autenticado, se le puede asignar uno o más roles.

La autorización es el proceso de determinar qué recursos puede acceder un usuario. Esto se hace comparando los roles del usuario con los permisos de los recursos. Por ejemplo, un rol puede tener el permiso de leer datos de una base de datos, mientras que otro rol puede tener el permiso de escribir datos en la base de datos.

La autenticación y la autorización son dos de los componentes más importantes de la seguridad en Java EE. Al implementar estas características, los desarrolladores pueden ayudar a proteger sus aplicaciones de ataques y garantizar que los datos de sus usuarios estén seguros.

## Asegurar la capa web

La capa web es la parte de una aplicación web que se comunica con los usuarios. Es responsable de mostrar la interfaz de usuario de la aplicación y procesar las entradas de los usuarios. La seguridad de la capa web es importante para proteger los datos de los usuarios y la infraestructura de la aplicación.

Hay una serie de cosas que se pueden hacer para asegurar la capa web, incluyendo:

* **Usar HTTPS:** HTTPS es un protocolo seguro que cifra la comunicación entre el navegador del usuario y el servidor web. Esto ayuda a proteger los datos de los usuarios de ser interceptados por terceros.
* **Habilitar la autenticación y la autorización:** La autenticación y la autorización ayudan a controlar quién puede acceder a los recursos de la aplicación. La autenticación verifica la identidad del usuario, mientras que la autorización determina qué recursos puede acceder el usuario.
* **Utilizar codificación segura:** La codificación segura ayuda a proteger los datos de los usuarios de ser manipulados por terceros. Por ejemplo, se debe usar codificación segura para almacenar contraseñas de usuarios.
* **Filtrar entradas:** La entrada de los usuarios debe ser filtrada para evitar ataques de inyección. Los ataques de inyección son un tipo de ataque en el que el atacante introduce código malicioso en una aplicación web. Este código malicioso puede luego ser ejecutado por la aplicación, lo que puede conducir a la pérdida de datos, el robo de identidad o la denegación de servicio.
* **Mantener las aplicaciones actualizadas:** Las aplicaciones deben mantenerse actualizadas con las últimas versiones. Las actualizaciones de seguridad a menudo incluyen parches para vulnerabilidades que pueden ser explotadas por los atacantes.
* **Realizar auditorías de seguridad:** Las auditorías de seguridad ayudan a identificar posibles vulnerabilidades en las aplicaciones. Las vulnerabilidades identificadas pueden entonces ser parcheadas para mejorar la seguridad de la aplicación.

Al seguir estos consejos, los desarrolladores pueden ayudar a asegurar la capa web de las aplicaciones web y proteger los datos de los usuarios.

Ejemplo

```xml
<!--Configuracion seguridad del sistema SGA-->

<!--
   Para especificar la forma en que el contenedor web recuperara la informacion
  para autenticar a los usuarios
-->
<login-config>
  <!-- Define el tipo de autenticacion -->
  <auth-method>BASIC</auth-method>
  <!-- Abstraccion del servidor de aplicaciones, donde se especifican las politicas de seguridad del sistema -->
  <realm-name>Login in</realm-name>
</login-config>

<!-- 
  Permite especificar los recursos o URL's a los cuales agregaremos seguridad
  asi como los roles que participaran en la revision de la seguridad
-->
<security-constraint>
  <web-resource-collection>
    <web-resource-name>Aplicacion WEB JSF</web-resouce-name>
    <!-- especificamos las paginas a asegurar -->
    <url-pattern>/*</url-pattern>
  </web-resource-collection>

  <!-- especificamos los roles permitidos para ejecutar el recurso -->
  <auth-constraint>
    <role-name>ROLE_ADMIN</role-name>
    <role-name>ROLE_USER</role-name>
  </auth-constraint>
</security-constraint>
```

## Seguridad en JSF y en primefaces

La seguridad en JSF y PrimeFaces es un tema importante que debe tenerse en cuenta al desarrollar aplicaciones web. Hay una serie de cosas que se pueden hacer para mejorar la seguridad de las aplicaciones web JSF y PrimeFaces, incluyendo:

* **Utilizar un servidor de aplicaciones seguro:** Un servidor de aplicaciones seguro es el primer paso para mejorar la seguridad de las aplicaciones web JSF y PrimeFaces. Los servidores de aplicaciones seguros, como Tomcat y Glassfish, vienen con una serie de características de seguridad integradas que pueden ayudar a proteger las aplicaciones web contra los ataques.
* **Habilitar la seguridad de la sesión:** La seguridad de la sesión es una característica de seguridad que ayuda a proteger las aplicaciones web contra los ataques de sesión. La seguridad de la sesión habilita las claves de sesión y el tiempo de caducidad de la sesión, lo que dificulta que los atacantes pirateen las sesiones de los usuarios.
* **Utilizar el filtro de autorización de PrimeFaces:** El filtro de autorización de PrimeFaces es una característica de PrimeFaces que ayuda a proteger las aplicaciones web contra los ataques de inyección SQL. El filtro de autorización de PrimeFaces valida todas las entradas de usuario antes de enviarlas a la base de datos, lo que ayuda a evitar que los atacantes inyecten código malicioso en la base de datos.
* **Utilizar la validación de entrada de usuario:** La validación de entrada de usuario es una técnica que ayuda a proteger las aplicaciones web contra los ataques de inyección SQL y Cross-site Scripting (XSS). La validación de entrada de usuario valida todas las entradas de usuario antes de enviarlas a la aplicación web, lo que ayuda a evitar que los atacantes inyecten código malicioso en la aplicación web.
* **Utilizar el cifrado:** El cifrado es un proceso que convierte la información en un formato ilegible. El cifrado se puede utilizar para proteger la información confidencial, como las contraseñas de los usuarios, de ser accedida por personas no autorizadas.
* **Mantener las aplicaciones web actualizadas:** Es importante mantener las aplicaciones web actualizadas con las últimas versiones de software. Las actualizaciones de software suelen incluir parches de seguridad que pueden ayudar a proteger las aplicaciones web contra los ataques.

Siguiendo estas recomendaciones, puede mejorar la seguridad de las aplicaciones web JSF y PrimeFaces y protegerlas contra los ataques.

Opciones para reestringir componentes en una pagina JSF con la extension de Primefaces:

* `#{p:ifGranted('ROLE_ADMIN')}`: Esta opción muestra u oculta el componente en función de si el usuario actual tiene el rol ROLE_ADMIN. Si el usuario tiene el rol ROLE_ADMIN, el componente se mostrará. Si el usuario no tiene el rol ROLE_ADMIN, el componente se ocultará.
* `#{P:ifAllGranted('ROLE_ADMIN, ROLE_EDITOR')}`: Esta opción muestra u oculta el componente en función de si el usuario actual tiene ambos roles ROLE_ADMIN y ROLE_EDITOR. Si el usuario tiene ambos roles, el componente se mostrará. Si el usuario no tiene ambos roles, el componente se ocultará.
* `#{p:ifAnyGranted('ROLE_USER, ROLE_ADMIN')}`: Esta opción muestra u oculta el componente en función de si el usuario actual tiene al menos uno de los roles ROLE_USER o ROLE_ADMIN. Si el usuario tiene al menos uno de estos roles, el componente se mostrará. Si el usuario no tiene ninguno de estos roles, el componente se ocultará.
* `#{P:ifNotGranted('ROLE_GUEST')}`: Esta opción muestra u oculta el componente en función de si el usuario actual no tiene el rol ROLE_GUEST. Si el usuario no tiene el rol ROLE_GUEST, el componente se mostrará. Si el usuario tiene el rol ROLE_GUEST, el componente se ocultará.
* `#{p:remoteUser()}`: Esta opción devuelve el nombre de usuario del usuario actual. El nombre de usuario puede ser utilizado para identificar al usuario y restringir el acceso a los componentes de la página JSF.
* `#{p:userPrincipal()}`: Esta opción devuelve el objeto UserPrincipal del usuario actual. El objeto UserPrincipal contiene información sobre el usuario, como el nombre de usuario, el rol y los grupos del usuario. El objeto UserPrincipal puede ser utilizado para restringir el acceso a los componentes de la página JSF.

Ejemplo de uso en paginas JSF:

* `<h:commandButton value="Eliminar persona" rendered="#{p:ifGranted('ROLE_ADMIN')}"/>`
* `<p:commandButton value="Reporte General" disabled="#{p:ifNotGranted('ROLE_USER, ROLE_ADMIN')}" />`

## Tipos de seguridad en la capa EJB

Hay varios tipos de seguridad que se pueden aplicar a la capa EJB, que incluyen:

* **Seguridad en el nivel de la aplicación:** Esta es la forma más básica de seguridad y se aplica a toda la aplicación EJB. Se puede utilizar para restringir el acceso a la aplicación a usuarios específicos o grupos de usuarios.
* **Seguridad en el nivel de la entidad:** Esta forma de seguridad se aplica a entidades EJB individuales. Se puede utilizar para restringir el acceso a entidades específicas a usuarios específicos o grupos de usuarios.
* **Seguridad en el nivel de la operación:** Esta forma de seguridad se aplica a operaciones específicas de entidades EJB. Se puede utilizar para restringir el acceso a operaciones específicas de entidades a usuarios específicos o grupos de usuarios.
* **Seguridad en el nivel del método:** Esta forma de seguridad se aplica a métodos específicos de entidades EJB. Se puede utilizar para restringir el acceso a métodos específicos de entidades a usuarios específicos o grupos de usuarios.

La seguridad que se aplica a la capa EJB depende de las necesidades específicas de la aplicación. Por ejemplo, si la aplicación debe ser accesible sólo a usuarios específicos, entonces se debe utilizar la seguridad en el nivel de la aplicación. Si la aplicación debe restringir el acceso a entidades específicas, entonces se debe utilizar la seguridad en el nivel de la entidad. Si la aplicación debe restringir el acceso a operaciones específicas de entidades, entonces se debe utilizar la seguridad en el nivel de la operación. Si la aplicación debe restringir el acceso a métodos específicos de entidades, entonces se debe utilizar la seguridad en el nivel del método.

Además de estos tipos de seguridad, también se puede utilizar la seguridad de las contraseñas para proteger la capa EJB. La seguridad de las contraseñas se utiliza para cifrar las contraseñas de los usuarios y almacenarlas en la base de datos. Esto ayuda a proteger las contraseñas de los usuarios de ser accedidas por personas no autorizadas.

La seguridad de la capa EJB es una parte importante de cualquier aplicación Java EE. Al utilizar los tipos de seguridad adecuados, puede ayudar a proteger su aplicación de los ataques.

## Anotaciones en la capa EJB

Las anotaciones son una característica del lenguaje Java que permite añadir metadatos a los elementos de código. Los metadatos son datos sobre datos, y pueden ser utilizados para proporcionar información adicional sobre los elementos de código, como su propósito, su uso y su configuración.

Las anotaciones se pueden utilizar en la capa EJB para proporcionar información adicional sobre los beans EJB, como su nombre, su tipo, su rol y su configuración. También se pueden utilizar para anotar métodos EJB con información sobre su propósito y su uso.

Las anotaciones en la capa EJB pueden ser utilizadas para mejorar la legibilidad y la mantenibilidad del código, y también pueden ser utilizadas para automatizar tareas, como la generación de documentación y la configuración de beans EJB.

Algunas de las anotaciones más comunes utilizadas en la capa EJB son:

* **@EJB:** Esta anotación se utiliza para anotar un campo o un método con un bean EJB.
* **@Stateless:** Esta anotación se utiliza para anotar un bean EJB que es sin estado.
* **@Stateful:** Esta anotación se utiliza para anotar un bean EJB que es con estado.
* **@Singleton:** Esta anotación se utiliza para anotar un bean EJB que es singleton.
* **@Local:** Esta anotación se utiliza para anotar un bean EJB que es accesible a otros beans EJB locales.
* **@Remote:** Esta anotación se utiliza para anotar un bean EJB que es accesible a otros beans EJB remotos.
* **@DeclareRoles:** Esta anotacion lista los roles que se utilizaran en el EJB. Solamente se puede utilizar a nivel de la clase.
* **@RolesAllowed:** Permite ejecutar los metodos del EJB siempre y cuando los roles se encuentren listados en esta anotacion. Se puede definir al nivel de la clase o a nivel del metodo.
* **@PermitAll:** Como su nombre lo indica, permite a cualquier usuario ejecutar el metodo EJB anotado.
* **@DenyAll:** Prohibe a cualquier usuario ejecutar este metodo.
* **@RunAs:** Permite ejecutar el metodo como si el usuario tuviera otro rol, unicamente durante la ejecucion de dicho metodo.

Las anotaciones en la capa EJB son una herramienta poderosa que puede ser utilizada para mejorar la legibilidad, la mantenibilidad y la automatización del código.
