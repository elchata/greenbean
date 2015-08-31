package implementaciones;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import daos.UserDAO; 
import beans.User;

@Repository(value = "userModel")
public class UserDAOHibernateJPA extends GenericDAOHibernateJPA<User>  implements UserDAO {		
	
		public UserDAOHibernateJPA() {
			super(User.class);
		}
		
		@Override
		public Long retornarPorIdFacebook(String id) {
			Query consulta= this.getEntityManager().createQuery("select c.idUser from User c where c.idFacebook=?");
			consulta.setParameter(1,id);
			try{
				long entity = (long) consulta.getSingleResult();
				return entity;
			}
			catch(NoResultException nre){
				return null;
			}
		}

}