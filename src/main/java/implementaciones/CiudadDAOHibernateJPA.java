package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.CiudadDAO; 
import beans.Ciudad;

@Repository(value = "ciudadModel")
public class CiudadDAOHibernateJPA extends GenericDAOHibernateJPA<Ciudad>  implements CiudadDAO {		
	
		public CiudadDAOHibernateJPA() {
			super(Ciudad.class);
		}

}