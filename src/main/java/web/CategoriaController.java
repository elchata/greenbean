package web; 

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.ServiceManager;
import beans.Categoria;  

@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {
	 
	  	@Autowired
	    private ServiceManager productManager;
	    
	    public void setProductManager(ServiceManager productManager) {
	        this.productManager = productManager;
	    }    

		@RequestMapping(value="/ver.htm")
		public String mostrarCategorias(ModelMap model) { 
		    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
		    model.addAttribute("menu","menuAdmin.jsp");
		    model.addAttribute("vista","ABMcategorias.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value = "/new.htm", method = RequestMethod.GET)
		public String nuevaCategorias(ModelMap model) { 
			model.addAttribute("command", new Categoria());
		    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias()); 
		    model.addAttribute("vista","editarCategoria.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value = "/create.htm", method = RequestMethod.POST)
		public String creaCategoria(@ModelAttribute("command") Categoria cat, ModelMap model) throws FileNotFoundException { 
			if (cat.getPadre().getIdCategoria() == 0) cat.setPadre(null);  
			if (cat.getAuxImagen().exists() != false) cat.setImagen(this.productManager.subirFoto(cat.getAuxImagen()));
			else {
				if (cat.getIdCategoria() != null) cat.setImagen(this.productManager.darCategoria(cat.getIdCategoria()).getImagen());
				else cat.setImagen(null);
			}
			this.productManager.guardarCategoria(cat);
		    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias()); 
		    model.addAttribute("vista","ABMcategorias.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value="/editar.htm", method = RequestMethod.GET)
		public String verCategorias(HttpServletRequest req, ModelMap model) { 
			Long val = Long.parseLong(req.getParameter("idCat"));
		    model.addAttribute("categorias",this.productManager.recuperarTodasCategorias());
		    model.addAttribute("command", this.productManager.darCategoria(val));  
		    model.addAttribute("vista","editarCategoria.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value="/eliminar.htm", method = RequestMethod.GET)
		public String eliminarCategoria(HttpServletRequest req, ModelMap model) { 
			Long val = Long.parseLong(req.getParameter("idCat"));
			this.productManager.borrarCategoria(val);			
		    model.addAttribute("categorias", this.productManager.recuperarTodasCategorias());  
		    model.addAttribute("vista","ABMcategorias.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value="/mostrar.htm", method = RequestMethod.GET)
		public String mostrarCategoria(HttpServletRequest req, ModelMap model) { 
			Long val = Long.parseLong(req.getParameter("idCat"));
		    model.addAttribute("categoria", this.productManager.darCategoria(val));  
		    model.addAttribute("vista","verCategoria.jsp");
		    return "frontend";
		}
		
		@RequestMapping(value="categoria/mostrarimagen.htm", method = RequestMethod.GET)
	    public void verFoto (HttpServletRequest req, ModelMap model, HttpServletResponse res) throws IOException { 
	    	Long val = Long.parseLong(req.getParameter("id"));
	    	Categoria categoria = this.productManager.darCategoria(val);
	    	
	    	byte[] imagen = categoria.getImagen();
	    	 try {
	    		 res.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    		 res.getOutputStream().write(imagen);
	    		 res.getOutputStream().close();
	    		 
	    	 } catch (Exception e) {
	    	        e.printStackTrace();
	    	 }
	    }
}