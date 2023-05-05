package unit08.Actividad16_Aplicacion;

public class Numero {

    public static boolean esNumero(Object ob){
        return ob instanceof Number;
    }

    public static boolean sumar(Object a, Object b){
        boolean sumar = false;
        if (a instanceof String && b instanceof String){
            System.out.println(a.toString() + b.toString());
            sumar = true;
        } else if (a instanceof Number && b instanceof Number){
            System.out.println(Double.parseDouble(a.toString()) + Double.parseDouble(b.toString()));
            sumar = true;
        } else {
            System.out.println("No sumables");
        }
        return sumar;
    }

}
