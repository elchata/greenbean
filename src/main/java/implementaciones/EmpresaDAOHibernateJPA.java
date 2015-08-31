package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.EmpresaDAO; 
import beans.Empresa;

@Repository(value = "empresaModel")
public class EmpresaDAOHibernateJPA extends GenericDAOHibernateJPA<Empresa>  implements EmpresaDAO {		
	
		public EmpresaDAOHibernateJPA() {
			super(Empresa.class);
		}

}