package ttps.spring.daos;

import org.springframework.stereotype.Repository;

import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.model.*;

@Repository
public interface InformacionVeterinariaDAO extends GenericDAO<InformacionVeterinaria> 
{
	InformacionVeterinaria ObtenerInformacionVeterinaria(String domicilioVeterinaria);
	
	void ActualizarInformacionVeterinaria(InformacionBasicaUsuarioDto usuarioEditado);
}
