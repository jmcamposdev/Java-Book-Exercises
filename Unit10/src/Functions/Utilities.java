package Functions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utilities {
    /**
     * Method that validates a number in a range.
     * between a minimum (included) and a maximum (excluded) value.
     * @param value The number to validate
     * @param minValue The minimum value (included).
     * @param maxValue The maximum value (excluded).
     * @return  It will return True if the value is within the range and False otherwise.
     */
    public static boolean validateRange (int value, int minValue, int maxValue) {
        return value >= minValue && value < maxValue;

    }

    /**
     * Method that validates if the number passed as a parameter is positive, excluding 0.
     * @param value The number to validate
     * @return It will return True if the number is positive and False otherwise
     */
    public static boolean validateNumberPositive (int value) {
        return value > 0;
    }

    /**
     * Method that validates if the String passed as parameter is not Empty or contains only white spaces.
     * @param str The String to validate
     * @return It will return True if the String is not Empty or contains only white spaces and False otherwise
     */
    public static boolean validateNotEmptyString (String str) {
        return !str.isBlank();
    }

    /**
     * Method that validates if a LocalDate is After than the other.
     * If are the same LocalDate it will return False.
     * @param localDateToValidate LocalDate to be validated
     * @param localDateBase LocalDate that localDateToValidate gets from reference to be compared
     * @return It will return True if the "localDateToValidate" is after the "localDateBase"
     * and False if "localDateToValidate" is equals or before than "localDateBase"
     */
    public static boolean validateLocaDateIsAfter (LocalDate localDateToValidate, LocalDate localDateBase) {
        return localDateToValidate.isAfter(localDateBase);
    }

    public static boolean validateLocaDateIsAfterOrEquals (LocalDate localDateToValidate, LocalDate localDateBase) {
        return localDateToValidate.isAfter(localDateBase) || localDateToValidate.equals(localDateBase);
    }

    /**
     * Method that generate a random number in a range, using Random Class.
     * @param minValue The minimum value (included)
     * @param maxValue The maximum value (included)
     * @return It will return a number between the minValue and the maxValue both inclusive.
     */
    public static int randomNumber (int minValue, int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue - minValue + 1) + 1;
    }

    /**
     * Method that calculate the Greatest common divisor in two numbers
     * @param num1 The first number
     * @param num2 The second number
     * @return It will return the Greatest common divisor in the two number;
     */
    public static int calculateMCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            return calculateMCD(num2, num1 % num2);
        }
    }

    /**
     * Method that calculate the Minimum with a Divider
     * @param num1 The first Number
     * @param num2 The second Number
     * @return It will return the Minimum with a Divider
     */
    public static int calcularMCM(int num1, int num2) {
        return (num1 * num2) / calculateMCD(num1, num2);
    }

    /**
     * Method that validate if the number passed has parameter is a Prime number
     * @param num The number to validate if is Prime
     * @return It will return True if is a Prime Number and False otherwise.
     */
    public static boolean isPrime(int num) {
        boolean isPrime = num > 1;
        for (int i = 2; i <= Math.sqrt(num) && isPrime; i++) {
            if (num % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    /**
     * Method that calculate the Factorial of the number passed has Parameter
     * @param num The number to calculate the Factorial
     * @return It will return the factorial of the number
     */
    public static int calculateFactorial(int num) {
        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }


    /*-----------------------
        Matrices
    -----------------------*/

    /**
     * This method creates a bidimensional array of integers with the specified number of rows and columns,
     * and fills it with random values within a given range.
     * @param row the number of rows of the array
     * @param column the number of columns of the array
     * @param min the minimum value of the range for the random numbers (included)
     * @param max the maximum value of the range for the random numbers (included)
     * @return A bidimensional array of integers with random values within the given range
     * @throws IllegalArgumentException if min is greater than max or if row or column is less than or equal to zero
     */
    public static int[][] createRandomMatrix(int row, int column, int min, int max) {
        int[][] matriz = new int[row][column];
        Random random = new Random();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matriz[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matriz;
    }

    /**
     * This method creates a bidimensional array of integers with the specified number of rows and columns,
     * and fills it with random values within a given range without repeating any value.
     * @param row the number of rows of the array
     * @param column the number of columns of the array
     * @param min the minimum value of the range for the random numbers
     * @param max the maximum value of the range for the random numbers
     * @return a bidimensional array of integers with random non-repeating values within the given range
     * @throws IllegalArgumentException if the range is not large enough to create the requested matrix,
     * or if row or column is less than or equal to zero
     */
    public static int[][] createNonRepeatingRandomMatrix(int row, int column, int min, int max) {
        if ((max - min + 1) * (max - min + 1) < row * column) {
            throw new IllegalArgumentException("El rango no es suficientemente grande para crear la matriz solicitada.");
        }
        int[][] matriz = new int[row][column];
        Set<Integer> numerosAleatorios = new HashSet<>();
        Random random = new Random();
        while (numerosAleatorios.size() < row * column) {
            numerosAleatorios.add(random.nextInt(max - min + 1) + min);
        }
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matriz[i][j] = (int) numerosAleatorios.toArray()[k++];
            }
        }
        return matriz;
    }


    /**
     * Returns a submatrix of the specified matrix.
     * @param matrix The matrix from which to extract the submatrix.
     * @param startRow the starting row index of the submatrix (inclusive).
     * @param endRow the ending row index of the submatrix (inclusive).
     * @param startCol the starting column index of the submatrix (inclusive).
     * @param endCol the ending column index of the submatrix (inclusive).
     * @return the submatrix of the specified matrix.
     * @throws IllegalArgumentException if the specified indices are out of range for the matrix.
     */
    public static int[][] createSubMatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol) {
        if (startRow < 0 || endRow >= matrix.length || startCol < 0 || endCol >= matrix[0].length) {
            throw new IllegalArgumentException("Los índices especificados están fuera del rango de la matriz.");
        }
        int[][] submatriz = new int[endRow - startRow + 1][endCol - startCol + 1];
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                submatriz[i - startRow][j - startCol] = matrix[i][j];
            }
        }
        return submatriz;
    }

    /**
     * Get the String of the matrix passed by parameter
     * @param matrix Matrix to Get the String.
     */
    public static String getMatrixString(int[][] matrix) {
        StringBuilder matrixString = new StringBuilder();
        for (int[] fila : matrix) {
            matrixString.append("| ").append(fila[0]);
            for (int j = 1; j < fila.length; j++) {
                matrixString.append(" | ").append(fila[j]);
            }
            matrixString.append(" |").append("-".repeat(matrix[0].length*4+1));
        }
        return matrixString.toString();
    }
    /**
     * Get the String of the matrix passed by parameter
     * @param matriz Matrix to Get the String.
     */
    public static void getMatrixString(String[][] matriz) {
        for (String[] fila : matriz) {
            System.out.print("| " + fila[0]);
            for (int j = 1; j < fila.length; j++) {
                System.out.print(" | " + fila[j]);
            }
            System.out.println(" |");
            System.out.println("-".repeat(matriz[0].length * 4 +1));
        }
    }
    //Método Torres de Hanoi Recursivo
    public static void Hanoi(int n, int origen,  int auxiliar, int destino){
        if(n==1){
            System.out.println("mover disco de " + origen + " a " + destino);
        }else{
            Hanoi(n-1, origen, destino, auxiliar);
            System.out.println("mover disco de "+ origen + " a " + destino);
            Hanoi(n-1, auxiliar, origen, destino);
        }
    }

    /**
     * Find the longest substring in a given string using the brute force technique.
     * @param str The string to search for the longest substring.
     * @return The longest substring found in the string.
     */
    public static String findLongestSubstring(String str) {
        String[] substrings = str.split(" ");
        String longestSubstring = "";
        for (String substring : substrings) {
            if (substring.length() > longestSubstring.length()) {
                longestSubstring = substring;
            }
        }
        return longestSubstring;
    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean areAnagrams (String str1, String str2) {
        boolean areAnagrams = str1.length() == str2.length();

        if (areAnagrams) {
            String[] characters = str1.split("");
            for (int i = 0; i < characters.length && areAnagrams; i++) {
                if (!str2.contains(characters[i])) {
                    areAnagrams = false;
                }
            }
        }
        return areAnagrams;
    }

    public static String[][] rotarMatriz(String[][] matriz) {
        int size = matriz.length;
        String[][] matrizNueva = new String[size][size];
        for(int i = 0, j = size - 1; i < size && j >= 0; i++, j--) {
            for(int k = 0; k < size; k++) {
                matrizNueva[k][j] = matriz[i][k];
            }
        }
        return matrizNueva;
    }

    public static void rotarArrayXVecesDerecha (int[] array, int x) {
        int[] backupArray = Arrays.copyOfRange(array,array.length-x,array.length);
        System.arraycopy(array,0,array,x,array.length-x);
        System.arraycopy(backupArray,0,array,0,x);
    }

    public static void rotarArrayXVecesIzquierda (int[] array, int x) {
        int[] backupArray = Arrays.copyOfRange(array,0,x);
        System.arraycopy(array,x,array,0,array.length-x);
        System.arraycopy(backupArray,0,array,array.length-x,x);
    }

    public static int[] searchMatriz (int[][] matriz, int valor) {
        boolean valueFound = false;
        int[] index = {-1,-1};
        for (int i = 0; i < matriz.length && !valueFound; i++) {
            for (int j = 0; j < matriz[i].length && !valueFound; j++) {
                if (matriz[i][j] == valor) {
                    index[0] = i;
                    index[1] = j;
                    valueFound = true;
                }
            }
        }
        return index;
    }

    public static int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo < hi) {
            int mid = lo + (hi-lo+1)/2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return nums[lo]==target?lo:-1;
    }

    public static boolean isJumpingNumber (int number) {
        boolean isJumpingNumber = true;

        while (number != 0 && isJumpingNumber) {
            int digit1 = number % 10;
            number = number / 10;

            if (number != 0) {
                int digit2 = number % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    isJumpingNumber = false;
                }
            }
        }
        return isJumpingNumber;
    }

    public static double sumarElementos(double... elementos){
        double sumaTotal=0.0;
        for(double x:elementos){
            sumaTotal+=x;
        }
        return sumaTotal;
    }
}
