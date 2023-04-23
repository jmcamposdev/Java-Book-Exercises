package unit13.Actividad01;

/*
    Definir una interfaz funcional cuya función abstracta permita generar un saludo dirigido
    al objeto que se le pasa como parámetro. Implementar un saludo para nombres (Clase String) y otra para
    clientes (Clase Cliente). Aplicarla a varios casos de uso.
 */
public class Actividad1 {
    public static void main(String[] args) {
        Saludo<String> saludoNombre = (nombre) -> "Hola " + nombre;
        Saludo<Cliente> saludoCliente = (cliente) -> "Hola " + cliente.getNombre();

        System.out.println(saludoNombre.saludar("Juan"));
        System.out.println(saludoNombre.saludar("Pedro"));
        System.out.println(saludoCliente.saludar(new Cliente("Juan")));
    }
}
