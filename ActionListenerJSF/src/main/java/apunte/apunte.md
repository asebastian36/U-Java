# Action listeners en JSF

JSF provee dos maneras de configurar la deteccion de eventos cuando un usuario ejecuta una accion de tipo
`submit`, ya sea agregando el atributo `actionListener` al componente JSF o como elemento interno en el
componente.

Algunos componentes que pueden manejar este tipo de eventos son `h:commandoButton` y `h:commandLink`.

Codigo en la pagina JSF:

```xhtml
<h:commandLink actionListener="#{vacanteForm.enviar}">
```

Una vez definido el atributo o elemento interno, se debe agregar el metodo action en el `Managed Bean` que
procesa la peticion de la vista, ejemplo:

```java
public void enviar(ActionEvent actionEvent) {...}
```

Esto nos permitira procesar formularios desde la vista del cliente.
