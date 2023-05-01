package unit03.Actividad10;

/*
    Diseñar un programa que muestre la suma de los 10 primeros números impares.
 */
public class Actividad10 {
    public static void main(String[] args) {
        int suma = 0;
        // Sumamos los 10 primeros números impares
        for (int i = 1; i <= 10 ; i++) {
            suma += (i * 2) - 1;
        }

        // Mostramos el resultado
        System.out.println("La suma de los 10 primeros números impares es: " + suma);
    }
}
