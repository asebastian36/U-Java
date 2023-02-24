package mx.com.manejointerfaces;

public class Test {
    public static void main(String[] args) {
        //  podemos crear variables de tipo interfaces
        //  utilizando una implementacion de la interfaz
        
        //  aplicacion de upcasting
        IAccesoDatos datos = new ImplementacionMySql(); 
        
        //  aplicacion de polimorfismo
        imprimir(datos);
        
        datos = new ImplementacionOracle();
        imprimir(datos);
    }
    
    public static void imprimir(IAccesoDatos datos) {
        datos.listar();        
    }
}
