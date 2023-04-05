# Notas del proyecto

Se hicieron los siguientes ajustes en el `pom.xml`:

Se agrego esta dependencia

```xml
<dependency>
  <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.20.0</version>
</dependency>
```

Despues borro el contenido de la etiqueta `<build>` para reemplazarlo por esto:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-war-plugin</artifactId>
      <version>3.2.3</version>
      <configuration>
        <failOnMissingWebXml>false</failOnMissingWebXml>
      </configuration>
    </plugin>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.11.0</version>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```

El `failOnMissingWebXml` ayuda para crear el archivo war y poder desplegar la aplicacion, el
`maven-compiler-plugin` configura la version en la que se compilara el proyecto con glashfish.

> Nota no es parte del pom, pero se borro el index.html de la carpeta webpages y se hizo un clean
> and build al terminar

## Configuracion del proyecto

Para que reconozca la ultima version de JSF:

Se creo la clase `ConfiguracionJSF` en el paquete `beans.configuracion`

```java
package beans.configuracion;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

/**
 *
 * @author Angel Franco
 */

@FacesConfig(
        //  Activa CDI build-in beans
        version = JSF_2_3
)
@ApplicationScoped
public class ConfiguracionJSF {

}
```

Despues en `other sources` en la carpeta `src/main/resources` se creo el archivo `log4j2.xml`

Esta configuracion esta hecha para poder ver la informacion relacionada `log4j` en la consola de
glassfish

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/XML/XMLDocument.xml to edit this template
-->

<Configuration status="INFO">
    <Appenders>
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss} [%t] %-5level %logger{36} -%msg%n"></PatternLayout>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>
</Configuration>
```

> solo es necesario por la version utilizada de glassfish 5.0, ya que para versiones posteriores
> no sera necesario para indicar el uso de la version mas reciente de JSF

Añadi un `index.xhtml` en la carpeta `Web Pages` y le agregue el hola mundo. Para que el proyecto
arranque con el `index.xhtml` se debe especificar en el archivo `web.xml` de la carpeta `WEB-INF`
(esa carpeta esta dentro de `Web Pages`) tambien se habilito el uso optimo de los JSF.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
   version="4.0"
   metadata-complete="true">
    
    <session-config>
        <session-timeout>
            30
        </session-timeout>
    </session-config>
    <context-param>
        <param-name>javax.faces.PROJECT_STAGE</param-name>
        <param-value>Development</param-value>
    </context-param>
    <servlet>
        <servlet-name>Faces Servlet</servlet-name>
        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>Faces Servlet</servlet-name>
        <url-pattern>/faces/*</url-pattern>
    </servlet-mapping>
    <welcome-file-list>
        <welcome-file>faces/index.xhtml</welcome-file>
    </welcome-file-list>
</web-app>
```
