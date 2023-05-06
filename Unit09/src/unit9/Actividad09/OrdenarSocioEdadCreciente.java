package unit9.Actividad09;

import unit9.Actividad07_08.Socio;

import java.util.Comparator;

public class OrdenarSocioEdadCreciente implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return o1.edad() - o2.edad();
    }
}
