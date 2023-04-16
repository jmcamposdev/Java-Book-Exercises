package unit11.Actividad08;

import java.io.Serializable;

public class Socio implements Serializable {
    private String nombre;
    private String dni;

    public Socio(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
