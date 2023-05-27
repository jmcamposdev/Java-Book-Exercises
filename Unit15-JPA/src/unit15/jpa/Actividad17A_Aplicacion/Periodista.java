package unit15.jpa.Actividad17A_Aplicacion;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Periodista implements Serializable {
    private String nombre;
    @Id
    private String dni; //clave
    private String numTel;
    
    
    @OneToMany(cascade = CascadeType.ALL) 
    private List<Articulo> articulos;

    public Periodista(String nombre, String dni, String numTel) {
        this.nombre = nombre;
        this.dni = dni;
        this.numTel = numTel;
        this.articulos = new LinkedList<>(); 
    }

    public Periodista() {
    }

    
    public void addArticulo(Articulo a) {
        articulos.add(a);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    
    @Override
    
    public String toString() {
        return "Periodista{" + "nombre=" + nombre + ", dni=" + dni + ", numTel=" + numTel + '}';
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
