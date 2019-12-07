package ttps.spring.services;

import java.util.List;

import ttps.spring.model.Mascota;

public interface MascotaService {

	//void CargaInicial();
	
	Mascota CrearMascota(Mascota mascotaACrear);
	
	List<Mascota> ObtenerMascotaPorDueño(int dueñoId);
	
	List<Mascota> ObtenerTodasLasMascotas();
}
