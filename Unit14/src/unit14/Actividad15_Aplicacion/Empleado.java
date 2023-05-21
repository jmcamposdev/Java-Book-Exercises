package unit14.Actividad15_Aplicacion;

import java.time.LocalDate;

public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private Oficina oficina;
    private String puesto;
    private LocalDate contrato;

    public Empleado(int id, String nombre, int edad, Oficina oficina, String puesto, LocalDate contrato) {
        if (edad <= 0) throw new IllegalArgumentException("La edad no puede ser negativa");
        if (puesto.isBlank()) throw new IllegalArgumentException("El puesto no puede estar vacío");

        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.oficina = new Oficina(oficina);
        this.puesto = puesto;
        this.contrato = contrato;
    }

    public Empleado(Empleado empleado) {
        this.id = empleado.id;
        this.nombre = empleado.nombre;
        this.edad = empleado.edad;
        this.oficina = new Oficina(empleado.oficina);
        this.puesto = empleado.puesto;
        this.contrato = empleado.contrato;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Oficina getOficina() {
        return new Oficina(oficina);
    }

    public String getPuesto() {
        return puesto;
    }

    public LocalDate getContrato() {
        return contrato;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad > 0) this.edad = edad;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = new Oficina(oficina);
    }

    public void setPuesto(String puesto) {
        if (!puesto.isBlank()) this.puesto = puesto;
    }

    public void setContrato(LocalDate contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + ", edad: " + edad + ", oficina: " + oficina + ", puesto: " + puesto + ", contrato: " + contrato;
    }
}
