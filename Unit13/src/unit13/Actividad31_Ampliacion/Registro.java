package unit13.Actividad31_Ampliacion;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Objects;

public class Registro implements Serializable, Comparable<Registro> {
    private final LocalTime hora;
    private final double temperatura;

    public Registro (double temperatura) {
        this.temperatura = temperatura;
        this.hora = LocalTime.now();
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registro registro = (Registro) o;

        return Objects.equals(hora, registro.hora);
    }


    @Override
    public int hashCode() {
        return hora != null ? hora.hashCode() : 0;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter
                .ofLocalizedTime(FormatStyle.MEDIUM)
                .withLocale(Locale.getDefault());
        return "Registro - " + hora.format(f) + " | " + temperatura;
    }

    @Override
    public int compareTo(Registro o) {
        return (int) Math.signum(this.temperatura - o.temperatura);
    }
}
