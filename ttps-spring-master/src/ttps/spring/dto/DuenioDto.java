package ttps.spring.dto;
import java.util.ArrayList;
import java.util.List;

import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;

public class DuenioDto extends InformacionPersonalDto {
	
	private List<MascotaDto> mascotas;

	public DuenioDto(Usuario usuario) {
		super(usuario);
		
		this.mascotas = new ArrayList<MascotaDto>();
		
		for (Mascota mascotaActual : usuario.getMascotas()) {
			this.mascotas.add(new MascotaDto(mascotaActual));
		}		
	}

	public List<MascotaDto> getMascotas() {
		return mascotas;
	}
}
