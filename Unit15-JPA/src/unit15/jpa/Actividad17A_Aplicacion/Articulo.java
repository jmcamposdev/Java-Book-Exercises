
package unit15.jpa.Actividad17A_Aplicacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Articulo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private Integer año;
    private Integer numPalabras;

    public Articulo(String titulo, Integer año, Integer numPalabras) {
        this.titulo = titulo;
        this.año = año;
        this.numPalabras = numPalabras;
    }

    public Articulo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getNumPalabras() {
        return numPalabras;
    }

    public void setNumPalabras(Integer numPalabras) {
        this.numPalabras = numPalabras;
    }

    @Override
    public String toString() {
        return "Articulo{" + "id=" + id + ", titulo=" + titulo + 
               ", a\u00f1o=" + año + ", numPalabras=" + numPalabras + '}';
    }
}
