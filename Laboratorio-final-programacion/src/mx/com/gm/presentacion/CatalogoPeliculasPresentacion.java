package mx.com.gm.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion: \n"
                    + "1. iniciar catalogo peliculas\n"
                    + "2. agregar pelicula\n"
                    + "3. listar peliculas\n"
                    + "4. buscar pelicula\n"
                    + "0. salir");
            opcion = Integer.parseInt(sc.nextLine());

            
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;

                case 2:
                    System.out.println("Introduce el nombre de la pelicula: ");
                    catalogo.agregarPelicula(sc.nextLine());
                    break;

                case 3:
                    catalogo.listarPeliculas();
                    break;

                case 4:
                    System.out.println("Introduce una pelicula a buscar: ");
                    catalogo.buscarPelicula(sc.nextLine());
                    break;

                case 0:
                    System.out.println("Hasta pronto");
                    break;

                default:
                    System.out.println("Opcion no reconocida");
                    break;
            }
        }
    }
}
