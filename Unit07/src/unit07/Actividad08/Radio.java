package unit07.Actividad08;

/*
    7.8
    Definir una clase que permita controlar un sintonizador digital de emisoras FM; concretamente
    se desea dotal al controlador de una interfaz que permite subir (up) o bajar (down) la frecuencia (en
    saltos de 0.5 MHz y mostrar la frecuencia sintonizada en un momento dado (display). Supondremos que el
    rango de fecuencias para manejar oscila entre los 80 MHz y los 108 MHz y que, al inicio, el controlador
    sintonice la frecuencia indicada en el constructor o 80 MHz po defecto. Si durante una operación de subida o
    bajada se sobrepasa uno de los dos límites, la frecuencia sintonizada debe pasar a ser la del extremo contrario.
 */

public class Radio {
    private double frecuencia;
    static final double FRECUENCIA_MAX = 108.0;
    static final double FRECUENCIA_MIN = 80.0;

    public Radio(double frecuencia){
        if (frecuencia > FRECUENCIA_MAX || frecuencia < FRECUENCIA_MIN){
            throw new IllegalArgumentException("La frecuencia debe de estar entre "+FRECUENCIA_MIN+" y "+FRECUENCIA_MAX);
        }
        this.frecuencia = frecuencia;
    }
    public Radio(){
        this(80);
    }

    public void up(){
        if (frecuencia+0.5 > FRECUENCIA_MAX){
            frecuencia+=0.5;
            frecuencia-=FRECUENCIA_MAX;
            frecuencia+=FRECUENCIA_MIN;
        } else {
            frecuencia+=0.5;
        }

    }
    public void down(){
        if(frecuencia-0.5 < FRECUENCIA_MIN){
            frecuencia-=0.5;
            frecuencia+=FRECUENCIA_MAX;
            frecuencia-=FRECUENCIA_MIN;
        } else {
            frecuencia-=0.5;
        }

    }
    public void display(){
        System.out.println("Tu frecuencia es: "+frecuencia);
    }

}
