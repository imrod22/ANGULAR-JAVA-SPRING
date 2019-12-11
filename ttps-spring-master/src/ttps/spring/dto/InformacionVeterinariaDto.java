package ttps.spring.dto;

public class InformacionVeterinariaDto {

	private String nombreClinica;
	
	private String domicilioClinica;

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
