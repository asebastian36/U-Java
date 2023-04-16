package beans.backing;

import beans.helper.ColoniaHelper;
import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
    private boolean comentarioEnviado;

    @Inject
    private ColoniaHelper coloniaHelper;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public boolean isComentarioEnviado() {
        return this.comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }

    public ColoniaHelper getColoniaHelper() {
        return this.coloniaHelper;
    }

    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }

    //  redireccionamiento a otra pagina con condicional
    public String enviar() {
        if (this.candidato.getNombre().equals("Angel")) {
            if (this.candidato.getApellido().equals("Franco")) {
                String msj = "Gracias, pero Angel Franco ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, msj);
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
        int nuevoCodigoPostal = ((Long) valueChangeEvent.getNewValue()).intValue();

        //  para ubicar a que campo del formulario va a ir la respuesta
        UIInput coloniIdaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");

        //  definimos la respuesta
        int coloniaId = this.coloniaHelper.getColonia(nuevoCodigoPostal);

        //  la enviamos
        coloniIdaInputText.setValue(coloniaId);
        coloniIdaInputText.setSubmittedValue(coloniaId);

        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String ciudad = "Nezahualcoyotl";
        ciudadInputText.setValue(ciudad);
        ciudadInputText.setSubmittedValue(ciudad);

        //  para mandar la respuesta con los cambios a la pagina
        facesContext.renderResponse();
    }

    public void ocultarComentario(ActionEvent actionEvent) {
        this.comentarioEnviado = !this.comentarioEnviado;
    }
}
