package unit07.Actividad10.Personal;

public class Menanico {
    String nombre;
    String telefono;
    enum Especialidad {FRENOS, HIDRAULICA, ELECTRICIDAD, MOTOR};
    Especialidad especialidad;

    public Menanico(String nombre, String telefono, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.especialidad = Especialidad.valueOf(especialidad);
    }
}
