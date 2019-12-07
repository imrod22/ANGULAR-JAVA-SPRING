package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.model.*;

@Repository
public interface UsuarioDAO extends GenericDAO<Usuario> 
{
	Usuario ObtenerUsuario(String userName,String pass);
	
}
