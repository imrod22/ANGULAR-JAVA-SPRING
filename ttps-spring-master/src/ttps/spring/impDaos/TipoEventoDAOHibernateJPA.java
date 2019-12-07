package ttps.spring.impDaos;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;

@Repository
public class TipoEventoDAOHibernateJPA extends GenericDAOHibernateJPA<TipoEvento> implements TipoEventoDAO {
	public TipoEventoDAOHibernateJPA() {
		super(TipoEvento.class);
	}
	
	public TipoEvento recuperarPorDescripcion(String descripcion) {
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() +" e WHERE e.descripcion='"+ descripcion+"'" );	
		
		TipoEvento resultado = (TipoEvento) consulta.getSingleResult();
		return resultado;
	}	
}