# Manejo de mensajes e internacionalizacion en JSF

JSF tiene soporte total para la especificacion `l18n` de Java, para la especificacion del idioma en la aplicacion web, estos archivos nos permiten especificar
nuestras etiquetas de las paginas HTML en varios idiomas. El idioma de la aplicacion se puede especificar ya sea en `faces-config.xml` o via programatica con
el metodo `action`, para ello se usa el objeto `FacesContext` y directamente vamos a utilizar el metodo `setLocale` y posteriormente usamos el metodo `locale`
indicando el lenguaje a utilizar.

| Codigo del lenguaje / subregion | Descripcion |
|:---:|:---:|
| es | Español |
| es_MX | Español / Mexico |
| en | Ingles |
| en_GB | Ingles / Britanico |
| en_US | Ingles / Estados Unidos |

Parte de la configuracion del manejo de mensajes se define en archivos de propiedades, cada uno de ellos contienen las etiquetas que se van a utilizar en
nuestras paginas JSF para desplegar las etiquetas en un idioma o en otro.

Java Server Faces puede cargar estas etiquetas de un archivo de propiedades llamado:

## Resource Bundle en JSF

Configuracion en `faces-config.xml`:

```xml
<application>
  <resource-bundle>
    <base-name>mensajes</base-name>
    <var>msg</var>
  </resource-bundle>
</application>
```

Ejemplo de uso:

```xhtml
<h:outputText value="#{msg['form.usuario']}" />
<h:commandButton value="#{msg.enviar}" type="submit" action="login" />
```

> mensajes es el nombre del archivo, sin la extension .properties y msg es el nombre de la variable para utilizarlo en los archivos que contienen las etiquetas.

JSF maneja la localizacion de errores, la informacion que ocurre en eventos como conversiones, validaciones esas acciones son resultado del ciclo de vida JSF,
dentro de este mismo concepto:

## Sobreescritura de mensajes JSF

* Se debe crear un archivo (no importa el nombre) de propiedades.

  `<jsf.properties>`

* Se sobreescriben los mensajes del sistema deseados.

  `javax.faces.component.UIInput.REQUIRED=Valor Requerido`

Se agrega esto al `faces-config.xml`:

```xml
<application>
  <message-bundle>jsf</message-bundle>
</application>
```

En este caso el sistema reconocera de manera automatica que se trata de un archivo que intenta sobreescribir las propiedades directamente de JSF.
