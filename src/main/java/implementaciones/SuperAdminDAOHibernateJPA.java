package implementaciones;


import org.springframework.stereotype.Repository;
 
import beans.SuperAdmin; 
import daos.SuperAdminDAO;

@Repository(value = "superAdminModel")
public class SuperAdminDAOHibernateJPA extends GenericDAOHibernateJPA<SuperAdmin> implements SuperAdminDAO {

	public SuperAdminDAOHibernateJPA() {
		super(SuperAdmin.class);
	}

}
