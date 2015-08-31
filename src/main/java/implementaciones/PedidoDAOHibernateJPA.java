package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.PedidoDAO; 
import beans.Pedido;

@Repository(value = "pedidoModel")
public class PedidoDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido>  implements PedidoDAO {		
	
		public PedidoDAOHibernateJPA() {
			super(Pedido.class);
		}

}