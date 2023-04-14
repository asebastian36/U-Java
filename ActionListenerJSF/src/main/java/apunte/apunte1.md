# Cambios con respecto al proyecto anterior

Se agregara un campo de formulario que se mustre o se oculte segun la accion que hagamos.

El primer cambio que se hizo fue agregar el campo de `comentario` a la clase `Candidato` en el paquete
`beans.model` incluyendo los metodos `set` y `get`

Despues agregaremos el campo `comentario` al formulario en el `index.xhtml`, se utilizo un `h:commandLink`
en el que se utilizo la propiedad `rendered` que ayuda a hacer visible o no segun la condicion, en este
caso la condicion sera de un atributo del `Managed Bean` de `VacanteForm`, estos `action listeners` solo
son condicionales, pero si se cumple la condicion se mostrara en un `h:panelGroup` que contiene una tabla
con el comentario a mostrar.

Posteriormente modificamos el Bean de `VacanteForm` para poder procesar los `action listener` definidos en
el formulario.

Por ultimo incluimos los mensajes extra del formulario en los `mensajes` en ingles y español.
