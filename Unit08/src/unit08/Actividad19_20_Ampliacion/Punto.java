package unit08.Actividad19_20_Ampliacion;

/*
    Actividad 19
    Define la clase Punto que tiene como atributos las coordenadas x e y de tipo entero, que los sitúa en el plano.
    Además del constructor, implementa el método
        double distancia(Punto p)
    Que devuelve la distancia a otro punto que se le pasa como parámetro.

    A partir de la clase Punto por herencia implementa la clase Punto3D que representa un punto en tres dimensiones
    y necesita coordenada adicional. Reimplementa el método distancia() para que calcule la distancia para puntos en 3D.

    Actividad 20
    Implementa el método equals() para las clases Punto y Punto3D teniendo en cuenta que dos puntos son iguales
    cuanto todas sus coordenadas son iguales.


 */
public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }

    public double distancia(Punto p){
        return Math.sqrt(Math.pow(this.x - p.x,2) + Math.pow(this.y - p.y,2));
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = false;
        if (obj instanceof Punto){
            Punto p = (Punto) obj;
            if (this.x == p.x && this.y == p.y){
                equals = true;
            }
        }
        return equals;
    }

}
