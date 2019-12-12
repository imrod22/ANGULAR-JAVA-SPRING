package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.dto.AdministradorDto;
import ttps.spring.dto.DuenioDto;
import ttps.spring.dto.IdentityDto;
import ttps.spring.dto.InformacionBasicaUsuarioDto;
import ttps.spring.dto.InformacionPersonalDto;
import ttps.spring.dto.UsuarioDto;
import ttps.spring.dto.VeterinarioDto;
import ttps.spring.model.Usuario;
import ttps.spring.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@RequestMapping("/actualizar")
	public ResponseEntity<String> Actualizar(@RequestBody InformacionBasicaUsuarioDto usuario) {		
		
		usuarioService.ActualizarUsuario(usuario);
		if(usuario.getRol().equals("Veterinario")) {
			if(usuario.getNombreClinica().equals(null) || usuario.getDireccionClinica().equals(null) || usuarioService.ExisteVeterinaria(usuario.getDireccionClinica()))
				return new ResponseEntity<String>("La veterinaria ingresada ya existe en el sistema", HttpStatus.INTERNAL_SERVER_ERROR);
			
			usuarioService.ActualizarDatosVeterinaria(usuario);
		}
		return new ResponseEntity<String>("Ok", HttpStatus.OK);
	}
	
	@PostMapping
	@RequestMapping("/registrar")
	public ResponseEntity<String> Registrar(@RequestBody UsuarioDto usuario) {
		
		if(usuarioService.ExisteUsuario(usuario))
			return new ResponseEntity<String>("El usuario ya esta registrado en el sistema", HttpStatus.INTERNAL_SERVER_ERROR);
		
		if(usuario.getRol().equals("Veterinario")) {
			if(usuario.getNombreClinica().equals(null) || usuario.getDireccionClinica().equals(null) || usuarioService.ExisteVeterinaria(usuario.getDireccionClinica()))
				return new ResponseEntity<String>("La veterinaria ingresada ya existe en el sistema", HttpStatus.INTERNAL_SERVER_ERROR);
			
			usuarioService.RegistrarVeterinario(usuario);
		}
		else {
			usuarioService.RegistrarUsuario(usuario);	
				
			}	
		return ResponseEntity.ok().body("Ok");
	}
	
	@PostMapping
	@RequestMapping("/informacionusuario")
	public ResponseEntity<InformacionPersonalDto> ObtenerInformacion(@RequestBody IdentityDto identificacionUsuario) {
		
		Usuario usuarioActual = this.usuarioService.ObtenerUsuario(identificacionUsuario.getId());		
		InformacionPersonalDto tipoUsuario;
		
		switch (usuarioActual.getTipo().getDescripcion()) {
		case "Dueno":	
			tipoUsuario = new DuenioDto(usuarioActual);
			break;
			
		case "Veterinario":	
			tipoUsuario = new VeterinarioDto(usuarioActual);		
			break;	
		default: 
			tipoUsuario = new AdministradorDto(usuarioActual);
		}
		
		
		return ResponseEntity.ok().body(tipoUsuario);
	}
	
}
