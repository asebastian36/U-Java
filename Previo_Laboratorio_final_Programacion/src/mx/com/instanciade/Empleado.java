package mx.com.instanciade;

//  Sobreescritura significa que un metodo en la clase hija modifica 

//  Sobreescritura significa que un metodo en la clase hija modifica 
//  el comportamiento de la clase padre
public class Empleado {
    //  atributos
    private String nombre;
    private double sueldo;
    
    //  constructor 
    public Empleado(String nombre, double sueldo) {
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
    //  getters y setters
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    //  metodo o comportamiento a sobreescribir
    public String obtenerDetalles() {
        return "Empleado{" + "nombre=" + nombre + ", sueldo=" + sueldo + '}';
    }


}
