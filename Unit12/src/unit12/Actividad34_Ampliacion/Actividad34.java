package unit12.Actividad34_Ampliacion;

import java.util.ArrayList;
import java.util.List;

import static unit12.Actividad33_Ampliacion.Actividad33.leeCadena;

/*
    Implementa la función uneCadenas, con el siguiente prototipo
        List <Character > uneCadenas (List<Character > cad1, List<Character >
    cada que devuelve una lista con la concatenación de cad1 y cad2.
 */
public class Actividad34 {
    public static void main(String[] args) {
        ArrayList<Character> lista1 = new ArrayList<>(leeCadena());
        ArrayList<Character> lista2 = new ArrayList<>(leeCadena());
        System.out.println(uneCadenas(lista1, lista2));
    }

    public static List<Character> uneCadenas (List<Character> cad1, List<Character> cad2) {
        List<Character> lista = new ArrayList<>(cad1);
        lista.addAll(cad2);
        return lista;
    }
}
