package ttps.spring.impDaos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import ttps.spring.daos.*;
import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.dto.InformacionVeterinariaDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.model.*;


@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	public Usuario ObtenerUsuario(String userName, String pass)
	{
		
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() 
						+" e WHERE e.nombreUsuario = '" + userName 
						+ "' AND e.contrasena = '" 		 + pass +"'"
				);
	
		@SuppressWarnings("unchecked")
		List<Usuario> resultado = (List<Usuario>) consulta.getResultList();
		if(!resultado.isEmpty())
		{
			return resultado.get(0);
		}
		
		return null;
	}
	
	public void ActualizarUsuario(InformacionBasicaUsuarioDto usuarioEditado)
	{
		Query update= this.getEntityManager().createQuery(
				"UPDATE " + getPersistentClass().getName() 
				+ " u SET u.email = '" + usuarioEditado.getEmail() + "', "
				+ " u.telefono = '" + usuarioEditado.getTelefono() + "', "
				+ " u.contrasena = '"+ usuarioEditado.getContrasenia() + "'"
				
				+ " WHERE u.id = '"+ usuarioEditado.getId() + "'" );
		
		update.executeUpdate();	
		
	}
	
	public void RegistrarUsuario(UsuarioDto usuario, TipoUsuario tipoUsuario)
	{
		Usuario nuevoUsuario = new Usuario();

		nuevoUsuario.setNombre(usuario.getNombre());
		nuevoUsuario.setApellido(usuario.getApellido());
		nuevoUsuario.setEmail(usuario.getEmail());
		nuevoUsuario.setTelefono(usuario.getTelefono());
		nuevoUsuario.setNombreUsuario(usuario.getNombreusuario());
		nuevoUsuario.setContrasena(usuario.getContrasena());
		nuevoUsuario.setTipo(tipoUsuario);
		
		this.getEntityManager().persist(nuevoUsuario);
	}
	
	public void RegistrarUsuario(UsuarioDto usuario, InformacionVeterinaria infoVeterinaria, TipoUsuario tipoUsuario)
	{
		Usuario nuevoUsuario = new Usuario();

		nuevoUsuario.setNombre(usuario.getNombre());
		nuevoUsuario.setApellido(usuario.getApellido());
		nuevoUsuario.setEmail(usuario.getEmail());
		nuevoUsuario.setTelefono(usuario.getTelefono());
		nuevoUsuario.setNombreUsuario(usuario.getNombreusuario());
		nuevoUsuario.setContrasena(usuario.getContrasena());
		nuevoUsuario.setTipo(tipoUsuario);
		nuevoUsuario.setVeterinaria(infoVeterinaria);
		
		this.getEntityManager().persist(nuevoUsuario);
	}
	
	public Usuario ExisteUsuarioRegistrado(String usuario, String email)
	{
		
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() 
						+" e WHERE e.nombreUsuario = '" + usuario 
						+ "' OR e.email = '" 		 + email +"'"
				);
	
		@SuppressWarnings("unchecked")
		List<Usuario> resultado = (List<Usuario>) consulta.getResultList();
		if(!resultado.isEmpty())
		{
			return resultado.get(0);
		}
		
		return null;
	}

	@Override
	public List<Usuario> ObtenerUsuarios() {
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() 
						+" e ");
	
		@SuppressWarnings("unchecked")
		List<Usuario> resultado = (List<Usuario>) consulta.getResultList();
		if(!resultado.isEmpty())
		{
			return resultado;
		}
		
		return null;
	}
}