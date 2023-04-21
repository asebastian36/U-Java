# Notas del proyecto

## pom.xml

Depencia que agrega Java EE al proyecto:

```xml
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-api</artifactId>
    <version>${jakartaee}</version>
    <scope>provided</scope>
</dependency>
```

En el `scope` dice `provided` dado que el servidor de aplicaciones ya la incluye,
la `version` se especifica en la creacion del proyecto por eso  dice `${jakartaee}`.

Se elimino el `index.xhtml` para reemplazarlo por un JSP con el nombre de `index`.
