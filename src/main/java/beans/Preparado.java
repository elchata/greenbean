package beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="preparado")
public class Preparado extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] paquetes;
	
	public String[] getPaquetes() {
		return paquetes;
	}
	public void setPaquetes(String[] paquetes) {
		this.paquetes = paquetes;
	}
	public Preparado() {
		super();
	}
	public Preparado(Confirmado confirmado) {
		super(new Date());
		this.setAnterior(confirmado);
		this.getSiguiente().add(Enviado.class.getName());
		this.getSiguiente().add(Cancelado.class.getName());
	}

	
}
