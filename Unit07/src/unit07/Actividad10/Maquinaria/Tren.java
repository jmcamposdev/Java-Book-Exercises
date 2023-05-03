package unit07.Actividad10.Maquinaria;

import unit07.Actividad10.Personal.Maquinista;

public class Tren {
    Locomotora locomotora;
    Maquinista maquinista;
    Vagon[] vagones;
    private int numeroDeVagones;

    public Tren(Locomotora locomotora, Maquinista maquinista, Vagon[] vagones) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagones = new Vagon[5];
        this.numeroDeVagones = 0;
    }

    public void engancharVagonVagon(double cargaMaxima, double cargaActual, String tipoMercancia){
        if (numeroDeVagones >= 5){
            System.out.println("El tren ya posee 5 vagones");
        } else {
            Vagon vagon = new Vagon(numeroDeVagones,cargaMaxima,cargaActual,tipoMercancia);
            vagones[numeroDeVagones] = vagon;
            numeroDeVagones++;
        }
    }

}
