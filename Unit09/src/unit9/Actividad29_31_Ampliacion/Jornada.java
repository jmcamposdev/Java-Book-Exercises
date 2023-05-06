package unit9.Actividad29_31_Ampliacion;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jornada implements Comparable<Jornada> {
    private String dni;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private int minutosTrabajados;

    public Jornada(String dni, LocalDate fecha, LocalTime horaEntrada, LocalTime horaSalida) {
        if (dni == null || dni.length() != 9) {
            throw new IllegalArgumentException("El dni debe tener 9 caracteres");
        }
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        if (horaEntrada == null) {
            throw new IllegalArgumentException("La hora de entrada no puede ser nula");
        }
        if (horaSalida == null) {
            throw new IllegalArgumentException("La hora de salida no puede ser nula");
        }
        if (horaEntrada.isAfter(horaSalida)) {
            throw new IllegalArgumentException("La hora de entrada no puede ser posterior a la de salida");
        }
        if (horaEntrada.equals(horaSalida)) {
            throw new IllegalArgumentException("La hora de entrada no puede ser igual a la de salida");
        }

        this.dni = dni;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.minutosTrabajados = (horaSalida.getHour() - horaEntrada.getHour()) * 60 + (horaSalida.getMinute() - horaEntrada.getMinute());
    }

    public int numeroMinutosTrabajados() {
        return minutosTrabajados;
    }

    @Override
    public int compareTo(Jornada o) {
        int resultado = this.dni.compareTo(o.dni);
        if (resultado == 0) {
            resultado = this.fecha.compareTo(o.fecha);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + ", Fecha: " + fecha + ", Minutos Trabajados: " + minutosTrabajados;
    }
}
