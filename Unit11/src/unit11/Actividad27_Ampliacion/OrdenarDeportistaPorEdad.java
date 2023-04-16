package unit11.Actividad27_Ampliacion;

import java.util.Comparator;

public class OrdenarDeportistaPorEdad implements Comparator<Deportista> {
    @Override
    public int compare(Deportista o1, Deportista o2) {
        return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
    }
}
