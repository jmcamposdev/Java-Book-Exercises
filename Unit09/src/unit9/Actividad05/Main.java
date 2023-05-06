package unit9.Actividad05;

import unit9.Actividad01.Cola;
import unit9.Actividad04.Lista;

import java.util.Scanner;

/*
    Implementar un programa en el que usando una Cola anónima, se encolan números enteros hasta que se
    introduzca uno negativo. A continuación,  desencolar todos a medida que se muestran por pantalla
 */
public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola() {
            Lista lista = new Lista();
            @Override
            public void encolar(Integer num) {
                lista.addFinal(num);
            }

            @Override
            public Integer desencolar() {
                return lista.removeInteger(0);
            }

            public int numeroElementos() {
                return lista.numeroElementos();
            }
        };
        Scanner sc = new Scanner(System.in);
        int num;

        // Pedimos los numeros por teclado hasta que se introduzca uno negativo
        do {
            System.out.print("Introduce un numero entero: ");
            num = sc.nextInt();
            if (num >= 0){
                cola.encolar(num);
            }
        } while (num >= 0);

        // Desencolamos y mostramos los numeros por pantalla
        System.out.println("Los numeros introducidos son:");
        Integer n = cola.desencolar();
        while (n != null){
            System.out.println(n);
            n = cola.desencolar();
        }

    }
}
