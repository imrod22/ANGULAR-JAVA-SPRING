package ttps.spring.services;

import java.util.List;

import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.Usuario;

public interface UsuarioService {
	
	void ActualizarUsuario(InformacionBasicaUsuarioDto usuario);
	
	void ActualizarDatosVeterinaria(InformacionBasicaUsuarioDto usuario);
	
	void RegistrarUsuario(UsuarioDto nuevoUsuario);

	void RegistrarVeterinario(UsuarioDto nuevoUsuario);
	
	Boolean ExisteUsuario(UsuarioDto nuevoUsuario);
	
	Boolean ExisteVeterinaria(String direccion);
	
	Usuario ObtenerUsuario(String id);	
	
	List<Usuario> ObtenerVeterinarios();
}
