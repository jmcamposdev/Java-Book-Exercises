package unit04.Actividad16_Aplicacion;

/*
    Escribe una función a la que se pase como parámetro de entrada una cantidad de días, horas y minutos.
    La función calculará y mostrará por pantalla el número total de segundos que representan los días, horas y minutos.
 */
public class Actividad16 {
    public static void main(String[] args) {
        System.out.println(calcularSegundos(0, 1, 1));
        System.out.println(calcularSegundos(2, 2, 2));
        System.out.println(calcularSegundos(3, 3, 3));
    }

    public static int calcularSegundos(int dias, int horas, int minutos) {
        return (dias * 24 * 60 * 60) +
                (horas * 60 * 60) +
                (minutos * 60);
    }
}
