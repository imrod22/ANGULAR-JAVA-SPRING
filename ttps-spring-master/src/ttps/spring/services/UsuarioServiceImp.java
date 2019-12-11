package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.daos.InformacionVeterinariaDAO;
import ttps.spring.daos.TipoUsuarioDAO;
import ttps.spring.daos.UsuarioDAO;
import ttps.spring.dto.InformacionVeterinariaDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.InformacionVeterinaria;
import ttps.spring.model.TipoUsuario;

@Service
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	TipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	InformacionVeterinariaDAO infoVeterinariaDao;
	
	public void ActualizarUsuario(UsuarioDto usuario)
	{
		usuarioDao.ActualizarUsuario(usuario);
	}
	
	public void RegistrarUsuario(UsuarioDto nuevoUsuario)
	{
		TipoUsuario tipoUsuario = tipoUsuarioDao.ObtenerTipoUsuario(nuevoUsuario.getRol());
		
		usuarioDao.RegistrarUsuario(nuevoUsuario, tipoUsuario);	
	}
	
	public void RegistrarVeterinario(UsuarioDto nuevoUsuario)
	{
		TipoUsuario tipoUsuario = tipoUsuarioDao.ObtenerTipoUsuario(nuevoUsuario.getRol());
		
		InformacionVeterinaria infoVeterinaria = new InformacionVeterinaria();
		infoVeterinaria.setDomicilioClinica(nuevoUsuario.getDireccionClinica());
		infoVeterinaria.setNombreClinica(nuevoUsuario.getNombreClinica());		
		
		usuarioDao.RegistrarUsuario(nuevoUsuario, infoVeterinaria, tipoUsuario);	
	}
	
	public Boolean ExisteUsuario(UsuarioDto nuevoUsuario) {
		
		if(usuarioDao.ExisteUsuarioRegistrado(nuevoUsuario.getNombreusuario(), nuevoUsuario.getEmail()) == null)
			return false;
		else return true;		
	}

	@Override
	public Boolean ExisteVeterinaria(UsuarioDto nuevoUsuario) {
		if(infoVeterinariaDao.ObtenerInformacionVeterinaria(nuevoUsuario.getDireccionClinica()) == null)
			return false;
		else return true;
	}
}
