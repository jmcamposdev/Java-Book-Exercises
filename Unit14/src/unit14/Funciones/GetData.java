package unit14.Funciones;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class GetData {

    /**
     * Método para pedir un número por Terminal.
     * Si no es un número vuelve a pedirle que ingrese un número.
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @return El número que ingrese el usuario
     */
    public static int getInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }
    /**
     * Método para pedir un número por Terminal con un mínimo.
     * Si no es un número vuelve a pedirle que ingrese un número.
     * Si el número que ingresa es menor al mínimo se lo vuelve a pedir
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @param minimo El número mínimo incluido
     * @return El número que ingrese el usuario
     */
    public static int getInt(String mensaje, int minimo) {
        int numero;
        do {
            numero = getInt(mensaje);
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }
    
    /**
     * Método para pedir un número por Terminal con un mínimo y un maximo ambos incluidos.
     * Si no es un número o esta fuera del rango se vuelve a perdir al usuairo que ingrese un número
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @param minimo El número mínimo incluido
     * @param maximo El número máximo incluido
     * @return El número que ingrese el usuario
     */
    public static int getInt(String mensaje, int minimo, int maximo) {
        int numero;
        do {
            numero = getInt(mensaje);
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }
    /**
     * Método para pedir un número por Terminal.
     * Si no es un número vuelve a pedirle que ingrese un número.
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @return El número que ingrese el usuario
     */ 
    public static double getDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        double numero;
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
        return numero;
    }
    
    /**
     * Método para pedir un número por Terminal con un mínimo.
     * Si no es un número vuelve a pedirle que ingrese un número.
     * Si el número que ingresa es menor al mínimo se lo vuelve a pedir
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @param minimo El número mínimo incluido
     * @return El número que ingrese el usuario
     */
    public static double getDouble(String mensaje, double minimo) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero < minimo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo);
        return numero;
    }
    
    /**
     * Método para pedir un número por Terminal con un mínimo y un maximo ambos incluidos.
     * Si no es un número o esta fuera del rango se vuelve a perdir al usuairo que ingrese un número
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @param minimo El número mínimo incluido
     * @param maximo El número máximo incluido
     * @return El número que ingrese el usuario
     */
    public static double getDouble(String mensaje, double minimo,double maximo) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero < minimo || numero > maximo){
                System.out.println("El rango no es el adecuado");
            }
        } while (numero < minimo || numero > maximo);
        return numero;
    }

    /**
     * Método para pedir un número por Terminal el número pedidio
     * debe de ser distinto al pasado por parametro si es igual
     * mostramos un mensaje de error y le pedimos otra vez.
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @param distinto El número que no puede ser insetado por el usuario
     * @return El número que ingrese el usuario
     */
    public static double getDoubleDistinto(String mensaje, double distinto) {
        Scanner sc = new Scanner(System.in);
        double numero;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextDouble()){
                System.out.println("Ingrese un valor numérico.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            numero = sc.nextDouble();
            if (numero==distinto){
                System.out.println("Ingrese un valor distingo a "+distinto);
            }
        } while (numero==distinto);
        return numero;
    }
    
    /**
     * Método para pedir un número por Terminal.
     * Si no es un número vuelve a pedirle que ingrese un número.
     * @param mensaje El mensaje que saldra para pedirle al usuario el número
     * @return El número que ingrese el usuario
     */ 
    public static long getLong(String mensaje) {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        while (!sc.hasNextInt()){
            System.out.println("Ingrese un valor numérico.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        numero = sc.nextInt();
        return numero;
    }
    

    /**
     * Método para pedir un String por Terminal.
     * El texto no puede estar vacío o contner solo espacios si es así le volvemos 
     * a pedir que ingrese de nuevo un String
     * @param mensaje El mensaje que saldra para pedirle al usuario el String
     * @return El String que ingrese el usuario
     */ 
    public static String getString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        String texto;
        do {
            System.out.print(mensaje);
            while (!sc.hasNextLine()){
                System.out.println("Ingrese un string valido.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            texto = sc.nextLine();
        } while (texto.isBlank());
        return texto.trim();
    }

    /**
     * Método para pedir un char por Terminal.
     * @param mensaje El mensaje que saldra para pedirle al usuario el char
     * @return El char que ingrese el usuario
     */ 
    public static char getChar(String mensaje) {
        Scanner sc = new Scanner(System.in);
        char texto;
        System.out.print(mensaje);
        while (!sc.hasNext()){
            System.out.println("Ingrese un string valido.");
            System.out.print(mensaje);
            sc.nextLine();
        }
        texto = sc.next().charAt(0);
        return texto;
    }

    /**
     * Método para pedir un booelan por Terminal.
     * El usuario debe de insetar (si|no) para la representación del boolean.
     * Si inseta una opción no válida imprime un error y se le vuevelve a pedir que ingrese (si|no)
     * @param mensaje El mensaje que saldra para pedirle al usuario el boolean
     * @return True si el usuario a escrito "si" y false en caso de que escriba "no".
     */ 
    public static boolean getBoolean (String mensaje) {
        Scanner sc = new Scanner(System.in);
        boolean option;
        String input;
        do {
            System.out.print(mensaje);
            while (!sc.hasNext()){
                System.out.println("Ingrese si o no.");
                System.out.print(mensaje);
                sc.nextLine();
            }
            input = sc.next();
            input = input.toLowerCase();
            if (!input.matches("si|no")){
                System.out.println("Valor no válido (si o no)");
            }
        } while (!input.matches("si|no"));
        return input.equals("si");
    }

    /**
     * Méttodo para perdirle al usuario una Fecha
     * el usuario debe de insertar la fecha con el formato "dd/MM/yyyy" si no insertar
     * este formato se le volvera a perdir que inserte de nuevo.
     * @param mensaje El mensaje que saldra para pedirle al usuario la fecha
     * @return La fecha que ha insertado el usuario
     */
    public static LocalDate getFecha(String mensaje) {
        String date = GetData.getString(mensaje); // Pedimos la Fecha
        // Creamos el formato que deberá tener la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // Seleccionamos que el analizador sea estricto por lo cual debe de coincidir con el formato que le hemos puesto
        sdf.setLenient(false);
        // Indicamos que el análisis lo realize desde el index 0 en adelante
        ParsePosition pp = new ParsePosition(0);
        // Intentamos convertir el String de la Fecha en un Date si no puede devuelve null
        java.util.Date d = sdf.parse(date, pp);
        while (d == null) { // Si es null volvemos a pedir la fecha y a pasarla hasta que sea válida
            System.out.println("Ingrese una fecha válida (dd/mm/yyyy)");
            date = GetData.getString(mensaje);
            d = sdf.parse(date, pp);
        }
        // Convertimos el String Fecha en un Array separándolo por "/"
        String[] splitFecha = date.split("/");
        // Devolvemos un LocalDate formada gracia al Array (año,mes,día)
        return LocalDate.of(Integer.parseInt(splitFecha[2]),Integer.parseInt(splitFecha[1]),Integer.parseInt(splitFecha[0]));
    }
}
