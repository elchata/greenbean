package implementaciones;

import org.springframework.stereotype.Repository;

import daos.EstadoDAO;
import beans.Estado;
 

@Repository(value = "estadoModel")
public class EstadoDAOHibernateJPA extends GenericDAOHibernateJPA<Estado>  implements EstadoDAO {		
	
		public EstadoDAOHibernateJPA() {
			super(Estado.class);
		}

}