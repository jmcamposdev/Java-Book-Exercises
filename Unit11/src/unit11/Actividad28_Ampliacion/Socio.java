package unit11.Actividad28_Ampliacion;

import java.io.Serializable;
import java.time.LocalDate;

public class Socio implements Serializable {
    private static int proximoNumeroSocio = 1;
    private int numeroSocio;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaAlta;
    private String telefono;
    private String email;

    public Socio(String nombre, LocalDate fechaNacimiento, String telefono, String email) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!validarTelefono(telefono)) {
            throw new IllegalArgumentException("El teléfono no es válido.");
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("El email no es válido.");
        }

        this.numeroSocio = proximoNumeroSocio++;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.email = email;
        this.fechaAlta = LocalDate.now();
    }




    public int getNumeroSocio() {
        return numeroSocio;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            this.telefono = telefono;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validarEmail(email)) {
            this.email = email;
        }
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    public static void setProximoNumeroSocio (int proximoNumeroSocio) {
        Socio.proximoNumeroSocio = proximoNumeroSocio;
    }
    public static boolean validarTelefono (String telefono) {
        return telefono.matches("^[0-9]{9}$");
    }

    public static boolean validarEmail(String email) {
        return email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
    }

    @Override
    public String toString() {
        return this.nombre + " (" + this.numeroSocio + ")" + " - " + this.fechaAlta + " - " + this.telefono + " - " + this.email + " - " + this.fechaNacimiento;
    }
}
