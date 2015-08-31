package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.PrecioDAO; 
import beans.Precio;

@Repository(value = "precioModel")
public class PrecioDAOHibernateJPA extends GenericDAOHibernateJPA<Precio>  implements PrecioDAO {		
	
		public PrecioDAOHibernateJPA() {
			super(Precio.class);
		}

}