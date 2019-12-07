package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;

@Repository
public interface EspecieDAO extends GenericDAO<Especie> 
{
	Especie recuperarPorDescripcion(String descripcion);
}
