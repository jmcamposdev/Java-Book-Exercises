package unit9.Actividad14_15_Aplicacion;

public class Futbolista implements Comparable<Futbolista>{
    private String dni;
    private String nombre;
    private int edad;
    private int goles;

    public Futbolista(String dni, String nombre, int edad, int goles) {
        if (dni.isBlank()) {
            throw new IllegalArgumentException("El dni no puede estar vacío");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (goles < 0) {
            throw new IllegalArgumentException("Los goles no pueden ser negativos");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.goles = goles;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getGoles() {
        return goles;
    }

    @Override
    public String toString() {
        return dni + " | Nombre: " + nombre + " | Edad: " + edad + " | Goles: " + goles;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Futbolista) {
            Futbolista f = (Futbolista) obj;
            return this.dni.equals(f.dni);
        }
        return false;
    }

    @Override
    public int compareTo(Futbolista o) {
        return this.dni.compareTo(o.dni);
    }
}
