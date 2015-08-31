package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "provincia")
public class Provincia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idProvincia;
	private String nombre;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProvincia", unique = true, nullable = false)
	public Long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	 public boolean equals (Object obj) {

      if (obj instanceof Provincia) {
          Provincia tmpProd = (Provincia) obj;
          if (this.getNombre().equals(tmpProd.getNombre()) ) {
              return true; } 
          else { return false; }

      }  else { return false; }
  } // Cierre del método equals 
	
	@Override
	public int hashCode(){
		return this.getIdProvincia().intValue();
	}
	

}
