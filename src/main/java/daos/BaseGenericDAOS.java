package daos;

import java.util.List;

public interface BaseGenericDAOS<T> {
	T actualizar(T entity) ;
	T persistir (T entity);
	List<T> recuperarTodos();
	T retornarPorNombre(String nombre);
	T retornarPorId(Long id);
	void borrar(long id);
	T borrar(T entity);
}
