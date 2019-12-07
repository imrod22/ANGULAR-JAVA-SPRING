package ttps.spring.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CampoFicha implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
	private long id;

	@ManyToOne(optional = true ,cascade = CascadeType.MERGE)
	@JoinColumn(name = "MascotaId",nullable = false)
	@JsonIgnore()
	private Mascota mascota;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CAMPO_ID")
	private NombreCampo campo;	
	
	private Boolean visibilidad;
	
	private String valor;
	
	public CampoFicha() {
		
	}
	
	
	public CampoFicha(Mascota mascota, NombreCampo campo, Boolean visibilidad, String valor) {
		
		this.mascota = mascota;
		this.campo = campo;
		this.visibilidad = visibilidad;
		this.valor = valor;
	}

	public Mascota getMascota() {
		return mascota;
	}
	
    public long getId() {
        return id;
    }
    
	public void setId(long id) {
		this.id = id;
	}
    
	public NombreCampo getCampo() {
		return campo;
	}

	public void setCampo(NombreCampo campo) {
		this.campo = campo;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
	
	public Boolean getVisibilidad() {
		return visibilidad;
	}
	
	public void setVisibilidad(Boolean visibilidad) {
		this.visibilidad = visibilidad;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
}
