package unit13.Actividad02;

import unit13.Actividad01.Cliente;
import unit13.Actividad01.Saludo;

import java.util.ArrayList;
import java.util.List;

/*
    Utilizando la interfaz Saludo de la Actividad 1, implementar un método estático que aplique
    un saludo a un grupo de personas que se le pasa como parámetro en una table. Devolverá
    los saludos en una lista de cadenas
 */
public class Actividad02 {
    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente("Paco"),
                new Cliente("Alvaro"),
                new Cliente("Sofia"),
                new Cliente("Calor"),
                new Cliente("Adrian")
        };
        ArrayList<String> saludos = (ArrayList<String>) saludarGrupo(clientes, c -> "Hola " + c.getNombre());
        for (String saludo : saludos) {
            System.out.println(saludo);
        }
    }

    static <T> List<String> saludarGrupo (T[] grupo, Saludo<T> saludo) {
        ArrayList<String> saludos = new ArrayList<>();
        for (T e : grupo) {
            saludos.add(saludo.saludar(e));
        }
        return saludos;
    }
}
