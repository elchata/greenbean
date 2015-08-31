package implementaciones;

import org.springframework.stereotype.Repository;

import daos.CategoriaDAO;
import beans.Categoria;

@Repository(value = "categoriaModel")
public class CategoriaDAOHibernateJPA extends GenericDAOHibernateJPA<Categoria>  implements CategoriaDAO {		
	
		public CategoriaDAOHibernateJPA() {
			super(Categoria.class);
		}

}