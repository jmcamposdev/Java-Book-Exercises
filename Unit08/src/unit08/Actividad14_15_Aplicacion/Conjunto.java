package unit08.Actividad14_15_Aplicacion;

import unit08.Actividad09_10_Aplicacion.Lista;

/*
    Actividad 14
    Un conjunto es una objeto similar a las listas, capaz de guardar valores de un tipo determinado
    con la diferencia de que sus elementos no pueden estar repetidos. Escribe la clase Conjunto
    para entores heredando de lista y reimplementando los métodos de inserción para evitar las repeticiones

    Actividad 15
    Implementa el método equals() en la clase Conjunto. Dos conjuntos se consideran iguales si tienen
    los mismos elementos, no importa en qué orden.
 */
public class Conjunto extends Lista {
    public Conjunto(){
        super();
    }

    @Override
    public void addStart(Integer num){
        if (this.search(num) == -1){
            super.addStart(num);
        }
    }
    @Override
    public void add(int index, Integer num){
        if (this.search(num) == -1){
            super.add(index,num);
        }
    }



    @Override
    public void addFinal(Integer num){
        if (this.search(num) == -1){
            super.addFinal(num);
        }
    }

    @Override
    public void addFinal(Integer[] nums){
        for (Integer num : nums) {
            if (this.search(num) == -1){
                super.addFinal(num);
            }
        }
    }

    @Override
    public boolean equals(Object obj){
        boolean equals = true;
        if (obj instanceof Conjunto){
            Conjunto conjunto = (Conjunto) obj;
            if (this.numeroElementos() == conjunto.numeroElementos()){
                for (int i = 0; i < this.numeroElementos() && equals; i++) {
                    if (this.search(conjunto.get(i)) == -1){
                        equals = false;
                    }
                }
            }
        }
        return false;
    }


}
