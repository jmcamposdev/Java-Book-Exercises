package unit15.jpa.Actividad14_Aplicacion;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
   @NamedQuery(name="RepostajeNormal.importeTotal", 
               query="SELECT SUM(r.importe) FROM RepostajeNormal r"),
   @NamedQuery(name="RepostajeNormal.todos",
               query="SELECT r FROM RepostajeNormal r")
   })
public class RepostajeNormal implements Serializable {
    @Id
    @GeneratedValue
    protected Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaHora;
    protected Double importe;

    public RepostajeNormal(Date fechaHora, Double importe) {
        this.fechaHora = fechaHora;
        this.importe = importe;
    }

    public RepostajeNormal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "RepostajeNormal{" + "id=" + id + ", fechaHora=" + 
           fechaHora + ", importe=" + importe + '}';
    }
}
