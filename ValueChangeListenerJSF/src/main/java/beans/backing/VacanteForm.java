package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
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
    
    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    //  redireccionamiento a otra pagina con condicional
    public String enviar() {
        if(this.candidato.getNombre().equals("Angel")) {
            if(this.candidato.getApellido().equals("Franco")) {
                String msj = "Gracias, pero Angel Franco ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj ,msj);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componenteId = null; //   este es un mensaje global
                facesContext.addMessage(componenteId, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de exito");
            return "exito";
        } else {
            log.info("Entrando en caso de fallo");
            return "fallo";
        }
    }
    
    public void CodigoPostalListener(ValueChangeEvent valueChangeEvent) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        //  objeto para buscar un componente en el formulario
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        
        //  para obtener el codigo postal escrito
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
        
        //  validacion para llenar los otros campos
        if("57000".equals(nuevoCodigoPostal)) {
            //  para ubicar a que campo del formulario va a ir la respuesta
            UIInput coloniaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:colonia");
            
            //  definimos la respuesta
            String colonia = "Benito Juarez";
            
            //  la enviamos
            coloniaInputText.setValue(colonia);
            coloniaInputText.setSubmittedValue(colonia);
            
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String ciudad = "Nezahualcoyotl";
            ciudadInputText.setValue(ciudad);
            ciudadInputText.setSubmittedValue(ciudad);
            
            //  para mandar la respuesta con los cambios a la pagina
            facesContext.renderResponse();
        }
            
    }
}
