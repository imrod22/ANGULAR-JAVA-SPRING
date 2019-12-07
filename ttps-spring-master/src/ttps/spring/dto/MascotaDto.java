package ttps.spring.dto;
import java.util.ArrayList;
import java.util.List;
import ttps.spring.model.CampoFicha;
import ttps.spring.model.Mascota;

public class MascotaDto {
	
	private String raza;	

	private String qr;
	
	private String veterinario;
	
	private String duenio;
	
	private List<String> infoFicha;
	
	public MascotaDto(Mascota unaMascota) {
		this.setQr(unaMascota.getQr());
		this.setRaza(unaMascota.getRaza().getDescripcion());
		
		this.setDuenio(unaMascota.getDuenio().getNombre() + " "+ unaMascota.getDuenio().getApellido());
		
		this.setVeterinario(unaMascota.getVeterinario().getNombre() + " "+ unaMascota.getVeterinario().getApellido());
		
		this.infoFicha = new ArrayList<String>();
		
		for (CampoFicha campoFicha : unaMascota.getCampoFicha()) {
			this.infoFicha.add(campoFicha.getCampo().getNombre() + ": " + campoFicha.getValor());
		}		
	}	

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public String getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(String veterinario) {
		this.veterinario = veterinario;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public List<String> getInfoFicha() {
		return infoFicha;
	}

	public void setInfoFicha(List<String> infoFicha) {
		this.infoFicha = infoFicha;
	}	
}
