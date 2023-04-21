package unit12.Actividad32_Aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Un centro educativo necesita distribuir de forma aleatoria a los alumnos de un curso entre los grupos disponibles para ese curso.
    Diseña la función:
    List<List<String>> repartoAlumnos (List<String> lista, int numGrupos)
    que devuelve una lista de listas, cada una de las cuales corresponde a un grupo.
    Cada nombre de la lista de alumnos se asigna a uno de los grupos.
 */
public class Actividad32 {
    public static void main(String[] args) {
        ArrayList<String> alumnos = new ArrayList<>();
        alumnos.add("Juan");
        alumnos.add("Pedro");
        alumnos.add("Luis");
        alumnos.add("Ana");
        alumnos.add("María");
        alumnos.add("Sara");
        alumnos.add("Pablo");

        System.out.println(repartoAlumnos(alumnos, 3));

    }

    public static List<List<String>> repartoAlumnos (List<String> lista, int numGrupos) {
        List<List<String>> grupos = new ArrayList<>();
        for (int i = 0; i < numGrupos; i++) {
            grupos.add(new ArrayList<>());
        }
        Collections.shuffle(lista);
        for (int i = 0; i < lista.size(); i++) {
            grupos.get(i % numGrupos).add(lista.get(i));
        }

        return grupos;
    }
}
