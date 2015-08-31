package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.BandaHoraria;
import service.ServiceManager;

@Controller
@RequestMapping(value="/banda")
public class BandaHorariaController {

	@Autowired
    private ServiceManager productManager;
	
	@RequestMapping(value="/ver.htm")
	public String mostrarBandas(ModelMap model) { 
	    model.addAttribute("bandas",this.productManager.darBandas()); 
	    model.addAttribute("vista","ABMbandas.jsp");
	    return "frontend";
	}

    @RequestMapping(value = "new.htm", method = RequestMethod.GET)
	public String nuevaBanda(ModelMap model) { 
	    model.addAttribute("command", new BandaHoraria());
		model.addAttribute("bandas",this.productManager.darBandas()); 
	    model.addAttribute("vista","editarBanda.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="editar.htm", method = RequestMethod.GET)
	public String verPedidos(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idBanda")); 
		model.addAttribute("bandas", this.productManager.darBandas());
	    model.addAttribute("command", this.productManager.darBanda(val));
	    model.addAttribute("vista","editarBanda.jsp");
	    return "frontend";
	}
    

    @RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
	public String eliminarBanda(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idBanda"));
		this.productManager.borrarBanda(val);			
	    model.addAttribute("bandas", this.productManager.darBandas());  
	    model.addAttribute("vista","ABMbandas.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value = "/create.htm", method = RequestMethod.POST)
	public String creaPedido(@ModelAttribute("banda") BandaHoraria banda, ModelMap model) { 
    	this.productManager.guardarBanda(banda);
	    model.addAttribute("bandas",this.productManager.darBandas()); 
	    model.addAttribute("vista","ABMbandas.jsp");
	    return "frontend";
	}
    
    @RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
	public String mostrarPedido(HttpServletRequest req, ModelMap model) { 
		Long val = Long.parseLong(req.getParameter("idBanda"));
	    model.addAttribute("banda", this.productManager.darBanda(val));  
	    model.addAttribute("vista","verBanda.jsp");
	    return "frontend";
	}
}
