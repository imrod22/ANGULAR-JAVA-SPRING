package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class NombreCampoDAOHibernateJPA extends GenericDAOHibernateJPA<NombreCampo> implements NombreCampoDAO {
	public NombreCampoDAOHibernateJPA() {
		super(NombreCampo.class);
	}

	
	
}