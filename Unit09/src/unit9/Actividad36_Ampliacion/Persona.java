package unit9.Actividad36_Ampliacion;

public class Persona implements Cliente, Empleado{
    private final String dni;
    private String nombre;
    private boolean esCliente;
    private boolean esEmpleado;
    private double saldo;
    private int horasTrabajadas;

    public Persona(String dni, String nombre, boolean esCliente, boolean esEmpleado) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El dni no puede ser nulo o vacío");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.esCliente = esCliente;
        this.esEmpleado = esEmpleado;
    }

    @Override
    public double getSaldo() {
        if (!esCliente) {
            throw new IllegalStateException("La persona no es cliente");
        }

        return saldo;
    }

    @Override
    public void setSaldo(double saldo) {
        if (!esCliente) {
            throw new IllegalStateException("La persona no es cliente");
        }

        this.saldo = saldo;
    }

    @Override
    public int getHorasTrabajadas() {
        if (!esEmpleado) {
            throw new IllegalStateException("La persona no es empleado");
        }

        return horasTrabajadas;
    }

    @Override
    public void setHorasTrabajadas(int horasTrabajadas) {
        if (!esEmpleado) {
            throw new IllegalStateException("La persona no es empleado");
        }
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas trabajadas no pueden ser negativas");
        }

        this.horasTrabajadas = horasTrabajadas;

    }
}
