package daos;

import beans.User;
  

public interface UserDAO extends BaseGenericDAOS<User>{
	
	Long retornarPorIdFacebook(String id);

}