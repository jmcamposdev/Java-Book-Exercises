package unit13.Actividad27_Aplicacion;


public class Jugador {
    private final String dni;
    private String nombre;
    private PosicionCampo posicion;
    private double estatura;

    public Jugador(String dni, String nombre,  double estatura ,PosicionCampo posicion) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (estatura <= 0) {
            throw new IllegalArgumentException("La estatura no puede ser negativa");
        }

        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PosicionCampo getPosicion() {
        return posicion;
    }

    public void setPosicion(PosicionCampo posicion) {
        this.posicion = posicion;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
}
