package ttps.spring.dto;

public class InformacionBasicaUsuarioDto {
	
	private String id;

	private String contrasenia;

	private String email;
	
	private String telefono;
	
	private String idVeterinaria;
	
	private String direccionClinica;
	
	private String nombreClinica;
	
	private String rol;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccionClinica() {
		return direccionClinica;
	}

	public void setDireccionClinica(String direccionClinica) {
		this.direccionClinica = direccionClinica;
	}

	public String getNombreClinica() {
		return nombreClinica;
	}

	public void setNombreClinica(String nombreClinica) {
		this.nombreClinica = nombreClinica;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getIdVeterinaria() {
		return idVeterinaria;
	}

	public void setIdVeterinaria(String idVeterinaria) {
		this.idVeterinaria = idVeterinaria;
	}
}
