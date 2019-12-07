package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class InformacionVeterinariaDAOHibernateJPA extends GenericDAOHibernateJPA<InformacionVeterinaria> implements InformacionVeterinariaDAO {
	public InformacionVeterinariaDAOHibernateJPA() {
		super(InformacionVeterinaria.class);
	}

	
	
}