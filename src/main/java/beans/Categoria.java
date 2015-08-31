package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn; 
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCategoria;
	private Categoria padre=null;
	private List<Categoria> hijos = new ArrayList<Categoria>(0);
	private String nombre;
	private byte[] imagen=null;
	private String descripcion;
	private boolean activo=true;
	private List<Producto> productos = new ArrayList<Producto>(0); 
	
	// auxiliar para enviar el idPadre al formulario, no se crea en la base de datos
	@Transient
	public Long aux=null ;
	@Transient
	public Long getAux(){
		return aux;
	}
	@Transient
	public void setAux(Long aux) {
		this.aux = aux;
	}
	
	@Transient
	private File auxImagen=null;  
	
	@Transient
	public File getAuxImagen() {
		return auxImagen;
	}
	@Transient
	public void setAuxImagen(File auxImagen) {
		this.auxImagen = auxImagen;
	}
	//--------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCategoria", unique = true, nullable = false)
	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	@ManyToOne
	@JoinColumn(name = "idPadre")
	public Categoria getPadre() {
		return padre;
	}
	public void setPadre(Categoria padre) {
		this.padre = padre;
	}
	
	@OneToMany(mappedBy = "padre", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Categoria> getHijos() {
		return hijos;
	}
	public void setHijos(List<Categoria> hijos) {
		this.hijos = hijos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Lob
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	@ManyToMany(mappedBy="categorias", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}	

	public Categoria(String nom) {
		this.nombre=nom;
	}
	
	public Categoria(){
		
	}
	//----------------------------------------------
	
	public String toString(){
		return this.getNombre();
	} 
	@Override
	 public boolean equals (Object obj) {

        if (obj instanceof Categoria) {
            Categoria tmpCateg = (Categoria) obj;
            if (this.getNombre().equals(tmpCateg.getNombre()) ) {
                return true; } 
            else { return false; }

        }  else { return false; }
    } // Cierre del método equals
}
