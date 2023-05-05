package unit08.Actividad22_Ampliacion;

import unit08.Actividad19_20_Ampliacion.Punto3D;

/*
    Implementa la clase Suceso que hereda de Punto3D. Un suceso está caracterizado de forma única por el lugar y el instante
    en el que ocurre (el atributo tiempo de tipo int). Añade un atributo descripción de tipo String que describe el suceso.
    Implementa el método equals() para que dos sucesos sean iguales si ocurren en el mismo sitio y en el mismo instante.
 */
public class Suceso extends Punto3D {
    private int tiempo;
    private String descripcion;

    public Suceso(int x, int y, int z, int tiempo, String descripcion) {
        super(x, y, z);
        if (tiempo < 0) {
            throw new IllegalArgumentException("Tiempo incorrecto");
        }
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }
    public void setTiempo(int tiempo) {
        if (tiempo > 0) {
            this.tiempo = tiempo;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        if (descripcion != null) {
            this.descripcion = descripcion;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Suceso) {
            Suceso s = (Suceso) o;
            return super.equals(o) && tiempo == s.tiempo;
        }
        return false;
    }
}
