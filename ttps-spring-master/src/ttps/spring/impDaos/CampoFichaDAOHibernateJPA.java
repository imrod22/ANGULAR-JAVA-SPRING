package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository(value = "CampoFichaDao")
public class CampoFichaDAOHibernateJPA extends GenericDAOHibernateJPA<CampoFicha> implements CampoFichaDAO {
	public CampoFichaDAOHibernateJPA() {
		super(CampoFicha.class);
	}

	
	
}