package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "producto")
public class Producto implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private Long idProducto;
	private String nombre;
	private Medida medida;
	private byte[] imagen;
	private List<Precio> precios= new Stack<Precio>();
	private int stock;
	private String descripcion;
	private boolean activo=true;
	private Map<Cliente,Integer> visitas = new HashMap<Cliente,Integer>();
	private List<Descuento> descuentos = new Stack<Descuento>();
	private List<Categoria> categorias = new ArrayList<Categoria>(0);	
	private List<Pedido> ventas = new ArrayList<Pedido>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProducto", unique = true, nullable = false)
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    @ManyToOne
	@JoinColumn(name = "idMedida")
	public Medida getMedida() {
		return medida;
	}
    
	public void setMedida(Medida medida) {
		this.medida = medida;
	}
	
	@Lob
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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
	

	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name="producto_categoria",
		    joinColumns={@JoinColumn(name="idProducto", referencedColumnName="idProducto")},
		    inverseJoinColumns={@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")})
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@JoinTable(name="prod_pedido",
		joinColumns={
			@JoinColumn(name="idProducto", referencedColumnName="idProducto")
			},
		inverseJoinColumns={
			@JoinColumn(name="idPedido", referencedColumnName="idPedido")
			})
	@ManyToMany
	public List<Pedido> getVentas() {
		return ventas;
	}
	public void setVentas(List<Pedido> ventas) {
		this.ventas = ventas;
	}
	
	@OneToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Precio> getPrecios() {
		return precios;
	}
	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}	
	
	public void agregarPrecio(Precio precio){
		this.precios.add(precio);
	}
	
	public Producto(){
		
	}
	
	public Producto (String nombre, int stock){
		this.nombre=nombre;
		this.stock=stock;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Cliente,Integer> getVisitas() {
		return visitas;
	}
	public void setVisitas(Map<Cliente,Integer> visitas) {
		this.visitas = visitas;
	}
	
	public double obtenerPrecio(Date fecha){
		int i = 0;
		double monto;
		while (!this.precios.get(i).getFecha().before(fecha))
			i++;
		monto = this.precios.get(i).getMonto();
		return monto - (monto * this.getDescuento(fecha) / 100);
	}
	
	public double obtenerPrecio(){
		return this.precios.get(0).getMonto();
	}
	
	public void setDescuento(Descuento descuento){
		if (this.descuentos.get(0).getFechaFin() == null)
			this.descuentos.get(0).setFechaFin(new Date());
		this.descuentos.add(descuento);
	}

	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Descuento> getDescuentos() {
		return descuentos;
	}
	
	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}
	public int getDescuento(Date fecha){
		int i = 0;
		boolean ok = false;
		boolean found = false;
		while (!ok && (this.descuentos.size() > 0)){
			found = this.descuentos.get(i).getFechaInicio().after(fecha);
			ok = found | this.descuentos.size() == i+1;
			i++;
		}
		if (found)
			if (this.descuentos.get(i-1).getFechaFin().after(fecha))
				return this.descuentos.get(i-1).getPorcentaje();
		return 0;
	}
	
	@Transient
	private File auxImagen;  
	
	@Transient
	public File getAuxImagen() {
		return auxImagen;
	}
	@Transient
	public void setAuxImagen(File auxImagen) {
		this.auxImagen = auxImagen;
	}
	
	// para enviarle a los checkboxes de categorias
	@Transient
	private String[] categos;
	@Transient
	public String[] getCategos() {
		return categos;
	}
	@Transient
	public void setCategos(String[] categos) {
		this.categos = categos;
	}
	
	
	
	@Transient
	private Long auxMon=null ;
	@Transient
	public Long getAuxMon(){
		return auxMon;
	}
	@Transient
	public void setAuxMon(Long auxMon) {
		this.auxMon = auxMon;
	}
	
	@Override
	 public boolean equals (Object obj) {

       if (obj instanceof Producto) {
           Producto tmpProd = (Producto) obj;
           if (this.getNombre().equals(tmpProd.getNombre()) ) {
               return true; } 
           else { return false; }

       }  else { return false; }
   } // Cierre del método equals 
	
	@Override
	public int hashCode(){
		return this.getIdProducto().intValue();
	}
}
