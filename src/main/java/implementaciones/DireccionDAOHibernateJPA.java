package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.DireccionDAO; 
import beans.Direccion;

@Repository(value = "direccionModel")
public class DireccionDAOHibernateJPA extends GenericDAOHibernateJPA<Direccion>  implements DireccionDAO {		
	
		public DireccionDAOHibernateJPA() {
			super(Direccion.class);
		}

}