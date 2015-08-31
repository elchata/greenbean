package implementaciones;

import org.springframework.stereotype.Repository;

import beans.BandaHoraria;
import daos.BandaHorariaDAO;

@Repository(value = "bandaHorariaModel")
public class BandaHorariaDAOHibernateJPA extends
		GenericDAOHibernateJPA<BandaHoraria> implements BandaHorariaDAO {

	public BandaHorariaDAOHibernateJPA() {
		super(BandaHoraria.class);
	}

}
