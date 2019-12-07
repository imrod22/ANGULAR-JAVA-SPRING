package ttps.spring.impDaos;

import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ttps.spring.daos.*;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class<T> persistentClass;
	
	private EntityManager entityManager;

	public GenericDAOHibernateJPA(Class<T> clase) {
		persistentClass = clase;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	@PersistenceContext
	 public void setEntityManager(EntityManager em)
	 {
		this.entityManager = em;
	 }
	 
	 public EntityManager getEntityManager() 
	 {
		 return entityManager;
	 }


	@Override
	public T persistir(T entity) {
		
		this.getEntityManager().persist(entity);
		
		return entity;
	}
	
	@Override
	public T actualizar(T entity) {
		
		T entityLocal = this.getEntityManager().merge(entity);
		
		return entityLocal;
	}

	@Override
	public void borrar(T entity) {
		
		this.getEntityManager().remove(entity);
	}
	
	@Override
	public T borrar(Serializable id) {

		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		
		if (entity != null) {
			this.borrar(entity);
		}
		return entity;
	}

	@Override
	public List<T> recuperarTodos(String columnOrder) {
		Query consulta= this.getEntityManager().createQuery("SELECT e FROM " + getPersistentClass().getName() + " e ");
		@SuppressWarnings("unchecked")
		List<T> resultado = (List<T>)consulta.getResultList();
		return resultado;
	}

	@Override
	public boolean existe(Serializable id) {
		
				String query ="SELECT "
						+ "CASE WHEN (count(e.id) > 0) THEN  true ELSE false END "
						+ "FROM "+ getPersistentClass().getName() +" e "
						+ "WHERE e.id = "+ id ;
				TypedQuery<Boolean> booleanQuery = this.getEntityManager().createQuery(query, Boolean.class);
				boolean exists = booleanQuery.getSingleResult();
				
				return exists;
	}

	@Override
	public T recuperar(Serializable id) {
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() +" e WHERE e.id="+ id );
	
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.getSingleResult();
		return resultado;
	}
	
	@Override
	public T recuperarPorNombreDescripcion(String campo, String valor)
	{
		
		
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() +" e WHERE e."+ campo  +"= '"+ valor +"'" );
	    
		@SuppressWarnings("unchecked")
		T resultado = (T) consulta.getSingleResult();
		return resultado;
	}
}