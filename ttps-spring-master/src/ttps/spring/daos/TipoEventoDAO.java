package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;

@Repository
public interface TipoEventoDAO extends GenericDAO<TipoEvento> 
{
	TipoEvento recuperarPorDescripcion(String descripcion);
}
