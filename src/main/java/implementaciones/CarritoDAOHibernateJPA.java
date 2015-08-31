package implementaciones;

import org.springframework.stereotype.Repository;

import daos.CarritoDAO;
import beans.Carrito;
  

@Repository(value = "carritoModel")
public class CarritoDAOHibernateJPA extends GenericDAOHibernateJPA<Carrito>  implements CarritoDAO {		
	
		public CarritoDAOHibernateJPA() {
			super(Carrito.class);
		}

}