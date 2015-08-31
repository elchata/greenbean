package implementaciones;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import daos.ProductoDAO; 
import beans.Producto;

@Repository(value = "productoModel")
public class ProductoDAOHibernateJPA extends GenericDAOHibernateJPA<Producto>  implements ProductoDAO {		
	
		public ProductoDAOHibernateJPA() {
			super(Producto.class);
		}

		@Override
		public List<Producto> retornarTodosNombre(String valor) {
			Query consulta= this.getEntityManager().createQuery("select c from Producto c where c.nombre LIKE :x");
			consulta.setParameter("x", '%' + valor + '%'); 
			@SuppressWarnings("unchecked")
			List<Producto> entity = consulta.getResultList();
			return entity;
		}

}