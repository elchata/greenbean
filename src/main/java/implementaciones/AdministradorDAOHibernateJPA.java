package implementaciones;


import beans.Administrador;
import daos.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {

	public AdministradorDAOHibernateJPA() {
		super(Administrador.class);
	}

}
