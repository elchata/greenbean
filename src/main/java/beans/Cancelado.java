package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity; 

@Entity(name="cancelado")
public class Cancelado extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String motivo;
	
	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Cancelado(Estado estado, String motivo) {
		super(new Date());
		this.setAnterior(estado);
		this.motivo = motivo;
	}
	public Cancelado() {
		super();
	}
	
	

	
}
