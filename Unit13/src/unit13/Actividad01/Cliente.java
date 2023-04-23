package unit13.Actividad01;

public class Cliente {
    private final String nombre;
    private int edad;
    public Cliente(String nombre) {
        this.nombre = nombre;
    }
    public Cliente (String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
}

