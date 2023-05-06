package unit9.Actividad20_24_Aplicacion;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
