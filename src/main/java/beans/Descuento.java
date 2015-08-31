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
@Table(name = "descuento")
public class Descuento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int porcentaje;
	private Date fechaInicio;
	private Date fechaFin;
	
	private long idDescuento;
	
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idDescuento", unique = true, nullable = false)
	public long getIdDescuento() {
		return idDescuento;
	}
	public void setIdDescuento(long idDescuento) {
		this.idDescuento = idDescuento;
	}
	
	public Descuento(){		
	}
}
