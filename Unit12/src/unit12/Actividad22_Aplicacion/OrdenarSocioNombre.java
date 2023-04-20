package unit12.Actividad22_Aplicacion;
import unit12.Actividad11.Socio;

import java.util.Comparator;

public class OrdenarSocioNombre implements Comparator<Socio> {

    @Override
    public int compare(Socio o1, Socio o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
