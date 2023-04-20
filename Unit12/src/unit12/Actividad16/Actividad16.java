package unit12.Actividad16;

import java.util.*;

/*
    Los miembros de la Real Academia de la Lengua ocupan sillones con las letras del abecedario español,
    minúsculas y mayúsculas (en la práctica, las letras v, w, x, y, z, N, W, Y nunca se ocupan,
    pero nosotros no lo tendremos en cuenta).
    Cuando un sillón queda vacante, se nombra un nuevo académico para ocuparlo.
    Implementar la clase Academico, cuyos atributos son el nombre y el año de ingreso.
    El criterio de ordenación natural será por nombres.
    Implementar un programa donde se crean cinco objetos Academico,
    que se insertan en un mapa en el que la clave es la letra del sillón que ocupan,
    y el valor un objeto de la clase Academico.
    Para ello implementar el método estático:
        static boolean nuevoAcademico (Map Character, Academico> academia, Academico nuevo, Character letra),
    donde se lleva a cabo la inserción después de comprobar que el carácter pasado como parámetro es una letra del abecedario.
    Hacer diversos listados de los académicos:
    1. Sin letra
    2. Orden de nombre
    3. Año de ingreso
    y después con letra, por orden de letra (clave), nombre y fecha de ingreso.
    Debemos recordar que, en código Unicode, las mayúsculas van antes que las minúsculas.
 */
public class Actividad16 {
    public static void main(String[] args) {
        Map<Character, Academico> academia = new TreeMap<>();
        for (int i = 0; i < 5; i++) {
            // Crear un caracter aleatorio del abecedario tanto en minúsculas como en mayúsculas
            Character letra = (char) (Math.random() * 26 + (Math.random() < 0.5 ? 'a' : 'A'));
            Academico nuevo = new Academico("Académico " + letra, (int) (Math.random() * 100 + 1900));
            nuevoAcademico(academia, nuevo, letra);
        }

        System.out.println("Orden por letra:" + academia);

        Collection<Academico> sinLetra = academia.values();
        List<Academico> listaSinLetra = new ArrayList<>(sinLetra);
        Collections.sort(listaSinLetra);
        System.out.println("Orden por nombre:" + listaSinLetra);

        Collections.sort(listaSinLetra, new Comparator<Academico>() {
            @Override
            public int compare(Academico o1, Academico o2) {
                return o1.ingreso - o2.ingreso;
            }
        });
        System.out.println("Orden por año de ingreso:" + listaSinLetra);

        Set<Map.Entry<Character, Academico>> conLetra = academia.entrySet();
        List<Map.Entry<Character, Academico>> listaConLetra = new ArrayList<>(conLetra);
        //Ordenamos por año de ingreso
        Collections.sort(listaConLetra, new Comparator<Map.Entry<Character, Academico>>() {
            @Override
            public int compare(Map.Entry<Character, Academico> o1, Map.Entry<Character, Academico> o2) {
                return o1.getValue().ingreso - o2.getValue().ingreso;
            }
        });
        System.out.println("Orden por año de ingreso con letra:" + listaConLetra);
        //Ordenamos por nombre
        Collections.sort(listaConLetra, new Comparator<Map.Entry<Character, Academico>>() {
            @Override
            public int compare(Map.Entry<Character, Academico> o1, Map.Entry<Character, Academico> o2) {
                return o1.getValue().nombre.compareTo(o2.getValue().nombre);
            }
        });
        System.out.println("Orden por nombre con letra:" + listaConLetra);

    }

    public static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
        boolean insertado = false;
        if ((letra >= 'A' && letra <= 'Z') ||
                (letra >= 'a' && letra <= 'z') || (letra == 'ñ' || letra == 'Ñ')) {
            academia.put(letra, nuevo);
            insertado = true;
        } else {
            System.out.println("El carácter no es una letra del abecedario.");
        }
        return insertado;
    }
}
