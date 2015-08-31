package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.MedidaDAO; 
import beans.Medida;

@Repository(value = "medidaModel")
public class MedidaDAOHibernateJPA extends GenericDAOHibernateJPA<Medida>  implements MedidaDAO {		
	
		public MedidaDAOHibernateJPA() {
			super(Medida.class);
		}

}