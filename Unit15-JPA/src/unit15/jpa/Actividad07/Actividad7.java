package unit15.jpa.Actividad07;

import Funciones.GetData;
import unit15.jpa.Actividad07.exceptions.NonexistentEntityException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
    Diseñar una pequeña aplicación que gestiona los libros (ISBN, título, autor y precio) de una
    biblioteca. El menú será:
    1. Nuevo libro (añade un nuevo libro a la biblioteca)
    2. Modification Libro (Excepto el ISBN)
    3. Informe de libro (Muestra los datos de un libro a partir de su ISBN)
    4. Eliminar libro (Elimina un libro a partir de su ISBN)
    5. Todos los libros (Muestra todos los libros de la biblioteca)
    6. Número de libros (Muestra el número de libros de la biblioteca)
    7. Salir

    La opción Todos los libros debe mostrar la información de todos los libros que exiten en la
    base de datos. Y la opción Número de libros mostrará cuantos libros hay en nuestra biblioteca

    Para hacer el ejercicio utiliza la técnica DAO que proporciona JPA
 */
public class Actividad7 {
    private static final int OPCION_NUEVO_LIBRO = 1;
    private static final int OPCION_MODIFICAR_LIBRO = 2;
    private static final int OPCION_INFORME_LIBRO = 3;
    private static final int OPCION_ELIMINAR_LIBRO = 4;
    private static final int OPCION_TODOS_LIBROS = 5;
    private static final int OPCION_NUMERO_LIBROS = 6;
    private static final int OPCION_SALIR = 7;
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libroPU");
        LibroJPA libroJPA = new LibroJPA(emf);
        boolean salir = false;
        int opcion;

        while (!salir) {
            mostrarMenu();
            opcion = GetData.getInt("Introduce una opción: ", 1, 7);
            switch (opcion) {
                case OPCION_NUEVO_LIBRO -> nuevoLibro(libroJPA);
                case OPCION_MODIFICAR_LIBRO -> modificarLibro(libroJPA);
                case OPCION_INFORME_LIBRO -> informeLibro(libroJPA);
                case OPCION_ELIMINAR_LIBRO -> eliminarLibro(libroJPA);
                case OPCION_TODOS_LIBROS -> libroJPA.findLibroEntities().forEach(System.out::println);
                case OPCION_NUMERO_LIBROS -> System.out.println("Número de libros: " + libroJPA.getLibroCount());
                case OPCION_SALIR -> salir = true;
                default -> System.out.println("Opción incorrecta");
            }
        }

    }

    private static void eliminarLibro(LibroJPA libroJPA) {
        String isbn = GetData.getString("Introduce el ISBN: ");
        Libro libro = libroJPA.findLibro(isbn);
        if (libro != null) {
            try {
                libroJPA.destroy(isbn);
                System.out.println("Libro eliminado");
            } catch (NonexistentEntityException e) {
                System.out.println("Error al eliminar el libro");
            }
        } else {
            System.out.println("No existe el libro");
        }
    }

    private static void informeLibro(LibroJPA libroJPA) {
        Libro libro = libroJPA.findLibro(GetData.getString("Introduce el ISBN: "));
        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("No existe el libro");
        }
    }

    private static void modificarLibro(LibroJPA libroJPA) {
        String isbn = GetData.getString("Introduce el ISBN: ");
        Libro libro = libroJPA.findLibro(isbn);
        int opcion;
        boolean salir = false;
        if (libro != null) {
            while (!salir) {
                mostrarMenuModificar();
                opcion = GetData.getInt("Introduce una opción: ", 1, 4);
                switch (opcion) {
                    case 1 -> {
                        String titulo = GetData.getString("Introduce el título: ");
                        libro.setTitulo(titulo);
                    }
                    case 2 -> {
                        String autor = GetData.getString("Introduce el autor: ");
                        libro.setAutor(autor);
                    }
                    case 3 -> {
                        double precio = GetData.getDouble("Introduce el precio: ");
                        libro.setPrecio(precio);
                    }
                    case 4 -> salir = true;
                    default -> System.out.println("Opción incorrecta");
                }
            }

            try {
                libroJPA.edit(libro);
                System.out.println("Libro modificado correctamente");
            } catch (Exception e) {
                System.out.println("Error al modificar el libro");
            }
        } else {
            System.out.println("El libro no existe");
        }
    }

    private static void nuevoLibro(LibroJPA libroJPA) {
        String isbn = GetData.getString("Introduce el ISBN: ");
        String titulo = GetData.getString("Introduce el título: ");
        String autor = GetData.getString("Introduce el autor: ");
        double precio = GetData.getDouble("Introduce el precio: ");
        Libro libro = new Libro(isbn, titulo, autor, precio);
        if (libroJPA.findLibro(isbn) == null) {
            libroJPA.create(libro);
            System.out.println("El libro añadido con exito");
        } else {
            System.out.println("El libro ya existe");
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                1. Nuevo libro
                2. Modification Libro
                3. Informe de libro
                4. Eliminar libro
                5. Todos los libros
                6. Número de libros
                7. Salir""");
    }

    private static void mostrarMenuModificar() {
        System.out.println("""
                1. Modificar título
                2. Modificar autor
                3. Modificar precio
                4. Salir""");
    }
}
