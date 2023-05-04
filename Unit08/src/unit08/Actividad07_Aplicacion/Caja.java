package unit08.Actividad07_Aplicacion;

/*
    Las empresas de transporte, para evitar daños en los paquetes embalan todas sus mercancías
    en cajas con el tamaño adecuado. Una caja se crea expresamente con un ancho, alto y un fondo
    y una vez creada se mantienen inmutables. Cada caja lleva pegada una etiqueta de un máximo de 30 caracteres
     con información útil como el nombre del destinatario, dirección. Implementar la clase Caja con los
     siguientes métodos:
     - Caja(int acnho,int alto, int fondo, Unidad unidad) que construye una caja con las dimensiones específicas.
       Pueden encontrarse en cm y m.
     - double getVolumen() devuelve el volumen de la caja en metros cúbicos.
     - void setEtiqueta((String etiqueta) que modifica el valor de la etiqueta de la caja.
     - String toString() devuelve una cadena con la representación de la caja
 */
public class Caja {
    private final int ancho;
    private final int alto;
    private final int fondo;
    private final Unidad unidad;
    private String etiqueta;

    public Caja(int ancho,int alto,int fondo,Unidad unidad){
        if (ancho <= 0 || alto <= 0 || fondo <= 0){
            throw new IllegalArgumentException("Las dimensiones de la caja deben ser positivas");
        }
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
    }

    public double getVolumen() {
        return (ancho*alto*fondo)/Math.pow(100,3);
    }

    public void setEtiqueta(String etiqueta){
        if (etiqueta.length() <= 30){
            this.etiqueta = etiqueta;
        }
    }

    @Override
    public String toString() {
        return "Caja{" +
                "ancho=" + ancho +
                ", alto=" + alto +
                ", fondo=" + fondo +
                ", unidad=" + unidad +
                ", etiqueta='" + etiqueta + '\'' +
                '}';
    }
}
