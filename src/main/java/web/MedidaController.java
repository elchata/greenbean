package web; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Medida; 
import service.ServiceManager;

@Controller
@RequestMapping(value="/medida")
public class MedidaController {
	

  	@Autowired
    private ServiceManager productManager;
    
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    

	@RequestMapping(value="/ver.htm")
	public String mostrarMedidas(ModelMap model) { 
	    model.addAttribute("medidas",this.productManager.darMedidas()); 
	    model.addAttribute("vista","ABMmedidas.jsp");
	    return "frontend";
	}	

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevaMedida(ModelMap model) { 
		model.addAttribute("command", new Medida());
		model.addAttribute("medidas",this.productManager.darMedidas()); 
	    model.addAttribute("vista","editarMedida.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verMedidas(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idMed"));
	    model.addAttribute("medidas",this.productManager.darMedidas()); 
	    model.addAttribute("command", this.productManager.darMedida(val));  
	    model.addAttribute("vista","editarMedida.jsp");
	    return "frontend";
	}
    

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idMed"));
		this.productManager.borrarMedida(val);			
	    model.addAttribute("medidas", this.productManager.darMedidas());  
	    model.addAttribute("vista","ABMmedidas.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaMedida(@ModelAttribute("command") Medida med, ModelMap model)  { 
    	this.productManager.guardarMedida(med);
	    model.addAttribute("medidas",this.productManager.darMedidas()); 
	    model.addAttribute("vista","ABMmedidas.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarMedida(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idMed"));
	    model.addAttribute("medida", this.productManager.darMedida(val));  
	    model.addAttribute("vista","verMedida.jsp");
	    return "frontend";
	}

}
