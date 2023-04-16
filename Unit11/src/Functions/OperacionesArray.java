package Functions;

import java.util.Arrays;

public class OperacionesArray {

    // Crear un array con numeros aleatorios con prendidos con el máximo sin incluirlo
    public static int[] crearArrayAleatorio(int longitudArray,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*maximo);
        }
        return array;
    }

    // Crea un array con números aleatorios entre un rando ambos incluidos
    public static int[] crearArrayAleatorio(int longitudArray,int minimo,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        for (int i = 0; i < array.length; i++) {
                array[i] = (int) ((Math.random()*((maximo-minimo)+1))+minimo);
        }
        return array;
    }
    // Crea un array con número aleatorios pares
    public static int[] crearArrayAleatorioPares (int longitud){
        int[] array = new int[longitud];
        int numeroAleatorio;
        for (int i = 0; i < longitud ; i++) {
            do {
                numeroAleatorio = (int) (Math.random()*1000+1);
            } while (numeroAleatorio%2!=0);
            array[i] = numeroAleatorio;
        }
        Arrays.sort(array);
        return array;
    }

    // Crea un array pidiendo los números por teclado sin restricciones
    public static int[] cargarArrayTeclado (int longitudArray){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ");
            array[i] = numeroIntroducido;
        }
        return array;
    }

    // Crea un array pidiendo los datos con un mínimo
    public static int[] cargarArrayTeclado (int longitudArray,int minimo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ",minimo);
            array[i] = numeroIntroducido;
        }
        return array;
    }

    public static int[] cargarArrayTeclado (int longitudArray,int minimo,int maximo){
        if (longitudArray<=0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int[] array = new int[longitudArray];
        int numeroIntroducido;
        for (int i = 0; i < array.length; i++) {
            numeroIntroducido = GetData.getInt("Ingrese un número: ",minimo,maximo);
            array[i] = numeroIntroducido;
        }
        return array;
    }

    // Muestra el array por pantalla de forma visual
    public static void mostrarArrayPantalla (int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Indice: "+i+" = "+array[i]);
        }

    }

    // Retorna la suma del array
    public static double suma (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma+=array[i];
        }
        return suma;
    }

    // Retorna la suma del array bidimensional
    public static int suma (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                suma+=array[i][j];
            }
        }
        return suma;
    }

    // Convertir array de ints a array de double
    public static double[] convertirDouble (int[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] arrayDouble = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayDouble[i] = array[i];
        }
        return arrayDouble;
    }

    // Devuelve el valor maximo del array
    public static double maximo (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return array[array.length-1];
    }

    // Devuelve el valor maximo del array bidimensional
    public static int maximo (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        int maximo = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]> maximo){
                    maximo = array[i][j];
                }
            }
        }
        return maximo;
    }

    // Devuelve el valor mínimo del array
    public static double minimo (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return array[0];
    }

    // Devuelve el valor mínimo del array bidimensional
    public static int minimo (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        int minimo = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]<minimo){
                    minimo = array[i][j];
                }
            }
        }
        return minimo;
    }

    // Devuelve la media del array
    public static int media (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        int suma = suma(array);
        return suma/(array.length*array[0].length);
    }

    // Devuelve la media del array
    public static double media (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double suma = suma(array);
        return suma/array.length;
    }

    // Devuelve la moda tanto unimodal como multimodal;
    public static double[][] moda (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        int numerosUnicos = OperacionesArray.numeroUnicos(array).length;
        double[][] vecesRepetidos = new double[numerosUnicos][2];
        double[] moda = new double[0];
        int indice = 0;
        int contador=0;
        double aux=array[0];
        for (double numero : array) {
            if (aux == numero) {
                contador++;
            } else {
                vecesRepetidos[indice][0] = aux;
                vecesRepetidos[indice][1] = contador;
                indice++;
                contador = 1;
                aux = numero;
            }
        }
        vecesRepetidos[indice][0] = array[array.length-1];
        vecesRepetidos[indice][1] = contador;

        int masRepetido = 0;
        for (int i = 0; i < vecesRepetidos.length; i++) {
                if (vecesRepetidos[i][1]>masRepetido){
                    masRepetido = (int) vecesRepetidos[i][1];
                }
        }

        int modaindice = 0;
        for (int i = 0; i < vecesRepetidos.length; i++) {
                if (vecesRepetidos[i][1] == masRepetido){
                    moda = Arrays.copyOf(moda,moda.length+1);
                    moda[modaindice] = vecesRepetidos[i][0];
                    modaindice++;
                }
        }
        System.out.println(Arrays.toString(moda));
        return vecesRepetidos;
    }

    public static int[] moda (int[] array){
        Arrays.sort(array);
        int[] moda = new int[1];
        int indicemoda = 0;
        int repetidos = 0;
        int maximasRepeticiones = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]){
                    repetidos++;
                }
            }
             if (repetidos == maximasRepeticiones && Arrays.binarySearch(moda,array[i])<0){
                     moda = Arrays.copyOf(moda,moda.length+1);
                     moda[indicemoda] = array[i];
                     indicemoda++;
            } else if (repetidos > maximasRepeticiones){
                 maximasRepeticiones = repetidos;
                 moda = Arrays.copyOf(moda,1);
                 moda[0] = array[i];
                 indicemoda = 1;
                 System.out.println(Arrays.toString(moda));
             }
            repetidos=0;
        }
        return moda;
    }
    public static double[] numeroUnicos (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] numerosRepetidos = new double[1];
        int indice = 0;
        for (double v : array) {
            if (Arrays.binarySearch(numerosRepetidos, v) < 0) {
                numerosRepetidos[indice] = v;
                numerosRepetidos = Arrays.copyOf(numerosRepetidos, numerosRepetidos.length + 1);
                indice++;
            }
        }
        numerosRepetidos = Arrays.copyOf(numerosRepetidos,numerosRepetidos.length-1);
        return numerosRepetidos;
    }

    // Mostrar un arrayBidimensional por pantalla DOUBLE
    public static void mostrarArrayBidimensional (double[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        for (double[] doubles : array) {
            for (int y = 0; y < doubles.length; y++)
                System.out.print(" | " + doubles[y] + " | ");
            System.out.println("\n----------------------------------------");

        }
    }

    public static void mostrarArrayBidimensional (int[][] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }
        for (int[] ints : array) {
            for (int y = 0; y < ints.length; y++)
                System.out.print(" | " + ints[y] + " | ");
            System.out.println("\n----------------------------------------");

        }
    }

    // Devuelve el array rotado.
    public static double[] voltear (double[] array){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        double[] arrayVolteado = new double[array.length] ;
        int indice = array.length-1;
        for (int i = 0; i < array.length; i++) {
            arrayVolteado[i] = array[indice];
            indice--;
        }
        return arrayVolteado;
    }

    public static int[] rotar (int[] array){
        int[] arrayRotado = new int[array.length];

        int aux = array[array.length-1]; // Cogemos el último valor
        for (int i = array.length-1; i > 0; i--) {
            arrayRotado[i] = array[i-1];
        }
        arrayRotado[0] = aux;
        return arrayRotado;
    }

    // Devuelve el array sin numero repetidos
    public static int[] sinRepetidos (int[] t){
        int[] sinRepetidos = new int[0];
        for (int valor: t) {
            if (Arrays.binarySearch(sinRepetidos,valor) <= -1){
                sinRepetidos = Arrays.copyOf(sinRepetidos,sinRepetidos.length+1);
                sinRepetidos[sinRepetidos.length-1] = valor;
                Arrays.sort(sinRepetidos);
            }
        }
        return sinRepetidos;
    }

    public static int[] borrarDatosOrdenados (int[] t,int aBorrar){
        int indiceBorrado = Arrays.binarySearch(t,aBorrar);
        if(indiceBorrado < 0){
            throw new IllegalArgumentException("El dato deseado para borrar del array no existe");
        }
        System.arraycopy(t,indiceBorrado+1,t,indiceBorrado,t.length-indiceBorrado-1);
        t = Arrays.copyOf(t,t.length-1);
        return t;
    }

    public static int[] borrarDatoDesordenado (int[] t,int datoBorrado){
        int[] nuevoArray = Arrays.copyOf(t,t.length);
        int indiceDeDato = Arrays.binarySearch(t,datoBorrado);
        if (indiceDeDato<0){
            throw new IllegalArgumentException("El dato deseado para borrar del array no existe");
        } else {
            nuevoArray[indiceDeDato] = nuevoArray[nuevoArray.length-1];
            nuevoArray = Arrays.copyOf(nuevoArray,nuevoArray.length-1);
        }
        // Arrays.sort(nuevoArray);
        return nuevoArray;
    }

    // Inserción de un nuevo dato a un array ordenado
    public static int[] insercionOrdenada (int[] t, int nuevoValor){
        int[] nuevoArray = new int[t.length+1];
        int indiceInsercion = Arrays.binarySearch(t,nuevoValor);
        if (indiceInsercion < 0) {
            indiceInsercion = -indiceInsercion -1;
        }
        System.arraycopy(t,0,nuevoArray,0,indiceInsercion);
        System.arraycopy(t,indiceInsercion,nuevoArray,indiceInsercion+1,t.length-indiceInsercion);
        nuevoArray[indiceInsercion] = nuevoValor;
        return nuevoArray;
    }

    // Inserción de un dato a un array desordenado
    public static int[] insercionDesordenada(int[] array,int nuevoValor){
        array = Arrays.copyOf(array,array.length+1);
        array[array.length-1] = nuevoValor;
        return array;
    }

    // Devuelve el índice donde se encuentra el número si no retorna un valor negativo;
    // el cual realizando -indiceDevuelto -1 es el índice donde se debería colocar.
    public static int busquedaOrdenada (double[] array,int numero){
        if (array.length == 0){
            throw new IllegalArgumentException("La longitud del array debe ser positiva mayor que 0");
        }

        Arrays.sort(array);
        return Arrays.binarySearch(array,numero);
    }

    // Búsqueda Desordenada
    public static int  busquedaDesordenada (int[] t,int clave){
        int contador = 0;
        while (contador<t.length && t[contador] != clave){
            contador++;
        }
        return contador<t.length ? contador : -1;
    }

    // Busca todos los nuemeros del array
    // Devuelve un array con los indices de los números
    public static int[] buscarTodos (int[] array,int clave){
        int[] indicesEncontrados = new int[1];
        int posicion = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == clave){
                indicesEncontrados[posicion] = i;
                indicesEncontrados = Arrays.copyOf(indicesEncontrados,indicesEncontrados.length+1);
                posicion++;
            }
        }
        indicesEncontrados = Arrays.copyOf(indicesEncontrados,indicesEncontrados.length-1);
        return indicesEncontrados;
    }

    // Desordena aleatoriamente el array
    public static void desordenar(int[] array){
        for (int i=0; i<array.length; i++) {
            int posAleatoria = (int) (Math.random()*array.length);
            int temp = array[i];
            array[i] = array[posAleatoria];
            array[posAleatoria] = temp;
        }
    }


}
