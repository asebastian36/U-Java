package test;

import datos.PersonaDAO;
import domain.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        //  insertando una instancia de persona
//        Persona registro_prueba = new Persona("Gerard", "Pique", "geri3@mail.com", "3333333333");
//        
//        personaDAO.insertar(registro_prueba);
        
        //  actualizar registro
//        Persona registro_prueba1 = new Persona(2, "Carles", "Puyol", "puyi@mail.com", "2222222222");
//        
//        personaDAO.actualizar(registro_prueba1);
        
        //  Eliminar registro
//        personaDAO.eliminar(registro_prueba1);

        
        //  recuperar registros de la tabla en una lista
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(persona -> {
            System.out.println(persona);
        });
        
        //  bajo acoplamiento: cada clase tiene las relaciones minimas
        //  con las otras clases. alta cohesion: ya que cada clase solo realiza
        //  sus tareas.
        
        //  se formo la capa de datos
    }
}
