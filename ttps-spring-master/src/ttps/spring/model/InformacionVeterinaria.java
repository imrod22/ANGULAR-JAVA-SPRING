package ttps.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class InformacionVeterinaria implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nombreClinica;
	
	private String domicilioClinica;	
	
	public InformacionVeterinaria() {}
	
	public InformacionVeterinaria(String nombreClinica, String domicilioClinica) {
		
		this.nombreClinica = nombreClinica;
		this.domicilioClinica = domicilioClinica;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNombreClinica() {
		return nombreClinica;
	}
	
	public void setNombreClinica(String nombreClinica) {
		this.nombreClinica = nombreClinica;
	}
	
	public String getDomicilioClinica() {
		return domicilioClinica;
	}
	
	public void setDomicilioClinica(String domicilioClinica) {
		this.domicilioClinica = domicilioClinica;
	}
}