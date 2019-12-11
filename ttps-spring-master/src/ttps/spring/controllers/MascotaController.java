package ttps.spring.controllers;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ttps.spring.model.Mascota;
import ttps.spring.services.MascotaService;

@RestController
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/mascotas/{id}")
	public ResponseEntity<List<Mascota>> listarMascotasDuenio(@PathVariable int id) {
					
			List<Mascota> mascotasDuenio = mascotaService.ObtenerMascotaPorDueño(id);

			if (mascotasDuenio != null && !mascotasDuenio.isEmpty() ) {
				return new ResponseEntity<List<Mascota>>(mascotasDuenio, HttpStatus.OK);
			}
			
			return new ResponseEntity<List<Mascota>>(HttpStatus.NO_CONTENT);
				
		
	}
	
	@PostMapping
	@RequestMapping("/mascota")
	public ResponseEntity<Mascota> crearMascota(@RequestBody Mascota mascota){
					
			if(mascota.getRaza() == null) {
				return new ResponseEntity<Mascota>(HttpStatus.BAD_REQUEST);
			}
			
			if(mascota.getDuenio() == null) {
				return new ResponseEntity<Mascota>(HttpStatus.BAD_REQUEST);
			}
		
			Mascota m = this.mascotaService.CrearMascota(mascota);
		
			return new ResponseEntity<Mascota>(m, HttpStatus.CREATED);
	}
}
