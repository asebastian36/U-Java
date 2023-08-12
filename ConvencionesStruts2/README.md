# Notas

Este proyecto es una copia del proyecto `HolaMundoStruts2`.

## Cambios

## Convenciones en Struts2

Struts 2 es un marco de desarrollo web MVC (Modelo-Vista-Controlador) que se utiliza para crear aplicaciones web dinámicas. Struts 2 se basa en el modelo de acción-resultado, en el que las acciones son las unidades de trabajo que realizan tareas en la aplicación, y los resultados son las páginas web que se muestran al usuario.

Struts 2 tiene una serie de convenciones que se utilizan para organizar el código y las configuraciones. Estas convenciones hacen que sea más fácil desarrollar y mantener aplicaciones Struts 2.

Algunas de las convenciones más importantes de Struts 2 incluyen:

* Los nombres de las acciones deben comenzar con la letra minúscula "a".
* Los nombres de los resultados deben comenzar con la letra mayúscula "R".
* Las acciones se definen en archivos de acción.
* Los resultados se definen en archivos de resultado.
* Los archivos de acción y de resultado se almacenan en el directorio `/WEB-INF`.
* Las acciones se llaman mediante enlaces URL.
* Los resultados se muestran al usuario mediante la función `render()`.

Al seguir estas convenciones, puede crear aplicaciones Struts 2 que sean más fáciles de desarrollar y mantener.

Aquí hay algunos ejemplos de convenciones de nomenclatura de Struts 2:

* Acción para agregar un nuevo producto: `addProductAction`
* Resultado para mostrar la lista de productos: `listProductsResult`
* Archivo de acción para la acción `addProductAction`: `/WEB-INF/addProductAction.action`
* Archivo de resultado para el resultado `listProductsResult`: `/WEB-INF/listProductsResult.jsp`
* Enlace URL para la acción `addProductAction`: `/addProduct.action`

Al seguir estas convenciones, puede crear aplicaciones Struts 2 que sean más consistentes y fáciles de entender.

## Mapeo de vistas

El mapeo de vistas en Struts 2 es el proceso de asociar un nombre de vista con una acción. Esto se hace para que el framework pueda generar la vista correcta en respuesta a una solicitud del usuario.

Hay dos formas de asociar un nombre de vista con una acción:

* **Usando la anotación @Result:** Esta anotación se utiliza para asociar un nombre de vista con una acción. La anotación se coloca en el método de acción que genera la vista.
* **Usando el archivo struts.xml:** Este archivo se utiliza para configurar el framework Struts 2. En el archivo struts.xml, puede asociar nombres de vista con acciones utilizando el elemento `result`.

Aquí hay un ejemplo de cómo usar la anotación @Result para asociar un nombre de vista con una acción:

```java
@Action(value = "/addProduct")
public class AddProductAction {

    @Result(name = "success", location = "/WEB-INF/success.jsp")
    public String addProduct() {
        // Do something
        return "success";
    }

}
```

En este ejemplo, el nombre de la vista es `success` y la ubicación de la vista es `/WEB-INF/success.jsp`. Cuando el usuario llama a la acción `addProduct`, el framework Struts 2 generará la vista `/WEB-INF/success.jsp`.

Aquí hay un ejemplo de cómo usar el archivo struts.xml para asociar un nombre de vista con una acción:

```xml
<struts>
    <package name="com.example.struts2">
        <action name="addProduct">
            <result name="success" location="/WEB-INF/success.jsp"/>
        </action>
    </package>
</struts>
```

En este ejemplo, el nombre de la vista es `success` y la ubicación de la vista es `/WEB-INF/success.jsp`. Cuando el usuario llama a la acción `addProduct`, el framework Struts 2 generará la vista `/WEB-INF/success.jsp`.

## Mapeo de acciones

El mapeo de acciones en Struts 2 es el proceso de asociar una ruta URL con una acción. Esto se hace para que el framework pueda invocar la acción correcta en respuesta a una solicitud del usuario.

Hay dos formas de asociar una ruta URL con una acción:

* **Usando la anotación @Action:** Esta anotación se utiliza para asociar una ruta URL con una acción. La anotación se coloca en la clase de acción.
* **Usando el archivo struts.xml:** Este archivo se utiliza para configurar el framework Struts 2. En el archivo struts.xml, puede asociar rutas URL con acciones utilizando el elemento `action`.

Aquí hay un ejemplo de cómo usar la anotación @Action para asociar una ruta URL con una acción:

```java
@Action(value = "/addProduct")
public class AddProductAction {

    // ...

}
```

En este ejemplo, la ruta URL es `/addProduct` y la acción es `AddProductAction`. Cuando el usuario llama a la ruta URL `/addProduct`, el framework Struts 2 invocará la acción `AddProductAction`.

Aquí hay un ejemplo de cómo usar el archivo struts.xml para asociar una ruta URL con una acción:

```xml
<struts>
    <package name="com.example.struts2">
        <action name="addProduct" path="/addProduct"/>
    </package>
</struts>
```

En este ejemplo, la ruta URL es `/addProduct` y la acción es `AddProductAction`. Cuando el usuario llama a la ruta URL `/addProduct`, el framework Struts 2 invocará la acción `AddProductAction`.
