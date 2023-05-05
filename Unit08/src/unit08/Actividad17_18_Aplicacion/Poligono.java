package unit08.Actividad17_18_Aplicacion;

/*
    Actividad 17
    Implementa la clase abstracta Poligono con los atributos base y altura, de tipo double y el método
    abstracto double area()
 */
public abstract class Poligono {
    private final double base;
    private final double altura;

    public Poligono(double base, double altura){
        if (base < 0){
            throw new IllegalArgumentException("La base no puede ser negativa");
        }
        if (altura < 0){
            throw new IllegalArgumentException("La altura no puede ser negativa");
        }

        this.base = base;
        this.altura = altura;
    }

    public double getBase(){
        return this.base;
    }

    public double getAltura(){
        return this.altura;
    }

    public abstract double area();

}
