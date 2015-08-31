package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection; 
import javax.persistence.Entity;
import javax.persistence.FetchType;  
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany; 
import javax.persistence.OneToMany; 
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import auxiliares.ValueComparator;

@Entity
public class Cliente extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Direccion> direcciones = new ArrayList<Direccion>(0);
	private Map<Producto, Integer> visitas = new HashMap<Producto, Integer>();
	private List<Pedido> pedidos = new ArrayList<Pedido>(0);
	private Carrito carrito;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name="cliente_direccion",
		    joinColumns={@JoinColumn(name="idUser", referencedColumnName="idUser")},
		    inverseJoinColumns={@JoinColumn(name="idDireccion", referencedColumnName="idDireccion")})
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Producto, Integer> getVisitas() {
		return visitas;
	}
	public void setVisitas(Map<Producto, Integer> visitas) {
		this.visitas = visitas;
	}
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	@OneToOne
	@JoinColumn(name = "idContenedor")
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	@Override
	 public boolean equals (Object obj) {

      if (obj instanceof Cliente) {
          Cliente tmpClie = (Cliente) obj;
          if (this.getIdUser().equals(tmpClie.getIdUser())) {
              return true; } 
          else { return false; }

      }  else { return false; }
  } // Cierre del método equals 
	
	@Override
	public int hashCode(){
		return this.getIdUser().intValue();
	}
	
	//ordena el hashMap, de mayor a menor cantidad de visitas
	@Transient
	public TreeMap<Producto, Integer> getVisitasOrdenadas() {
		ValueComparator bvc =  new ValueComparator(this.getVisitas());
        TreeMap<Producto,Integer> sorted_map = new TreeMap<Producto,Integer>(bvc);
        sorted_map.putAll(this.getVisitas());
		return sorted_map;
	}
}
