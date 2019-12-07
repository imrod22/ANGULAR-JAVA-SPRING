package ttps.spring.services;
import ttps.spring.dto.LoginDto;
import ttps.spring.model.Usuario;

public interface LoginService {	
	 Usuario Ingresar(LoginDto datosLogin);
}
