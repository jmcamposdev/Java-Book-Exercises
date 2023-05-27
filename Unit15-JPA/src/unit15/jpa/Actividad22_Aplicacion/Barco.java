package codigo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Barco")
@NamedQueries({
   @NamedQuery(name = "Barco.findAll", query = "SELECT b FROM Barco b"),
   @NamedQuery(name = "Barco.findByMatricula", query = "SELECT b FROM Barco b WHERE b.matricula = :matricula"),
   @NamedQuery(name = "Barco.findByNombre", query = "SELECT b FROM Barco b WHERE b.nombre = :nombre"),
   @NamedQuery(name = "Barco.findByNacionalidad", query = "SELECT b FROM Barco b WHERE b.nacionalidad = :nacionalidad"),
   @NamedQuery(name = "Barco.findByCapacidadCarga", query = "SELECT b FROM Barco b WHERE b.capacidadCarga = :capacidadCarga"),
   @NamedQuery(name = "Barco.findByVela", query = "SELECT b FROM Barco b WHERE b.vela = :vela")})
public class Barco implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "matricula")
   private Integer matricula;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "nacionalidad")
   private String nacionalidad;
   @Column(name = "capacidadCarga")
   private Integer capacidadCarga;
   @Column(name = "vela")
   private Boolean vela;
   @OneToMany(mappedBy = "barco")
   private Collection<Marinero> marineroCollection;

   public Barco() {
   }

   public Barco(Integer matricula) {
      this.matricula = matricula;
   }

   public Integer getMatricula() {
      return matricula;
   }

   public void setMatricula(Integer matricula) {
      this.matricula = matricula;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getNacionalidad() {
      return nacionalidad;
   }

   public void setNacionalidad(String nacionalidad) {
      this.nacionalidad = nacionalidad;
   }

   public Integer getCapacidadCarga() {
      return capacidadCarga;
   }

   public void setCapacidadCarga(Integer capacidadCarga) {
      this.capacidadCarga = capacidadCarga;
   }

   public Boolean getVela() {
      return vela;
   }

   public void setVela(Boolean vela) {
      this.vela = vela;
   }

   public Collection<Marinero> getMarineroCollection() {
      return marineroCollection;
   }

   public void setMarineroCollection(Collection<Marinero> marineroCollection) {
      this.marineroCollection = marineroCollection;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (matricula != null ? matricula.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Barco)) {
         return false;
      }
      Barco other = (Barco) object;
      if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
         return false;
      }
      return true;
   }

   //modificamos el método toString() y lo adaptamos

   @Override
   public String toString() {
      return "Barco{" + "matricula=" + matricula + ", nombre=" + nombre + 
         ", nacionalidad=" + nacionalidad + ", capacidadCarga=" + capacidadCarga + 
         ", vela=" + vela + '}';
   }
   
}
