# Cambios con respecto al proyecto anterior

Agregar un estilo e imagenes a nuestro proyecto de JSF para que luzca distinto.

Se creo una carpeta llamada `resources` en la carpeta `Web pages` que contendra una
carpeta llamada `css` con archivo llamado `estilos.css`. Tambien dentro de `Web pages`
creamos la carpeta `images` e incluimos imagenes.

Despues creamos dentro de la carpeta `WEB-INF` una carpeta llamada `plantillas` donde
se agregara un archivo llamado `plantilla.xhtml` agregandole al archivo las etiquetas
de JSF y el manejo de Facelets.

Una vez configurada la `plantilla.xhtml` hay que habilitar la plantilla en el `index.xhtml`
para que la pueda utilizar e importamos el `xmlns="http://java.sun.com/jsf/facelets"` en
el `index.xhtml`.
