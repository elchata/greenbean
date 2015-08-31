package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="enviado")
public class Enviado extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Enviado(Preparado preparado) {
		super(new Date());
		this.setAnterior(preparado);
		this.getSiguiente().add(Entregado.class.getName());
		this.getSiguiente().add(Cancelado.class.getName());
	}

	public Enviado() {
		super();
	}
	
	

}
