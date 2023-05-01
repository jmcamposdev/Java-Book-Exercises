package unit03.Actividad02;

import java.util.Scanner;

/*
    Implementar una aplicación para calcular datos estadísticos de las edades de los alumnos de un centro educativo.
    Se introducirán por teclado las edades de los alumnos hasta que se introduzca un valor negativo. Y se mostrará
    la suma de todas las edades, la media, el número de alumnos y cuántos de ellos son mayores de edad.
 */
public class Actividad2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumaEdades = 0, numAlumnos = 0, numMayoresEdad = 0, edad, mediaEdades;
        boolean isMayorEdad;

        // Pedimos la edad
        System.out.print("Introduce la edad: ");
        edad = sc.nextInt();

        // Mientras la edad sea mayor que 0
        while (edad >= 0) {
            // Sumamos la edad a la suma de edades
            sumaEdades += edad;

            // Comprobamos si es mayor de edad
            isMayorEdad = edad >= 18;

            // Si es mayor de edad, sumamos 1 al número de mayores de edad
            if (isMayorEdad) {
                numMayoresEdad++;
            }

            // Sumamos 1 al número de alumnos
            numAlumnos++;

            // Pedimos la edad
            System.out.print("Introduce la edad: ");
            edad = sc.nextInt();
        }

        // Calculamos la media de edades
        mediaEdades = sumaEdades / numAlumnos;

        // Mostramos los resultados
        System.out.println("La suma de las edades es " + sumaEdades);
        System.out.println("La media de las edades es " + mediaEdades);
        System.out.println("El número de alumnos es " + numAlumnos);
        System.out.println("El número de alumnos mayores de edad es " + numMayoresEdad);
    }
}
