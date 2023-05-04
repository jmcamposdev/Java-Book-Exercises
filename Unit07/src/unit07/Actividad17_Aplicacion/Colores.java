package unit07.Actividad17_Aplicacion;

/*
    En el moment de decorar una casa, una habitación o cualquier objeto, se plantea el problema de elegir
    la paleta de colores que vamos a utilizar en nuestra decoración. Existe una solución algo atrevida
    que consiste en utilizar colores al azar.

    Diseña la clase Colores que alberga por defecto una serie de colores (mediante una cadena) aunque es posible
    añadir tantos como necesitemos. La clase tendrá un método que devuelve una tabla con los n colores que
    necesitamos elegidos al azar sin repeticiones
 */
public class Colores {
    private String colores;
    private int nColores;

    public Colores () {
        colores = "azul rojo verde amarillo naranja rosa morado";
        nColores = 7;
    }

    public boolean addColor (String color) {
        boolean added = false;
        color = color.toLowerCase(); // Para evitar problemas con mayúsculas y minúsculas
        if (!colores.contains(color)) { // Si el color no está en la lista, lo añadimos
            colores += " " + color;
            nColores++;
            added = true;
        }

        return added;
    }

    public String[] coloresAleatorios (int n) {
        String[] coloresAleatorios = new String[n];
        String[] colores = this.colores.split(" ");
        int i = 0;
        while (i < n) {
            int random = (int) (Math.random() * this.nColores);
            if (colores[random] != null) {
                coloresAleatorios[i] = colores[random];
                colores[random] = null;
                i++;
            }
        }
        return coloresAleatorios;
    }
}
