package ttps.spring.impDaos;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;

@Repository
public class EspecieDAOHibernateJPA extends GenericDAOHibernateJPA<Especie> implements EspecieDAO {
	public EspecieDAOHibernateJPA() {
		super(Especie.class);
	}
	
	public Especie recuperarPorDescripcion(String descripcion) {
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() +" e WHERE e.descripcion='"+ descripcion+"'" );
	
		
		Especie resultado = (Especie) consulta.getSingleResult();
		return resultado;
	}	
}