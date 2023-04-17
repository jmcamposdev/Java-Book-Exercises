package unit12.Actividad03;

import Functions.GetData;

/*
    Definir la interfaz Pila con parámetros genéricos.
    A continuación, implementar la interfaz Pila genérica en la clase Contenedor.
    Por último, escribir un programa donde se utilice un objeto contenedor como pila.
    En ella apilamos números enteros positivos leídos del teclado hasta que se introduzca un -1.
    Después, mediante un bucle, se desapilan todos los números hasta que la pila esté vacía y los mostramos por consola.
 */
public class Actividad3 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Contenedor<>(new Integer[0]);
        int numero;
        do {
            numero = GetData.getInt("Introduce un número entero positivo: ", -1, Integer.MAX_VALUE);
            if (numero != -1) {
                pila.apilar(numero);
            }
        } while (numero != -1);

        System.out.println("Desapilando números: ");
        Integer n = pila.desapilar();
        while (n != null) {
            System.out.println(n);
            n = pila.desapilar();
        }
    }
}
