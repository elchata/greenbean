package web; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager; 
import beans.Provincia;

@Controller
@RequestMapping(value="/provincia")
public class ProvinciaController {

	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarProvincias(ModelMap model) { 
	    model.addAttribute("provincias",this.productManager.darProvincias()); 
	    model.addAttribute("provinc", new Provincia());
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevaProvincia(ModelMap model) { 
		model.addAttribute("provinc", new Provincia());
		model.addAttribute("provincias",this.productManager.darProvincias()); 
	    model.addAttribute("vista","editarProvincia.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verProvincias(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv")); 
	    model.addAttribute("provinc", this.productManager.darProvincia(val));
	    return "editarProvincia";
	}
    

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarProvincia(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv"));
		this.productManager.borrarProvincia(val);			
	    model.addAttribute("provincias", this.productManager.darProvincias());  
	    model.addAttribute("provinc", new Provincia());  
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaProvincia(@ModelAttribute("provinc") Provincia prov, ModelMap model) { 
    	this.productManager.guardarProvincia(prov);
	    model.addAttribute("provincias",this.productManager.darProvincias()); 
	    model.addAttribute("provinc", new Provincia());
	    model.addAttribute("vista","ABMprovincias.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarProvincia(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idProv"));
	    model.addAttribute("provincia", this.productManager.darProvincia(val));  
	    model.addAttribute("vista","verProvincia.jsp");
	    return "frontend";
	}
}
