package ttps.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombreUsuario;
	
	private String contrasena;
	
	private String nombre;
	
	private String apellido;
	
	private String telefono;
	
	
	private String email;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	private InformacionVeterinaria veterinaria;
	
	@ManyToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "TIPO_ID")
	private TipoUsuario tipo;
	
	@OneToMany(mappedBy="duenio", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Mascota> mascotas;
	
	@OneToMany(mappedBy="veterinario", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Mascota> pacientes;
	
	public Usuario() {}
	
	public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono,
			String email, TipoUsuario tipo) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.tipo = tipo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
	public InformacionVeterinaria getVeterinaria() {
		return veterinaria;
	}
	
	public void setVeterinaria(InformacionVeterinaria veterinaria) {
		this.veterinaria = veterinaria;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public List<Mascota> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Mascota> pacientes) {
		this.pacientes = pacientes;
	}
}