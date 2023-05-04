package unit08.Actividad02_03;

/*
    8.2
    A partir de la clase Hora implementar la clase HoraExacta que incluye le la hora los segundos.
    Además de los métodos heredados de Hora dispondrá de:
    - HoraExacta(hora,minutos,segundo) que construye el objeto con los valores pasados por parámetro
    - setSegundos(valor) que asigna si está comprendido entre 0 y 59 el valor indicado a los segundos.
    - inc() que incrementa la hora en un segundo.

    8.3
    Añadir a la clase HoraExacta un método que compare si dos horas (la invocada y otra pasada por
    parámetro) sean iguales o distintas.
 */
public class HoraExacta extends unit08.Actividad01.Hora{
    private byte segundos;

    public HoraExacta(byte hora,byte minutos,byte segundos){
        super(hora,minutos);
        if (!setSegundos(segundos)){
            throw new IllegalArgumentException("El valor de segundos es erróneo");
        }
        this.segundos = segundos;
    }

    public boolean setSegundos(byte segundos){
        boolean esValido = false;
        if (segundos >= 0 && segundos <= 59){
            this.segundos = segundos;
            esValido = true;
        }
        return esValido;
    }

    @Override
    public void inc() {
        this.segundos++;
        if (segundos > 59){
            this.segundos = 0;
            super.inc();
        }
    }

    @Override
    public String toString() {
        return super.toString()+":"+this.segundos;
    }

    @Override
    public boolean equals(Object obj) {
        HoraExacta otraHora = (HoraExacta) obj;
        return this.hora == otraHora.hora &&
                this.minutos == otraHora.minutos &&
                this.segundos == otraHora.segundos;

    }

}
