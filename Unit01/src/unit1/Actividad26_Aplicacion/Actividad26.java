package unit1.Actividad26_Aplicacion;

import java.util.Scanner;

/*
    La FILA (Federación Internacional de Lanzamiento de Algoritmo) realiza una competición
    donde cada participante escribe un algoritmo en un papel y lo lanza, ganando quien consiga lanzarlo más lejos.
    La peculiaridad del concurso es que la longitud del lanzamiento se mide en metros (con tantos decimales como se desee),
    pero para el ranking solo se tiene en cuenta la longitud en centímetros (sin decimales).
    Por ejemplo, para un lanzamiento de 12,3456 m (que son 1234,56 cm) únicamente se contabilizarán 1234 cm.

    Realiza un programa que solicite la longitud (en metros) de un lanzamiento y muestre la parte entera correspondiente en centímetros.
 */
public class Actividad26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double metros;
        int centimetros;

        // Pedimos la longitud del lanzamiento
        System.out.print("Introduce la longitud del lanzamiento: ");
        metros = sc.nextDouble();

        // Calculamos la longitud en centímetros
        centimetros = (int) (metros * 100);

        // Mostramos el resultado
        System.out.println("La longitud del lanzamiento es " + centimetros + "cm");
    }
}
