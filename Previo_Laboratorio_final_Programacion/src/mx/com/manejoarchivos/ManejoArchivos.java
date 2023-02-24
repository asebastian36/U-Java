package mx.com.manejoarchivos;

//  io de input output, entrada y salida
import java.io.*;

public class ManejoArchivos {
    //  el manejo de archivos implica varias operaciones
    /*
        1. Crear el archivo
        2. Guardar informacion en el archivo.
        3. Eliminar informacion en el archivo.
        4. Eliminar por completo el archivo.
        ... etc.
    */
    
    public static void crearArchivo(String nombreArchivo) {
        //  creamos un objeto de tipo File y PrintWriter
        File archivo = new File(nombreArchivo);
        
        try {
            //  al instanciar printwriter arroja una excepcion
            PrintWriter salida = new PrintWriter(archivo);
            
            //  esta es la linea que crea el archivo
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    //  agrega informacion, pero sobreescribiendo el archivo
    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        
        try {
            //  al instanciar printwriter arroja una excepcion
            PrintWriter salida = new PrintWriter(archivo);
            
            //  en esta linea se escribe el contenido en el archivo
            salida.println(contenido);
            
            //  esta es la linea que crea el archivo
            salida.close();
            System.out.println("Se ha escrito al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    //  agregara informacion pero sin sobreescribir el archivo
    public static void agregarInformacion(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);
        
        try {
            //  al instanciar printwriter arroja una excepcion
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            
            //  la instancia del filewriter es el cambio que generara
            //  el anexar informacion sin sobreescribirla
            
            //  en esta linea se escribe el contenido en el archivo
            salida.println(contenido);
            
            //  esta es la linea que crea el archivo
            salida.close();
            System.out.println("Se agrego informacion al archivo");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void leerInformacion(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        
        try {
            //  esta es la clase que leera la informacion del archivo
            //  lee el archivo por linea, almacena caracter por caracter
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            
            //  esta es la linea que puede leer el archivo
            String lectura = entrada.readLine();
            
            while(lectura != null) {
                System.out.println("lectura = " + lectura);
                lectura = entrada.readLine();
            }
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
