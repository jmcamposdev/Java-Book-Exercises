package unit12.Actividad09;

import Functions.GetData;

import java.util.ArrayList;

/*
    Crear una lista de números enteros positivos introducidos por consola has que se
    introduce un número negativo. A continuación recorrer la lista y mostrar por pantalla
    los índices de los elementos de valor par que serán multiplicados por 100.
 */
public class Actividad9 {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        int userNumber;
        System.out.println("Para salir ingresa un número negativo");
        boolean salida;
        do {
            userNumber = GetData.getInt("Ingrese un número: ");
            salida = userNumber < 0;
            if (!salida) {
                lista.add(userNumber);
            }
        } while (!salida);
        System.out.println("Lista sin modificar: " +  lista);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) % 2 == 0) {
                System.out.println("Indice: "+i);
                lista.set(i,lista.get(i)*100);
            }
        }
        System.out.println("Lista modificada: " + lista);

    }
}
