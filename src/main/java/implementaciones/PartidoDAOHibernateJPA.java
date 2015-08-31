package implementaciones;

import org.springframework.stereotype.Repository;

import daos.PartidoDAO;
import beans.Partido;


@Repository(value = "partidoModel")
public class PartidoDAOHibernateJPA extends GenericDAOHibernateJPA<Partido>  implements PartidoDAO {	

	public PartidoDAOHibernateJPA() {
		super(Partido.class);
	}
}
