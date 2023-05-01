package unit04.Actividad15_Aplicacion;

/*
    Crea la función muestraPares(int n) que muestre por consola los primeros n números pares.
 */
public class Actividad15 {
    public static void main(String[] args) {
        muestraPares(100);
    }

    public static void muestraPares(int n) {
        for (int i = 0; i < n * 2; i+=2) {
            System.out.println(i);
        }
    }
}
