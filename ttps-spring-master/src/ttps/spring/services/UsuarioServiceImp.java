package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.daos.CampoFichaDAO;
import ttps.spring.daos.InformacionVeterinariaDAO;
import ttps.spring.daos.MascotaDAO;
import ttps.spring.daos.TipoUsuarioDAO;
import ttps.spring.daos.UsuarioDAO;
import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.dto.InformacionVeterinariaDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.CampoFicha;
import ttps.spring.model.InformacionVeterinaria;
import ttps.spring.model.Mascota;
import ttps.spring.model.TipoUsuario;
import ttps.spring.model.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	TipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	MascotaDAO mascotaDao;
	
	@Autowired
	CampoFichaDAO campoDao;
	
	@Autowired
	InformacionVeterinariaDAO infoVeterinariaDao;
	
	public void ActualizarUsuario(InformacionBasicaUsuarioDto usuario)
	{
		usuarioDao.ActualizarUsuario(usuario);
	}
	
	public void ActualizarDatosVeterinaria(InformacionBasicaUsuarioDto usuario)
	{
		infoVeterinariaDao.ActualizarInformacionVeterinaria(usuario);
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
	public Boolean ExisteVeterinaria(String direccion) {
		if(infoVeterinariaDao.ObtenerInformacionVeterinaria(direccion) == null)
			return false;
		else return true;
	}

	@Override
	public Usuario ObtenerUsuario(String id) {
		Usuario usuario = this.usuarioDao.recuperar(id);
		
		if(usuario != null) {
			List<Mascota> mascotas = mascotaDao.recuperarTodos(null);	
			
			if (mascotas.size() > 0) {	
				List<CampoFicha> fichas = campoDao.recuperarTodos(null);
				
				List<Mascota> mascotaDuenio = mascotas.stream().filter(t -> t.getDuenio().getId() == usuario.getId()).collect(Collectors.toList());
				
				for (Mascota unaMascota : mascotaDuenio) {
					unaMascota.setFicha(fichas.stream().filter(t -> t.getMascota().getId() == unaMascota.getId()).collect(Collectors.toList()));
				}
				
				usuario.setMascotas(mascotaDuenio);		
				
				List<Mascota> mascotasPacientes = mascotas.stream().filter(t -> t.getVeterinario().getId() == usuario.getId()).collect(Collectors.toList());
				
				for (Mascota unaMascota : mascotasPacientes) {
					unaMascota.setFicha(fichas.stream().filter(t -> t.getMascota().getId() == unaMascota.getId()).collect(Collectors.toList()));
				}
				
				usuario.setPacientes(mascotasPacientes);
			}
			
			return usuario;
		}	
		
		return null;
	}

	@Override
	public List<Usuario> ObtenerVeterinarios() {
		List<Mascota> mascotas = mascotaDao.recuperarTodos(null);
		List<Usuario> usuarios = usuarioDao.ObtenerUsuarios();
		List<Usuario> veterinarios = new ArrayList<Usuario>();
		for(Usuario unUsuario : usuarios) {
			if(unUsuario.getTipo().getDescripcion().equals("Veterinario")) {
				
				List<Mascota> mascotasPacientes = mascotas.stream().filter(t -> t.getVeterinario().getId() == unUsuario.getId()).collect(Collectors.toList());
				
				unUsuario.setPacientes(mascotasPacientes);
				veterinarios.add(unUsuario);				
			}				
		}
		
		return veterinarios;
	}	
}
