package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager;
import beans.Ciudad;
import beans.Partido;


@Controller
@RequestMapping(value="/ciudad")
public class CiudadController {
	
	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    
    
    @RequestMapping(value="/ver.htm")
	public String mostrarCiudad(ModelMap model) { 
	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
	    model.addAttribute("vista","ABMciudades.jsp");
	    return "frontend";
	}	
    
    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
   	public String nuevaCiudad(ModelMap model) { 
   		model.addAttribute("ciudadForm", new Ciudad());
   		model.addAttribute("partidos",this.productManager.darPartidos()); 
   	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
   	    model.addAttribute("vista","editarCiudad.jsp");
   	    return "frontend";
   	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verCiudades(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCiu"));
		Ciudad ciu=  this.productManager.darCiudad(val);
   		model.addAttribute("ciudadForm",ciu);
   		model.addAttribute("partidos",this.productManager.darPartidos()); 
   	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
   	    model.addAttribute("vista","editarCiudad.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarCiudad(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCiu"));
		this.productManager.borrarCiudad(val);			
	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
	    model.addAttribute("vista","ABMciudades.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaCiudad(@ModelAttribute("ciudadForm") Ciudad ciu,@ModelAttribute("partidoForm") Partido part, ModelMap model)  {  
    	this.productManager.guardarCiudad(ciu);
	    model.addAttribute("ciudades",this.productManager.darCiudades()); 
	    model.addAttribute("vista","ABMciudades.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idCiu"));
	    model.addAttribute("ciudad", this.productManager.darCiudad(val));   
	    model.addAttribute("vista","verCiudad.jsp");
	    return "frontend";
	}
}
