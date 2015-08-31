package service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List; 

import beans.BandaHoraria;
import beans.Carrito;
import beans.Categoria;
import beans.Ciudad;
import beans.Cliente;
import beans.Contenedor;
import beans.Direccion;
import beans.Empresa;
import beans.Estado;
import beans.Medida;
import beans.Partido;
import beans.Pedido;
import beans.Producto; 
import beans.Provincia;
import beans.User;

public interface ServiceManager extends Serializable {
    
/*	GET	*/
	
	/* Listas */
	
    public List<Categoria> recuperarTodasCategorias();
    
    public List<Producto> darProductos();
    
    public List<Pedido> darPedidos();

    public List<Partido> darPartidos();
    
    public List<Provincia> darProvincias();

	public List<Cliente>  darClientes();
	
	public List<Medida> darMedidas();

	public List<Ciudad> darCiudades(); 

	public List<Direccion> darDirecciones();
	
	public List<Empresa> darEmpresas();
	
	public List<Producto> darProductos(String nombre);
	
	public List<BandaHoraria> darBandas();
	
	/* Individuos */ 

	public Medida darMedida(Long l);

	public Producto darProducto(Long l);

	public Pedido darPedido(Long l);
	
    public Categoria darCategoria(Long id);
    
   	public Empresa darEmpresa(Long id);
    
	public Cliente darCliente(long l);
	
	public Provincia darProvincia(long l);	

	public User darUser(long id);

	public Ciudad darCiudad(long auxCiu);

	public Direccion darDireccion(Long val);
	
    public Partido darPartido(Long val);
	
	public BandaHoraria darBanda(Long val);

	public Empresa darEmpresaPorNombre(String string);
    
/* POST */
    
    public void guardarCategoria(Categoria cat);
    
    public void guardarMedida(Medida medida);

	public void guardarEmpresa(Empresa emp);

	public void guardarProducto(Producto prod);
	
	public void guardarPedido(Pedido aux);
	
	public Estado guardarEstado(Estado aux);

	public Cliente guardarCliente(Cliente aux);
	
	public Contenedor guardarContenedor(Contenedor aux);
	
	public void guardarProvincia(Provincia prov);

	public void guardarDireccion(Direccion dir);

    public void guardarPartido(Partido par);
    
    public Carrito guardarCarrito(Carrito carrito);

	public void guardarBanda(BandaHoraria ban);

	public void guardarCiudad(Ciudad ciu);

/* DETELE */
	
	public void borrarProducto(Long val);

	public void borrarMedida(Long val);

	public void borrarCliente(Long val);

	public void borrarPedido(Long val); 
	
  	public void borrarCategoria (long idCat);
	
	public void borrarProvincia(Long val);
    
    public Categoria borrarCategoria (Categoria cat);

	public void borrarDireccion(Long val);
	
    public void borrarPartido(Long val);

	public void borrarBanda(Long val);

	public void borrarCarrito(Long val);
	
	public void borrarCiudad(Long val);
    
/* AUX */
    
	public byte[] subirFoto(File auxImagen) throws FileNotFoundException;
	
	public Long existeUser(String id);





}
