package ttps.spring.dto;

public class UsuarioDto {
	
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	private String nombreusuario;
	private String contrasena;
	private String nombreClinica;
	private String direccionClinica;
	
	private String rol;

	public String getNombreusuario() {
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
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
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombreClinica() {
		return nombreClinica;
	}

	public void setNombreClinica(String nombreClinica) {
		this.nombreClinica = nombreClinica;
	}

	public String getDireccionClinica() {
		return direccionClinica;
	}

	public void setDireccionClinica(String direccionClinica) {
		this.direccionClinica = direccionClinica;
	}
}
