package unit07.Actividad01_05;

/*
    7.5

    Existen gestores que administran las cuentas bancarias y atienden a sus propiedades

    Cada cuenta en caso de tenerlo, cuenta con un único gestor. Diseñar la clase Gestor de
    la que interesa guardar su nombre, teléfono y el importe máximo autorizado con el que pueden operar.
    Con respecto a los gestores, existen las siguientes restricciones:
    - Un gestor tendrá siempre un nombre y un teléfono
    - Si no se asigna, el importe máximo autorizado será de 10000 euros
    - Un gestor una vez asignado, no podrá cambiar su número de teléfono. Y se podrá consultar.

    El nombre será público y el importe máximo solo será visible por las clases vecinas.

    Modifica la clase CuentaCorriente para que pueda disponer de un objeto Gestor. Escribir los
    métodos necesarios
 */

public class Gestor {
    public String nombre;
    private int telefono;
    double importeMaximoAutorizado;

    public int getTelefono() {
        return telefono;
    }

    public Gestor(String nombre, int telefono, double importeMaximoAutorizado ){
        this.nombre = nombre;
        this.telefono = telefono;
        this.importeMaximoAutorizado = importeMaximoAutorizado;
    }
    public Gestor(String nombre, int telefono){
        this(nombre,telefono,10000);
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Telefono: "+this.telefono);
        System.out.println("Importe Máximo: "+this.importeMaximoAutorizado);
    }
}
