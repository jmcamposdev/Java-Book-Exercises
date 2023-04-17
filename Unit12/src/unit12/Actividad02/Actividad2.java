package unit12.Actividad02;

/*
    Implementar con tipos genéricos la clase Contenedor, donde podremos guardar tantos
    objetos como deseemos. Para ello utilizaremos una tabla que inicialmente tendrá tamaño
    cero y se irá redimensionando segun añadamos o eliminemos elementos. La clase además
    del constructor y toString() tendrá los siguientes métodos:
    - void insertarAlPrincipio(T nuevo): inserta un nuevo elemento al principio de la tabla.
    - void insertarAlFinal(T nuevo): inserta un nuevo elemento al final de la tabla.
    - T extraerDelPrincipio(): extrae el primer elemento de la tabla.
    - T extraerDelFinal(): extrae el último elemento de la tabla.
    - void ordenar(): ordena los elementos de la tabla.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Contenedor<Integer> contenedor = new Contenedor<>(new Integer[0]);
        for (int i = 0; i < 20; i++) {
            contenedor.insertarAlPrincipio(i);
        }
        System.out.println("Sin ordenar: " + contenedor);
        contenedor.insertarAlFinal(100);
        System.out.println("Insertado al final: " + contenedor);
        contenedor.ordenar();
        System.out.println("Ordenado: " + contenedor);
        Integer extraido = contenedor.extraerDelPrincipio();
        Integer extraidoFinal = contenedor.extraerDelFinal();
        System.out.println("Extraido del principio: " + extraido);
        System.out.println("Extraido del final: " + extraidoFinal);
        System.out.println("Contenedor: " + contenedor);

    }
}
