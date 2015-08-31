package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name="nuevo")
public class Nuevo extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String detalle;
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Nuevo() {
		super(new Date());
		this.setAnterior(null);
		this.getSiguiente().add(Confirmado.class.getName());
		this.getSiguiente().add(Cancelado.class.getName());
	}
	
	
	

}
