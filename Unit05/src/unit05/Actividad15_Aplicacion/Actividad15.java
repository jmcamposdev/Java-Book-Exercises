package unit05.Actividad15_Aplicacion;

/*
    Modifica la Actividad de aplicación 14 para que la función no modifique la tabla que se pasa como parámetro y,
    en su lugar, cree y devuelva una copia de la tabla donde se han desordenado los valores de los elementos.
 */
public class Actividad15 {
    public static void main(String[] args) {
        int[] array = {12,3,4,5,55,6,5,2};
        System.out.println("El array es: "+ java.util.Arrays.toString(array));
        System.out.println("Desordenamos el array");
        System.out.println("El nuevo array es: "+ java.util.Arrays.toString(desordenar(array)));
    }

    public static int[] desordenar(int[] array) {
        int[] nuevoArray = array.clone();
        for (int i = 0; i < nuevoArray.length; i++) {
            int indiceAleatorio = (int) (Math.random()*nuevoArray.length);
            int aux = nuevoArray[i];
            nuevoArray[i] = nuevoArray[indiceAleatorio];
            nuevoArray[indiceAleatorio] = aux;
        }
        return nuevoArray;
    }
}
