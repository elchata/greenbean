package service;

 
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component; 

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
import daos.BandaHorariaDAO;
import daos.CarritoDAO;
import daos.CategoriaDAO;
import daos.CiudadDAO;
import daos.ClienteDAO;
import daos.ContenedorDAO;
import daos.DireccionDAO;
import daos.EmpresaDAO;
import daos.EstadoDAO;
import daos.MedidaDAO;
import daos.PartidoDAO;
import daos.PedidoDAO;
import daos.ProductoDAO; 
import daos.ProvinciaDAO;
import daos.UserDAO;

@Component
public class ImplementServiceManager implements ServiceManager {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductoDAO productoModel;
    
    @Autowired
    private ContenedorDAO contenedorModel;
    
    @Autowired
    private CarritoDAO carritoModel;
    
    @Autowired
    private CiudadDAO ciudadModel;
    
    @Autowired
    private DireccionDAO direccionModel;
    
    @Autowired
    private MedidaDAO medidaModel;
    
    @Autowired
    private EmpresaDAO empresaModel;
    
    @Autowired
    private PedidoDAO pedidoModel;
    
    @Autowired
    private ClienteDAO clienteModel;
  
    @Autowired
    private CategoriaDAO categoriaModel;
    
    @Autowired
    private UserDAO userModel;

    @Autowired
    private ProvinciaDAO provinciaModel;
    
    @Autowired
    private PartidoDAO partidoModel;
    
    @Autowired
    private BandaHorariaDAO bandaHorariaModel;
    

    @Autowired
    private EstadoDAO estadoModel;
	
	/*
	 * (non-Javadoc)
	 * LISTS
	 */
	
	@Override
	public List<Cliente> darClientes() {
		// TODO Auto-generated method stub
		return clienteModel.recuperarTodos();
	}
	

	@Override
	public List<Medida> darMedidas() {
		// TODO Auto-generated method stub
		return medidaModel.recuperarTodos();
	}


	@Override
	public List<Pedido> darPedidos() {
		return pedidoModel.recuperarTodos();
	}


	public List<Categoria> recuperarTodasCategorias() {
		return categoriaModel.recuperarTodos();
	}

	@Override
	public List<Producto> darProductos() {
		return productoModel.recuperarTodos();
	}

	@Override
	public List<Empresa> darEmpresas() {
		// TODO Auto-generated method stub
		return empresaModel.recuperarTodos();
	}

	@Override
	public List<Direccion> darDirecciones() {
		// TODO Auto-generated method stub
		return direccionModel.recuperarTodos();
	}
	

	@Override
	public List<Ciudad> darCiudades() {
		// TODO Auto-generated method stub
		return ciudadModel.recuperarTodos();
	}

	@Override
	public List<Provincia> darProvincias() {
		return provinciaModel.recuperarTodos();
	}
	
	@Override
	public List<Partido> darPartidos() {
		return partidoModel.recuperarTodos();
	}
	

	@Override
	public List<Producto> darProductos(String nombre) {
		
		return productoModel.retornarTodosNombre(nombre);
	}
	
	@Override
	public List<BandaHoraria> darBandas() {
		return bandaHorariaModel.recuperarTodos();
	}

	/*
	 * (non-Javadoc)
	 * DELETES
	 */
	
	@Override
	public void borrarCategoria(long idCat) {
		categoriaModel.borrar(idCat);		
	}

	@Override
	public Categoria borrarCategoria(Categoria cat) {
		// TODO Auto-generated method stub
		return categoriaModel.borrar(cat);
	}
	

	@Override
	public void borrarProducto(Long val) {
		productoModel.borrar(val);
		
	}

	
	@Override
	public void borrarMedida(Long val) {
		medidaModel.borrar(val);
		
	}


	@Override
	public void borrarCliente(Long val) {
		clienteModel.borrar(val);		
	}

	@Override
	public void borrarPedido(Long val) {
		pedidoModel.borrar(val);
		
	}
	
	@Override
	public void borrarDireccion(Long val) {
		direccionModel.borrar(val);		
	}


	@Override
	public void borrarProvincia(Long val) {
		provinciaModel.borrar(val);
	}


	@Override
	public void borrarPartido(Long val) {
		partidoModel.borrar(val);
	}
	
	@Override
	public void borrarBanda(Long val) {
		bandaHorariaModel.borrar(val);
	}

	@Override
	public void borrarCarrito(Long val) {
		carritoModel.borrar(val);
	}
	
	@Override
	public void borrarCiudad(Long val) {
		ciudadModel.borrar(val);		
	}
	
	/*
	 * (non-Javadoc)
	 * SETTERS
	 */
	
	@Override
	public void guardarCategoria(Categoria cat) {
		categoriaModel.actualizar(cat);		
	}
	
	@Override
	public void guardarMedida(Medida med) {
		medidaModel.actualizar(med);		
	}
	
	@Override
	public void guardarEmpresa(Empresa emp) {
		empresaModel.actualizar(emp);		
	}

	@Override
	public Carrito guardarCarrito(Carrito carrito) {
		return carritoModel.actualizar(carrito);		
	} 


	@Override
	public void guardarProducto(Producto prod) {
		productoModel.actualizar(prod);
		
	}
	

	@Override
	public void guardarPedido(Pedido aux) {
		this.pedidoModel.actualizar(aux);
		
	}
	

	@Override
	public Cliente guardarCliente(Cliente aux) {
		return this.clienteModel.actualizar(aux);
		
	}
	

	@Override
	public void guardarDireccion(Direccion dir) {
		direccionModel.actualizar(dir);
	}



	@Override
	public void guardarProvincia(Provincia prov) {
		provinciaModel.actualizar(prov);
	}
	

	@Override
	public void guardarPartido(Partido par) {
		partidoModel.actualizar(par);
		
	}
	
	@Override
	public void guardarBanda(BandaHoraria ban) {
		bandaHorariaModel.actualizar(ban);
		
	}
	
	@Override
	public void guardarCiudad(Ciudad ciu) {
		ciudadModel.actualizar(ciu);
	}

	@Override
	public Estado guardarEstado(Estado aux) {
		return estadoModel.actualizar(aux);
		
	}

	
	/*
	 * (non-Javadoc)
	 * GETTERS
	 */
	
	@Override
	public Categoria darCategoria(Long id) {
		return categoriaModel.retornarPorId(id);
	}
	
	@Override
	public Empresa darEmpresa(Long id) {
		return empresaModel.retornarPorId(id);
	}
	


	@Override
	public Pedido darPedido(Long l) {
		// TODO Auto-generated method stub
		return this.pedidoModel.retornarPorId(l);
	}


	@Override
	public Medida darMedida(Long l) {
		return medidaModel.retornarPorId(l);
	}

	@Override
	public Producto darProducto(Long l) {
		// TODO Auto-generated method stub
		return productoModel.retornarPorId(l);
	}


	@Override
	public Cliente darCliente(long l) {
		// TODO Auto-generated method stub
		return this.clienteModel.retornarPorId(l);
	} 
	
	@Override
	public Direccion darDireccion(Long val) {
		// TODO Auto-generated method stub
		return direccionModel.retornarPorId(val);
	}



	@Override
	public Ciudad darCiudad(long id) {
		// TODO Auto-generated method stub
		return ciudadModel.retornarPorId(id);
	}


	@Override
	public Provincia darProvincia(long l) {
		return provinciaModel.retornarPorId(l);
	}

	@Override
	public Partido darPartido(Long val) {
		return partidoModel.retornarPorId(val);
	}
	
	@Override
	public BandaHoraria darBanda(Long val) {
		return bandaHorariaModel.retornarPorId(val);
	}

	@Override
	public Contenedor guardarContenedor(Contenedor aux) {
		// TODO Auto-generated method stub
		return contenedorModel.actualizar(aux);
	}
	
	/*
	 * (non-Javadoc)
	 * OTHERS
	 */
	
	public byte[] subirFoto(File file) throws FileNotFoundException { 
    	@SuppressWarnings("resource")
		FileInputStream fis = new FileInputStream(file); 
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) { 
                bos.write(buf, 0, readNum); 
            }
        } catch (IOException ex) {
        }
        byte[] bytes = bos.toByteArray(); 
        return bytes;
    }


	@Override
	public Long existeUser(String id) { 
		return userModel.retornarPorIdFacebook(id);
	}


	@Override
	public User darUser(long id) { 
		return userModel.retornarPorId(id);
	}

	@Override
	public Empresa darEmpresaPorNombre(String string) {
		// TODO Auto-generated method stub
		return empresaModel.retornarPorNombre(string);
	}


	



}
