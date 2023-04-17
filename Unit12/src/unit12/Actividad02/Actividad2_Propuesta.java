package unit12.Actividad02;

import Functions.GetData;

/*
    Define la interfaz cola con parámetros genéricos.
    A continuación, implementa la interfaz Cola genérica en la clase Contenedor
    (no hace falta suprimir la implementación de Pila de la Actividad resuelta 12.3).
    Por último, escribe un programa donde se utilice un objeto Contenedor como cola.
    En ella encolamos números enteros positivos leídos del teclado hasta que se introduzca un -1.
    Después, mediante un bucle, se desencolan todos los números hasta que la cola esté vacía y los mostramos por consola.
 */
public class Actividad2_Propuesta {
    public static void main(String[] args) {
        Cola<Integer> cola = new Contenedor<>(new Integer[0]);
        int numero;
        do {
            numero = GetData.getInt("Introduce un número entero positivo: ", -1, Integer.MAX_VALUE);
            if (numero != -1) {
                cola.encolar(numero);
            }
        } while (numero != -1);

        System.out.println("Desencolando números: ");
        Integer n = cola.desencolar();
        while (n != null) {
            System.out.println(n);
            n = cola.desencolar();
        }
    }
}
