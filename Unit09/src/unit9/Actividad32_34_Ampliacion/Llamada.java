package unit9.Actividad32_34_Ampliacion;

import java.time.LocalDateTime;

public class Llamada implements Comparable<Llamada> {
    private String numeroTelefonoCliente;
    private String numeroInterlocutor;
    private boolean esSaliente;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private ZonaTarifa zonaInterlocutor;
    private int duracionLlamada;
    private double costeLlamada;

    public Llamada(String numeroTelefonoCliente, String numeroInterlocutor, boolean esSaliente, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin, ZonaTarifa zonaInterlocutor) {
        if (numeroTelefonoCliente == null || numeroInterlocutor == null || fechaHoraInicio == null || fechaHoraFin == null || zonaInterlocutor == null) {
            throw new IllegalArgumentException("Error: ninguno de los parámetros puede ser nulo");
        }
        if (numeroTelefonoCliente.isEmpty() || numeroInterlocutor.isEmpty()) {
            throw new IllegalArgumentException("Error: ninguno de los parámetros puede ser una cadena vacía");
        }
        if (fechaHoraInicio.isAfter(fechaHoraFin)) {
            throw new IllegalArgumentException("Error: la fecha y hora de inicio no puede ser posterior a la fecha y hora de fin");
        }

        this.numeroTelefonoCliente = numeroTelefonoCliente;
        this.numeroInterlocutor = numeroInterlocutor;
        this.esSaliente = esSaliente;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.zonaInterlocutor = zonaInterlocutor;
        this.duracionLlamada = (int) fechaHoraInicio.until(fechaHoraFin, java.time.temporal.ChronoUnit.MINUTES);
        this.costeLlamada = zonaInterlocutor.getCoste() * duracionLlamada;
    }



    public int getDuracionLlamada() {
        return duracionLlamada;
    }

    public double getCosteLlamada() {
        return costeLlamada;
    }

    public boolean isEsSaliente() {
        return esSaliente;
    }

    @Override
    public int compareTo(Llamada o) {
        int resultado = this.numeroTelefonoCliente.compareTo(o.numeroTelefonoCliente);
        if (resultado == 0) {
            resultado = this.fechaHoraInicio.compareTo(o.fechaHoraInicio);
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Numero de teléfono del cliente: " + numeroTelefonoCliente + "\n"
                + "Numero del interlocutor: " + numeroInterlocutor + "\n"
                + "Fecha y hora de inicio: " + fechaHoraInicio + "\n"
                + "Fecha y hora de fin: " + fechaHoraFin + "\n"
                + "Duración de la llamada: " + duracionLlamada + " minutos\n"
                + "Coste de la llamada: " + costeLlamada + " euros\n";
    }
}

