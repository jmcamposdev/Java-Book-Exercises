package unit9.Actividad14_15_Aplicacion;

import java.util.Comparator;

public class OrdenarEdadNombre implements Comparator<Futbolista> {
    @Override
    public int compare(Futbolista o1, Futbolista o2) {
        int resultado = o1.getEdad() - o2.getEdad();
        if (resultado == 0) {
            resultado = o1.getNombre().compareTo(o2.getNombre());
        }
        return resultado;
    }
}
