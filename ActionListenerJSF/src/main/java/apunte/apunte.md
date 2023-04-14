# Value change listeners en JSF

JSF provee dos maneras de detectar cambios (value change) en los componentes, ya sea agregando un
atributo `valueChangeListener` al componente o como un elemento interno. Por ejemplo:

Revision del codigo de la vista

```xhtml
<h:inputText id="codigoPostal" onchange="this.form.submit()"
value="#{empleadoBean.codigoPostal}"
valueChangeListener="#{vacanteForm.codigoPostalListener}" />
```

El atributo de `valueChangeListener` tiene asociado un `Bean` y ese Bean va a mandar a llamar
directamente el metodo `codigoPostalListener`, entonces una vez que el usuario haga algun cambio
en ese `InputText` se manda a llamar el atributo `onchange` y automaticamente se manda a llamar
el codigo Java respectivo asociado con este Bean `vacanteForm`.

Esto permite llamar de manera muy simplificada eventos del lado del servidor de Java directamente
asociados con nuestras paginas JSF.

Los `listeners` en JSF nos permiten responder a eventos que suceden en la vista para enlazar el evento
al controlador y procesar el cambio en el componente, estos componentes deben implementar la
interfaz `EditableValueHolder`.

Una vez definido el atributo o elemento interno, se debe agregar el metodo action en el `Managed
Bean` que escucha el cambio en la vista.

Codigo que hay que agregar al `Managed Bean`:

```Java
public void codigoPostalListener(ValueChangeEvent valueChangeEvent) {...}
```
