package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.ClienteDAO; 
import beans.Cliente;

@Repository(value = "clienteModel")
public class ClienteDAOHibernateJPA extends GenericDAOHibernateJPA<Cliente>  implements ClienteDAO {		
	
		public ClienteDAOHibernateJPA() {
			super(Cliente.class);
		}

}