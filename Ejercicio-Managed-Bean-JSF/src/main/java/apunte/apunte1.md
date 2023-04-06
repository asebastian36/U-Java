# Navegacion en JSF

## Navegacion en JSF (cont.)

La navegacion en JSF permite movernos entre paginas de la misma tecnologia. Existen varios tipos de navegacion:

* **Navegacion estatica:** En el cual la siguiente pagina esta definida por un nombre o cadena fija.
* **Navegacion dinamica:** El valor de la siguiente vista a seleccionar va a depender de la accion que ejecute el usuario y la cadena de regreso del metodo `action` ejecutado.

Existen varias formas de configurar la navegacion:

* **Navegacion implicita (JSF):** Busca directamente una pagina con un nombre identico a la cadena de salida en el directorio actual con la extension de la pagina actual tambien,
por ejemplo `xhtml` o `jspx`.
* **Navegacion explicita (en el archivo faces-config.xml):** Se define desde `faces-config.xml`, se debe de agregar un elemento `xml` que permita indicar de donde proviene la
peticion cual es su salida y hacia que pagina debe dirigirse, en JSF 2.0 la navegacion explicita toma precedencia sobre la navegacion implicita, esto quiere decir que
unicamente al regresar una cadena busca en automatico una pagina con un nombre identico y si la encuentra toma preferencia y despliega esa vista en lugar de buscar un caso
de navegacion sobre el archivo de `faces-config.xml`.

## Navegacion estatica

En la navegacion estatica el elemento para definir cual es la siguiente pagina para mostrar, es una cadena y se le conoce como salida o en ingles outcome, la navegacion
estatica aplica en los siguientes casos:

* No se requiere ejecutar codigo Java del lado del servidor, sino unicamente dirigirse a otra pagina.
* No hay logica para determinar la pagina siguiente.

### Ejemplo de navegacion estatica

* Pagina JSF que inicia la peticion:

```xhtml
<h:commandButton label="Entrar" action="login" />
```

* La pagina siguiente se puede determinar de 2 formas:
  a. Outcome por default, buscar directamente la pagina `login.xhtml`
  b. Buscar el outcome en `faces.config.xml`, encontrando el caso que detemina la siguiente pagina a mostrar.

> En el caso a solo buscara en el mismo directorio.

## Navegacion dinamica

La navegacion dinamica utiliza un metodo `action`, el cual tiene la logica para determinar el outcome.

### Codigo pagina JSF (Vista)

```xhtml
<h:commandButton label="aceptar"
action="#{loginBean.verificarUsuario}" />
```

### Codigo LoginBean (Controlador)

```java
public String verificarUsuario () {
  if(...) return "exito";
  else return "fallo";
}
```

## Creacion de reglas de navegacion (faces-config.xml)

Con la dentro de la etiqueta `navigation-rule` primero especificamos cual es la pagina de donde viene la peticion con `from-view-id`, posteriormente se defininen casos de navegacion
con `navigation-case`, la salida de cada uno de los casos de navegacion ya sea estatica o dinamica de definen dentro de `navigation-case` con `from-outcome`, despues se define la
siguiente vista a mostrar con `to-view-id`

```xml
<faces-config...>
  <navigation-rule>
    <from-view-id>/inicio.xhtml</from-view-id>
    <navigation-case>
      <from-outcome>entrar</from-outcome>
      <to-view-id>/login.xhtml</to-view-id>
    </navigation-case>
  </navigation-rule>
  ...
</faces-config>
```
