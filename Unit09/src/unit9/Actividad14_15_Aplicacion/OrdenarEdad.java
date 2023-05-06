package unit9.Actividad14_15_Aplicacion;

import java.util.Comparator;

public class OrdenarEdad implements Comparator<Futbolista> {
    public int compare(Futbolista f1, Futbolista f2) {
        return f1.getEdad() - f2.getEdad();
    }
}
