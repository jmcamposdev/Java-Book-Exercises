package unit08.Actividad21_Ampliacion;

/*
    Diseña la clase Calendario que representa una fecha concreta (año, mes y día). La clase debe disponer de los métodos:
        • Calendario (int año, int mes, int dia): que crea un objeto con los datos pasados como parámetros, siempre y cuando, la fecha que representen sea correcta.
        • void incrementarDia (): que incrementa en un día la fecha del calendario.
        • void incrementarMes (): que incrementa en un mes la fecha del calendario.
        • void incrementarAño (int cantidad): que incrementa la fecha del calendario en el número de años especificados. Ten en cuenta que el año 0 no existió.
        • void mostrar (): muestra la fecha por consola.
        • boolean iguales (Calendario otraFecha): que determina si la fecha invocante y la
        que se pasa como parámetro son iguales o distintas.
    Por simplicidad, solo tendremos en consideración que existen meses con distinto número de días, pero no tendremos en cuenta los años bisiestos
 */
public class Calendario {
    private int año;
    private int mes;
    private int dia;

    public Calendario(int año, int mes, int dia) {
        if (!fechaCorrecta(año, mes, dia)) {
            throw new IllegalArgumentException("Fecha incorrecta");
        }

        this.año = año;
        this.mes = mes;
        this.dia = dia;
    }

    public void incrementarDia () {
        dia++;
        if (dia > diasMes(mes, año)) {
            dia = 1;
            incrementarMes();
        }
    }

    public void incrementarMes() {
        mes++;
        if (mes > 12) {
            mes = 1;
            incrementarAño(1);
        }
    }

    public void incrementarAño(int i) {
        año += i;
    }

    /**
     * Comprueba si una fecha es correcta, es decir,
     * Si el año es mayor que 0,
     * El mes está entre 1 y 12,
     * El día está entre 1 y el número de días que tiene el mes
     * @param año El año de la fecha
     * @param mes El mes de la fecha
     * @param dia El día de la fecha
     * @return Devuelve true si la fecha es correcta y false en caso contrario
     */
    private boolean fechaCorrecta(int año, int mes, int dia) {
        return año > 0 && mes > 0 && mes <= 12 && dia > 0 && dia <= diasMes(mes, año);
    }

    /**
     * Calcula el número de días que tiene un mes
     * @param mes El mes del que queremos saber el número de días
     * @param año El año del que queremos saber el número de días
     * @return Devuelve el número de días que tiene el mes indicado
     */
    private int diasMes(int mes, int año) {
        int dias = 0;
        switch (mes) {
            case 2 -> {
                dias = 28;
                // Comprobamos si es bisiesto
                if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
                    dias = 29;
                }
            }
            case 4, 6, 9, 11 -> dias = 30;
            default -> dias = 31;
        }
        return dias;
    }


    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Calendario) {
            Calendario c = (Calendario) o;
            return año == c.año && mes == c.mes && dia == c.dia;
        }
        return false;
    }

}
