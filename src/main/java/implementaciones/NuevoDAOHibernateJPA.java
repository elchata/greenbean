package implementaciones; 

import org.springframework.stereotype.Repository;

import daos.NuevoDAO; 
import beans.Nuevo; 

@Repository(value = "nuevoModel")
public class NuevoDAOHibernateJPA extends GenericDAOHibernateJPA<Nuevo>  implements NuevoDAO {		
	
		public NuevoDAOHibernateJPA() {
			super(Nuevo.class);
		} 

}