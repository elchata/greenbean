package beans; 

import javax.persistence.Entity; 
import javax.persistence.Transient;

@Entity
public class Canasto extends Contenedor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private byte[] imagen;
	private int descuento;
	private boolean activo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}  
	
	@Transient
	public double getPrecio(){
		double precio = super.getPrecio();
		return precio - (precio * descuento / 100);
	}
	
}
