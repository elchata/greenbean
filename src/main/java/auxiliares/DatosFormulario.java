package auxiliares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import beans.Categoria;

public class DatosFormulario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Categoria> categos = new ArrayList<Categoria>(0);

	public List<Categoria> getCategos() {
		return categos;
	}

	public void setCategos(List<Categoria> categos) {
		this.categos = categos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
