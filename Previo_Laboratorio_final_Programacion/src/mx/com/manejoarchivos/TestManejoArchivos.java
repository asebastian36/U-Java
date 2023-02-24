package mx.com.manejoarchivos;

public class TestManejoArchivos {
    public static void main(String[] args) {
        String nombreArchivo = "UsU";
        
        //  ManejoArchivos.crearArchivo(nombreArchivo);
        
        ManejoArchivos.escribirArchivo(nombreArchivo, "Soy el contenido");
        ManejoArchivos.agregarInformacion(nombreArchivo, "Hola, buenos dias,");
        ManejoArchivos.agregarInformacion(nombreArchivo, "buenas tardes y buenas noches.");
        
        System.out.println("");
        
        ManejoArchivos.leerInformacion(nombreArchivo);
    }
}
