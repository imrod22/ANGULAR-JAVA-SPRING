package ttps.spring.services;

import ttps.spring.dto.UsuarioDto;

public interface UsuarioService {
	
	void ActualizarUsuario(UsuarioDto usuario);
	
	void RegistrarUsuario(UsuarioDto nuevoUsuario);

	void RegistrarVeterinario(UsuarioDto nuevoUsuario);
	
	Boolean ExisteUsuario(UsuarioDto nuevoUsuario);
	
	Boolean ExisteVeterinaria(UsuarioDto nuevoUsuario);
	
}
