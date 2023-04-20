package unit12.Actividad13;

/*
    Implementar la clase Sorteo con parámetros genéricos. Deberá guardar un conjunto de valores distintos de tipo genérico
    suministrados por consola y será capaz de generar una combinación premiada de un tamaño determinado. Deberá implementarse como mínimo
    los métodos.
    boolean add (T elemento): Que añadirá un elemento nuevo al conjunto de valores posibles en una apuesta. Si el elemento se añde
    devuelve true y en caso contrario debido a que ya estaba presente, false.

    Set<T> premiados (int numPremiados): Que devolverá una combinación ganadora de numPremiados elementos distintos.
 */
public class Actividad13 {
    public static void main(String[] args) {
        Sorteo<Integer> s = new Sorteo<>();
        for (int i = 0; i < 100; i++) {
            s.add(i);
        }
        System.out.println(s);
        System.out.println("Premiados: " + s.premiados(20));
    }
}
