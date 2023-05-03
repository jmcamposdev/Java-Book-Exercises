package unit06.Actividad20_Aplicacion;

import java.util.Scanner;

/*
    Escribe un programa que lea el título y el contenido de una página web. La aplicación generará
    por consola un documento HTML donde el título será un encabezado de primer nivel <h1> y el
    contenido será un párrafo <p>.
 */
public class Actividad20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String titulo, contenido;

        // Pedimos el título y el contenido
        System.out.print("Introduce el título: ");
        titulo = sc.nextLine();

        System.out.print("Introduce el contenido: ");
        contenido = sc.nextLine();

        // Mostramos el documento HTML
        System.out.printf("""
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>%s</title>
                </head>
                <body>
                    <h1>%s</h1>
                    <p>%s</p>
                </body>
                </html>
                """, titulo, titulo, contenido);
    }
}
