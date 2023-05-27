package unit15.jpa.Actividad14_Aplicacion;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="LlenadoDeposito.ultimoId",
            query="SELECT MAX(ll.id) FROM LlenadoDeposito ll")
public class LlenadoDeposito implements Serializable {
    @Id
    @GeneratedValue
    Integer id;
    Integer litros;
    String tipoCombustible;
    Double importe;

    public LlenadoDeposito(Integer litros, String tipoCombustible, Double importe) {
        this.litros = litros;
        this.tipoCombustible = tipoCombustible;
        this.importe = importe;
    }

    public LlenadoDeposito() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "LLenadoDeposito{" + "id=" + id + ", litros=" + litros + ", tipoCombustible=" + tipoCombustible + ", importe=" + importe + '}';
    }
    
    

}
