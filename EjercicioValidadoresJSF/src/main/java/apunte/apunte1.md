# Cambios con respecto al ejercicio anterior

Modificacion en la clase `Candidato` en el paquete `beans.model` para agregar los atributos de apellido y salarioDeaseado
junto con un constructor publico vacio que mandara un mensaje al servidor de glashfish al crear el objeto. Se agregaron
los setter y getters de los atributos agregados.

Despues pasamos al `index.xhtml` en la carpeta `Web Pages` para agregar los nuevos atributos e incluir validaciones. incluimos
la importacion de la libreria de core, dado que incluye muchos de los elementos para las validaciones.

Por ultimo pasamos al archivo de `VacanteForm` en el paquete `beans.backing` creando un constructor publico y vacio en el que
habra un mensaje para la consola de glashfish, tambien modificaremos el metodo `enviar` para hacer algunas validaciones (no son
relacionadas al tema de JSF).
