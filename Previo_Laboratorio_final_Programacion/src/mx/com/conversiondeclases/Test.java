package mx.com.conversiondeclases;

public class Test {
    public static void main(String[] args) {        
        
        //  definimos la instancia
        Empleado empleado;
        
        //  le asignamos un valor
        empleado = new Escritor("Juan", 5000, TipoEscritura.CLASICO);
        
        //  aplicacion del downcasting     
        //  pasar de una clase hija a una clase padre
        ((Escritor) empleado).getTipoEscritura();
        
        //  aplicacion del upcasting
        //  pasar de una clase padre a una clase hija
        Empleado empleado2 = ((Escritor) empleado);
        
        /*
            podemos usar apuntadores del tipo de la clase padre 
            apuntando a un objeto de la clase hija SI en ese momento estamos
            llamando metodos y/o atributos que esten en ambas clases
        
            sino necesitaremos hacer una conversion (casting)
        */
        
    }
}
