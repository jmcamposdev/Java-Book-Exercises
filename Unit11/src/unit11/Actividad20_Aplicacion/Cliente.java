package unit11.Actividad20_Aplicacion;

import java.io.Serializable;

public class Cliente implements Serializable {
    private final int id;
    private String nombre;
    private String telefono;

    public Cliente(String nombre, String telefono) {
        this.id = generateId();
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (!nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            this.telefono = telefono;
        }
    }

    public static boolean validarTelefono(String telefono) {
        return !telefono.isBlank() && telefono.matches("[0-9]{9}");
    }

    private int generateId() {
        return (int) (Math.random() * 1000000);
    }

    @Override
    public String toString() {
        return this.nombre + " - " + this.telefono;
    }
}
