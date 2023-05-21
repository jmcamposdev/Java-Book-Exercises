package unit14.Actividad15_Aplicacion.DAO;

import java.util.List;

/**
 * Interfaz que define métodos abstractos para realizar
 * las operaciones CRUD (create, read, update and delete)
 * en objetos de tipo T.
 * DAO (Data Access Object)
 * @author josemaria
 */

public interface DAO<T> {
    /**
     * Lee un objeto de tipo T a partir del id.
     * @param id el ID del objeto a leer
     * @return el objeto de tipo T encontrado o null si no existe
     */
    T read (String id);

    /**
     * Lee todos los objetos de tipo T almacenados.
     * @return una lista con todos los objetos de tipo T encontrados
     */
    List<T> readAll();

    /**
     * Inserta un nuevo objeto de tipo T.
     * @param t el objeto de tipo T a insertar
     */
    void insert(T t);

    /**
     * Actualiza un objeto de tipo T.
     * @param t el objeto de tipo T a actualizar
     */
    void update(T t);

    /**
     * Elimina un objeto de tipo T.
     * @param t el objeto de tipo T a eliminar
     */
    void delete(T t);

}
