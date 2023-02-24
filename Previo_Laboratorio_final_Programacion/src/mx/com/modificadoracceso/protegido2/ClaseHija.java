package mx.com.modificadoracceso.protegido2;

import mx.com.modificadoracceso.protegido1.Clase1;

public class ClaseHija extends Clase1{
    public ClaseHija() {
        //  Desde una clase hija (heredando desde otro paquete)
        //  si podemos acceder a los atributos, constructores y metodos protected
        super();
        //  se puede acceder para leer o modificar
        this.atributoProtegido = "Modificacion atributo protected";
        System.out.println("this.atributoProtegido = " + this.atributoProtegido);
        this.metodoProtegido();
    }
}
