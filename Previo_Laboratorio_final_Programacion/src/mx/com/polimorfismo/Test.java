package mx.com.polimorfismo;

//  test de polimorfismo 

/*
    se requiere tener una clase  padre, un metodo,
    una clase hija y un metodo sobreescrito de la clase padre.

    polimorfismo significa multiples comportamientos
    solo se visualiza en tiempo de ejecucion.
*/
public class Test {
    public static void main(String[] args) {
        Empleado empleadoInstancia = new Empleado("Diego", 5000000);
        //  System.out.println("empleado = " + empleado.obtenerDetalles());
        imprimir(empleadoInstancia);
        
        empleadoInstancia = new Gerente("Chamoy", 6000000, "leloide");
        //  System.out.println("gerente = " + gerente.obtenerDetalles());
        imprimir(empleadoInstancia);
    }
    
    //  este metodo llamara al metodo mostrar detalles
    //  del objeto recibido, se pone el tipo mas generico
    public static void imprimir(Empleado empleado) {
        String detalles = empleado.obtenerDetalles();
        System.out.println("empleado = " + detalles);
    }
}
