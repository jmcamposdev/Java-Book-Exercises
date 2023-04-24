package unit13.Actividad07;

public class Entero {
    private final Integer valor;

    public Entero(Integer valor) {
        this.valor = valor;
    }

    public Entero siguiente() {
        return new Entero(valor + 1);
    }

    @Override
    public String toString() {
        return "Entero{" +
                "valor=" + valor +
                '}';
    }
}
