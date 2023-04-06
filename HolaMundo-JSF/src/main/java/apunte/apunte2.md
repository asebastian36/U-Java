# Managed Bean en JSF

## Concepto de Managed Beans

> Repaso de un Java Bean: Clase Java que sigue las siguientes convenciones tiene un constructor vacio, tiene atributos privados y por
> cada atributo privado tiene su metodo set y get.

Los Managed Bean son clases Java que tambien cumplen con las convenciones de los JavaBeans, sin embargo al trabajar con JSF vamos a
configurarlos y declararlos de manera distinta.

Los Managed Bean no estan obligados a extender de ninguna otra clase.

> Un Backing Bean es lo mismo que un Managed Bean

Aunque JSF no define una clasificacion para los Backing Beans, podemos definir las siguientes:

* **Beans de Modelo:** Representan el modelo en el patron MVC.
* **Beans de Control:** Representan el controlador en el patron MVC.
* **Beans de soporte o helpers:** Contiene codigo por ejemplo de convertidores.
* **Beans de utilerias:** Tareas genericas, como obtener el objeto request.

## Uso de los Managed Beans

Un Managed Bean se puede declarar de distintas maneras:

```java
@ManagedBean
```

Como bean CDI (Contexts and Dependency Inyection), antes del nombre de la clase:

```java
@Named
//  agregar un archivo llamado beans.xml en la carpeta: web/WEB-INF
```

> En la version Java EE 8 es opcional el archivo beans.xml

En el archivo `faces-config.xml`:

```java
<managed-bean>...</managed-bean>
```

## Alcance de los managed beans

| | de mayor a menor alcance |
|:---|:---|
| **application** | persiste durante toda la aplicacion. |
| **session** | persiste durante el tiempo de la sesion del usuario. |
| **view** | persiste si es la misma vista (de la misma pagina), util si usamos ajax. |
| **request** | persiste solo durante la peticion del usuario. |

## Alcance de los CDI y el alcance de Beans

| | de mayor a menor alcance |
|:---|:---|
| **application** | persiste durante toda la aplicacion. |
| **session** | persiste durante el tiempo de la sesion del usuario. |
| **conversation** | persiste hasta concluir alguna tarea |
| **request** | persiste solo durante la peticion del usuario. |
