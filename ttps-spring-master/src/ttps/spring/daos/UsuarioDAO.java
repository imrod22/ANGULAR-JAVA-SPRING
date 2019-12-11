package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.*;

@Repository
public interface UsuarioDAO extends GenericDAO<Usuario> 
{
	Usuario ObtenerUsuario(String userName,String pass);
	
	void ActualizarUsuario(UsuarioDto usuario);
	
	void RegistrarUsuario(UsuarioDto usuario, TipoUsuario tipo);
	
	void RegistrarUsuario(UsuarioDto usuario, InformacionVeterinaria infoVeterinaria, TipoUsuario tipo);
	
	Usuario ExisteUsuarioRegistrado(String usuario, String email);
}
