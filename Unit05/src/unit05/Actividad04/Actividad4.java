package unit05.Actividad04;

/*
    Diseñar una función que nos devuelva el valor mayor de un array.
 */
public class Actividad4 {
    public static void main(String[] args) {
        int[] listado = {1,5,15,8,9,10,6};

        System.out.println("El valor mayor es: "+valorMayorArray(listado));

    }
    public static int valorMayorArray (int[] listado){
        int aux = 0;
        for (int valor: listado) {
            if (valor > aux){
                aux = valor;
            }
        }
        return aux;
    }
}
