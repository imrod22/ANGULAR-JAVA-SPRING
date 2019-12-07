package ttps.spring.dto;

import ttps.spring.model.Usuario;

public abstract class InformacionPersonalDto {
	private String nombre;
	
	private String apellido;
	
	private String telefono;
	
	private String rol;
	
	protected InformacionPersonalDto(Usuario usuario) {
		this.setApellido(usuario.getApellido());
		this.setNombre(usuario.getNombre());
		this.setTelefono(usuario.getTelefono());
		this.setRol(usuario.getTipo().getDescripcion());
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
}
