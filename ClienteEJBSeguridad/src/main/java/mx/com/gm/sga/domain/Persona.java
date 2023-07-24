package mx.com.gm.sga.domain;

import java.io.Serializable;

/**
 *
 * @author angel
 */

public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer idPersona;
    private String apellido;
    private String email;
    private String nombre;
    private String telefono;
    
    public Persona() {
    
    }
    
    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", apellido=" + apellido + ", email=" + email + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
}
