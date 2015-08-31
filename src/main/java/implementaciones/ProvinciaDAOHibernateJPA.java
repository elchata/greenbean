package implementaciones;

import org.springframework.stereotype.Repository;

import beans.Provincia;
import daos.ProvinciaDAO;

@Repository(value = "provinciaModel")
public class ProvinciaDAOHibernateJPA extends GenericDAOHibernateJPA<Provincia>
		implements ProvinciaDAO {

	public ProvinciaDAOHibernateJPA() {
		super(Provincia.class);
	} 
}
