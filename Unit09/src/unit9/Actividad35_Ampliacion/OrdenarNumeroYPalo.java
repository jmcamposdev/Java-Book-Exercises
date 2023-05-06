package unit9.Actividad35_Ampliacion;

public class OrdenarNumeroYPalo implements java.util.Comparator<Carta>{

    @Override
    public int compare(Carta o1, Carta o2) {
        int resultado = o1.getPalo().compareTo(o2.getPalo());
        if (resultado == 0) {
            resultado = Integer.compare(o1.getNumero(), o2.getNumero());
        }
        return resultado;
    }
}
