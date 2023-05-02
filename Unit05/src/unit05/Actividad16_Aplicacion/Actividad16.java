package unit05.Actividad16_Aplicacion;

import java.util.Scanner;

import static unit05.Actividad09.Actividad9.insercionOrdenada;

/*
    El ayuntamiento de tu localidad te ha encargado una aplicación que ayude a realizar encuestas estadísticas
    para conocer el nivel adquisitivo de los habitantes del municipio.
    Para ello, tendrás que preguntar el sueldo a cada persona encuestada.
    A priori, no conoces el número de encuestados.
    Para finalizar la entrada de datos, introduce un sueldo con valor -1.
    Una vez terminada la entrada de datos, muestra la siguiente información:
        • Todos los sueldos introducidos ordenados de forma decreciente.
        • El sueldo máximo y mínimo.
        • La media de los sueldos.
 */
public class Actividad16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sueldos = new int[0];
        int sueldo;
        boolean salida = false;

        // Entrada de datos
        while (!salida){
            System.out.print("Introduce el sueldo: ");
            sueldo = sc.nextInt();
            if (sueldo == -1) {
                salida = true;
            } else {
                sueldos = insercionOrdenada(sueldos, sueldo);
            }
        }

        // Salida de datos
        System.out.println("Los sueldos ordenados de forma decreciente son: ");
        for (int i = sueldos.length-1; i >= 0; i--) {
            System.out.print(sueldos[i]+" ");
        }

    }

}
