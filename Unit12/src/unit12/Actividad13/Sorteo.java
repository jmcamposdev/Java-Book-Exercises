package unit12.Actividad13;


import java.util.*;

public class Sorteo <T extends Comparable<T>> {
    private final Set<T> elementos;

    public Sorteo() {
        this.elementos = new TreeSet<>();
    }
    boolean add(T nuevo) {
        return elementos.add(nuevo);
    }

    Set<T> premiados (int numPremiados) {
        Set<T> premiados = null;
        List<T> temp = new ArrayList<>(elementos);
        Collections.shuffle(temp);
        if (numPremiados <= elementos.size()) {
            premiados = new TreeSet<>();
            for (int i = 0; i < numPremiados; i++) {
                premiados.add(temp.get(i));
            }
        }

        return premiados;
    }

    @Override
    public String toString() {
        return "Sorteo: " + elementos;
    }
}
