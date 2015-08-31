package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "pedido")
public class Pedido {
	
	private Long idPedido;
	private double precioFinal;
	private Map<Producto,Integer> productos = new HashMap<Producto, Integer>();
	private Cliente cliente;
	private Direccion direccion;
	private Estado estado;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPedido", unique = true, nullable = false)
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	} 
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Producto, Integer> getProductos() {
		return productos;
	}
	public void setProductos(Map<Producto, Integer> productos) {
		this.productos = productos;
	}
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	@OneToOne(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name = "idEstado")
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Pedido(
			Cliente cliente, Nuevo estado) {
		super();
		this.precioFinal = cliente.getCarrito().getPrecio();
		this.productos = cliente.getCarrito().getProductos();
		this.cliente = cliente;
		this.estado = estado;
	}
	public Pedido(
			Cliente cliente) {
		super();
		this.precioFinal = cliente.getCarrito().getPrecio();
		this.productos = cliente.getCarrito().getProductos();
		this.cliente = cliente;
	}
	public Pedido() {
		super();
	}
	@OneToOne(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinColumn(name = "idDireccion")
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Transient
	private String auxString;

	public String getAuxString() {
		return auxString;
	}
	public void setAuxString(String auxString) {
		this.auxString = auxString;
	}
	
	
	
	/*
	@Transient
	private Long direccionaux=null ;
	
	@Transient
	public Long getDireccionaux(){
		return direccionaux;
	}
	@Transient
	public void setDireccionaux(Long auxMon) {
		this.direccionaux = auxMon;
	}
	*/
}
