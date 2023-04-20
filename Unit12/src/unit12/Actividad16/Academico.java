package unit12.Actividad16;

public class Academico implements Comparable<Academico> {
    String nombre;
    int ingreso;

    public Academico(String nombre, int ingreso) {
        this.nombre = nombre;
        this.ingreso = ingreso;
    }

    @Override
    public int compareTo(Academico o) {
        return nombre.compareTo(o.nombre);
    }

    @Override
    public String toString() {
        return "Academico{" +
                "nombre='" + nombre + '\'' +
                ", ingreso=" + ingreso +
                '}';
    }
}
