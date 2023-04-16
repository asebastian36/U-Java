# Cambios con respecto al proyecto anterior

Separaremos del modelo las colonias para que se manejen desde otra clase, creando asi
la clase `Colonia` en `beans.model` agregando los atributos `coloniaId`, `nombreColonia`
y `codigoPostal`, despues se agregan los constructores, uno vacio y uno que inicialize
los atributos, Por ultimo los setters y getters.

Despues se agrego una clase complementario para obtener las colonias (es un boceto),
pero la finalidad es que funcione para obtenerlas. Esta clase es un `Managed Bean` de
alcance `request`, Contiene un metodo para retornar una lista de objetivos de tipo
`Colonia`, agregamos metodos a esta clase para buscar en la lista ya sea por id o por
codigo postal, junto con un metodo para volver a las colonias de tipo `SelectItem`.

Modificando el `index.xhtml` cambios en el `inputText` de `codigo postal` para pasar
los datos que maneja (antes de tipo `String`) a `int`, despues se modifico el
`h:selecOneMenu` para que las opciones en la lista las busque directamente de la clase
`Colonia`.
