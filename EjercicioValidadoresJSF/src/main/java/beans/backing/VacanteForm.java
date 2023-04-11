package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    
    Logger log = LogManager.getRootLogger();

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    //  redireccionamiento a otra pagina con condicional
    public String enviar() {
        if(this.candidato.getNombre().equals("Angel")) {
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando en caso de fallo");
            return "fallo";
        }
    }
}
