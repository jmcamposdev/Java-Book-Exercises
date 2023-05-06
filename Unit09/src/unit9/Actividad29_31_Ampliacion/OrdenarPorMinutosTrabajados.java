package unit9.Actividad29_31_Ampliacion;

import java.util.Comparator;

public class OrdenarPorMinutosTrabajados implements Comparator<Jornada> {
    @Override
    public int compare(Jornada o1, Jornada o2) {
        return o1.numeroMinutosTrabajados() - o2.numeroMinutosTrabajados();
    }
}
