package unit08.Actividad01;

/*
    Diseñar la clase Hora que representa un instante de tiempo compuesto por la hora (de 0 a 23)
    y los minutos. Dispone de los métodos:
    - Hora(hora,minutos), que construye un objeto con los datos pasados como parámetros.
    - void inc() que incrementa la hora en un minuto
    - boolean setMinutos(valor) que asigna un valor si es válido a los minutos.
      Devuelve true o false según haya sido posible modificar los minutos.
    - boolean setHora(valor) que asigna un valor si está comprendido entre 0 y 23, a la hora.
      Devuelve true o false dependiendo del valor introducido.
    - String toString() que devuelve un String con la representación de la hora.
 */
public class Hora {
    protected byte hora;
    protected byte minutos;

    public Hora(byte hora,byte minutos){
        if (!setHora(hora)){
            throw new IllegalArgumentException("El valor de la hora no es válido");
        }
        if (!setMinutos(minutos)){
            throw new IllegalArgumentException("El valor de los minutos no es válido");
        }
    }

    public void inc(){
        if (++this.minutos == 60){
            this.minutos = 0;
            if (++this.hora == 23){
                this.hora = 0;
            }
        }
    }

    public boolean setMinutos(byte minutos) {
        boolean esValido = false;
        if (minutos >= 0 && minutos <= 59){
            this.minutos = minutos;
            esValido = true;
        }
        return esValido;
    }

    public boolean setHora(byte hora) {
        boolean esValido = false;
        if (hora >= 0 && hora <=23){
            this.hora = hora;
            esValido = true;
        }
        return esValido;
    }

    @Override
    public String toString() {
        return this.hora+":"+this.minutos;
    }
}
