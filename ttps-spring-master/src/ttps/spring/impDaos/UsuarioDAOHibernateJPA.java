package ttps.spring.impDaos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO {
	public UsuarioDAOHibernateJPA() {
		super(Usuario.class);
	}

	public Usuario ObtenerUsuario(String userName,String pass)
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
	
	
}