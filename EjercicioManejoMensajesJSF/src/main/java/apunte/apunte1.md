# Cambios con respecto al ejercicio anterior

Se agrego un archivo llamado `mensajes.properties` dentro de la carpeta `Resources` dentro de `Other Sources`
y a nivel raiz creamos el archivo, en este archivo se agregan cada uno de los mensajes a modificar del
formulario y de JSF.

> Se usan referencias unicas para los nombres de los campos del formulario.

Posteriormente en la misma ruta se creo el archivo `jsf.properties` para cambiar los mensajes de error de
los JSF segun el idioma especificado en la aplicacion, Se modifico el mensaje de valor requerido.

Para reconocer los cambios en los mensajes de los JSF y en el formulario se entra al `faces-config.xml`
y se configura.

Esta configuracion es para especificar el uso del lenguaje español como lenguaje por defecto.

```xml
<application>
    <locale-config>
        <default-locale>es</default-locale>
    </locale-config>
</application>
```

Se agrega esto para poder usar los mensajes en el formulario:

```xml
<application>
    <locale-config>
        <default-locale>es</default-locale>
    </locale-config>
    <resource-bundle>
        <base-name>mensajes</base-name>
        <var>msjs</var>
    </resource-bundle>
</application>
```

Por ultimo para poder cambiar los mensajes de JSF por los del archivo:

```xml
<application>
    <locale-config>
        <default-locale>es</default-locale>
    </locale-config>
    <resource-bundle>
        <base-name>mensajes</base-name>
        <var>msjs</var>
    </resource-bundle>
    <message-bundle>jsf</message-bundle>
</application>
```

Despues se modifico el archivo `index.xhtml` para utilizar los mensajes creados en el formulario. El cambio
es en las etiquetas `<h:outputLabel>` en el atributo `value` y un ejemplo del cambio:
`<td><h:outputLabel for="nombre" value="#{msjs['vacanteForm.nombre']}"></h:outputLabel></td>`.
