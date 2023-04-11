# Validadores, Convertidores y manejo de mensajes en JSF

Estos temas tienen principal relevancia en la etapa tres del ciclo de vida de los JSF en el procesamiento de validadores,
las validaciones en JSF aseguran que los datos de la aplicacion sean consistentes segun los datos introducidos por el usuario,
cuestiones que `podemos validar` son `rangos de numeros o limites, largo de cadena, formatos de fechas y etc`.

JSF provee distintos tipos de validaciones, por ejemplo `validaciones estandar`, `validaciones en metodos de Managed Beans` y
`validaciones personalizadas`.

El proceso en la etapa tres del ciclo de vida de los JSF permite asegurar que antes de actualizar las propiedades del `model manages bean`
tengamos certeza que la informacion se encuentra con el formato y tipo de dato adecuado.

## Validaciones en JSF

Dos maneras de ejecutar la validacion en nuestros componentes:

Validacion individual por campo, por ejemplo:

* Agregando un atributo required al tag JSF.
* Agregando un atributo validador al tag JSF.
* Agregando un validador como un tag interno.
* El tag `h:message` se utiliza para mostrar errores de un componente.

> h:message se utiliza para mostrar errores en un componente de JSF

Validacion por campos interdependientes (de manera customizada)

La validacion interdependiente se ejecuta dentro de los metodos actions

* El tag `h:messages` se utiliza para mostrar varios errores a la vez.

> h:messages se utiliza para desplegar errores que no necesariamente tienen que ver con errores generales de la pagina

Al utilizar validaciones se es responsable de mandar los mensajes de error usando ya sea `h:message` o `h:messages`.

## Ejemplo de uso de validadores en JSF

**Ejemplo de un validador estandar:**

```Java
<h:inputText id="edadId" required="true" value="#{empleadoBean.edad}">
  <f:validateLongRange minimum="18" maximum="50"/>
</h:inputText>
```

**Ejemplo de validador personalizado:**

```Java
<h:inputText id="ipId" required="true" value="#{ipBean.ipValor}">
  <f:validator validatorId="validadorIp">
</h:inputText>
```
