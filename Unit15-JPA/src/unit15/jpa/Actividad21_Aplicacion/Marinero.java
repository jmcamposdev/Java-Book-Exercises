package unit15.jpa.Actividad21_Aplicacion;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Marinero")
@NamedQueries({
   @NamedQuery(name = "Marinero.findAll", query = "SELECT m FROM Marinero m"),
   @NamedQuery(name = "Marinero.findByNumMar", query = "SELECT m FROM Marinero m WHERE m.numMar = :numMar"),
   @NamedQuery(name = "Marinero.findByNombre", query = "SELECT m FROM Marinero m WHERE m.nombre = :nombre"),
   @NamedQuery(name = "Marinero.findByPuesto", query = "SELECT m FROM Marinero m WHERE m.puesto = :puesto"),
   @NamedQuery(name = "Marinero.findBySueldo", query = "SELECT m FROM Marinero m WHERE m.sueldo = :sueldo")})
public class Marinero implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @Basic(optional = false)
   @Column(name = "numMar")
   private Integer numMar;
   @Column(name = "nombre")
   private String nombre;
   @Column(name = "puesto")
   private String puesto;
   // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   @Column(name = "sueldo")
   private BigDecimal sueldo;
   @JoinColumn(name = "barco", referencedColumnName = "matricula")
   @ManyToOne
   private Barco barco;

   public Marinero() {
   }

   public Marinero(Integer numMar) {
      this.numMar = numMar;
   }

   public Integer getNumMar() {
      return numMar;
   }

   public void setNumMar(Integer numMar) {
      this.numMar = numMar;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getPuesto() {
      return puesto;
   }

   public void setPuesto(String puesto) {
      this.puesto = puesto;
   }

   public BigDecimal getSueldo() {
      return sueldo;
   }

   public void setSueldo(BigDecimal sueldo) {
      this.sueldo = sueldo;
   }

   public Barco getBarco() {
      return barco;
   }

   public void setBarco(Barco barco) {
      this.barco = barco;
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (numMar != null ? numMar.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof Marinero)) {
         return false;
      }
      Marinero other = (Marinero) object;
      if ((this.numMar == null && other.numMar != null) || (this.numMar != null && !this.numMar.equals(other.numMar))) {
         return false;
      }
      return true;
   }

  //modificamos el método toString()

   @Override
   public String toString() {
      return "Marinero{" + "numMar=" + numMar + ", nombre=" + nombre + 
         ", puesto=" + puesto + ", sueldo=" + sueldo + ", barco=" + barco + '}';
   }  
}
