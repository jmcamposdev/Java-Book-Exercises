package unit12.Actividad11;

import java.util.Comparator;

public class OrdenarSocioAntiguedad implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return o2.antiguedad() - o1.antiguedad();
    }
}
