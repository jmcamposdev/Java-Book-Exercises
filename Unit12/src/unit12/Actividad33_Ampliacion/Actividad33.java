package unit12.Actividad33_Ampliacion;

import Functions.GetData;

import java.util.ArrayList;
import java.util.List;

/*
    Implementa la función leeCadena (), con el siguiente prototipo:
        List<Character> leeCadena () ,
    Que lee una cadena por teclado y nos la devuelve en una lista con un carácter en cada elemento.
 */
public class Actividad33 {
    public static void main(String[] args) {
        ArrayList<Character> lista = new ArrayList<>(leeCadena());
        System.out.println(lista);
    }

    public static List<Character> leeCadena () {
        String cadena = GetData.getString("Introduce una cadena: ");
        ArrayList<Character> lista = new ArrayList<>();
        for (int i = 0; i < cadena.length(); i++) {
            lista.add(cadena.charAt(i));
        }
        return lista;
    }

}
