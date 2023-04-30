package unit02.Actividad17_Aplicacion;

import java.util.Scanner;

/*
    En una grania se compra diariamente una cantidad (comidaDiaria) de comida para los animales.
    El número de animales que alimentar (todos de la misma especie) es numAninales y sabemos que cada animal come una media de kilos PorAnimal.
    Diseña un programa que solicite al usuario los valores anteriores y determine si dispone mos de alimento suficiente para cada animal.
    En caso negativo, ha de calcular cuál es la ración que corresponde a cada uno de los animales.
    Nota: Evitar que la aplicación realice divisiones por cero.
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAnimales;
        double comidaDiaria, kilosPorAnimal, racion, cantidadRacion;

        // Pedimos los datos
        System.out.print("Introduce el número de animales: ");
        numAnimales = sc.nextInt();

        System.out.print("Introduce la cantidad de comida diaria: ");
        comidaDiaria = sc.nextDouble();

        System.out.print("Introduce los kilos por animal: ");
        kilosPorAnimal = sc.nextDouble();

        if (kilosPorAnimal == 0) {
            System.out.println("No se puede dividir por cero");
        } else {
            racion = comidaDiaria / kilosPorAnimal;
            cantidadRacion = comidaDiaria / numAnimales;

            if (racion >= numAnimales) {
                System.out.println("Hay suficiente comida para todos los animales");
            } else {
                System.out.println("No hay suficiente comida para todos los animales");
                System.out.println("La ración que corresponde a cada animal es: " + cantidadRacion);
            }
        }

    }
}
