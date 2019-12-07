package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;


@Repository
public interface TipoUsuarioDAO extends GenericDAO<TipoUsuario> 
{
	int ObtenerIdTipoUsuario(String valDesc);
}
