package unit08.Actividad11_Aplicacion;

import unit08.Actividad09_10_Aplicacion.Lista;

/*
    Diseña la clase Pila heredando de Lista (Ver Actividad Unidad 7 - 13)
 */
public class Pila extends Lista {

        // Constructor
        public Pila() {
            super();
        }

        // Métodos
        public void apilar(Integer dato) {
            this.addFinal(dato);
        }

        public Object desapilar() {
            Integer numeroEliminado = null;
            if (this.numeroElementos() != -1){
                numeroEliminado = this.removeInteger(this.numeroElementos()-1);
            }
            return numeroEliminado;
        }

        public boolean esVacia() {
            return this.numeroElementos() == 0;
        }


    @Override
    public String toString() {
        return super.toString();
    }
}
