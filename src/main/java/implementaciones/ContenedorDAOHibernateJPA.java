package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.ContenedorDAO; 
import beans.Contenedor;
  

@Repository(value = "contenedorModel")
public class ContenedorDAOHibernateJPA extends GenericDAOHibernateJPA<Contenedor>  implements ContenedorDAO {		
	
		public ContenedorDAOHibernateJPA() {
			super(Contenedor.class);
		}

}