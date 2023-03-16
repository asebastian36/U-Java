# Creacion de la capa de datos

Se configuro el `pom.xml` de la carpeta `Proyect Files`.

Se agrego la dependencia de mysql:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```

Se agrego otra dependencia:

```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.7.0</version>
</dependency>
```

Aplicar un `Clean and Build` para descargar las dependencias.

## Configuracion de clase Conexion

Esta clase permite la conexion con la base de datos y obtener una conexion del pull
de conexiones
