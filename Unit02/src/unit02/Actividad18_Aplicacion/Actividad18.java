package unit02.Actividad18_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que solicite al usuario un número comprendido entre 1 y 99.
    El programa debe mostrarlo con letras, por ejemplo para 56 se verá: cincuenta y seis.
 */
public class Actividad18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, decenas, unidades;

        // Pedimos el número
        System.out.print("Introduce un número entre 1 y 99: ");
        numero = sc.nextInt();

        decenas = numero / 10;
        unidades = numero % 10;

        switch (decenas) {
            case 1 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Diez");
                    case 1 -> System.out.println("Once");
                    case 2 -> System.out.println("Doce");
                    case 3 -> System.out.println("Trece");
                    case 4 -> System.out.println("Catorce");
                    case 5 -> System.out.println("Quince");
                    case 6 -> System.out.println("Dieciséis");
                    case 7 -> System.out.println("Diecisiete");
                    case 8 -> System.out.println("Dieciocho");
                    case 9 -> System.out.println("Diecinueve");
                }
            }
            case 2 ->{
                switch (unidades) {
                    case 0 -> System.out.println("Veinte");
                    case 1 -> System.out.println("Veintiuno");
                    case 2 -> System.out.println("Veintidós");
                    case 3 -> System.out.println("Veintitrés");
                    case 4 -> System.out.println("Veinticuatro");
                    case 5 -> System.out.println("Veinticinco");
                    case 6 -> System.out.println("Veintiséis");
                    case 7 -> System.out.println("Veintisiete");
                    case 8 -> System.out.println("Veintiocho");
                    case 9 -> System.out.println("Veintinueve");
                }
            }
            case 3 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Treinta");
                    case 1 -> System.out.println("Treinta y uno");
                    case 2 -> System.out.println("Treinta y dos");
                    case 3 -> System.out.println("Treinta y tres");
                    case 4 -> System.out.println("Treinta y cuatro");
                    case 5 -> System.out.println("Treinta y cinco");
                    case 6 -> System.out.println("Treinta y seis");
                    case 7 -> System.out.println("Treinta y siete");
                    case 8 -> System.out.println("Treinta y ocho");
                    case 9 -> System.out.println("Treinta y nueve");
                }
            }
            case 4 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Cuarenta");
                    case 1 -> System.out.println("Cuarenta y uno");
                    case 2 -> System.out.println("Cuarenta y dos");
                    case 3 -> System.out.println("Cuarenta y tres");
                    case 4 -> System.out.println("Cuarenta y cuatro");
                    case 5 -> System.out.println("Cuarenta y cinco");
                    case 6 -> System.out.println("Cuarenta y seis");
                    case 7 -> System.out.println("Cuarenta y siete");
                    case 8 -> System.out.println("Cuarenta y ocho");
                    case 9 -> System.out.println("Cuarenta y nueve");
                }
            }
            case 5 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Cincuenta");
                    case 1 -> System.out.println("Cincuenta y uno");
                    case 2 -> System.out.println("Cincuenta y dos");
                    case 3 -> System.out.println("Cincuenta y tres");
                    case 4 -> System.out.println("Cincuenta y cuatro");
                    case 5 -> System.out.println("Cincuenta y cinco");
                    case 6 -> System.out.println("Cincuenta y seis");
                    case 7 -> System.out.println("Cincuenta y siete");
                    case 8 -> System.out.println("Cincuenta y ocho");
                    case 9 -> System.out.println("Cincuenta y nueve");
                }
            }
            case 6 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Sesenta");
                    case 1 -> System.out.println("Sesenta y uno");
                    case 2 -> System.out.println("Sesenta y dos");
                    case 3 -> System.out.println("Sesenta y tres");
                    case 4 -> System.out.println("Sesenta y cuatro");
                    case 5 -> System.out.println("Sesenta y cinco");
                    case 6 -> System.out.println("Sesenta y seis");
                    case 7 -> System.out.println("Sesenta y siete");
                    case 8 -> System.out.println("Sesenta y ocho");
                    case 9 -> System.out.println("Sesenta y nueve");
                }
            }
            case 7 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Setenta");
                    case 1 -> System.out.println("Setenta y uno");
                    case 2 -> System.out.println("Setenta y dos");
                    case 3 -> System.out.println("Setenta y tres");
                    case 4 -> System.out.println("Setenta y cuatro");
                    case 5 -> System.out.println("Setenta y cinco");
                    case 6 -> System.out.println("Setenta y seis");
                    case 7 -> System.out.println("Setenta y siete");
                    case 8 -> System.out.println("Setenta y ocho");
                    case 9 -> System.out.println("Setenta y nueve");
                }
            }
            case 8 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Ochenta");
                    case 1 -> System.out.println("Ochenta y uno");
                    case 2 -> System.out.println("Ochenta y dos");
                    case 3 -> System.out.println("Ochenta y tres");
                    case 4 -> System.out.println("Ochenta y cuatro");
                    case 5 -> System.out.println("Ochenta y cinco");
                    case 6 -> System.out.println("Ochenta y seis");
                    case 7 -> System.out.println("Ochenta y siete");
                    case 8 -> System.out.println("Ochenta y ocho");
                    case 9 -> System.out.println("Ochenta y nueve");
                }
            }
            case 9 -> {
                switch (unidades) {
                    case 0 -> System.out.println("Noventa");
                    case 1 -> System.out.println("Noventa y uno");
                    case 2 -> System.out.println("Noventa y dos");
                    case 3 -> System.out.println("Noventa y tres");
                    case 4 -> System.out.println("Noventa y cuatro");
                    case 5 -> System.out.println("Noventa y cinco");
                    case 6 -> System.out.println("Noventa y seis");
                    case 7 -> System.out.println("Noventa y siete");
                    case 8 -> System.out.println("Noventa y ocho");
                    case 9 -> System.out.println("Noventa y nueve");
                }
            }
        }
    }
}
