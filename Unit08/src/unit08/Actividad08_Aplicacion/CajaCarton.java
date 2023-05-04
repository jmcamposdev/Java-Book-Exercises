package unit08.Actividad08_Aplicacion;

import unit08.Actividad07_Aplicacion.Caja;
import unit08.Actividad07_Aplicacion.Unidad;

/*
    La empresa de mensajería BiciExpress que reparte en bicicleta, para disminuir el peso que transportan
    sus empleados solo utilizan cajas de cartón. El volumen de estas se calcula como el 80% del volumen real,
    con el fin de evitar que se deforme y se rompan. Otra característica de las cajas de cartón es que sus medidas
    siempre están en CM. Por último la empresa para controlar costes necesita saber cuál es la superficie total de
    cartón usado para construir todas las cajas.

    Escribe la clase CajaCarton heredando de Caja.
 */
public class CajaCarton extends Caja {
    private double superficieTotalCarton;

    public CajaCarton(int ancho,int alto,int fondo){
        super(ancho,alto,fondo, Unidad.CM);
        this.superficieTotalCarton += (2*(alto*ancho)) + (2*(ancho*fondo)) + (2*(alto*fondo));
    }

    @Override
    public double getVolumen() {
        return super.getVolumen()*0.8;
    }

    public double getSuperficieTotalCarton() {
        return superficieTotalCarton;
    }
}
