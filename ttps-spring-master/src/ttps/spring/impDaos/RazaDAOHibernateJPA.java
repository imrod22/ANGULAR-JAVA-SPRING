package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class RazaDAOHibernateJPA extends GenericDAOHibernateJPA<Raza> implements RazaDAO {
	public RazaDAOHibernateJPA() {
		super(Raza.class);
	}

	
	
}