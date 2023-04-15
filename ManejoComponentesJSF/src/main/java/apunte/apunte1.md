# Cambios con respecto al proyecto anterior

Agregaremos un componente en el `index.xhtml` de tipo `Select item`.

Empezando por la clase `Candidato` en el paquete `beans.model`, eliminando el atributo de `colonia` para
manejarlo como un `Select item`, despues se agrega el atributo `coloniaId` de tipo `int` agregando sus
setters y getters.

Luego modificamos los archivos `.properties` quitando el `vacanteForm.colonia` y en su lugar agregando
`vacanteForm.coloniaId` y `vacanteForm.seleccione`.

Ahora si modificamos el archivo de `index.xhtml` para manejar los cambios hechos, empezando buscando
el `h:inputText` con el id de colonia para eliminarlo, esto para manejar el tipo `selectOneMenu`. Y
cambiando los mensajes y la direccion de los `h:OutputLabel` a `coloniaId`.

Despues pasamos a al Managed Bean de `vacanteForm` para que puede manejar el `selectOneItem`.
