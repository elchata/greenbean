package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="estado")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Estado implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idEstado;
	private Date fecha;
	private Estado anterior;
	private ArrayList<String> siguiente = new ArrayList<String>();
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEstado", unique = true, nullable = true)
	public Long getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Estado(Date fecha) {
		super();
		this.fecha = fecha;
	}	

	@OneToOne(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idEstado")
	public Estado getAnterior() {
		return anterior;
	}
	public void setAnterior(Estado anterior) {
		this.anterior = anterior;
	}
	public ArrayList<String> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(ArrayList<String> siguiente) {
		this.siguiente = siguiente;
	}
	public Estado(){
		
	}
	
}
