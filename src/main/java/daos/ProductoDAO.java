package daos;

import java.util.List;

import beans.Producto;

public interface ProductoDAO extends BaseGenericDAOS<Producto>{
	
	List<Producto> retornarTodosNombre(String valor);

}
