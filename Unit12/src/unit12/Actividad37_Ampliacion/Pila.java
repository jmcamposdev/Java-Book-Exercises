package unit12.Actividad37_Ampliacion;

import java.util.ArrayList;

public class Pila<T> extends ArrayList<T> {

    public void push(T item) {
        this.add(item);
    }

    public T pop() {
        if (this.isEmpty()) {
            return null;
        }
        T item = this.get(this.size() - 1);
        this.remove(this.size() - 1);
        return item;
    }
}
