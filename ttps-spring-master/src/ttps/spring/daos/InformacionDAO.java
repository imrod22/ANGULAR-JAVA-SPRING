package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;

@Repository
public interface InformacionDAO extends GenericDAO<Informacion> {
	
	public Informacion recuperarInformacion(int id);

}
