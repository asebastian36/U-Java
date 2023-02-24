# Buenas practicas y patrones de diseño

En un arquitectura Java EE es comun que una aplicacion se divida en capas y cada una esta encargada de realizar tareas en especifico, existen los conceptos de buenas practicas y patrones de diseño con el objetivo de reducir problemas.

Las buenas practicas incluyen temas de codificacion, division de responsabilidades en capas logicas, etc.

Los patrones de diseño resuelven un problema recurrente (un patron) en el desarrollo de sistemas, en particular en sistemas relacionados a objetos.

Un tema crucial en el desarrollo de sistemas es la cohesion y el acoplamiento este tema entra cuando manejamos varias capas logicas.

| Capa de presentacion | Capa de negocio  | Capa de datos |
| -- | -- |-- |
| administrar el flujo y la presentacion de las pantallas del sistema, procesar los datos del usuario (formularios) y desplegar la informacion al usuario. | Procesar la logica de negocio y/o servicios del sistema | Obtiene y guarda informacion de las fuentes de datos, como son: una bd, archivo, etc |

Las capas se intercomunican para procesar la informacion.

## Cohesion y acoplamiento

* El objetivo del diseño es minimizar costos de desarrollo.
* La **cohesion** es la medida en la que un componente de software se dedica a realizar solo la tarea para la cual fue creado, delegando las tareas complementarias a otros componentes.
* El **acoplamiento** es la medida en que los cambios de un componente tiende a necesitar cambios de otro componente, mide el grado de dependencia entre dos o mas elementos, estos elementos pueden ser clases o cualquier componente de software.
* El objetivo del diseño de software es tener una **alta cohesion** y un **bajo acoplamiento** entre sus componentes de software.

## Patrones de diseño

Es una guia que puede involucrar a varias clases y que a su vez nos permite resolver un problema que se presenta de manera recurrente, cuando hablamos de las capas de una aplicacion Java EE cada capa puede tener varios patrones de diseños.

### Ejemplo:
| -Capa presentacion- | -Capa negocio- | -Capa datos- |
| -- | -- | -- |
| **MVC** (modelo vista controlador), **Front Controller** permite una entrada unica cuando el usuario hace una peticion permite aplicar seguridad o validaciones, **DTO**, etc | **Business Delegate** se encarga de llamar a alguno de los metodos de servicio , **Service Locator** se utiliza por el patron business delegate para localizar los servicios si es que se encuentra en algun directorio, **DTO**, etc | **DAO** este patron se encarga de extraer y almacenar informacion en la bd, **DTO** represente un objeto del dominio del problema en ocasiones puede ser una clase de entidad que se persiste en la bd se utilliza para transferir una entidad o lista de entidades entre las distintas capas de la aplicacion, etc |

Estas capas no son las unicas posibles pero son las mas comunes, o pueden llegar a ser menos capas segun sea el caso. El tipo de arquitectura final dependera del problema que queramos resolver.

>Es recomendable usar minimo esas tres capas, para que el mantenimiento y los cambios sean mas faciles de desarrollar.
