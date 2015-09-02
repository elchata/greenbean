package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity; 

@Entity(name="enviado")
public class Enviado extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enviado(Preparado preparado) {
		super(new Date());
		this.setAnterior(preparado);
		this.getSiguiente().add("Entregado");
		this.getSiguiente().add("Cancelado");
	}

	public Enviado() {
		super();
	}
	
	

}
