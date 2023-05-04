package unit07.Actividad18_Aplicacion;

/*
    Crea una clase que sea capaz de mostrar el importe de un cambio, por ejemplo
    al realizar una compra, con el menor número de monedas y billetes posible.
 */
public class Importe {
    double importe;
    double[] monedas = {2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};
    int[] billetes = {500, 200, 100, 50, 20, 10, 5};

    public Importe(double importe) {
        this.importe = importe;
    }

    public Importe() {
        this(0);
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void addImporte(double importe) {
        this.importe += importe;
    }

    public void removeImporte(double importe) {
        if (this.importe - importe > 0) {
            this.importe -= importe;
        }
    }

    /**
     * Calcula el cambio en billetes y monedas
     * @return Devuelve un array de enteros con el número de billetes y monedas
     * necesarios para devolver el cambio de la cantidad indicada.
     */
    public int[] cambio() {
        int[] cambio = new int[monedas.length + billetes.length];
        int i = 0;
        // Primero calculamos los billetes
        while (i < billetes.length) {
            cambio[i] = (int) (importe / billetes[i]);
            importe -= cambio[i] * billetes[i];
            i++;
        }
        // Ahora calculamos las monedas
        while (i < cambio.length) {
            cambio[i] = (int) (importe / monedas[i - billetes.length]);
            importe -= cambio[i] * monedas[i - billetes.length];
            i++;
        }
        return cambio;
    }
}
