package mx.com.modificadoracceso.privado;


public class ClaseHija extends Clase1{
    public ClaseHija() {
        super("Publico");
        
        //  solo con encapsulamiento podemos acceder a un atributo privado
        System.out.println(this.getAtributoPrivado());
    } 
}
