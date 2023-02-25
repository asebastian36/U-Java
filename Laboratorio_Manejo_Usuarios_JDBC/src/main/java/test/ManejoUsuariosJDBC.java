package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.*;

public class ManejoUsuariosJDBC {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = new ArrayList<>();
        
        //  usuarioDAO.insertar(new Usuario("Angel", "1manzanaGrande"));
        
        usuarios = usuarioDAO.seleccionar();
        
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
        

    }
}
