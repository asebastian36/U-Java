package mx.com.modificadoracceso.privado;

//  No se puede aplicar el modificador private a clases
class Clase1 {
    //  al ser un atributo privado ya no se puede modificar desde otras clases
    //  ya sea una clase hija o que este en el mismo paquete no podra modificar
    //  el atributo directamente
    private String atributoPrivado = "Valor atributo privado";
    
    //  no podremos crear objetos con el constructor 
    //  (en este caso el constructor vacio)
    private Clase1() {
        System.out.println("Constructor privado");
    }
    
    public Clase1(String arg) {
        this();
        System.out.println("Constructor publico");
        this.metodoPrivate();
    }
    
    //  no podemos acceder al metodo privado desde otras clases
    //  solo desde un metodo publico o desde el constructor de la clase
    private void metodoPrivate() {
        System.out.println("Metodo privado");
    }

    public String getAtributoPrivado() {
        return this.atributoPrivado;
    }

    public void setAtributoPrivado(String atributoPrivado) {
        this.atributoPrivado = atributoPrivado;
    }
    
    
}
