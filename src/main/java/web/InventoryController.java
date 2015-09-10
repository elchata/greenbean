package web; 

import java.io.FileNotFoundException;  
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import auxiliares.DatosFacebook; 
import beans.BandaHoraria;
import beans.Carrito;
import beans.Categoria;
import beans.Ciudad;
import beans.Cliente;  
import beans.Empresa; 
import beans.Medida;
import beans.Partido;
import beans.Pedido;
import beans.Precio;
import beans.Producto;
import beans.Provincia;
import beans.User;
import service.ServiceManager;


@Controller
public class InventoryController {
    
    @Autowired
    private ServiceManager productManager;
    
    @Autowired
    private ServletContext context; 
    
    @Autowired
    public HttpSession session;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

    @RequestMapping(value="/hello.htm")
    public String printHello( ModelMap model ) throws FileNotFoundException {  
    	model.addAttribute("menu","menuAdmin.jsp");  
    	context.setAttribute("categorias", this.productManager.recuperarTodasCategorias());
    	session.setAttribute("carro", new Carrito());
    	model.addAttribute("vista","hello.jsp"); 
        return "frontend";
    }  
    
    //metodos para crear objetos y testear la bbdd
     
    public void creaEmp(){
    	Empresa aux=new Empresa("Facebook");
    	this.productManager.guardarEmpresa(aux);
    }  
    
    @RequestMapping(value="/cerrarSesion.htm")
    public String cerrarSesion(ModelMap model){    	
    	session.invalidate();
    	model.addAttribute("menu","menuAdmin.jsp");  
    	model.addAttribute("vista","hello.jsp"); 
    	return "redirect:hello.htm";
    }
    
    @RequestMapping(value="/rellenar.htm")
    public String completarBBDD(HttpServletRequest req, ModelMap model) { 
    	ArrayList<Precio> precios = new ArrayList<Precio>();
    	precios.add(new Precio(14));
    	ArrayList<Categoria> categos = new ArrayList<Categoria>();
    	categos.add(this.productManager.guardarCategoria(new Categoria("caramelos")));
    	this.productManager.guardarCiudad(new Ciudad("San fernando", 1425, 
    			this.productManager.guardarPartido(new Partido("Del valle", 
    					this.productManager.guardarProvincia(new Provincia("Catamarca")))
    			), 10));
    	this.productManager.guardarProducto(new Producto(
    			"caramelo", 
    			this.productManager.guardarMedida(new Medida("unidad", "unit")),
    			precios,
    			10,
    			"comadrejas",
    			true,
    			categos));
    	this.productManager.guardarBanda(new BandaHoraria(new Time(9,0,2), new Time(12,0,2), true));
    	return "redirect:hello.htm";
    }
    
    @RequestMapping(value="/regist.htm")
    public String registrar(HttpServletRequest req, ModelMap model) { 
		String val = req.getParameter("id");
		Long idUser = this.productManager.existeUser(val);
		if (idUser != null ) {
			this.iniciarSesion(idUser);
			return "redirect:hello.htm";
		}
		else {
			DatosFacebook datos = new DatosFacebook();
			datos.setId(val);
			model.addAttribute("datosFace",datos);
			return "registrar";
		} 
    } 
    
    public void iniciarSesion(long id){
    	
    	Cliente cli = (Cliente) this.productManager.darCliente(id);
    	Carrito carro = (Carrito) session.getAttribute("carro");
    	if (carro != null && carro.getProductos().size() > 0 ) {
    		Carrito miCar = cli.getCarrito();
    		miCar.setProductos(carro.getProductos());
    		miCar.setFecha(new Date());
    		this.productManager.guardarCarrito(miCar);
    	}    	
    	session.setAttribute("sesion", cli);
    	if (cli == null) {
    		User user = (User) this.productManager.darUser(id);
    		session.setAttribute("sesion", user); 
    	}
    }
    
    @RequestMapping(value="/registro.htm" , method = RequestMethod.POST)
    public String registrar(@ModelAttribute("datosFace") DatosFacebook datos, ModelMap model) {  
		Cliente cli = new Cliente();
		Map<String,String> aux = new HashMap<String,String>();
		cli.setIdFacebook(datos.getId());
		aux.put("email", datos.getEmail());
		aux.put("nombre", datos.getNombre());
		aux.put("apellido", datos.getApellido());
		aux.put("faceNombre", datos.getFaceNombre());
		cli.setDatos(aux);
		Carrito carro = new Carrito();
		carro = this.productManager.guardarCarrito(carro);
		cli.setCarrito(carro);
		cli.setEmpresa(this.productManager.darEmpresaPorNombre("Facebook"));
		this.productManager.guardarCliente(cli);
    	return "redirect:hello.htm";
    }
    
    @RequestMapping(value="/login.htm")
    public String login(  ModelMap model) {     
    	return "loggin";
    }
    
    
    
    public void datosUser(){
    	Map<String,String> dato = new HashMap<String,String>();
    	dato.put("id","100003337804280"); 
    	dato.put("name","Juan Sequeira");
    	dato.put("birthday","01/02/1985");
    	dato.put("gender" , "male");
    	dato.put("link" ,"https://www.facebook.com/juansequeira");
    	dato.put("email" , "juansequeira@hotmail.com");
    	Cliente aux = (Cliente) this.productManager.darCliente(1);
    	aux.setDatos(dato);
    	this.productManager.guardarCliente(aux);
    	}
    public void creaPed(){
    	Pedido aux=new Pedido();
    	aux.setPrecioFinal(270.80);
    	Producto pr = this.productManager.darProducto((long) 1);
    	aux.getProductos().put(pr, 2);
    	aux.getProductos().put(this.productManager.darProducto((long) 2), 8);
    	aux.setCliente(this.productManager.darCliente((long) 1));
    	this.productManager.guardarPedido(aux);
    }      
}