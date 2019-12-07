package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class InformacionDAOHibernateJPA extends GenericDAOHibernateJPA<Informacion> implements InformacionDAO {
	public InformacionDAOHibernateJPA() {
		super(Informacion.class);
	}

	
	@Override
	public Informacion recuperarInformacion(int id) 
	{
		return this.recuperar(id);
	}
}