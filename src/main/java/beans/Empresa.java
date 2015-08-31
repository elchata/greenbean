package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idEmpresa;
	private String nombre;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEmpresa", unique = true, nullable = false)
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Empresa(String nombre) {
		
		this.nombre = nombre;
	}
	
	public Empresa() {
	}
	
}
