package unit08.Actividad21_Ampliacion;

/*
    A partir de la clase Calendario implementada en la Actividad Unidad 7 - 19. Escribe la clase CalendarioExacto
    que determina un instante de tiempo exacto formado por un año, mes, día, hora, minuto. Implementa los métodos
    toString(), equals() y los necesarios para el funcionamiento de la clase.
 */
public class CalendarioExacto extends Calendario{
    private int hora;
    private int minuto;

    public CalendarioExacto(int año, int mes, int dia, int hora, int minuto) {
        super(año, mes, dia);
        if (hora < 0 || hora > 23 ) {
            throw new IllegalArgumentException("Hora incorrecta");
        }
        if (minuto < 0 || minuto > 59) {
            throw new IllegalArgumentException("Minuto incorrecto");
        }

        this.hora = hora;
        this.minuto = minuto;
    }

    public void incrementarHora() {
        if (++hora > 23) {
            hora = 0;
            incrementarDia();
        }
    }

    public void incrementarMinuto() {
        if (++minuto > 59) {
            minuto = 0;
            incrementarHora();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " " + hora + ":" + minuto;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CalendarioExacto) {
            CalendarioExacto c = (CalendarioExacto) o;
            return super.equals(o) && hora == c.hora && minuto == c.minuto;
        }
        return false;
    }
}
