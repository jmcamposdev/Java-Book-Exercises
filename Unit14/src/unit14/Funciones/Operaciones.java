package unit14.Funciones;
import java.util.Arrays;

public class Operaciones {

    // REALIZA EL AREA DEL TRIANGULO
    // COM BASE Y ALTURA
    public static double areaTriangulo(double base,double altura){
        if (base <= 0){
            throw new IllegalArgumentException("La base debe de ser positiva");
        }
        if (altura<=0){
            throw new IllegalArgumentException("La altura debe de ser positiva");
        }
        return (base*altura)/2;
    }

    // CON LOS LADOS DEL TRIÁNGULO
    public static double areaTriangulo(double l1,double l2,double l3){
        if (l1 <= 0 || l2 <= 0 || l3 <= 0){
            throw new IllegalArgumentException("Los lados deben de ser positivos");
        }
        double sp = (l1+l2+l3)/2;
        return Math.sqrt(sp*(sp-l1)*(sp-l2)*(sp-l3));
    }


    // REALIZA EL CAMBIO DE SIGNO
    public static double cambioDeSigno(double numero){
        return numero   * -1;
    }

    // CAMBIO DE EUROS A PESETAS
    public static double eurosAPesetas (double euros){
        return euros*166.86;
    }

    // REALIZA EL VOLUMEN DE UN CONO
    public static double volumenCono(double radio,double altura){
        if (radio<= 0){
            throw new IllegalArgumentException("El radio debe ser positivo");
        }
        if (altura<= 0){
            throw new IllegalArgumentException("La altura debe ser positiva");
        }
        return (Math.PI*radio*radio*altura)/3;
    }

    // REALIZA LA MEDIA PONDERADA
    public static double mediaPonderada(double nota1,double media){
        if (nota1 < 0 || nota1 > 10 || media < 0 || media > 10){
            throw new IllegalArgumentException("Debe de ser un rango entre 0 y 10");
        }
        return (media-(nota1*0.4))/0.6;
        // Siendo 0.4 el valor de nota1 y 0.6 el valor de la nota que debería sacar en el próximo examen
    }

    // ECUACIÓN DE PRIMER GRADO
    public static double ecuacion1Grado(double a, double b){
        if (a==0){
            throw new IllegalArgumentException("El valor de b no puede ser 0");
        }
        return -b/a;
    }

    // ECUACIÓN DE SEGUNDO GRADO
    public static double[] ecuacion2Grado(double a, int b, int c) {
        if (a == 0){
            throw new IllegalArgumentException("El valor a debe ser diferente entre 0");
        }
        double discriminante = (Math.pow(b, 2) - (4 * a * c));
        if (discriminante >= 0) {
            double[] soluciones;
            // Una solución
            if(discriminante == 0){
                soluciones = new double[1];
                soluciones[0] = ((-b) - (4 * a * c)) / (2 * a);
                // Dos soluciones
            }else{
                soluciones = new double[2];
                final double sqrt = Math.sqrt(discriminante);
                soluciones[0] = ((-b) + sqrt) / (2 * a);
                soluciones[1] = ((-b) - sqrt) / (2 * a);
            }
            return soluciones;
        } else {
            // Sin solución
            return null;
        }
    }

    // MÚLTIPLOS DE
    public static int[] multiplosDe(int base,int repeticiones){
        if (base <= 0){
            throw new IllegalArgumentException("La base debe ser positiva");
        }
        if (repeticiones <= 0){
            throw new IllegalArgumentException("Las repeticiones deben ser positivas");
        }
        int[] array = new int[repeticiones];
        int multiplicador = 1;
        for (int i = 0; i <= repeticiones-1 ; i++) {
            array[i] = base*multiplicador;
            multiplicador++;
        }
        return array;
    }

    // TIEMPO DE CAÍDA
    public static double tiempoCaida(double altura){
        if (altura <= 0){
            throw new IllegalArgumentException("La altura debe ser positiva");
        }
        return Math.sqrt((2*altura)/9.81);
    }

    // HORÓSCOPO / SÍMBOLOS DEL ZODIACO
    public static String horoscopo(int dia, int mes){
        if (!fechaValida(dia,mes)){
            throw new IllegalArgumentException("La fecha debe ser válida");
        }
        String zodiaco;
        if ((dia >= 21 && mes==3)||(dia <= 19 && mes ==4)){
            zodiaco = "Eres Aries";
        } else if ((dia >= 20 && mes==4)||(dia <= 20 && mes ==5)){
            zodiaco = "Eres Tauro";
        } else if ((dia >= 21 && mes==5)||(dia <= 20 && mes ==6)){
            zodiaco = "Eres Géminis";
        } else if ((dia >= 21 && mes==6)||(dia <= 22 && mes ==7)){
            zodiaco = "Eres Cáncer";
        } else if ((dia >= 23 && mes==7)||(dia <= 22 && mes ==8)){
            zodiaco = "Eres Leo";
        } else if ((dia >= 23 && mes==8)||(dia <= 22 && mes ==9)){
            zodiaco = "Eres Virgo";
        } else if ((dia >= 23 && mes==9)||(dia <= 22 && mes ==10)){
            zodiaco = "Eres Libra";
        } else if ((dia >= 23 && mes==10)||(dia <= 21 && mes ==11)){
            zodiaco = "Eres Escorpio";
        } else if ((dia >= 22 && mes==11)||(dia <= 21 && mes ==12)){
            zodiaco = "Eres Sagitario";
        } else if ((dia >= 22 && mes==12)||(dia <= 19 && mes ==1)){
            zodiaco = "Eres Capricornio";
        } else if ((dia >= 20 && mes==1)||(dia <= 18 && mes ==2)){
            zodiaco = "Eres Acuario";
        } else if ((dia >= 19 && dia <= 28 && mes==2)||(dia<=20 && mes==3)){
            zodiaco = "Eres Piscis";
        } else {
            zodiaco = "Fecha introducida no valida";
        }
        return zodiaco;
    }

    // REALIZA LA VALIDACIÓN DE UNA FECHA
    public static boolean fechaValida (int dia,int mes){
        if (dia <= 0 || dia > 31 || mes <= 0 || mes > 12){
            throw new IllegalArgumentException("El rando de los dias y meses es erróneo");
        }

        boolean valida;
        valida = dia <= 28 && mes == 2 ||
                ((dia <= 30) && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) ||
                ((dia <= 31) && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12));
        return valida;
    }

    // CALCULA LA CANTIDAD DE SEGUNDOS HASTA EL AMANECER
    public static int segundosHastaElAmanecer (int horas,int minutos){
        if (horas < 0 || horas > 23){
            throw new IllegalArgumentException("Las horas deben de ser entre 0 y 23");
        }
        if (minutos < 0 || minutos > 59){
            throw new IllegalArgumentException("Los minutos deben de ser entre 0 y 59");
        }
        return 86400 - (horas*60*60)+(minutos*60);
    }

    // ADIVINAR CÓDIGO CAJA FUERTE
    public static boolean adivinarCodigo (int codigo, int intentos){
        if (codigo<1000){
            throw new IllegalArgumentException("El código debe ser como mínimo 1000");
        }
        if (intentos<=0){
            throw new IllegalArgumentException("El número de intentos debe ser positivo");
        }

        int numero;
        do {
            numero = GetData.getInt("Ingrese la combinación de 4 dígitos: ",1000,9999);
            if (numero != codigo){
                System.out.println("Código erróneo inténtelo de nuevo.");
            }
            intentos--;
        } while (intentos > 0 && numero!=1234);

        return numero == codigo;
    }

    // ORDENAR NÚMEROS INDEPENDIENTEMENTE DE LA CANTIDAD DE NÚMERO.
    // DEVUELVE UN ARRAY ORDENADO 0 ES EL MENOR Y EL ÚLTIMO EL MAYOR
    public static int[] ordenarNumeros(int cantidadNumeros){
        if (cantidadNumeros<=0){
            throw new IllegalArgumentException("La cantidad de intentos debe ser positiva");
        }

        int numeroIntroducido;
        String numeros = "";
        for (int i = 0; i < cantidadNumeros ; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ");
            numeros += numeroIntroducido+",";
        }
        numeros = numeros.substring(0,numeros.length()-1);
        String[] arrayString = numeros.split(",");
        int[] arrayNumeros = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayNumeros[i] = Integer.parseInt(arrayString[i]);
        }
        Arrays.sort(arrayNumeros);
        return arrayNumeros;
    }

    // PIEDRA,PAPEL,TIJERA
    // DEVULEVE 0 SI ES EMPATE,1 SI ES J1 Y -1 SI ES J2;
    public static int piedraPapelTijera(String jugador1,String jugador2){
        if ((jugador1.equals("piedra") &&jugador2.equals("tijera"))||
                (jugador1.equals("papel")&&jugador2.equals("piedra"))||
                (jugador1.equals("tijera")&&jugador2.equals("papel"))){
            return 1;
        } else {
            if (jugador1.equals(jugador2)){
                return 0;
            } else return -1;
        }
    }

    // RECREAMOS LA SERIA DE FIBONACCI
    public static int[] serieFibonacci(int cantidad){
        if (cantidad<0){
            throw new IllegalArgumentException("La cantidad de numeros debe ser mayor o igual que 0");
        }

        int aux,num1=0,num2=1,contador=2;
        int[] numeros = new int[cantidad+1];
        switch (cantidad){
            case 0 -> numeros[0]=0;
            case 1 -> {
                numeros[0]=0;
                numeros[1]=1;
            }
            default -> {
                numeros[0]=0;
                numeros[1]=1;
                while (cantidad >= 2){
                    aux = num1;
                    num1 = num2;
                    num2 = aux + num2;
                    cantidad=cantidad-1;
                    numeros[contador]=num2;
                    contador++;
                }
            }

        }
        return numeros;
    }

    // SUMA DE LOS N PRIMEROS NÚMEROS
    public static int sumaNNumeros(int numero){
        if (numero<=0){
            throw new IllegalArgumentException("El número debe de ser positivo");
        }

        int suma = 0;
        for (int i = 0; i <= numero ; i++) {
            suma+=i;
        }
        return suma;
    }

    // COMPROBAR SI UN AÑO ES BISIESTO
    public static boolean yearBisiesto(int year){
        if (year<= 0){
            throw new IllegalArgumentException("El año debe de ser positivo");
        }

        return ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0));
    }

    // CALCULA LA POTENCIA DADA BASE Y EXPONENTE
    public static double potencia(int base,int exponente){
        if (base==0 && exponente<=0){
            throw new IllegalArgumentException("La base 0 no puede contener valores negativos");
        }
        double resultado;
        int exponentemodificado;
        if (exponente == 0){
            resultado = 1;
        } else{
            if (exponente < 0){
                exponentemodificado = exponente * -1;
            } else{
                exponentemodificado = exponente;
            }
            resultado = base;
            for (int contador = 1; contador < exponentemodificado; contador++) {
                resultado = resultado * base;
            }
        }

        if (exponente < 0){
            resultado = 1/resultado;
        }
        return resultado;
    }

    // COMPRUEBA SI ES PRIMO
    public static boolean esPrimo(int num){
        boolean primo = true;
        int i = 2;
        if (num == 1 || num== 0){
            primo = false;
        } else{
            while (i < num){
                if (num % i == 0) {
                    primo = false;
                    break;
                }
                i++;
            }
        }
        return primo;
    }

    // DEVUELVE EL NÚMERO DE CIFRAS DEL NÚMERO
    public static int cifras (int numero){
        int numeroDeCifras = 0;
        if (numero == 0){
            numeroDeCifras+=1;
        }
        int div = numero;
        while (div != 0){
            div = div / 10;
            numeroDeCifras = numeroDeCifras + 1;
        }
        return numeroDeCifras;
    }

    // COMPROBAR SI UN NÚMERO ES CAPICÚA O NO
    public static boolean capicua(int numero){
        int div,reves=0,mod;
        if (numero!=0){
            div = numero;
            while (div!=0){
                mod = div % 10;
                reves = (reves * 10) + mod;
                div = div / 10;
            }
        }
        return reves == numero;
    }

    // Calcula el importe de la llamada
    public static int costeLlamadaTelefonica(int segundos){
        if (segundos<=0){
            throw new IllegalArgumentException("Los segundos deben de ser positivos");
        }
        int importe;
        if (segundos > 180) {
            segundos = segundos -180;
            importe = segundos/60;
            importe = (importe * 7) + 45;
        } else {
            importe = segundos/60;
            importe = importe * 15;
        }
        if (segundos % 60 != 0){
            importe = importe + 7;
        }
        return importe;
    }

    // PROGRESIÓN GEOMÉTRICA
    // número de elementos de la progresión (N)
    // la razón (r)
    // el término inicial (ti)
    public static int[] progresionGeometrica (int ti,int r,int n) {
        if (n<=0){
            throw new IllegalArgumentException("La progresión debe de ser positiva");
        }

        int contador =0;
        int[] numeros = new int[n];
        numeros[0] = ti;
        while (contador < n){ // Iteramos mientras contador sea menor a n imprimimos ti y modificamos ti y aumentamos contador
            numeros[contador] = ti;
            ti = ti * r;
            contador = contador +1;
        }
        return numeros;
    }

    // NUMERO PERFECTOS
    public static boolean numeroPerfecto (int numero){
        if (numero<0){
            throw new IllegalArgumentException("El número debe de ser positivo");
        }
        int perfecto = 0;
        for (int j = 1; j < numero; j++) { //Itera el número i con todos los numero menores menos el mismo buscando divisores
            if (numero % j == 0){ // Comprueba si es divisible entre j
                perfecto = perfecto + j; // Si es divisible lo suma a la variable
            }
        }
        return numero==perfecto;
    }

    // CALCULA LA CUOTA MENSUAL
    public static double cuotaMensual (double hipoteca,int year,double interes){
        if (hipoteca<=0){
            throw new IllegalArgumentException("El valor de la hipoteca debe de ser positivo");
        }
        if (year<= 0){
            throw new IllegalArgumentException("El valor del año debe de ser positivo");
        }
        if (interes<0){
            throw new IllegalArgumentException("El valor del interes debe de ser positivo o 0");
        }

        double r = (interes)/(100*12);
        return  (hipoteca*r)/(1-Math.pow((1+r),(-12*year)));
    }

    // CONVERSOR PALITOS
    //  Devolvemos el Array con tantas posiciones como dígitos tenga y en cada posición el dígito correspondiente
    public static int[] conversorPalitos (int numero){
        if (numero<0){
            throw new IllegalArgumentException("El número debe de ser positivo");
        }
        int numeroDecifras,cifra,contador;
        numeroDecifras = cifras(numero); // Calculamos el numero de cifras del número.
        int[] numerosPalitos = new int[numeroDecifras]; // Creamos el array con el número de cifras obtenido
        numeroDecifras--; //Restamos una ya que si no nos sale resto Para poder sacar los numeros
        contador = numeroDecifras; // Creamos contador ya que numeroDeCifras va a ser modificado
        for (int i = 0; i <= contador; i++) { // Creamos un loop que itere tantas veces como cifras tenga -1;
            // Calculamos la primera cifra dividiendo el número entre 10 ^ numeroDeCifras -1;
            cifra = numero/(int)Math.pow(10,numeroDecifras);
            // Reasignamos número restando la cifra elevada su posición Ej: 4350 cifra=4000 numero=4350-4000;
            numero = numero-(cifra*(int)Math.pow(10,numeroDecifras));
            // Guardamos la cifra en la posición deseada;
            numerosPalitos[i] = cifra;
            // Restamos numeroDeCifras para el próximo dígito
            numeroDecifras--;
        }
        // Devolvemos el Array con tantas posiciones como dígitos tenga y en cada posición el dígito correspondiente
        return numerosPalitos;
    }

    // INSERTA IN DIGITO EN UNA POSICIÓN DESEADA
    // DESTACAR: Para el correcto funcionamiento de pasarle el número multiplicado por 10;
    public static int insertarDigito (int numero,int nuevoDigito,int posicion){

        boolean salida = false;
        int cifra,numeroModificado=0;
        int numeroDecifras = cifras(numero); // Calculamos el número de cifras que tenga el número
        numeroDecifras--; // Restamos las cifras para poder sacar el primer dígito
        int contador = numeroDecifras; // Creamos una variable auxiliary ya que modificaremos la variable
        for (int i = 1; i <= contador+1 && !salida; i++) {
            cifra = numero/(int)Math.pow(10,numeroDecifras); // Sacamos la primera cifra del número
            if (i == posicion){ // Comprobamos que la posición coincide con la posición del usuario
                // Si coincide sumamos a númeroModificado el nuevo dígito elevado a la posición y se suman el resto del número
                numeroModificado = numeroModificado + (nuevoDigito*(int)Math.pow(10,numeroDecifras))+(numero/10);
                salida = true;
            } else {
                numero = numero - (cifra*(int)Math.pow(10,numeroDecifras));
                numeroModificado = numeroModificado + (cifra*(int)Math.pow(10,numeroDecifras));
                numeroDecifras--;
            }
        }
        return numeroModificado;
    }

    // Nos podemos aproximar al número PI usando la seria de Leibniz que dice que PI se puede
    // obtener a partir de la siguiente sucesión: 4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...
    public static double serieLeibnez (int iteraciones){
        double resultado = 0;
        boolean signo = true;
        int denominador = 1;
        for (int i = 1; i <= iteraciones; i++) {

            if (signo){
                resultado += (double) 4/denominador;
            } else {
                resultado -= (double) 4/denominador;
            }
            denominador+=2;
            signo = !signo;
        }
        return resultado;
    }
}
