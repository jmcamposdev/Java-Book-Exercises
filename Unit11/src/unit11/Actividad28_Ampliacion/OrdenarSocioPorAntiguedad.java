package unit11.Actividad28_Ampliacion;

import java.util.Comparator;

public class OrdenarSocioPorAntiguedad implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return o1.getFechaAlta().compareTo(o2.getFechaAlta());
    }
}
