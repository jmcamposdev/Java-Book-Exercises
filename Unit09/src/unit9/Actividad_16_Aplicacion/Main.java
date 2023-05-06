package unit9.Actividad_16_Aplicacion;

import java.util.Scanner;

/*
    Implementa la clase SuperCola, que tiene como atributos dos colas para enteros, en las que se encolan y desencolan
    por separado. Sin embargo si una de las colas queda vacía, al llaamar a su método desencolar, de desencola de la otra
    mientras tenga elementos. Solo cuando las dos colas estén vacías, cualquier llamada a desencolar devolverá null.
    Escribir un programa con el menú:
    1. Encolar en cola1.
    2. Encolar en cola2.
    3. Desencolar de cola1.
    4. Desencolar de cola2.
    5. Salir.

    Después de cada operación se mostrará el estado de la dos colas para seguir su evolución.
 */
public class Main {
    // Variables del Switch
    private static final int OPCION_ENCOLAR1 = 1;
    private static final int OPCION_ENCOLAR2 = 2;
    private static final int OPCION_DESENCOLAR1 = 3;
    private static final int OPCION_DESENCOLAR2 = 4;
    private static final int OPCION_SALIR = 5;
    public static void main(String[] args) {
        SuperCola superCola = new SuperCola(); // Creamos la supercola
        boolean salir = false; // Variable para salir del bucle
        int opcion; // Variable para guardar la opción del usuario

        while (!salir) { // Mientras no queramos salir
            mostrarMenu(); // Mostramos el menú
            opcion = getInt("Introduce una opción: ", 1, 5); // Pedimos una opción al usuario

            switch (opcion) { // Según la opción
                case OPCION_ENCOLAR1 -> {
                    int numero = getInt("Introduce un número: "); // Pedimos un número al usuario
                    superCola.encolar1(numero);  // Encolamos el número en la cola1
                    System.out.println(superCola); // Mostramos la supercola
                }
                case OPCION_ENCOLAR2 -> {
                    int numero = getInt("Introduce un número: "); // Pedimos un número al usuario
                    superCola.encolar2(numero); // Encolamos el número en la cola2
                    System.out.println(superCola); // Mostramos la supercola
                }
                case OPCION_DESENCOLAR1 -> {
                    Integer numero = superCola.desencolar1(); // Desencolamos de la cola1 si no de la cola2
                    if (numero == null) { // Si esta vacía la cola1 y la cola2
                        System.out.println("Cola1 y Cola2 vacías"); // Mostramos que están vacías
                    } else { // Si no
                        System.out.println("Número desencolado: " + numero); // Mostramos el número desencolado
                    }
                    System.out.println(superCola); // Mostramos la supercola
                }
                case OPCION_DESENCOLAR2 -> { // Desencolamos de la cola2 si no de la cola1
                    Integer numero = superCola.desencolar2(); // Desencolamos de la cola2 si no de la cola1
                    if (numero == null) { // Si esta vacía la cola2 y la cola1
                        System.out.println("Cola2 y Cola1 vacía"); // Mostramos que están vacías
                    } else { // Si no
                        System.out.println("Número desencolado: " + numero); // Mostramos el número desencolado
                    }
                    System.out.println(superCola); // Mostramos la supercola
                }
                case OPCION_SALIR -> salir = true; // Salimos del bucle
            }
        }



    }


    public static void mostrarMenu() {
        System.out.println("""
                1. Encolar en cola1.
                2. Encolar en cola2.
                3. Desencolar de cola1.
                4. Desencolar de cola2.
                5. Salir.
                """);
    }

    // Obtener un número entero del usuario
    public static int getInt(String mensaje, int minimo, int maximo) {
        int numero;
        do {
            numero = getInt(mensaje);
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    public static int getInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }
}
