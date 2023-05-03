package unit07.Actividad10.Maquinaria;

import tema7.Tren.Personal.Menanico;

public class Locomotora {
    String matricula;
    int potenciaMotor;
    int añoFabricacion;
    Menanico menanico;

    public Locomotora(String matricula, int potenciaMotor, int añoFabricacion, Menanico menanico) {
        this.matricula = matricula;
        this.potenciaMotor = potenciaMotor;
        this.añoFabricacion = añoFabricacion;
        this.menanico = menanico;
    }
}
