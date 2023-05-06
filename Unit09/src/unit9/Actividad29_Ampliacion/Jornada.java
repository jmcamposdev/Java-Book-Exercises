package unit9.Actividad29_Ampliacion;

import java.time.LocalDate;
import java.time.LocalTime;

/*
    Implementar la clase Jornada, cuyo objeto son los datos de cada día de trabajo de los empleados
    de una empresa. En ella se identificarán al trabajador por su DNI y figurarán la fecha y las horas
    de entrada y salida del trabajado de cada jornada. Un método computará el número de minutos trabajados en la jornada.
    El criterio de orden natural de las jornadas será el de los DNI y para igual DNI el de la fecha de jornada, con objeto de que aparezca
    consecutivas todas las jornadas de cada trabajador. Asimismo implementar el método toString() que muestre el DNI del empleado, la fecha
    y la duración en minutos de las jornadas.
 */
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
