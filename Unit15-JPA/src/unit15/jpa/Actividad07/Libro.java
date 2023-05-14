package unit15.jpa.Actividad07;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "precio")
    private double precio;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, double precio) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Libro: " +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", precio=" + precio;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
