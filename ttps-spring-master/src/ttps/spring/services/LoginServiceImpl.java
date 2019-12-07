package ttps.spring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.daos.CampoFichaDAO;
import ttps.spring.daos.MascotaDAO;
import ttps.spring.daos.TipoUsuarioDAO;
import ttps.spring.daos.UsuarioDAO;
import ttps.spring.dto.LoginDto;
import ttps.spring.dto.DuenioDto;
import ttps.spring.model.CampoFicha;
import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UsuarioDAO usuarioDao;
	
	@Autowired
	TipoUsuarioDAO tipoUsuarioDao;
	
	@Autowired
	MascotaDAO mascotaDao;
	
	@Autowired
	CampoFichaDAO campoDao;
	
	@Override
	public Usuario Ingresar(LoginDto datosLogin)
	{
		Usuario usuario = usuarioDao.ObtenerUsuario(datosLogin.getUsuario(), datosLogin.getPassword());
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

}
