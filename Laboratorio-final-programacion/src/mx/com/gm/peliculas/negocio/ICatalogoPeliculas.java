package mx.com.gm.peliculas.negocio;

/*
    Contiene las operaciones necesarias de la aplicacion CatalogoPeliculas
*/

public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt";
    
    public void agregarPelicula(String nombrePelicula);
    public void listarPeliculas();
    public void buscarPelicula(String buscar);
    public void iniciarCatalogoPeliculas();
}
