package unit12.Actividad28_Aplicacion;

import Functions.GetData;

import java.util.HashSet;
import java.util.Set;

/*
    Introduce por teclado, hasta que se introduzca «fin», una serie de nombres,
    que se insertarán en una colección,
    de forma que se conserve el orden de inserción y que no puedan repetirse.
    Al final, la colección se mostrará por pantalla.
 */
public class Actividad28 {
    public static void main(String[] args) {
        Set<String> nombres = new HashSet<>();
        String nombre;
        do {
            nombre = GetData.getString("Introduce un nombre: ");
            if (!nombre.equals("fin")) {
                nombres.add(nombre);
            }
        } while (!nombre.equals("fin"));

        System.out.println(nombres);
    }
}
