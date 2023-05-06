package unit9.Actividad36_Ampliacion;

/*
    Implementar una aplicación para gestionar la información de los empleados y clientes de un banco.
    Teniendo en cuenta que un empleado puede ser cliente del banco y que un cliente puede ser empleado del banco.
    Para ello crear una única clase Persona que implemente las interfaces Cliente y Empleado. Para simplificar solo
    se van a tener en cuenta lso siguientes atributos:
        Empleado: número de horas trabajadas en el mes
        Cliente: saldo en su cuenta
        Comunes: DNI (inmutable una vez creado), nombre y dos booleanos que digan si es cliente y/o empleado

    Escribir un programa donde se crea un empleado que es cliente y se incremente su número de horas trabajadas y su saldo
    como cliente
 */
public class Main {
    public static void main(String[] args) {
        // Al crear el Objeto como Persona podemos acceder a los métodos de Cliente y Empleado
        // Si lo hiciéramos como Cliente o Empleado no podríamos acceder a los métodos de la otra interfaz
        Persona p1 = new Persona("12345678A", "Pepe", true, true);

        System.out.println("Datos por defecto:");
        System.out.println("Saldo: " + p1.getSaldo());
        System.out.println("Horas trabajadas: " + p1.getHorasTrabajadas());
        // Aumentamos el saldo del cliente
        p1.setSaldo(1000);

        // Aumentamos las horas trabajadas del empleado
        p1.setHorasTrabajadas(100);

        System.out.println("\nDatos modificados:");
        System.out.println("Saldo: " + p1.getSaldo());
        System.out.println("Horas trabajadas: " + p1.getHorasTrabajadas());
    }

}
