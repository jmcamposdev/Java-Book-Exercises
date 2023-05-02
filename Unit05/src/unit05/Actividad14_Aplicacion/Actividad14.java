package unit05.Actividad14_Aplicacion;

/*
    Escribe la función void desordenar (int t []), que cambia de forma aleatoria los elementos contenidos en la tabla t.
    Si la tabla estuviera ordenada, dejaría de estarlo.
 */

public class Actividad14 {
    public static void main(String[] args) {
        int[] array = {12,3,4,5,55,6,5,2};
        System.out.println("El array es: "+ java.util.Arrays.toString(array));
        System.out.println("Desordenamos el array");
        desordenar(array);
        System.out.println("El nuevo array es: "+ java.util.Arrays.toString(array));

    }

    private static void desordenar(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indiceAleatorio = (int) (Math.random()*array.length);
            int aux = array[i];
            array[i] = array[indiceAleatorio];
            array[indiceAleatorio] = aux;
        }
    }
}
