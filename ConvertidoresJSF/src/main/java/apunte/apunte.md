# Convertidores en JSF

Los convertidores cubren la necesidad de asignar valores entre la vista y el modelo de manera automatica, manejando tipos distintos los convertidores cubren la necesidad
de desplegar la informacion del modelo a la vista; Por ejemplo podemos convertir una cadena que representa a su vez una fecha y esa fecha convertirla en un tipo
date a nuestro modelo con ello logramos la conversion del tipo de dato `String` y lo asignamos a un tipo `Date` al modelo.

De igual manera los convertidores convierten de igual manera de la vista al modelo.

## Tipos de convertidores en JSF

**Conversiones implicitas:**

* Son todas las conversiones que JSF realiza de manera automatica, por ejemplo al usar tipos primitivos, `BigInteger` o `String`.

  * Ejemplo: `<h:inputText id="edadId" value="#{empleadoBean.edad}">`

> En este ejemplo pasamos de un tipo de dato String a un tipo de dato Int.

**Conversiones explicitas:** (tenemos dos maneras de hacerlo)

* Utilizando el atributo convertir, por ejemplo: `<h:inputText value="#{empleadoBean.edad} converter="javax.faces.Integer" />`
* Utilizando un componente de tipo `converter`:

```xhtml
<h:inputText value="#{empleadoBean.edad}">
  <f:converter converterId="javax.faces.Integer" />
</h:inputText>
```

**Convertidores personalizados:**

* JSF permite crear convertidores personalizados.

* Pasos para crear y utilizar una clase `Converter`:
  * En la pagina JSF:

  ```xhtml
  <h:inputText id="fechaId" value="#{empleadoBean.fechaNacimiento}"
  convert="util.ConvertidorFecha">
  ```

  * Clase Java de tipo `Converter` contiene el codigo del convertidor. Debe de implementar la interfaz `javax.faces.convert.Converter`.
  * La clase `Converter` se registra en `faces-config.xml` o agregar la anotacion `@FacesConverter` a la clase de tipo `Converter`.

> Ademas la clase Converter debe sobreescribir el metodo `getAsObject` o `getAsString()` dependiendo el tipo de conversion que se requiera.
