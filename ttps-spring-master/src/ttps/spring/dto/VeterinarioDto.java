package ttps.spring.dto;

import java.util.ArrayList;
import java.util.List;

import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;

public class VeterinarioDto extends InformacionPersonalDto {
	
	private int idVeterinaria;
	
	private String nombreConsultorio;
	
	private String direccion;
	
	private List<MascotaDto> pacientes;

	public VeterinarioDto(Usuario usuario) {
		super(usuario);
		
		this.setDireccion(usuario.getVeterinaria().getDomicilioClinica());
		this.setNombreConsultorio(usuario.getVeterinaria().getNombreClinica());
		this.setIdVeterinaria(usuario.getVeterinaria().getId());
		
		this.pacientes = new ArrayList<MascotaDto>();
		
		for (Mascota mascotaActual : usuario.getPacientes()) {
			this.pacientes.add(new MascotaDto(mascotaActual));
		}		
	}

	public List<MascotaDto> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<MascotaDto> pacientes) {
		this.pacientes = pacientes;
	}
	
	public String getNombreConsultorio() {
		return nombreConsultorio;
	}

	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdVeterinaria() {
		return idVeterinaria;
	}

	public void setIdVeterinaria(int idVeterinaria) {
		this.idVeterinaria = idVeterinaria;
	}
}
