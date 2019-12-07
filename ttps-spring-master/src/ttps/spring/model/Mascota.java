package ttps.spring.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Mascota implements Serializable {	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Raza raza;
	
	private String qr;
	
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Evento> eventos;	
	
	@OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<CampoFicha> ficha;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "veterinario_id")
    private Usuario veterinario;
	
	@OneToOne(cascade = CascadeType.MERGE)
    private Usuario duenio;
	
	public Mascota() {}
	
	public Mascota(Raza unaRaza) {		
		this.raza = unaRaza;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Raza getRaza() {
		return raza;
	}
	
	public void setRaza(Raza raza) {
		this.raza = raza;
	}

	public List<CampoFicha> getCampoFicha() {
		return ficha;
	}
	
	public void setCampoFicha(List<CampoFicha> ficha) {
		this.ficha = ficha;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}
	
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<CampoFicha> getFicha() {
		return ficha;
	}

	public void setFicha(List<CampoFicha> ficha) {
		this.ficha = ficha;
	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public Usuario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Usuario veterinario) {
		this.veterinario = veterinario;
	}

	public Usuario getDuenio() {
		return duenio;
	}

	public void setDuenio(Usuario duenio) {
		this.duenio = duenio;
	}
}
