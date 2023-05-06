package unit9.Actividad35_Ampliacion;

/*
    Las cartas formadas por un palo y un número son la base para muchos juegos de azar.
    Construir las clases necesarias que permitan ordenar una serie de cartas según el palo
    y el número o solamente por su número. Asimismo, como el azar es algo ligado a los
    juegos de cartas, implementar una clase Carta un método estático que construya y devuelva
    una carta al azar.
 */
public class Carta implements Comparable<Carta>{
    private Palo palo;
    private int numero;

    public Carta(Palo palo, int numero) {
        if (numero < 1 || numero > 12) {
            throw new IllegalArgumentException("El número de la carta debe estar entre 1 y 12");
        }

        this.palo = palo;
        this.numero = numero;
    }

    public Palo getPalo() {
        return palo;
    }
    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        if (numero >= 1 && numero <= 12) {
            this.numero = numero;
        }
    }

    public static Carta generarCartaAlAzar() {
        return new Carta(
                Palo.values()[(int) (Math.random() * Palo.values().length)],
                (int) (Math.random() * 12) + 1
        );
    }


    @Override
    public String toString() {
        return "Número: " + numero + " - Palo: " + palo;
    }

    @Override
    public int compareTo(Carta o) {
        return this.numero - o.numero;
    }
}
