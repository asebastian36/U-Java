package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author Angel Franco
 */

@RequestScoped
@Named
public class ColoniaHelper {
    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();
        
        int coloniaId = 1;
        Colonia colonia = new Colonia(coloniaId++, "Benito Juarez", 57000);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Agua Azul Grupo A Super 4", 57500);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Agua Azul Grupo B Super 23", 57500);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Agua Azul Grupo B Super 4", 57500);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Agua Azul Grupo C Super 4 y Super 23", 57500);
        colonias.add(colonia);
        
        colonia = new Colonia(coloniaId++, "Agua Azul Seccion Pirules", 57510);
        colonias.add(colonia);
        return colonias;
    }
    
    public int getColonia(String nombre) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        
        for(Colonia colonia : colonias) {
            if(colonia.getNombreColonia().equals(nombre)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        
        return coloniaId;
    }
    
    public int getColonia(int codigoPostal) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        
        for(Colonia colonia : colonias) {
            if(colonia.getCodigoPostal() == (codigoPostal)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        
        return coloniaId;
    }
    
    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        
        for(Colonia colonia : colonias) {
            //  el primer parametro es el id y el otro es el label
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(), colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        
        return selectItems;
    }
}
