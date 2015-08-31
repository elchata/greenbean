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
import auxiliares.DatosFacebook;
import beans.Cliente;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	

  	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarClientes(ModelMap model) { 
	    model.addAttribute("clientes",this.productManager.darClientes()); 
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value = "/new.htm", method = RequestMethod.GET)
	public String nuevoCliente(ModelMap model) { 
		model.addAttribute("command", new Cliente());
		model.addAttribute("empresas", this.productManager.darEmpresas()); 
	    model.addAttribute("vista","editarCliente.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaCliente(@ModelAttribute("command") Cliente cli, ModelMap model) { 
		cli.setEmpresa(this.productManager.darEmpresa(cli.getAuxEmp()));
		this.productManager.guardarCliente(cli);
	    model.addAttribute("clientes",this.productManager.darClientes()); 
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value = "/create2.htm", method = RequestMethod.POST)
	public String creaCliente2(HttpSession session,@ModelAttribute("datos") DatosFacebook datos, ModelMap model) { 
		Cliente cli=(Cliente) session.getAttribute("sesion");
		//se tendria q hacer un metodo al q se le pasa el obj DatosFacebook y lo llena
			Map<String,String> aux = new HashMap<String,String>(); 
			aux.put("email", datos.getEmail());
			aux.put("nombre", datos.getNombre());
			aux.put("apellido", datos.getApellido());
			aux.put("faceNombre", datos.getFaceNombre());
			cli.setDatos(aux); 
		this.productManager.guardarCliente(cli);
	    return "redirect:mostrar.htm?idCli=" + cli.getIdUser();
	}
	
	@RequestMapping(value="/editar.htm", method = RequestMethod.GET)
	public String verClientes(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
	    model.addAttribute("command", this.productManager.darCliente(val));  
	    model.addAttribute("empresas", this.productManager.darEmpresas()); 
	    model.addAttribute("vista","editarCliente.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarCliente(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
		this.productManager.borrarCliente(val);			
	    model.addAttribute("clientes", this.productManager.darClientes());  
	    model.addAttribute("vista","ABMclientes.jsp");
	    return "frontend";
	}
	
	@RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarCliente(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCli"));
	    model.addAttribute("cliente", this.productManager.darCliente(val)); 
	    model.addAttribute("datos",new DatosFacebook());
	    model.addAttribute("vista","verCliente.jsp");
	    return "frontend";
	}
	
	 @RequestMapping(value="editarDatos.htm", method = RequestMethod.GET)
		public String editarDatosPersonales(HttpServletRequest req, ModelMap model) { 
			Long val = Long.parseLong(req.getParameter("idCli"));
			Cliente cli = this.productManager.darCliente(val);	 
			DatosFacebook dato = new DatosFacebook();
		    model.addAttribute("cliente", cli);
		    model.addAttribute("datos", dato);
		    return "editarDatosPersonales";
		}
	 
} 