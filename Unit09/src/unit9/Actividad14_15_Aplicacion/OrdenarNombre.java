package unit9.Actividad14_15_Aplicacion;

import java.util.Comparator;

public class OrdenarNombre implements Comparator<Futbolista> {
    public int compare(Futbolista f1, Futbolista f2) {
        return f1.getNombre().compareTo(f2.getNombre());
    }
}
