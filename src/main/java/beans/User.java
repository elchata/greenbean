package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column; 
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
@Table(name = "user")
public abstract class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idUser;
	private Empresa empresa;
	private Map<String,String> datos = new HashMap<String,String>();
	private String idFacebook;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUser", unique = true, nullable = false)
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	@ManyToOne
	@JoinColumn(name = "idEmpresa")
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<String, String> getDatos() {
		return datos;
	}
	public void setDatos(Map<String, String> datos) {
		this.datos = datos;
	}
	
	public String getIdFacebook() {
		return idFacebook;
	}
	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	} 
	
}
