package ttps.spring.impDaos;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository(value = "MascotaDAO")
public class MascotaDAOHibernateJPA extends GenericDAOHibernateJPA<Mascota> implements MascotaDAO {
	public MascotaDAOHibernateJPA() {
		super(Mascota.class);
	}	
}