package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Angel Franco
 */

@Named
@RequestScoped
public class Candidato {
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
