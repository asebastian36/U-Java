# Facelets en JSF

Los Facelets es la tecnologia estandar de despliegue en JSF, los Facelets eliminan
completamente la necesidad de utilizar los JSP's. Parte de dejar de usar los JSP's
y utilizar los Facelets se debe a que estos utilizan un parser XML en lugar del compilador
de Java de JSP, Comparado con los JSP, los Facelets crean un `component tree` mas ligero.

Los Facelets resultan hasta 30% mas rapidos en compilacion en comparacion con los JSP's,
tienen soporte para templates y ademas tienen creacion de componentes compuestos mas simple
utilizar este tipo de tecnologia. Permiten el manejo dinamico del `component tree` tanto
para agregar como para eliminar componentes.

> Tienen una sintaxis muy similar a los JSP's

## Los Facelets no son JSP'S

Dentro de una pagina Facelet **NO** es posible utilizar los siguientes taglib de JSP:

* `<jsp:root />`
* `<jsp:directive.include.../>`
* `<jsp:output.../>`
* `<jsp:directive.content.../>`

Sin embargo, **SI** es posible utilizar los tags de JSTL en los Facelets:

* `<c:forEach.../>`
* `<c:if.../>`
* `<c:catch.../>`

## Plantillas con Facelets

Las plantillas definen las regiones logicas de una pagina JSF, por ejemplo:

* **Cabecero.**
* **Menu.**
* **Contenido.**
* **Pie de pagina.**

Para utilizar las plantillas con Facelets los elementos generales son:

* **Template (plantilla):** Pagina utilizada para controlar el layout (disposicion de los
elementos).

* **Template-cliente (Cliente de la plantilla):** Pagina que personaliza su propia
distribucion (layout) a partir de la plantilla que implementa.

Los clientes acceden al Template-client, NUNCA directamente a la plantilla.

## Componentes compuestos en Facelets

Anteriormente la creacion de nuevos componentes JSF requerian de crear clases Java, estas
clases Java a su vez requerian de varios elementos y archivos de configuracion para que
pudieran funcionar en las paginas JSF.

Los Facelets permiten crear componentes reutilizables combinando HTML, css, JavaScript
y tags de JSF:

* Permite la reutilizacion de otros componentes.
* Se definen en un archivo XHTML, no en clases Java.

Los componentes compuestos son basicamente templates asociados a un tag library
personalizado. Para referenciar un componente compuesto basta con importar el namespace
en el XHTML.
