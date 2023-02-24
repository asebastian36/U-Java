package domain;

//  clase de dominio o entidad debido a que tiene una representacion en la bd
public class Persona {
    //  atributos extraidos de la tabla en una clase, representan columnas
    //  de nuestra tabla
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    //  clase que representa un registro de la tabla de personas
    //  esta clase se utilizara para recuperar informacion, insertar informacion
    //  modificar informacion y eliminar informacion
    
    //  se puede tener la necesidad de crear objetos de persona de diferentes 
    //  maneras 
    public Persona() {
    }

    //  en caso de que este objeto se cree momentaneamente y se pueda eliminar
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    //  para crear un registro
    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //  para modificar todos los atributos
    public Persona(int idPersona, String nombre, String apellido, String email, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    //  para modificar los campos uno a uno
    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "idPersona=" + this.idPersona + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", email=" + this.email + ", telefono=" + this.telefono;
    }
}
