package unit14.Funciones;

public class OperacionesArrayBidimensional {
    // Crea un array bidimensional aleatorio con n filas y n columnas
    public static int[][] crearArrayAleatorioBidimensional (int filas,int columnas,int maximo){
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) (Math.random()*maximo);
            }
        }
        return array;
    }

    // Crea un array bidimensional aleatorio con n filas y n columnas
    public static int[][] crearArrayAleatorioBidimensional (int filas,int columnas,int minimo,int maximo){
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (int) ((Math.random()*((maximo-minimo)+1))+minimo);
            }
        }
        return array;
    }

    public static int[][] crearArrayAleatorioBidimensionalSinRepetir (int filas,int columnas,int minimo,int maximo){
        boolean repetido = true;
        int numero;
        if (filas<=0 || columnas<= 0){
            throw new IllegalArgumentException("El array no puede tener 0 filas o columnas");
        }
        int[][] array = new int[filas][columnas];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                while (repetido){
                    numero =(int) ((Math.random()*((maximo-minimo)+1))+minimo);
                    for (int k = 0; k < array.length && repetido; k++) {
                        for (int l = 0; l < array[0].length && repetido; l++) {
                            repetido = numero == array[k][l];
                        }
                    }
                    array[i][j] = numero;
                }
                repetido = true;
            }
        }
        return array;
    }

    // Rellena el array bidimensional con elementos introducidos;
    public static int[][] cargarArrayBidimensionalTeclado(int filas, int columnas){
        if (filas<=0 || columnas<=0){
            throw new IllegalArgumentException("El valor de las filas o columnas no puede ser menor a 0");
        }
        int[][] array = new int[filas][columnas];
        int numero;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                numero = GetData.getInt("Ingrese un número: ");
                array[i][j] = numero;
            }
        }
        return array;
    }

    // Rellena el array bidimensional con elementos introducidos;
    public static int[][] cargarArrayBidimensionalTeclado(int filas, int columnas, int minimo, int maximo){
        if (filas<=0 || columnas<=0){
            throw new IllegalArgumentException("El valor de las filas o columnas no puede ser menor a 0");
        }
        int[][] array = new int[filas][columnas];
        int numero;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                numero = GetData.getInt("Ingrese un número: ",minimo,maximo);
                array[i][j] = numero;
            }
        }
        return array;
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

    public static int[][] traspuesta (int[][] array){
        int[][] traspuesta = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                traspuesta[j][i] = array[i][j];
            }
        }
        return traspuesta;
    }

    public static int[][] sumaMatrizes (int[][] array1, int[][] array2){
        if (array1.length != array2.length || array1[0].length != array2[0].length){
            throw new IllegalArgumentException("Las matrizes deben de ser iguales");
        }
        int[][] suma = new int[array1.length][array1[0].length];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[0].length; j++) {
                suma[i][j] = array1[i][j]+array2[i][j];
            }
        }
        return suma;
    }

    public static int[] sumaFilas (int[][] array){
        int[] sumaFilas = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                sumaFilas[i] += array[i][j];
            }
        }
        return sumaFilas;
    }

    public static int determinante (int[][] array){
        if (array.length!=3 || array[0].length!=3){
            throw new IllegalArgumentException("El array debe ser un 3x3");
        }

        return (array[0][0]*array[1][1]*array[2][2])+(array[0][1]*array[1][2]*array[0][2])+(array[1][0]*array[2][1]*array[0][2])-(array[0][2]*array[1][1]*array[0][1])-(array[0][1]*array[1][0]*array[2][2])-(array[1][2]*array[2][1]*array[0][0]);
    }
}
