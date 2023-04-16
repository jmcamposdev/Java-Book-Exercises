package unit11.Actividad28_Ampliacion;

import java.util.Comparator;

public class OrdenarSocioPorNombre implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
