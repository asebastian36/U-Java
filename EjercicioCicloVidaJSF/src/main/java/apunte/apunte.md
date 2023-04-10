# ciclo de vida de JSF

Comienza con la peticion de un usuario (usuario que solicite algun recurso del servidor web), la primera fase en este ciclo de vida
es el proceso de restauracion o creacion de la vista, si es la primera vez que solicita esta vista, se va a crear cada uno
de los componentes que representan las etiquetas de la pagina JSF y va a tener una clase correspondiente de Java que represente
esa etiqueta en JSF, todas estas etiquetas son administradas por un componente principal llamado `component tree` o arbol de componentes.

En caso de que la peticion haya sido GET o sin parametros, en este caso el framework no tiene nada mas que realizar y simplemente
regresamos la respuesta hacia el cliente, en caso contrario y que necesitemos procesar informacion el paso dos es aplicar los valores
de la peticion (procesamiento de parametros), en este paso los parametros enviados son mapeados con cada uno de los componentes Java
correspondientes, esto nos permitira llenar la informacion que los usuarios estan enviando a nuestra aplicacion Java.

En el paso tres de este ciclo de vida lo que sucede es el procesamiento de validaciones y conversiones, es decir en el paso dos ya se
asignaron los valores correspondientes a nuestras clases Java, sin embargo en este punto todavia no sabemos si esos valores son los
adecuados o si es necesario convertirlos a cierto tipo de dato, por ello en este paso tres si alguna validacion falla, el estado del
componente Java se marca como invalido y se pasa directamente al estado seis, esto unicamente sucede en caso de que se halla encontrado
algun error de conversion o de validacion, sin embargo esto garantiza que la aplicacion Java no va a continuar si es que tiene algun
problema de validacion o de correccion de datos, en caso que no tengamos errores de validacion. En el paso cuatro lo que hace el
framework es actualizar el valor de las clases de modelo, los valores de los componentes Java ya una vez validados y convertidos en el
paso tres son puestos en los objetos de modelo utilizando los metodos setters respectivos, es decir que hasta este paso cuatro es donde
hasta realmente el framework nos garantiza que esos valores ya los podemos utilizar para operar.

En el paso cinco tenemos la informacion de modelo, procedemos a invocar nuestra aplicacion o lo que es lo mismo los metodos que procesan
las peticiones de nuestros usuarios, en este punto se ejecutan los metodos `action` que estan almacenados en los `Managed Bean`, los
metodos `action listener` son llamados antes que los metodos de tipo `action`.

Una vez que hemos procesado los metodos de la aplicacion se genera una respuesta hacia el cliente, con esto se concluye el ciclo de vida
de la aplicacion de JSF, es posible crear clases para la depuracion de las fases paso a paso, para ello debemos implementar la interfaz
`PhaseListener` y se debe registrar en el archivo de `faces-config.xml`
