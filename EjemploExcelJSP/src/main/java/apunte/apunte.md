# Directivas en JSP's

* Las directivas nos permiten controlar el comportamiento de un JSP

* Con las directivas podemos especificar:
    * Las calses Java que queremos importar en un JSP.
    * El tipo MIME utilizado.
    * Indicar si el JSP puede acceder a la sesion HTTP.
    * El tamano del buffer de salida.
    * Indicar la pagina JSP de error en caso de alguna Excepcion.
    * El manejo de multihilos, etc.

## Atributos en las directivas en un JSP

Para especificar las clases a importar dentro del JSP.

> Se recomienda especificar al principio

* Atributo `import`:
    * `<%@ page import="paquete.Clase1, paquete.ClaseN" %>`

Para especificar el tipo de respuesta al cliente.

* Atributo `contentType`:
    * `<%@ page contentType="MIME-Type" %>`

Para el uso de sesiones en el JSP o en el servlet.

> Por defecto ya esta habilitado asi que es mas probable llamarlo para
> deshabilitarlo

* Atributo `session`:
    * `<%@ page session="true" %>`

Para el uso de `expression language` en el JSP.

> Comunmente se llama para deshabilitarlo

* Atributo `isELIgnored`:
    * `<%@ page isELIgnored="false" %>`

Podemos especicar el tamano del buffer del JSP.

> Una vez llegado al maximo especificado se hace un vaciado de manera automatica
> de todo el flujo que se agregue al printWritter o al outputservler depende
> el caso

* Atributo `buffer`:
    * `<%@ page buffer="tamanoenKB" %>`

Se especifica cual JSP manejara la excepcion en caso de error

* Atributo `errorPage`:
    * `<%@ page errorPage="url relatico al JSP de error" %>`

> Esta sintaxis se agrega al JSP que maneje los errores para que pueda acceder
> a la pila de errores, este atributo por defecto esta en false

Brinda al JSP la capacidad de procesar excepciones ya sea en el JSP o en otros
JSP.

* Atributo `isErrorPage`:
    * `<%@ page isErrorPage="true" %>`

Especificamos que un JSP es seguro para ser accedido por multiples hilos.

> El valor por default es true, pero si se decide deshabilitarlo hay
> que acceder al atributo

* Atributo `isThreadSafe`:
    * `<%@ page isThreadSafe="true" %>`

Permite heredar de una clase.

> Se suele utilizar cuando se requiere agregar comportamiento de terceros

* Atributo `extends`:
    * `<%@ page extends="paquete.NombreClase" %>`
