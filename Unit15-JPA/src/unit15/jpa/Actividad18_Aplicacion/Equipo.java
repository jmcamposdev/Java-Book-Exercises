package unit15.jpa.Actividad18_Aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Equipo implements Serializable {
    @Id
    @GeneratedValue
    private int nie; 
    private String nombre;
   
    @OneToMany(orphanRemoval = false) 
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        
        this.jugadores = new ArrayList<>();
    }

    public Equipo() {
        
    }

    
   
    public void addJugador(Jugador j) {
        jugadores.add(j);
    }
    
    
    public void quitaJugador(Jugador j) {
        jugadores.remove(j);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNie() {
        return nie;
    }

    public void setNie(int nie) {
        this.nie = nie;
    }

    
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "Equipo{" + "nie=" + nie + ", nombre=" + nombre + '}';
    }
}
