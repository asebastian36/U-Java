package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Angel Franco
 */

@Named
@RequestScoped
public class VacanteForm {
    //  uso de CDI para inyectar una dependencia
    @Inject
    //  agregando la inyeccion del tipo Candidato
    private Candidato candidato;

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    //  redireccionamiento a otra pagina con condicional
    public String enviar() {
        if(this.candidato.getNombre().equals("Angel")) return "exito";
        else return "fallo";
    }
}
