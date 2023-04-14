# Cambios con respecto al proyecto anterior

Cambios a la clase `Candidato` del paquete `beans.model` se agregaran atributos para trabajar con el
concepto de `value change listener`.

Despues modificamos el `VacanteForm` en el paquete `beans.backing` para agregar el metodo de `value change
listener` en este caso se llamo `CodigoPostalListener`

> Se requiere que los elementos de la vista tengan un `id` para poder ser accedidos por el `UIViewRoot`

Posteriormente modificamos el `index.xhtml` para que los id que definimos en el `vacanteForm` funcionen y
se agregaran los nuevos atributos al formulario.

En la etiqueta `h:inputText` del atributo `colonia` se agregaran algunas propiedades extra como `immediate`
para hacer que este atributo se proceso de inmediato una vez modificado este valor, se agrego la propiedad
`onchange` para que se haga el envio del formulario y despues se agrego la propiedad de
 `valueChangeListener` para mandar a llamar el metodo `value change listener` definido en `vacanteForm`.

Por ultimo se agregaron los nuevos atributos a los properties de mensajes tanto en ingles como en español.
