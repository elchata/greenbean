package web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;  
import java.util.HashSet;
import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import auxiliares.DatosCompra;
import auxiliares.DatosFormulario; 
import beans.Carrito;
import beans.Categoria;
import beans.Cliente; 
import beans.Precio;
import beans.Producto; 
import service.ServiceManager;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {
	
	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    
    
    @RequestMapping(value="ver.htm")
	public String mostrarProductos(ModelMap model) { 
    	model.addAttribute("prod", new Producto());
	    model.addAttribute("productos",this.productManager.darProductos()); 
	    model.addAttribute("vista","ABMproductos.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="buscar.htm", method = RequestMethod.GET)
	public String buscarProductos(ModelMap model) {  
    	model.addAttribute("find", new DatosFormulario());
	    model.addAttribute("vista","buscarProd.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="result.htm", method = RequestMethod.POST)
	public String resultProductos(HttpSession session,@ModelAttribute("find") DatosFormulario res,ModelMap model) {  
    	List<Producto> prods = this.productManager.darProductos(res.getNombre()); 
    	return this.listarProductos(session, model, prods);
	}
    
    @RequestMapping(value="filtro.htm", method = RequestMethod.GET)
	public String resultFiltro(HttpSession session,@RequestParam(value = "cat") Long cat,ModelMap model) {  
    	Categoria cate = this.productManager.darCategoria(cat);
    	List<Producto> prods = cate.getProductos();
    	HashSet<Producto> hs = new HashSet<Producto>();
    	for (Categoria m : cate.getHijos()) { 
            prods.addAll(m.getProductos());
    	}
    	// para que no halla duplicados. Cuando se elije una categoria padre, se muestra
    	// todos los productos de sus hijos y los productos q esten solo en la cat padre.
    	hs.addAll(prods);
    	prods.clear();
    	prods.addAll(hs);
    	return this.listarProductos(session, model, prods);
	}
    
    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevoProducto(ModelMap model) { 
		model.addAttribute("command", new Producto());
		model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
	    model.addAttribute("medidas",this.productManager.darMedidas());
	    model.addAttribute("productos",this.productManager.darProductos()); 
	    model.addAttribute("vista","editarProducto.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verProductos(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
	    model.addAttribute("productos",this.productManager.darProductos());
	    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
	    model.addAttribute("medidas",this.productManager.darMedidas());
	    model.addAttribute("command", this.productManager.darProducto(val));  
	    model.addAttribute("vista","editarProducto.jsp");
	    return "frontend";
	}

    @RequestMapping(value="producto/mostrarimagen.htm", method = RequestMethod.GET)
    public void verFoto (HttpServletRequest req, ModelMap model, HttpServletResponse res) throws IOException { 
    	if (!req.getParameter("id").equals("")){
    	Long val = Long.parseLong(req.getParameter("id"));
    	Producto producto = this.productManager.darProducto(val);
    	
    	byte[] imagen = producto.getImagen();
    	 try {
    		 res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
    		 res.getOutputStream().write(imagen);
    		 res.getOutputStream().close();
    		 
    	 } catch (Exception e) {
    	        e.printStackTrace();
    	 }
    	}
    }
    
    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
		this.productManager.borrarLogicoProducto(val);			
		return "redirect:ver.htm";
	}
    
    @RequestMapping(value="/cambiarActivo.htm", method = RequestMethod.GET)
	public String cambiarActivoProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
		this.productManager.cambioLogicoProducto(val);			
		return "redirect:ver.htm";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String crearProducto(@RequestParam("cates")String[] categs, @ModelAttribute("command") Producto prod, ModelMap model) throws FileNotFoundException { 
    	    
		if (prod.getAuxImagen().exists() != false) prod.setImagen(this.productManager.subirFoto(prod.getAuxImagen()));
		else {
			if (prod.getIdProducto() != null) prod.setImagen(this.productManager.darProducto(prod.getIdProducto()).getImagen());
			else prod.setImagen(null);
		}
		
		//agrega cada uno de los seleccionados en el checkbox y crea una lista nueva de categorias
		//reemplazando la que existia.
		
		List<Categoria> listaAuxiliar= new ArrayList<Categoria>(0);	
		for(String cat: categs){
			listaAuxiliar.add(this.productManager.darCategoria(Long.parseLong(cat)));
		}
		prod.setCategorias(listaAuxiliar);
		//-----------------------------------------------
		if ((prod.getPrecios().isEmpty()) || (prod.obtenerPrecio() != prod.getAuxMon()))
			prod.agregarPrecio(new Precio(prod.getAuxMon()));
		this.productManager.guardarProducto(prod);
		return "redirect:ver.htm";
	}
    
    @RequestMapping(value="mostrar.htm", method = RequestMethod.GET)
	public String mostrarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProd"));
	    model.addAttribute("producto", this.productManager.darProducto(val));
	    model.addAttribute("compra", new DatosCompra());
	    return "comprarProducto";
	} 
    
	public String listarProductos(HttpSession session,ModelMap model, List<Producto> prods) {  
		// ordena a los productos por nombre
		Collections.sort(prods, new Comparator<Producto>(){
			@Override
			public int compare(Producto o1, Producto o2) {
				return o1.getNombre().compareTo(o2.getNombre());
			}			
		});
		
    	model.addAttribute("productos", prods);
	    model.addAttribute("objForm", new DatosFormulario());
	    
	    // bean con los datos de producto y cantidad que luego son agregados al hashmap
	    
	    model.addAttribute("compra",new DatosCompra());
	    
	    //---------------------
	    
	    model.addAttribute("vista","listarProductos.jsp");
	    Cliente aux = (Cliente) session.getAttribute("sesion");
	    
	    if (aux != null && aux.getVisitasOrdenadas().size() > 0 )
	    	model.addAttribute("maximo", aux.getVisitasOrdenadas().firstKey()); 
	    return "frontend";
	}
    
    @RequestMapping(value="listar.htm", method = RequestMethod.GET)
	public String listarTodosProductos(HttpSession session,ModelMap model) {   
	    return this.listarProductos(session, model ,this.productManager.darProductosAListar());
	}
    @RequestMapping(value="agregarCarro.htm", method = RequestMethod.POST)
   	public String adicionarCompra(HttpSession session, @ModelAttribute("compra") DatosCompra compra, ModelMap model) {  
    	Cliente aux = (Cliente) session.getAttribute("sesion");
    	Producto prod = this.productManager.darProducto(compra.getIdProducto());
    	Carrito carro;
    	if (aux != null) carro = aux.getCarrito();
    	else carro = (Carrito) session.getAttribute("carro");
    	carro.getProductos().put(prod, compra.getCantidad());
    	carro.setFecha(new Date());
    	
    	if (aux != null){
    	// subir cantidad de visitas del cliente y del producto
    	int cant = 1;
    	if (aux.getVisitas().containsKey(prod)) cant = aux.getVisitas().get(prod) + 1;
    	aux.getVisitas().put(prod, cant);
    	aux.setCarrito(this.productManager.guardarCarrito(aux.getCarrito()));   
    	this.productManager.guardarCliente(aux);
    	// 
    	prod.getVisitas().put(aux, cant);
    	this.productManager.guardarProducto(prod);
    	}
    	else session.setAttribute("carro", carro);
    	
    	//++++++++++++++++++
    	 	
    	return "redirect:listar.htm";
   	}
    
    @RequestMapping(value="quitar.htm", method = RequestMethod.GET)
   	public String quitarCompra(HttpServletRequest req, HttpSession session, ModelMap model) {  
    	Cliente aux = (Cliente) session.getAttribute("sesion");
		Long val = Long.parseLong(req.getParameter("idKey"));
    	Producto prod = this.productManager.darProducto(val);
    	Carrito carro = aux.getCarrito();
    	carro.getProductos().remove(prod);
    	this.productManager.guardarCarrito(carro);
    	return "redirect:listar.htm";
   	}
    
    @RequestMapping(value="editarStock.htm", method = RequestMethod.GET)
   	public String cambiarStock(@RequestParam("idProd") Long val, ModelMap model) {  
   	    model.addAttribute("prod", this.productManager.darProducto(val));
   	    return "editStock";
   	}
    
    @RequestMapping(value="cambiarStock.htm", method = RequestMethod.POST)
   	public String changeStock(@ModelAttribute("prod") Producto prod, ModelMap model) {  
   	    Producto aux =this.productManager.darProducto(prod.getIdProducto());
   	    aux.setStock(prod.getStock());
   	    this.productManager.guardarProducto(aux);
   	    return "redirect:ver.htm";
   	}
       
}
