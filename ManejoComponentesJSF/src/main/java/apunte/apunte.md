# Componentes HTML en JSF

El API de JSF provee varios componentes basicos para el despliegue de informacion HTML. El API de JSF
provee varios componentes `core` para el manejo de eventos, administracion de componentes, etc.

## Lista de algunos componentes HTML en JSF

* `<h:form />`
* `<h:inputSecret />`
* `<h:outputLink />`
* `<h:commandButton />`
* `<h:messages />`
* `<h:dataTable />`
* `<h:selectOneRadio />`
* `<h:selectManyListbox />`
* `<h:inputText />`
* `<h:inputHidden />`
* `<h:outputFormat />`
* `<h:commandoLink />`
* `<h:panelGrid />`
* `<h:column />`
* `<h:selectBooleanCheckbox />`
* `<h:selectManyMenu />`
* `<h:inputTextarea />`
* `<h:outputLabel />`
* `<h:outputText />`
* `<h:message />`
* `<h:panelGroup />`
* `<h:selectOneListbox />`
* `<h:selectManyCheckbox />`

## Lista de algunos componentes core en JSF

* `<f:view />`
* `<f:attribute />`
* `<f:valueChangeListener />`
* `<f:convertNumber />`
* `<f:validateLength />`
* `<f:selectItems />`
* `<f:subview />`
* `<f:param />`
* `<f:converter />`
* `<f:validatos />`
* `<f:validateLongRange />`
* `<f:selectItem />`
* `<f:facet />`
* `<f:actionListener />`
* `<f:convertDataTime />`
* `<f:loadBundle />`
* `<f:verbatim />`

Este tipo de componentes no dan un resultado de tipo HTML como tal, sino que tienen que ver directamente
con el framework de JSF, con el ciclo de vida de JSF o con validaciones y conversiones que se aplicacion
a los componentes HTML.

## Arquitectura de componentes JSF

> Tienen similitud con componentes de tipo swim para aplicaciones de escritorio en Java.

Un componente JSF se compone de 3 partes:

* **Etiqueta JSF.** Es el primer componente, aqui es donde podemos configurar eventos, etiquetas con
internacionalizacion, personalizacion de la apariencia del componente, conversiones, validaciones, etc.
  * `h:inputText`

* **Despliegue del componente.** Representa el codigo que visualiza el cliente, en caso de ser un cliente con
un navegador web lo visualiza en HTML, el `render kit` por default en JSF es un codigo en HTML
  * Elemento HTML

* **Componente JSF UI:** Finalmente como parte de la arquitectura. el componente Java UI este es una clase
de Java que representa el componente de la pagina JSF, pero desde el punto de vista de codigo Java, en la
fase 1 del ciclo de vida de JSF (restauracion de la vista) es donde la etiqueta JSF se mapea con un
componente Java de tipo UI y una vez que se mapea se agrega este componente a la clase `ComponentTree` de
la vista, por lo que como podemos observar un componente de JSF se compone de mas elementos que una simple
etiqueta HTML, esto permite que un elemento creado en JSF sea reutilizable y bastante robusto.

## ComponentTree en JSF

Flujo de una aplicacion JSF, la cual esta orienta a administrar el codigo desde el lado del servidor,
el flujo comienza con el cliente o navegador unicamente recibe el codigo HTML generado por nuestro servidor
Java, una vez que el cliente hace una nueva peticion al servidor, el `ComponentTree` sincroniza nuevamente
esto es el codigo de las etiquetas JSF son convertidos o actualizados a su componente JSF de tipo UI
respectivo. Por ejemplo el componente `<h:inputText>` se convierte en un componente de tipo UI inputText
el cual puede ser manipulado directamente por un `Managed Bean`, entonces nuestra etiqueta finalmente genera
elementos Java y estos elementos Java se agregan a nuestro `ComponentTree` una vez que sea terminado con las
fases del ciclo de vida de JSF se envia nuevamente la respuesta al cliente, generando finalmente la respuesta
HTML.

El `ComponentTree` tiene una duracion de vida muy corta, normalmente durante el envio y la respuesta de la
peticion, es decir, un alcance de tipo `request response`.

## Componentes de seleccion en JSF

El API de JSF provee distintos tipos de componentes de seleccion:

Por ejemplo:

* `<h:selecOneListbox />`
* `<h:selectOneMenu />`
* `<h:selectOneRadio />`
* `<h:selectBooleanCheckBox />`
* `<h:selectManyCheckbox />`
* `<h:selectManyListbox />`
* `<h:selectManyMenu />`

> En la pagina de corejsf podemos encontrar ejemplos de estos componentes JSF.
> www.corejsf.com/jsf-tags.html

## Select items en JSF

Los componentes JSF tales como `h:selectOneMenu` muestran una lista de datos, los cuales se conocen
como **Select items**. La lista de elementos de tipo `Select items` ligada a una propiedad del
`Managed Bean`:

Codigo a utilizar en la pagina JSF:

```xhtml
<h:selectOneMenu>
    <f:selecItems value="#{coloniaHelper.coloniaSelectItems}" />
</h:selectOneMenu>
```

El elemento `selectItems` esta asociado con un componente Java en una clase de tipo `Managed Bean`, el Bean
se llama `coloniaHelper` y el atributo a utilizar se llama `coloniaSelectItems` que es de tipo `selectItems`
en la clase Java. Tambien podemos desplegar la lista de elementos de JSF de la siguiente manera (agregando)
elementos en codigo duro:

```xhtml
<h:selectOneMenu>
      <f:selectItems>
            <f:selectItem itemLabel="Rojo" itemValue="rojo" />
            <f:selectItem itemLabel="Verde" itemValue="verde" />
            <f:selectItem itemLabel="Azul" itemValue="azul" />
      </f:selectItems>
</h:selectOneMenu>
```
