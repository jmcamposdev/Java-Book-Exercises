package unit04.Actividad17_Aplicacion;

/*
    Diseña una función a la que se le pasan las horas y minutos de dos instantes de tiempo
    y devuelve el número de minutos que hay de diferencia entre ambos instantes.
 */
public class Actividad17 {
    public static void main(String[] args) {
        System.out.println(calcularDiferencia(0, 1, 1, 0));
        System.out.println(calcularDiferencia(2, 2, 2, 2));
    }

    public static int calcularDiferencia(int horas1, int minutos1, int horas2, int minutos2) {
        // Convertimos las horas a minutos y sumamos los minutos luego restamos los minutos de ambos instantes
        return Math.abs((horas1 * 60) + minutos1 - ((horas2 * 60) + minutos2));
    }
}
