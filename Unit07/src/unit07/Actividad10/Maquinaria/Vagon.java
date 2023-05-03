package unit07.Actividad10.Maquinaria;

class Vagon {
    int idenficiacion;
    double cargaMaxima;
    double cargaActual;
    String tipoMercancia;

    public Vagon(int idenficiacion, double cargaMaxima, double cargaActual, String tipoMercancia) {
        this.idenficiacion = idenficiacion;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }
}
