package implementaciones;


import org.springframework.stereotype.Repository;

import beans.Administrador;
import daos.AdministradorDAO;

@Repository(value = "administradorModel")
public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {

	public AdministradorDAOHibernateJPA() {
		super(Administrador.class);
	}

}
