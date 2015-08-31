package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Partido;
import beans.Provincia;
import service.ServiceManager;

@Controller
@RequestMapping(value="/partido")
public class PartidoController {
	
	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    
    
    @RequestMapping(value="/ver.htm")
	public String mostrarPartido(ModelMap model) { 
	    model.addAttribute("partidos",this.productManager.darPartidos()); 
	    model.addAttribute("vista","ABMpartidos.jsp");
	    return "frontend";
	}	
    
    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
   	public String nuevoPartido(ModelMap model) { 
   		model.addAttribute("partidoForm", new Partido());
   		model.addAttribute("partidos",this.productManager.darPartidos()); 
   	    model.addAttribute("provincias",this.productManager.darProvincias()); 
   	    model.addAttribute("vista","editarPartido.jsp");
   	    return "frontend";
   	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verPartidos(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPar"));
		Partido par=  this.productManager.darPartido(val);
   		model.addAttribute("partidoForm",par);
   		model.addAttribute("partidos",this.productManager.darPartidos()); 
   	    model.addAttribute("provincias",this.productManager.darProvincias()); 
   	    model.addAttribute("vista","editarPartido.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarPartido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPar"));
		this.productManager.borrarPartido(val);			
	    model.addAttribute("partidos",this.productManager.darPartidos()); 
	    model.addAttribute("vista","ABMpartidos.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaPartido(@ModelAttribute("provinciaForm") Provincia prov,@ModelAttribute("partidoForm") Partido part, ModelMap model)  {  
    	
    	this.productManager.guardarPartido(part);
	    model.addAttribute("partidos",this.productManager.darPartidos()); 
	    model.addAttribute("vista","ABMpartidos.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idPar"));
	    model.addAttribute("partido", this.productManager.darPartido(val));   
	    model.addAttribute("vista","verPartido.jsp");
	    return "frontend";
	}
}
