package ttps.spring.impDaos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.model.*;


@Repository
public class TipoUsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<TipoUsuario> implements TipoUsuarioDAO {
	
	public TipoUsuarioDAOHibernateJPA() {
		super(TipoUsuario.class);
	}

	public int ObtenerIdTipoUsuario(String valDesc)
	{
		
		TipoUsuario tipoUsuario = this.recuperarPorNombreDescripcion("descripcion", valDesc);
		
		if(tipoUsuario != null) {
			return tipoUsuario.getId();
		}
		else {
			return 0;
		}	
	}
	
	public TipoUsuario ObtenerTipoUsuario(String nombreTipo)
	{
		
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() 
						+" e WHERE e.descripcion = '" + nombreTipo + "'"
				);
	
		@SuppressWarnings("unchecked")
		List<TipoUsuario> resultado = (List<TipoUsuario>) consulta.getResultList();
		if(!resultado.isEmpty())
		{
			return resultado.get(0);
		}
		
		return null;
	}
}