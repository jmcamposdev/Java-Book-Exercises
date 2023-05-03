package unit07.Actividad15_Aplicacion;

/*
    Escribe la clase MarcaPagina, que ayude a llevar el control de la lectura de un libro.
    Deberá disponer de métodos para incrementar la página leída, para obtener información de la
    última página que se ha leído y para comenzar desde el principio una nueva lectura del
    mismo libro.
 */
public class MarcaPagina {
    private int paginaActual;

    /**
     * Constructor por defecto
     */
    public MarcaPagina(){
        paginaActual = 0;
    }

    /**
     * Constructor con parametro
     * @param pagina Página actual del libro, debe ser mayor o igual a 0
     */
    public MarcaPagina(int pagina){
        if (pagina < 0) {
            throw new IllegalArgumentException("La pagina debe ser mayor o igual a 0");
        }

        this.paginaActual = pagina;
    }

    /**
     * Incrementa la página actual en 1
     */
    public void incrementarPagina(){
        paginaActual++;
    }

    /**
     * Decrementa la página actual en 1,
     * no decrementa si la página actual es 0
     */
    public void decrementarPagina(){
        if (paginaActual > 0)
            paginaActual--;
    }

    /**
     * Devuelve la página actual
     * @return Página actual
     */
    public int getPaginaActual(){
        return paginaActual;
    }

    /**
     * Establece la página actual
     * @param pagina Página actual, debe ser mayor o igual a 0
     */
    public void setPaginaActual(int pagina){
        if (pagina >= 0)
            paginaActual = pagina;
    }

    /**
     * Comienza la lectura desde el principio
     */
    public void comenzarLectura(){
        paginaActual = 0;
    }

    /**
     * Comienza la lectura desde la página indicada
     * @param pagina Página actual, debe ser mayor o igual a 0
     */
    public void comenzarLectura(int pagina){
        if (pagina >= 0)
            paginaActual = pagina;
    }

    /**
     * Muestra la página actual
     * @return Página actual
     */
    public String mostrarPagina(){
        return "Pagina actual: " + paginaActual;
    }

}
