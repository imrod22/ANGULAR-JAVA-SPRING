package ttps.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Informacion implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	
	private double peso;
	
	private String droga;
	
	private String diagnostico;
	
	private String indicaciones;
	
	public Informacion() {}
	
	public Informacion(double peso, String droga, String diagnostico, String indicaciones) {
		this.peso = peso;
		this.droga = droga;
		this.diagnostico = diagnostico;
		this.indicaciones = indicaciones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getDroga() {
		return droga;
	}
	
	public void setDroga(String droga) {
		this.droga = droga;
	}
	
	public String getDiagnostico() {
		return diagnostico;
	}
	
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public String getIndicaciones() {
		return indicaciones;
	}
	
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
}