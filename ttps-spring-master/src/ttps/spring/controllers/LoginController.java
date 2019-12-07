package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.LoginDto;
import ttps.spring.dto.VeterinarioDto;
import ttps.spring.dto.InformacionPersonalDto;
import ttps.spring.dto.AdministradorDto;
import ttps.spring.dto.DuenioDto;
import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;
import ttps.spring.services.LoginService;
import ttps.spring.services.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	 @Autowired
	 private TokenService tokenService;
	
	 private final int EXPIRATION_IN_SEC = 10; 
	
	@PostMapping
	public ResponseEntity<InformacionPersonalDto> Login(@RequestBody LoginDto datosLogin)
	{
		if(datosLogin == null ||  datosLogin.getUsuario() == null || datosLogin.getPassword() == null)
			return new ResponseEntity<InformacionPersonalDto>(HttpStatus.BAD_REQUEST);		
		
		Usuario usuarioLogueado = loginService.Ingresar(datosLogin);		
		
		InformacionPersonalDto tipoUsuario;
		
		if(usuarioLogueado == null) 
			return new ResponseEntity<InformacionPersonalDto>(HttpStatus.UNAUTHORIZED);
		
		switch (usuarioLogueado.getTipo().getDescripcion()) {
		case "Dueno":	
			tipoUsuario = new DuenioDto(usuarioLogueado);
			break;
			
		case "Veterinario":	
			tipoUsuario = new VeterinarioDto(usuarioLogueado);		
			break;	
		default: 
			tipoUsuario = new AdministradorDto(usuarioLogueado);
		}		
		
		String token = tokenService.generateToken(datosLogin.getUsuario(), EXPIRATION_IN_SEC);
		
		HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("token", token);	    
	    
		return ResponseEntity.ok().headers(responseHeaders).body(tipoUsuario);
	
	}	
}
