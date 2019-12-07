package ttps.spring.impDaos;

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
	
}