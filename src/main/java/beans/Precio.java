package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "precio")
public class Precio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPrecio;
	private double monto;
	private Date fecha;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPrecio", unique = true, nullable = false)
	public Long getIdPrecio() {
		return idPrecio;
	}
	public void setIdPrecio(Long idPrecio) {
		this.idPrecio = idPrecio;
	}
	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Precio(double monto) {
		super();
		this.monto = monto;
		this.fecha = new Date();
	}	
	
	public Precio(){
		
	}
	
}
