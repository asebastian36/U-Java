package mx.com.modificadoracceso.test;

import mx.com.modificadoracceso.protegido2.ClaseHija;
import mx.com.modificadoracceso.protegido1.Clase1;

public class TestModificadoresAccesoProtegido {
    public static void main(String[] args) {
        //  Un contructor de la clase protected ya no se puede utilizar,
        //  tenemos que crear un constructor publico para instanciar la clase
        Clase1 clase1 = new Clase1("argumento para el constructor publico");
        
        //  ya no podemos acceder directamente a un atributo protected,
        //  ya que solo las subclases de la clase padre pueden acceder a los atributos protected
        //  de la clase padre
        System.out.println("clase1 = " + clase1.getAtributoProtegido());
        
        //  ya no podemos acceder a un metodo protegido desde otro paquete
        //  clase1.metodoProtegido();
        
        //  test ahora con la clase hija
        //  si podemos acceder al constructor protected, al atributo (desde el constructor)
        //  y al metodo protected (desde el constructor)
        ClaseHija hija = new ClaseHija();
        
        System.out.println("hija = " + hija);
    }
    
}
