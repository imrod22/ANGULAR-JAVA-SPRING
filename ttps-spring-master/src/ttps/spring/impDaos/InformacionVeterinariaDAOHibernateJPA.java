package ttps.spring.impDaos;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.spring.daos.*;
import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.model.*;


@Repository
public class InformacionVeterinariaDAOHibernateJPA extends GenericDAOHibernateJPA<InformacionVeterinaria> implements InformacionVeterinariaDAO {
	public InformacionVeterinariaDAOHibernateJPA() {
		super(InformacionVeterinaria.class);
	}

	@Override
	public InformacionVeterinaria ObtenerInformacionVeterinaria(String domicilioVeterinaria) {
		Query consulta= this.getEntityManager().createQuery
				("SELECT e FROM " +  getPersistentClass().getName() 
						+" e WHERE e.nombreClinica = '" + domicilioVeterinaria + "'");
	
		@SuppressWarnings("unchecked")
		List<InformacionVeterinaria> resultado = (List<InformacionVeterinaria>) consulta.getResultList();
		if(!resultado.isEmpty())
		{
			return resultado.get(0);
		}
		
		return null;
	}
	
	public void ActualizarInformacionVeterinaria(InformacionBasicaUsuarioDto usuarioEditado)
	{
		Query update= this.getEntityManager().createQuery(
				"UPDATE " + getPersistentClass().getName() 
				+ " u SET u.domicilioClinica = '" + usuarioEditado.getDireccionClinica() + "', "
				+ " u.nombreClinica = '"+ usuarioEditado.getNombreClinica() + "'"
				
				+ " WHERE u.id = '"+ usuarioEditado.getIdVeterinaria() + "'" );
		
		update.executeUpdate();	
		
	}

	
	
}