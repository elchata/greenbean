package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCiudad;
	private String nombre;
	private int codPost;
	private Partido partido;
	private double costoEnvio;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCiudad", unique = true, nullable = false)
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodPost() {
		return codPost;
	}
	public void setCodPost(int codPost) {
		this.codPost = codPost;
	}
	
	@ManyToOne
	@JoinColumn(name = "idPartido")
	public Partido getPartido() {
		return partido;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	public double getCostoEnvio() {
		return costoEnvio;
	}
	public void setCostoEnvio(double costoEnvio) {
		this.costoEnvio = costoEnvio;
	}

}
