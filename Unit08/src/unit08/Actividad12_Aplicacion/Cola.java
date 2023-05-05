package unit08.Actividad12_Aplicacion;

import unit08.Actividad09_10_Aplicacion.Lista;

/*
    Escribe la clase Cola heredando de Lista (Ver Actividad Unidad 7 - 22)
 */
public class Cola extends Lista {
    public Cola(){
        super();
    }

    public void encolar(Integer num){
        super.addFinal(num);
    }

    public Integer desencolar(){
        Integer numeroEliminado = null;
        if (super.numeroElementos()-1 != -1){
            numeroEliminado = super.removeInteger(0);
        }
        return numeroEliminado;
    }
}

