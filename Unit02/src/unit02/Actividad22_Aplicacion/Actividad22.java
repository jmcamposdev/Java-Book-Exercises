package unit02.Actividad22_Aplicacion;

import java.util.Scanner;

/*
    Modifica la Actividad 21 para que aparezca la operación que debe de realizar el usuario (suma,resta, multiplicación).
 */
public class Actividad22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Operación 1 = Suma, 2 = Resta, 3 = Multiplicación
        int numero1, numero2, resultado = 0, usuarioCalculo, operacion;
        
        // Generamos los números aleatorios
        numero1 = (int) (Math.random() * 99 + 1);
        numero2 = (int) (Math.random() * 99 + 1);
        operacion = (int) (Math.random() * 3 + 1);
        
        // Mostramos la pregunta
        switch (operacion) {
            case 1 -> System.out.println("¿Cuánto es " + numero1 + " + " + numero2 + "?");
            case 2 -> System.out.println("¿Cuánto es " + numero1 + " - " + numero2 + "?");
            case 3 -> System.out.println("¿Cuánto es " + numero1 + " * " + numero2 + "?");
        }
        usuarioCalculo = sc.nextInt();
        
        // Calculamos la suma
        switch (operacion) {
            case 1 -> resultado = numero1 + numero2;
            case 2 -> resultado = numero1 - numero2;
            case 3 -> resultado = numero1 * numero2;
        }
        
        // Comprobamos si el resultado es correcto
        if (usuarioCalculo == resultado) {
            System.out.println("¡Correcto!");
        } else {
            System.out.println("¡Incorrecto!");
        }
        
        
        
        
    }
}
