package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.Cliente;
import service.ServiceManager;

public class AdministradorController {

  	@Autowired
    private ServiceManager productManager;
  	
    public void setProductManager(ServiceManager productManager) {
        this.productManager = productManager;
    }    
    
	@RequestMapping(value="/ver.htm")
	public String mostrarAdmins(ModelMap model) { 
	    model.addAttribute("admins",this.productManager.darAdmins()); 
	    model.addAttribute("vista","ABMadmins.jsp");
	    return "frontend";
	}
	
}
