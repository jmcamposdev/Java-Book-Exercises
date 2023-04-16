package unit11.Actividad27_Ampliacion;

import java.util.Comparator;

public class OrdenarDeportistaPorNombre implements Comparator<Deportista> {
    @Override
    public int compare(Deportista o1, Deportista o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
