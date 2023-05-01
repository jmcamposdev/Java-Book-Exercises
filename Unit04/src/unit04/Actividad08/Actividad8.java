package unit04.Actividad08;

/*
    Diseñar la función calculadora(), a la que se le pasan dos números reales y qué operación se desea
    realizar con ellos. Las operaciones disponibles son: 1) Suma, 2) Resta, 3) Multiplicación y 4) División.
    La función devolverá el resultado de la operación.
 */
public class Actividad8 {
    public static void main(String[] args) {
        System.out.println("Suma de 2 y 3: " + calculadora(2, 3, 1));
        System.out.println("Resta de 2 y 3: " + calculadora(2, 3, 2));
        System.out.println("Multiplicación de 2 y 3: " + calculadora(2, 3, 3));
        System.out.printf("División de 2 y 3: %.2f\n", calculadora(2, 3, 4));

    }

    private static double calculadora(int num1, int num2, int operator) {
        return switch (operator) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> {
                double result;
                if (num2 == 0) {
                    System.out.println("No se puede dividir entre 0");
                    result = 0;
                } else {
                    result = (double) num1 / num2;
                }
                yield result;
            }
            default -> 0;
        };
    }
}
