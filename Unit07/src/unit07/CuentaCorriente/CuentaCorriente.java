package unit07.CuentaCorriente;

/*
    7.1
    Diseña la clase CuentaCorriente, que almacena los datos: DNI y nombre del titular, así como el saldo.
    Las operaciones típicas con una cuenta corriente son:
    - CREAR UNA CUENTA: se necesita el DNI y nombre del titular. El saldo inicial será de 0-
    - SACAR DINERO: El método debe indicar si ha sido posible llevar a cabo la operación, si existe saldo suficiente.
    - INGRESAR DINERO: se incrementa el saldo.
    - MOSTRAR INFORMACIÓN: muestra la información disponible de la cuenta corriente.

    7.2
    Añadir sobrecarga al constructor para poder crear los siguientes objetos.
    - Con el DNI del titular de la cuenta y un saldo inicial.
    - Con el DNI, nombre y el saldo inicial.

    7.3
    Modifica la visibilidad de la clase CuentaCorriente para que sea visible desde clases externas
    y la visibilidad de sus atributos para que:
    - saldo no sea visible para otras clases
    - nombre sea público para cualquier clase.
    - dni solo sea visible po clases vecinas

    7.4
    Todas las cuentas corrientes con las que se va a trabajar pertenecen al mismo banco.
    Añadir un atributo que almacene el nombre del banco (que es único) en la clase CuentaCorriente
    Diseñar un método que permite recuperar y modificar el nombre del banco (al que pertenecen todas
    las cuentas corrientes)
 */

public class CuentaCorriente {
    private static String banco = "International Java Bank";
    String dni;
    public String nombre;
    private double saldo;
    Gestor gestor;

    public CuentaCorriente (String dni,String nombre){
        this(dni,nombre,0);
    }
    public CuentaCorriente(String dni,double saldo){
        this(dni,"Sin asignar",saldo);
    }
    public CuentaCorriente(String dni,String nombre,double saldo){
        this.dni = dni;
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public CuentaCorriente(String dni,String nombre,Gestor gestor){
        this(dni,nombre);
        this.gestor = gestor;
    }


    public boolean sacarDinero (double cantidadASacar){
        boolean operacionRealizada = false;
        if (saldo >= cantidadASacar){
            saldo -= cantidadASacar;
            operacionRealizada = true;
        } else {
            System.out.println("No se ha podido sacar el dinero");
        }
        return operacionRealizada;
    }

    public void ingresar (double cantidadAIngresar){
        saldo += cantidadAIngresar;
    }

    public void mostrarInformacion(){
        if (gestor == null){
            System.out.println("La cuente no tiene gestor");
        } else {
            System.out.println("Información del gestor:");
            System.out.println("Nombre: "+gestor.nombre);
            System.out.println("Telefono: "+gestor.getTelefono());
        }
        System.out.println("El titular es: "+nombre+" con DNI: "+dni);
        System.out.println("Posee: "+saldo);
    }

    public static void setBanco(String banco) {
        CuentaCorriente.banco = banco;
    }
    public static String getBanco() {
        return banco;
    }
}
