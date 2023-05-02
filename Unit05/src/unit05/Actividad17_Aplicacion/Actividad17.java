package unit05.Actividad17_Aplicacion;

import java.util.Scanner;

/*
    Debes desarrollar una aplicación que ayude a gestionar las notas de un centro educativo.
    Los alumnos se organizan en grupos compuestos por 5 personas.
    Leer las notas (números enteros) del primer, segundo y tercer trimestre de un grupo.
    Debes mostrar al final la nota media del grupo en cada trimestre y
    la media del alumno que se encuentra en una posición dada (que el usuario introduce por teclado).
 */
public class Actividad17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] notas = new int[5][3];

        // Leer las notas de los alumnos
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Alumno " + (i + 1));
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print("Nota trimestre " + (j + 1) + ": ");
                notas[i][j] = sc.nextInt();
            }
        }
        // Mostramos la tabla
        System.out.println("Notas de los alumnos");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Alumno " + (i + 1) + ": ");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.print(notas[i][j] + " ");
            }
            System.out.println();
        }

        // Mostrar las notas de los alumnos
        System.out.println("Notas Media de los Trimestres");
        for (int i = 0; i < notas[0].length; i++) {
            int media = 0;
            System.out.println("Trimestre " + (i + 1) + ":");
            for (int[] nota : notas) {
                media += nota[i];
            }
            System.out.println("Media: " + (media / notas[i].length));
        }

        // Mostrar la media de un alumno
        System.out.print("Introduce el número de alumno: ");
        int alumno = sc.nextInt();

        int media = 0;
        for (int i = 0; i < notas[alumno - 1].length; i++) {
            media += notas[alumno - 1][i];
        }
        System.out.println("Media del alumno " + alumno + ": " + (media / notas[alumno - 1].length));
    }
}
