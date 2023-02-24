package mx.com.sobreescritura;


public class Gerente extends Empleado {
    //  Atributo
    private String departamento;
    
    //  constructor
    public Gerente(String nombre, double sueldo, String departamento) {
        super(nombre, sueldo);
        this.departamento = departamento;
    }
    
    //  una anotacion modificar de cierta manera el comportamiento del metodo
    //  que esta posterior a la notacion
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles() + ", departamento=" + this.departamento;
    }
}
