package web; 

import java.util.HashMap; 
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager;  
import beans.Cancelado; 
import beans.Cliente;
import beans.Confirmado;
import beans.Entregado;
import beans.Enviado;
import beans.Estado;
import beans.Nuevo;
import beans.Pedido;
import beans.Preparado;
import beans.Producto; 

@Controller
@RequestMapping(value="/pedido")
public class PedidoController {

	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarPedidos(ModelMap model) { 
	    model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("command", new Pedido());
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/cambiarEstado.htm")
	public String avanzarPedido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPed"));
		Pedido ped = this.productManager.darPedido(val);
		model.addAttribute("command", ped); 
    	return "editar"+req.getParameter("nombre");
	}
    
    @RequestMapping(value = "miPedido.htm", method = RequestMethod.GET)
	public String nuevoPedidoMio(HttpServletRequest req, ModelMap model) { 
    	Long val = Long.parseLong(req.getParameter("idCli"));
    	Pedido ped = new Pedido();
    	ped.setEstado(new Nuevo());
    	ped.setCliente((Cliente)this.productManager.darCliente(val));
		model.addAttribute("command", ped);
		model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","editarPedido.jsp");
	    return "frontend";
	}

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProducto(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPed"));
		this.productManager.borrarPedido(val);			
	    model.addAttribute("pedidos", this.productManager.darPedidos());  
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaPedido(@ModelAttribute("command") Pedido ped, ModelMap model, HttpSession session) { 

    	Cliente aux = (Cliente) session.getAttribute("sesion");
    	
    	// no se envia x formulario la lista de productos, x lo tanto hay q volver a 
    	// sacarlas del carrito
    	
    	ped.setProductos(aux.getCarrito().getProductos());
    	
    	// renueva los stock de los productos involucrados en el pedido.
    	// faltaria en el caso q el stock no sea suficiente se avise mediante pantalla
    	    	
    	Map<Producto, Integer> map = ped.getProductos();
    	for (Map.Entry<Producto, Integer> entry : map.entrySet()) {
    	    Producto produc = entry.getKey();
    	    Integer cant = entry.getValue();
    	    System.out.println("CANTIDAD A DESCONTAR" + cant);
    	    produc.setStock(produc.getStock() - cant);
    	    System.out.println("CANTIDAD TOTAL" + produc.getStock());
    	    this.productManager.guardarProducto(produc); 
    	}

    	aux.getCarrito().setProductos(new HashMap<Producto, Integer>());
    	this.productManager.guardarCliente(aux);
    	Nuevo nuevo = new Nuevo();
    	nuevo.setDetalle(ped.getAuxString());
    	nuevo = (Nuevo) this.productManager.guardarEstado(nuevo);
    	ped.setEstado(nuevo);
    	this.productManager.guardarPedido(ped);
	    model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
	} 
    
    @RequestMapping(value = "/guardarConfirmado.htm", method = RequestMethod.POST)
	public String avanzaConfirmado(@ModelAttribute("command") Pedido ped, ModelMap model) { 
    	Confirmado estado = new Confirmado((Nuevo) ped.getEstado(), ped.getAuxString());
    	return this.avanzar(ped, model, estado);
	} 
    
    @RequestMapping(value = "/guardarCancelado.htm", method = RequestMethod.POST)
	public String avanzaCancelado(@ModelAttribute("command") Pedido ped, ModelMap model) { 
    	Cancelado estado = new Cancelado(ped.getEstado(), ped.getAuxString());
    	
    	// el pedido enviado x el command no tiene los productos asociados, hay 
    	// q ir a la bbdd a buscarlos.
    	ped = this.productManager.darPedido(ped.getIdPedido());
    	
    	// renueva los stock de los productos involucrados en el pedido.
    	
    	Map<Producto, Integer> map = ped.getProductos();
    	for (Map.Entry<Producto, Integer> entry : map.entrySet()) {
    	    Producto produc = entry.getKey();
    	    Integer cant = entry.getValue();
    	    produc.setStock(produc.getStock() + cant);
    	    this.productManager.guardarProducto(produc); 
    	}
    	return this.avanzar(ped, model, estado);
	} 
    
    @RequestMapping(value = "/guardarPreparado.htm", method = RequestMethod.POST)
	public String avanzaPreparado(@ModelAttribute("command") Pedido ped, ModelMap model) { 
    	Preparado estado = new Preparado((Confirmado) ped.getEstado());
    	return this.avanzar(ped, model, estado);
	} 
    
    @RequestMapping(value = "/guardarEnviado.htm", method = RequestMethod.POST)
	public String avanzaEnviado(@ModelAttribute("command") Pedido ped, ModelMap model) { 
    	Enviado estado = new Enviado((Preparado) ped.getEstado());
    	return this.avanzar(ped, model, estado);
	} 
    
    @RequestMapping(value = "/guardarEntregado.htm", method = RequestMethod.POST)
   	public String avanzaEntregado(@ModelAttribute("command") Pedido ped, ModelMap model) { 
    	Entregado estado = new Entregado((Enviado) ped.getEstado());
       	return this.avanzar(ped, model, estado);
   	} 
    
    private String avanzar(Pedido ped, ModelMap model, Estado estado){
    	ped.setEstado(this.productManager.guardarEstado(estado));
    	this.productManager.guardarPedido(ped);
	    model.addAttribute("pedidos",this.productManager.darPedidos()); 
	    model.addAttribute("vista","ABMpedidos.jsp");
	    return "frontend";
    }
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarPedido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPed"));
	    model.addAttribute("pedido", this.productManager.darPedido(val));  
	    model.addAttribute("vista","verPedido.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="confirmarCompra.htm", method = RequestMethod.GET)
    public String confirmarPedido ( ModelMap model, HttpSession session){
    	Cliente aux = (Cliente) session.getAttribute("sesion");
    	if (aux == null) return "redirect:../login.htm";
		Pedido nuevo = new Pedido(aux);
		model.addAttribute("command", nuevo);
		model.addAttribute("vista","editarPedido.jsp");
    	return "frontend";
    }
}
