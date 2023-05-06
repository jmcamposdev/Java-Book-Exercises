package unit9.Actividad20_24_Aplicacion;

import java.util.Comparator;


public class OrdenarPorNombreInvertido implements Comparator<Socio> {
    @Override
    public int compare(Socio o1, Socio o2) {
        return new OrdenarPorNombre().reversed().compare(o1, o2);
    }
}
