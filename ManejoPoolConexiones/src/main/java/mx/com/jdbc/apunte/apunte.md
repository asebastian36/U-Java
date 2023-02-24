# Nota de los cambios en el proyecto

Vamos a manejar el concepto de pool de conexiones, para obtener este pool de conexiones se utiliza empleando la dependencia apache commons, es un proyecto de apache que contiene varias librerias que son comunes para los proyectos Java.

Empezamos entrando al pom y agregando la dependencia de dcp2:
```xml
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.7.0</version>
</dependency>
```

Despues vamos a la clase conexion en el paquete de datos, agregamos un atributo DataSource,  reemplazaremos el uso de la clase DriverManager creando un metodo extra:

```java
private static BasicDataSource dataSource;
    
public static DataSource getDataSource() {
    if(Conexion.dataSource == null) {
        Conexion.dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PASSWORD);

        //  Definimos el tamano inicial del pool de conexiones
        dataSource.setInitialSize(5);
    }
        
    return dataSource;
}

public static Connection getConnection() throws SQLException {
    //  se llama al metodo de connection para solicitar un objeto conexion del pool de conexiones
    //  ya configurado
    return getDataSource().getConnection();
}
```

> Es recomendable establecer una cantidad de conexiones menor por defecto al principio para asi evitar bloquear la aplicacion.
