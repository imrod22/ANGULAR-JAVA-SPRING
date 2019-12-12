package ttps.spring.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.*;

@Repository
public interface UsuarioDAO extends GenericDAO<Usuario> 
{
	Usuario ObtenerUsuario(String userName,String pass);
	
	void ActualizarUsuario(InformacionBasicaUsuarioDto usuarioEditado);
	
	void RegistrarUsuario(UsuarioDto usuario, TipoUsuario tipo);
	
	void RegistrarUsuario(UsuarioDto usuario, InformacionVeterinaria infoVeterinaria, TipoUsuario tipo);
	
	Usuario ExisteUsuarioRegistrado(String usuario, String email);
	
	List<Usuario> ObtenerUsuarios();
}
