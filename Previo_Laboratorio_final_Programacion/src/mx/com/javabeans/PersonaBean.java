package mx.com.javabeans;

import java.io.Serializable;

public class PersonaBean implements Serializable{
    //  un javabean es una clase con ciertas caracteristicas:
    /*
        1. todos sus atributos deben ser privados con su respectivo
        setter y getter.
        
        2. Debe implementar la interfaz serializable.
    
        3. Implementar un constructor vacio y publico.
    */
     
    private String nombre;
    private String apellido;
    
    public PersonaBean() {
    
    }
    
    public PersonaBean(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //  esto esta de mas
    @Override
    public String toString() {
        return "PersonaBean{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
}
