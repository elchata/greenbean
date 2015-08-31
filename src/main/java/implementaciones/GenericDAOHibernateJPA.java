package implementaciones;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import daos.BaseGenericDAOS;
@Transactional

public class GenericDAOHibernateJPA<T> implements BaseGenericDAOS<T> {
	private EntityManager entityManager = null;
	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA(Class<T> entity) {
		persistentClass = entity;
	}
	@PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@Override
	@Transactional
	public T persistir(T entity) {
			this.getEntityManager().persist(entity);
			return entity;
	}
	@Override
	@Transactional
	public T actualizar(T entity) {
		T aux = this.getEntityManager().merge(entity);
		return aux;
	}
	
	@Override
	@Transactional
	public void borrar(long id) {
		T entity = this.getEntityManager().getReference(getPersistentClass(), id);
		this.borrar(entity);	
	}
	
	@Override
	@Transactional
	public T borrar(T entity) {
		this.getEntityManager().remove(getEntityManager().contains(entity) ? entity : getEntityManager().merge(entity));		
		return entity;
	}
	
	@Override
	public List<T> recuperarTodos() {
		@SuppressWarnings("unchecked")
		List<T> entity = this.getEntityManager().createQuery("select c from "+ getPersistentClass().getSimpleName()+" c").getResultList();
		return entity;
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	//retorna algun acierto o null
	@Override
	public T retornarPorNombre(String nombre) {
		Query consulta= this.getEntityManager().createQuery("select c from "+ getPersistentClass().getSimpleName() +" c where c.nombre=?");
		consulta.setParameter(1,nombre);
		try{
			@SuppressWarnings("unchecked")
			T entity = (T) consulta.getSingleResult();
			return entity;
		}
		catch(NoResultException nre){
			return null;
		}
	}
	@Override
	public T retornarPorId(Long id) {
		Query consulta= this.getEntityManager().createQuery("select c from "+ getPersistentClass().getSimpleName() +" c where c.id=?");
		consulta.setParameter(1,id);
		try{
			@SuppressWarnings("unchecked")
			T entity = (T) consulta.getSingleResult();
			return entity;
		}
		catch(NoResultException nre){
			return null;
		}
	}
}
